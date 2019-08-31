package com.lee.birthnotice.response;

import lombok.Data;

@Data
public class BasePageResponse extends BaseResponse {

	private static final long serialVersionUID = -3421016549704702743L;

	private Integer pageSize;

	private Integer page;
}
