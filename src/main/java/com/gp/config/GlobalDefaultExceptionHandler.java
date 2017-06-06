package com.gp.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String dafaultExceptionHandler(HttpServletRequest request,Exception e){
	 return "访问信息错误";
	}
}
