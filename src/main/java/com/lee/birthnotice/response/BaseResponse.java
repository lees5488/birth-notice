package com.lee.birthnotice.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {

  private static final long serialVersionUID = -6178782068740455844L;
  private int code = 0;

  private String message = "成功";

  public static int OK = 0;
  public static int EXCEPTION = 1;

  public int getCode() {
	return code;
  }

  public void setCode(int code) {
	this.code = code;
  }

  public String getMessage() {
	return message;
  }

  public void setMessage(String message) {
	this.message = message;
  }
}
