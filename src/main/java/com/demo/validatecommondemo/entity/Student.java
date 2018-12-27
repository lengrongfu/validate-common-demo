package com.demo.validatecommondemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Data
public class Student {

	@Length(min = 1,message = "姓名不能为空")
	@NotNull(message = "姓名不能为空")
	private String name;

	@NotNull(message = "年龄不能为空")
	@Min(value = 18,message = "年龄不能小于18岁")
	@Max(value = 56,message = "年龄不能大于56岁")
	private Integer age;

	@NotNull(message = "邮箱不能为空")
	@Email(message = "邮箱地址无效")
	private String email;

	@Length
	@NotEmpty(message = "身份证号不能为空")
	@Pattern(regexp = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$",message = "请输入正确的身份证号")
	private String idCard;

	@NotEmpty(message = "手机号码不能为空")
	@Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "请输入正确的手机号码")
	private String phone;

	@NotNull(message = "请输入合法的时间")
	@Future(message = "请输入未来的时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date inSchoolDate;

	@NotNull(message = "请输入正确的银行卡号")
	@CreditCardNumber(message = "请输入正确的银行卡号")
	private String backCard;

	@NotEmpty(message = "请填写女朋友信息")
	private List<@Valid Girlfriend> girlfriends;
}
