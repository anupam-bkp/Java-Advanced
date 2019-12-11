package com.anupam.hibernatejpatest2;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.service.ServiceRegistry;

public class EntityManagerProviderFactory {

	private final String DATABASE_NAME = "test2A";
	private final String DATABASE_FILE_NAME = DATABASE_NAME + ".h2.db";
	private final String TRACE_FILE_NAME = DATABASE_NAME + ".trace.db";
	private final String LOCK_FILE_NAME = DATABASE_NAME + ".lock.db";

	private final String MAIN_CONNECTION_OPTIONS = ";MV_STORE=FALSE;MVCC=FALSE";

	private final String DATABASE_USER = "admin";

	private EntityManagerFactory _entityManagerFactory;
	private Metadata _metadata;
	private String _databaseFullPath = "./" + DATABASE_NAME;
	private Connection _connection;
	private SessionFactory _sessionFactory;

	public void initialize(){
		_entityManagerFactory = buildEntityManagerFactory();
//		registerJpaTrigger(true);
	}

	private EntityManagerFactory buildEntityManagerFactory()
	{

		String hbm2ddlAuto = "none";
		if (true)
		{
			hbm2ddlAuto = "create";
		}

		Map<String, Object> settings = new HashMap<>();

		// String hbm2ddlAuto="create-drop";
		int jdbcBatchSize = 20;
		int nbCores = 8;
		int cacheSize = 512000;
		// int cacheSize=0;

		// use customized dialect including missing functions like group_concat
		
//		settings.put("hibernate.dialect", "com.artal.citrus.persistence.jpa.h2.H2ExtendedDialect");
		settings.put("hibernate.connection.autocommit", "false");
		settings.put("hibernate.connection.driver_class", "org.h2.Driver");
		settings.put("hibernate.connection.url",
				"jdbc:h2:"
						+ _databaseFullPath + MAIN_CONNECTION_OPTIONS + ";CACHE_SIZE=" + cacheSize
						+ ";LOCK_MODE=0;TRACE_LEVEL_SYSTEM_OUT=0");
		settings.put("hibernate.connection.user", DATABASE_USER);
		settings.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);

		settings.put("hibernate.exclude-unlisted-classes", "true");
		settings.put("hibernate.archive.autodetection", "false");

		settings.put("hibernate.flushMode", "MANUAL");
		settings.put("hibernate.jdbc.batch_size", jdbcBatchSize);
		settings.put("hibernate.order_updates", "true");
		settings.put("hibernate.order_inserts", "true");
		settings.put("hibernate.cache.use_second_level_cache", "false");

		// disable outer joins
		settings.put("hibernate.max_fetch_depth", "0");

		settings.put("hibernate.connection.pool_size", "1");
		settings.put("hibernate.transaction.factory_class",
				"org.hibernate.transaction.JDBCTransactionFactory");
		settings.put("hibernate.current_session_context_class", "thread");
		settings.put("hibernate.query.plan_cache_max_size", "128");


		ClassLoaderService classLoaderService = new ClassLoaderServiceImpl(this.getClass().getClassLoader());
		
		// configure bootstrapServiceRegistry
		BootstrapServiceRegistryBuilder bootstrapServiceRegistryBuilder = new BootstrapServiceRegistryBuilder();
		bootstrapServiceRegistryBuilder.enableAutoClose();
		bootstrapServiceRegistryBuilder.applyClassLoaderService(classLoaderService);
		BootstrapServiceRegistry bootstrapServiceRegistry = bootstrapServiceRegistryBuilder.build();

		// configure standardRegistry
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder(
				bootstrapServiceRegistry);
		standardServiceRegistryBuilder.applySettings(settings);
		ServiceRegistry standardRegistry = standardServiceRegistryBuilder.build();

		// create metadata sources
		MetadataSources metadataSources = new MetadataSources(standardRegistry);

		// Fill persistence classes
		Collection<Class<?>> jpaClasses = new ArrayList<Class<?>>();


		// programmatically fill metadata with classes
		for (Class<?> persistenceClass : jpaClasses)
		{
			metadataSources.addAnnotatedClass(persistenceClass);
		}

		// build metadata
		MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();
		_metadata = metadataBuilder.build();

		// configure session factory
		SessionFactoryBuilder sessionFactoryBuilder = _metadata.getSessionFactoryBuilder();


		_sessionFactory = sessionFactoryBuilder.build();

		return _sessionFactory;

	}

	private void registerJpaTrigger(final boolean init)
	{

		StringBuilder triggerCreation = new StringBuilder();

		for (PersistentClass binding : _metadata.getEntityBindings())
		{
			String tableName = binding.getTable().getName().toUpperCase();
			Class<?> entity = binding.getMappedClass();

			(new DatabaseMapping()).put(tableName, entity);

			if (init && !binding.getTable().isAbstract())
			{
				triggerCreation.append(buildTrigger(tableName, "INSERT", "insert"));
				triggerCreation.append(buildTrigger(tableName, "UPDATE", "update"));
				triggerCreation.append(buildTrigger(tableName, "DELETE", "delete"));
			}
		}

		if (init)
		{
			_entityManagerFactory.createEntityManager().createNativeQuery(triggerCreation.toString()).executeUpdate();
			
		}
	}


	private String buildTrigger(String tableName, String actionKind, String triggerSuffix)
	{
		return "CREATE TRIGGER "
				+ tableName + "_" + triggerSuffix + " AFTER " + actionKind + " ON " + tableName
				+ " FOR EACH ROW CALL " + "\"com.anupam.hibernatejpatest2.H2JPATrigger\";";
	}

	final static class DatabaseMapping
	{

		/** Mapping : Table Name => JPA Class (Used for trigger initialization) */
		private static Map<String, Class<?>> _map = new HashMap<>();

		/** Mapping : JPA Class => Table Name */
		private static Map<Class<?>, String> _pam = new HashMap<>();

		/** Mapping : JPA class name => JPA Class */
		private static Map<String, Class<?>> _classes = new HashMap<>();

		public Class<?> getEntityClass(String tableName)
		{
			return _map.get(tableName);
		}

		public String getTableName(Class<?> entity)
		{
			return _pam.get(entity);
		}

		public Class<?> getClassByName(String className)
		{
			return _classes.get(className);
		}

		public void put(String tableName, Class<?> entity)
		{
			_map.put(tableName, entity);
			_pam.put(entity, tableName);
			_classes.put(entity.getName(), entity);
		}
	}
}
