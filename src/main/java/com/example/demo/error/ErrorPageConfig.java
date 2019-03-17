package com.example.demo.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ErrorPageConfig implements ErrorPageRegistrar{

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400.html") ,
				
				new ErrorPage(HttpStatus.NOT_FOUND, "/404.html" ),
				new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html"),
				new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html")
				);
		
	}

	
}
