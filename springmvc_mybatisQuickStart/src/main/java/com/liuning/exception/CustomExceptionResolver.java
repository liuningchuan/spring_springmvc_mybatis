package com.liuning.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description 全局异常处理器
 * @author	LiuNing
 * @date	2017-11-2晚上21:08:09
 * @version 1.0
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	/**
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex 系统 抛出的异常
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		//handler就是处理器适配器要执行Handler对象（只有method）
		
		//解析出异常类型
		//如果该异常类型是系统自定义的异常，直接取出异常信息，在错误页面展示
		CustomException customException = null;
		if(ex instanceof CustomException){
			customException = (CustomException)ex;
		}else{
			customException = new CustomException("未知错误");
			System.out.println("未知错误");
		}
		//错误信息
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		//将错误信息传到页面
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error");

		return modelAndView;
	}

}
