package com.demo.validatecommondemo.vo;

import lombok.Data;

@Data
public class ResponeVo<T> {
	private String code;
	private String msg;
	private T data;

	public static <T> ResponeVo<T> create(T t){
		ResponeVo<T> vo = new ResponeVo<T>();
		vo.setData(t);
		vo.setCode("200");
		vo.setMsg("成功");
		return vo;
	}
}
