package API;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/API")
public class RESTfulConfig extends ResourceConfig {
	public RESTfulConfig(){
		this.packages("API","cardPoint.model");
	}
}
