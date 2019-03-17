package com.example.demo.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalDefaultErrorHandler {

	
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler({BusinessException.class})
	@ResponseBody
	public ErrorInf globalDefaultErrorHandle(HttpServletRequest request, Exception e) {
		
		ErrorInf errorInf=new ErrorInf();
		
	    errorInf.setMessage(e.getMessage());
	    errorInf.setUrl(request.getRequestURI());
		
		return errorInf;
		
		
	}
}
