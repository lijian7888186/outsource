package com.project.outsource.commons;
/**
* 名称: STATUS.java
* 类说明:
*
*/
public enum STATUS {
	SUCCESS("000", "成功"),
	PARAM_ERROR("100", "参数错误"),
	ERROR("999", "服务器错误");
	private String code;
	private String message;
	private STATUS() {
		
	}
	private STATUS(String code, String message) {
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
