package com.solutionia.restmessenger.resource;

import java.util.Date;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
public class DemoInjectResource {
	// http://localhost:8080/rest-demo-massenger/webapi/injectdemo/annotations;name="Emrul"

	@GET
	@Path("/annotations")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParams(
			@MatrixParam("name") String matrixparam,
			@HeaderParam("name") String headerParam,
			@CookieParam("name")String cookieParam) {
		return "Matrix Param: " + matrixparam + "\n" + "HeaderParam: " + headerParam+"\n"+"Cookie Param: "+cookieParam;
	}
	
	@GET
	@Path("/contexts")
	@Produces(MediaType.TEXT_PLAIN)
	public String getContexts(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders ) {
		
		String absoluteUri=uriInfo.getAbsolutePath().toString();
		Date date=httpHeaders.getDate();
		
		return "Absulute Uri: "+absoluteUri+"\n"+"Date: "+date;
	}

}
