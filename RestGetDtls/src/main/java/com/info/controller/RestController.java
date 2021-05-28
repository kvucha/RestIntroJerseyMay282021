package com.info.controller;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.info.dao.dataExtractDao;
import com.info.model.StateCityInfo;








@Path("/suresh")
public class RestController {
	
	
	
	// http://localhost:8080/RestGetDtls/webapi/getDtlsWithCity/NAGPUR
	
	//json, xml  data representation
	
    @GET
    @Path("/getDtlsWithCity/{city_name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfo(@PathParam("city_name") String city_name)
	{
    	System.out.println("The value of city name is  "+ city_name);
    	dataExtractDao dao = new dataExtractDao();
    	StateCityInfo sci = dao.getLocDetails(city_name);
    	return Response.status(201).entity(sci).build();
	}

	
	////////////////
    
    @GET
    @Path("/getDtlsTotal")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDtls()
	{
    	
    	dataExtractDao dao = new dataExtractDao();
    	List<StateCityInfo> sciList = dao.getAllCitiesDtls();
    	return Response.status(201).entity(sciList).build();
	}

    
    
}
