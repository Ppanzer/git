package com.example.excalhandler.util;

public class IHPRequest {
	private String action;
	private IHPRequestHeader header;
	private Object body;
	
	public IHPRequest(){}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public IHPRequestHeader getHeader() {
		return header;
	}
	public void setHeader(IHPRequestHeader header) {
		this.header = header;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
}
