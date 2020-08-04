package com.example.dbtest.jpa01;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EmfBuilder {

	private static final EmfBuilder INSTANCE = new EmfBuilder();  

	private EntityManagerFactory emf;
	private EntityManager em;

	private EmfBuilder() {
		//For singleton
	}
	
	public void initialize(){
		emf = buildEntityManagerFactory();
//		emf = Persistence.createEntityManagerFactory("RMS-Application");
		em = emf.createEntityManager();
	}
	
	public static EmfBuilder getInstance() {
		return INSTANCE;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public  Map<String, Object> getSettings() {
		
		final int cacheSize = 512000;
		final int jdbcBatchSize = 20;
		final String hbm2ddlAuto = "none";
		final String DATABASE_NAME = "dorms";
//		final String DATABASE_FILE_NAME = DATABASE_NAME + ".mv.db";
//		final String TRACE_FILE_NAME = DATABASE_NAME + ".trace.db";
//		final String LOCK_FILE_NAME = DATABASE_NAME + ".lock.db";
		final String MAIN_CONNECTION_OPTIONS = ";DB_CLOSE_DELAY=-1";
//		private final String MAIN_CONNECTION_OPTIONS = ";MV_STORE=FALSE;MVCC=FALSE";
		final String DATABASE_USER = "admin";
		final String DATABASE_PASSWORD = "";
		final String DATABASE_FULL_PATH = 
				"C:\\Users\\kanupam\\Desktop\\Databases\\" + DATABASE_NAME;
		
		final Map<String, Object> settings = new HashMap<>();
		
		settings.put("hibernate.connection.autocommit", "false");
		settings.put("hibernate.connection.driver_class", "org.h2.Driver");
		settings.put("hibernate.connection.url",
				"jdbc:h2:"+ DATABASE_FULL_PATH + MAIN_CONNECTION_OPTIONS);
		/*	+ ";CACHE_SIZE=" + cacheSize
		+ ";LOCK_MODE=0;TRACE_LEVEL_SYSTEM_OUT=0");*/
		settings.put("hibernate.connection.user", DATABASE_USER);
		settings.put("hibernate.connection.password", DATABASE_PASSWORD);
		
		settings.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
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

		return settings;
	}
	
	public Collection<Class<?>> getAllEntities() {
		
		final List<Class<?>> entities = new ArrayList<>();
		
		entities.add(Employee.class);
		entities.add(Project.class);
		entities.add(ProjectDetail.class);
		entities.add(ReviewType.class);
		entities.add(ResultType.class);
		entities.add(ReviewChecklist.class);
	
		return entities;
	}
	
	public EntityManagerFactory buildEntityManagerFactory() {
		
		final StandardServiceRegistryBuilder standardServiceRegistryBuilder = 
				new StandardServiceRegistryBuilder();
		
		standardServiceRegistryBuilder.applySettings(getSettings());
		
		final StandardServiceRegistry standardServiceRegistry = 
				standardServiceRegistryBuilder.build();
		
		final MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		
		
		// programmatically fill metadata with classes
		for (Class<?> persistenceClass : getAllEntities()){
				metadataSources.addAnnotatedClass(persistenceClass);
		}
		
//		Metadata metadata = metadataSources.buildMetadata();
		
		final MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();
		/*metadataBuilder.applyImplicitNamingStrategy(
				ImplicitNamingStrategyJpaCompliantImpl.INSTANCE);*/
		
		final Metadata metadata = metadataBuilder.build();
		
//		final SessionFactory sessionFactory = metadata.buildSessionFactory();
		
		final SessionFactoryBuilder sessionFactoryBuilder = 
					metadata.getSessionFactoryBuilder();
		
//		sessionFactoryBuilder.applyName("");
		
		final SessionFactory sessionFactory = sessionFactoryBuilder.build();
		
		return sessionFactory;
	}

	private void buildEMWithUnitInfo() {
		
		/*final EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("RMS-Application"); 
		em = emf.createEntityManager();*/
		
		/*SessionFactory sf = new Configuration().configure("hibernate.cfg2.xml")
				.addAnnotatedClass(ProjectDetail.class)
				.buildSessionFactory();
				
				em = sf.createEntityManager();*/
		
		/*final PersistenceProvider provider= new HibernatePersistenceProvider();
		final EntityManagerFactory emf = provider.createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), Collections.emptyMap());
		
		em = emf.createEntityManager();*/
		
		/*final EntityManagerFactoryBuilder emfBuilder = 
				new EntityManagerFactoryBuilderImpl(
						new PersistenceUnitInfoDescriptor(new MyPersistenceUnitInfo()), 
						Collections.emptyMap());
		
		emfBuilder.build();*/
	}

	private class MyPersistenceUnitInfo implements PersistenceUnitInfo{

		private final String JPA_VERSION = "2.0";
		private String persistenceUnitName;
		private String persistenceProviderClassName;
		private PersistenceUnitTransactionType transactionType = 
				PersistenceUnitTransactionType.RESOURCE_LOCAL;
		private DataSource dataSource;
		private List<String> mappingFileNames = Collections.emptyList();
		private List<String> managedClassNames = Collections.emptyList();
		private Properties properties;

		@Override
		public String getPersistenceUnitName() {
			return persistenceUnitName;
		}

		@Override
		public String getPersistenceProviderClassName() {
			return persistenceProviderClassName;
		}

		@Override
		public PersistenceUnitTransactionType getTransactionType() {
			//			PersistenceUnitTransactionType.JTA;
			return transactionType;
		}

		@Override
		public DataSource getJtaDataSource() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DataSource getNonJtaDataSource() {
			// TODO Auto-generated method stub
			
			return null;
		}

		@Override
		public List<String> getMappingFileNames() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<URL> getJarFileUrls() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public URL getPersistenceUnitRootUrl() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<String> getManagedClassNames() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean excludeUnlistedClasses() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public SharedCacheMode getSharedCacheMode() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ValidationMode getValidationMode() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Properties getProperties() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getPersistenceXMLSchemaVersion() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ClassLoader getClassLoader() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void addTransformer(ClassTransformer transformer) {
			// TODO Auto-generated method stub

		}

		@Override
		public ClassLoader getNewTempClassLoader() {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
