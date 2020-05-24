package com.anupam.webservicesrestclient1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String MEDIA_TYPE = MediaType.APPLICATION_XML; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String customers = getCustomers();
		PrintWriter out = response.getWriter();
		out.println(customers);
	}
	
	private static String getCustomers() {
		
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		
		String mediaType = "";
	
		mediaType = MediaType.APPLICATION_XML;
		final String webresource = 
				"http://localhost:8080/Webservices-REST-Resource1/webapi/customers";

		
	/*	mediaType = MediaType.APPLICATION_JSON;
		final String webresource = 
				"http://localhost:8080/Webservices-REST-Resource1/webapi/customers/customer/1";
		*/
		WebTarget target = client.target(webresource);
		
		//Get XML
		String response = 
				target.request().accept(mediaType)
				.get(String.class);
		System.out.println("Customer Servlet Customer : " + response);
		
		return response;
	}
}