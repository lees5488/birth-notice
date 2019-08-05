package com.lee.birthnotice.exception;

public class CommonException extends RuntimeException {

	private String msg;
	private int code = 500000;


	public CommonException(int code, String msg) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}


	public CommonException(int code, String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public CommonException(ExceptionEnum e) {
		super(e.getDesc());
		this.code = e.getCode();
		this.msg = e.getDesc();
	}



	public CommonException(String msg) {
		super(msg);
	}

	public CommonException(BizError bizError) {
		this(bizError.getCode(), bizError.getDesc());
	}


	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}
}
