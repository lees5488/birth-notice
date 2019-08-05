package com.lee.birthnotice.model;

import lombok.Data;

/**
 * 需要发送的msg
 */
@Data
public class SendMsg {
	/**信息*/
	private String msg;
	/**接收手机号码*/
	private String receiveNumber;
	/**使用模板*/
	private int template;
}
