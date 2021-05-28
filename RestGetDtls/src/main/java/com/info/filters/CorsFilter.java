package com.info.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {
	
	public void filter(ContainerRequestContext requestContext,ContainerResponseContext response) throws IOException {
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		response.getHeaders().add("Access-Control-Allow-Headers", 
				 "CSRF-Token,X-Requested-By, Authorization,content-type");
		response.getHeaders().add("Access-Control-Allow-Credentials","true");
		response.getHeaders().add("Access-Control-Allow-Methods",
				"GET,POST,PUT,DELETE,OPTIONS,HEAD");
	}

}
