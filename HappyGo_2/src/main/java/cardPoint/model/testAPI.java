package cardPoint.model;

import javax.ws.rs.*;
import javax.ws.rs.Path;

@Path("/test")
public class testAPI {
	@GET
	@Path("/{id}")
	@Produces("text/html")
	public String hello(@PathParam("id") int id){
		String hello;
		hello = "hello World"+ id ;
		return hello;
		
	}
}
