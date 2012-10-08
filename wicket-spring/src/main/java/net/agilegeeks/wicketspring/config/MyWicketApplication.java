package net.agilegeeks.wicketspring.config;

import net.agilegeeks.wicketspring.pages.home.HomePage;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyWicketApplication extends WebApplication {

	private static final Logger log = LoggerFactory.getLogger(MyWicketApplication.class);
	
	@Override
	public Class<HomePage> getHomePage() {
 
		return HomePage.class; // return default page
	}
 
	@Override
	protected void init() {
 
		super.init();
		
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
 
	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.protocol.http.WebApplication#newSession(org.apache.wicket.request.Request, org.apache.wicket.request.Response)
	 */
	@Override
	public Session newSession(Request request, Response response) {
		log.trace("newSession: {}", request);
		return super.newSession(request, response);
	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.protocol.http.WebApplication#sessionUnbound(java.lang.String)
	 */
	@Override
	public void sessionUnbound(String sessionId) {
		log.trace("sessionUnbound: {}", sessionId);
		super.sessionUnbound(sessionId);
	}

	
 
}