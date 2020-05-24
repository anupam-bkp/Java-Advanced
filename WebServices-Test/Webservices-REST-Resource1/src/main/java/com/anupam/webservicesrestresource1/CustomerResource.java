package com.anupam.webservicesrestresource1;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.anupam.webservicesrestresource1.model.Customer;
import com.anupam.webservicesrestresource1.model.ModelFactory;

@Path("customers")
public class CustomerResource {
	
	//Produces only XML data
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Customer> getCustomers(){
		System.out.println("Calling Customers");
		return ModelFactory.getCustomers();
	}
	

	/**
	 * Using PathParams and Content Negotiation.
	 * Produces both XML and JSON data
	 * @param id
	 */
	@GET
	@Path("customer/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Customer getCustomer(@PathParam("id") int id) {
		return ModelFactory.getCustomer(id);
	}
	
	//Consumes only XML data
	@POST
//	@Path("customer")
	@Consumes(MediaType.APPLICATION_XML)
	public Customer createCustomerXML(Customer cust) {
		
//		ModelFactory.
		System.out.println("From server : " + cust);
		
		return cust;
	}
	
	/**
	 * Consumes only XML and JSON data
	 * To consume every other form of data remove @Consumes annotation
	 * @param cust
	 */
	@POST
	@Path("customer2")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Customer createCustomerGeneric(Customer cust) {
		
//		ModelFactory.
		System.out.println("From server : " + cust);
		
		return cust;
	}
	
	@PUT
	@Path("customer")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Customer updateCustomer(Customer cust) {
		
		//Code To Update
		
		System.out.println("Updating Resource : " + cust);
		return cust;
	}
	
	@DELETE
	@Path("customer/{id}")
	public Customer deleteCustomer(@PathParam("id") int id) {
		
		//Code To Delete
		
		return ModelFactory.getCustomer(id);
	}
	
}





