package com.Filter.Filters;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
@Order(1)
public class AuthenticationFilter implements  Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		//Authenticate user or request by header with "Authentication" key if headers
		String auth = httpRequest.getHeader("Authentication");
		
		if(auth.equals("123456")) {
			chain.doFilter(httpRequest, httpResponse);
		}
		else {
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			httpResponse.setContentType("application/json");

			httpResponse.getWriter().write(
			    "{\"message\":\"Authentication key is wrong\"}"
			);
			return;
		}
	}

	
	
	
	
	
}
