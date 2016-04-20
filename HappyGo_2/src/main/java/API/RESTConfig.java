package API;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import cardPoint.model.CardPointService;


public class RESTConfig extends Application {

	Set<Object> singletons = new HashSet<Object>();
	public RESTConfig() {
		singletons.add(new CardPointService());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
