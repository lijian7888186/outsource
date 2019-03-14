package com.project.outsource.action.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.project.outsource.commons.ResData;
import com.project.outsource.commons.STATUS;

/**
* 名称: ExceptionController.java
* 类说明:
*
*/
@ControllerAdvice
public class ExceptionController {
	private static final Gson GSON = new Gson();
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String solveException(Exception exception) {
		LOGGER.error("服务器错误", exception);
		return GSON.toJson(new ResData(STATUS.ERROR));
	}
}
