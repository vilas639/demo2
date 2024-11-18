package com.example.demo.exception;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ErrorResponse {

	
	
	private LocalDateTime timestamp;
	private int status;
	
	private String msg;

	
	
	

	public ErrorResponse(int status, String msg) {
		super();
		this.timestamp=LocalDateTime.now();
		this.status = status;
		this.msg = msg;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
