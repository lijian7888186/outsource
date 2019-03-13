package com.project.outsource.commons;
/**
* 名称: ResData.java
* 类说明:返回的数据
*
*/
public class ResData {
	private String code;
	private Object data;
	private String message;
	public ResData() {
		
	}
	public ResData(STATUS status) {
		this.code = status.getCode();
		this.message = status.getMessage();
		this.data = "";
	}
	public ResData(String code, Object data, String message) {
		this.code = code;
		this.data = data;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
