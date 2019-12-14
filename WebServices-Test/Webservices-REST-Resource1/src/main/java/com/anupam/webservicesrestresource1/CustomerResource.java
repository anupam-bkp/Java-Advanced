package com.anupam.webservicesrestresource1;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.anupam.webservicesrestresource1.model.Customer;
import com.anupam.webservicesrestresource1.model.ModelFactory;

@Path("customers")
public class CustomerResource {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Customer> getCustomers(){
		return ModelFactory.getCustomers();
	}
	
	
	@GET
	@Path("customer/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomer(@PathParam("id") int id) {
		return ModelFactory.getCustomer(id);
	}
}
