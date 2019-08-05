package com.lee.birthnotice.request;

import lombok.Data;

@Data
public abstract class BaseSessionRequest extends BaseRequest {
	private Integer userNumId;
}
