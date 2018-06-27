package cn.erlaila.mybatis.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class CustomExceptionResolver implements HandlerExceptionResolver {


	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		CustomException customException = null;
		if(ex instanceof CustomException){
			customException = (CustomException)ex;
		}else{
			customException = new CustomException("未知错误");
		}	
		String message = customException.getMessage();	
		//将错误信息传到页面
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);		
		//指向错误页面
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
