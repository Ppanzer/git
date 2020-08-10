package com.example.excalhandler.util;

public class IHPRequestHeader {
	private String requestId;
	private long timeStamp;
	private String accessToken;
	private String appCode;
	private String appSecretKey;
	
	private String securityKey;
	
	public IHPRequestHeader(){}
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public String getAppSecretKey() {
		return appSecretKey;
	}
	public void setAppSecretKey(String appSecretKey) {
		this.appSecretKey = appSecretKey;
	}

	public String getSecurityKey() {
		return securityKey;
	}

	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}
	
}
