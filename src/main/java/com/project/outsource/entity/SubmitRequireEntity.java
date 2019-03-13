package com.project.outsource.entity;
/**
* 名称: SubmitRequireEntity.java
* 类说明:需求实体类
*
*/
public class SubmitRequireEntity {
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 需求内容
	 */
	private String content;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
