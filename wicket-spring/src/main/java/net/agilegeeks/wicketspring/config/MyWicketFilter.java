package net.agilegeeks.wicketspring.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class MyWicketFilter extends WicketFilter {
	
	private static final Logger log = LoggerFactory.getLogger(MyWicketFilter.class);

	static long requestId = 0;

	private static synchronized long getNextRequestId() {
		return requestId++;
	}
	
	public MyWicketFilter() {
		super();
	}

	public MyWicketFilter(WebApplication application) {
		super(application);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.wicket.protocol.http.WicketFilter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession(false);
		
		String relativePath = getRelativePath(httpServletRequest);
		String redirectUri = checkIfRedirectRequired(httpServletRequest.getRequestURI(), httpServletRequest.getContextPath());
		
		String sessionId = "";
		if(session != null) {
			sessionId = session.getId();
		}
		
		MDC.put("requestId", String.valueOf(getNextRequestId()));		
		MDC.put("remoteAddr", request.getRemoteAddr());
		MDC.put("sessionId", sessionId);
		
		log.trace("relativePath: {}", relativePath);
		log.trace("redirectUri: {}", redirectUri);
		log.trace("doFilter begin");
		
		super.doFilter(request, response, chain);

		log.trace("doFilter end");
	}

}
