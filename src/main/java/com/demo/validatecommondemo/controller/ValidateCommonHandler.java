package com.demo.validatecommondemo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.validatecommondemo.vo.ResponeVo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ValidateCommonHandler extends ResponseEntityExceptionHandler {


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		ResponeVo vo = new ResponeVo();
		vo.setCode("400");
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			String defaultMessage = fieldError.getDefaultMessage();
			vo.setMsg(defaultMessage);
			Object value = fieldError.getRejectedValue();
			String data = "请求参数值为:"+JSON.toJSONString(value);
			vo.setData(data);
			break;
		}
		return new ResponseEntity(vo, HttpStatus.OK);
	}
}
