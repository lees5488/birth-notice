package com.lee.birthnotice.hadler;


import com.lee.birthnotice.exception.BizError;
import com.lee.birthnotice.exception.CommonException;
import com.lee.birthnotice.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ContextExceptionHandler {


	@ExceptionHandler(CommonException.class)
	@ResponseBody
	public BaseResponse commonExceptionHandler(HttpServletRequest request, CommonException exception) {
		return BaseResponse.error(exception.getCode(), exception.getMsg());
	}


	@ExceptionHandler(Exception.class)
	@ResponseBody
	public BaseResponse exceptionHandler(HttpServletRequest request, Exception exception) {
		log.info(ExceptionUtils.getStackTrace(exception));
		return BaseResponse.error(BizError.SYSTEM_ERR.getCode(), BizError.SYSTEM_ERR.getMsg());
	}
}
