package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {

	private String statusText;
	private int status;
	private String message;
	private Object data;
	private Object error;
	private boolean isApiTimeout;
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	public boolean isApiTimeout() {
		return isApiTimeout;
	}
	public void setApiTimeout(boolean isApiTimeout) {
		this.isApiTimeout = isApiTimeout;
	}
	
	

}
