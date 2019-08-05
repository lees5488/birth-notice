package com.lee.birthnotice.exception;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum BizError implements ExceptionEnum {

	DEMO_ERROR(1000001, "测试错误"),
	PARAM_ERROR(1000002, "参数错误"),
	SYSTEM_ERR(4010001, "系统异常");

	private static final Map<Integer, BizError> VALUE_LOOK_UP = new ConcurrentHashMap<>(values().length);

	static {
		for (BizError type : EnumSet.allOf(BizError.class)) {
			VALUE_LOOK_UP.put(type.code, type);
		}
	}

	private final int code;
	private final String msg;

	BizError(int value, String name) {

		this.code = value;
		this.msg = name;
	}

	public static BizError resolve(String value) {

		return (value != null ? VALUE_LOOK_UP.get(value) : null);
	}

	public static BizError fromValue(String value) {

		BizError data = VALUE_LOOK_UP.get(value);
		if (data == null) {
			throw new IllegalArgumentException("参数[" + value + "]不正确，没有找到对应的 BizError");
		}
		return data;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getDesc() {
		return msg;
	}

	public String getMsg() {

		return msg;
	}
}
