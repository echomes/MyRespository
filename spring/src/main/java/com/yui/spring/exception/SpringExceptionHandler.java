package com.yui.spring.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理类
 * 
 * @author Echo
 *
 */
@ControllerAdvice
public class SpringExceptionHandler {

	public static final String GLOBELE_ERROR_VIEW = "error";

	/**
	 * 异常处理
	 * 
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView();

		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());

		mav.setViewName(GLOBELE_ERROR_VIEW);
		return mav;
	}
}
