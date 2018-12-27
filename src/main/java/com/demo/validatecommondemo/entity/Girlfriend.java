package com.demo.validatecommondemo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Girlfriend {

	@NotEmpty(message = "请输入姓名")
	private String name;

	@NotNull(message = "请输入年龄")
	@Range(min = 18,max = 24,message = "对不起，年龄不在合适的范围内")
	private Integer age;
	@NotNull(message = "请输入性别")
	@Digits(integer = 1,fraction = 0,message = "只接受女性为女朋友")
	private Integer gender;
}
