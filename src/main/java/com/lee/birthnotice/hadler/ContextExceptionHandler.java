package com.lee.birthnotice.hadler;


import com.lee.birthnotice.exception.CommonException;
import com.lee.birthnotice.response.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ContextExceptionHandler {


	@ExceptionHandler(CommonException.class)
	@ResponseBody
	public BaseResponse commonExceptionHandler(HttpServletRequest request, CommonException exception) {
		return BaseResponse.error(exception.getCode(), exception.getMsg());
	}
}
