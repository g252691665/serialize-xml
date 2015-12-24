package com.henugao.geneatexml.domain;

public class Message {
	private String body;//短信内容
	private String date;//短信日期
	private String address; // 短信的地址，即来源
	private String type; // 是接收的还是发送
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Message(String body, String date, String address, String type) {
		super();
		this.body = body;
		this.date = date;
		this.address = address;
		this.type = type;
	}
	
	

}
