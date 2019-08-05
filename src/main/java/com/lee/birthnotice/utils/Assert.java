package com.lee.birthnotice.utils;

import com.lee.birthnotice.exception.CommonException;
import com.lee.birthnotice.exception.ExceptionEnum;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public class Assert{


		public static void isTrue(boolean expression, String message) {
			if (!expression) {
				throw new CommonException(message);
			}
		}

		public static void isTrue(boolean expression, int errorCode, String message) {
			if (!expression) {
				throw new CommonException(errorCode, message);
			}
		}

		public static void isTrue(boolean expression, ExceptionEnum error) {
			if (!expression) {
				throw new CommonException(error.getCode(), error.getDesc());
			}
		}

		public static void notNull(Object obj, String message) {
			if (obj == null) {
				throw new CommonException(message);
			}
		}

		public static void notNull(Object obj, int code, String message) {
			if (obj == null) {
				throw new CommonException(code, message);
			}
		}

		public static void notNull(Object obj, ExceptionEnum error) {
			if (obj == null) {
				throw new CommonException(error.getCode(), error.getDesc());
			}
		}

		public static void notBlank(String obj, String message) {
			if (StringUtils.isEmpty(obj)) {
				throw new CommonException(message);
			}
		}

		public static void notBlank(String obj, int code, String message) {
			if (StringUtils.isEmpty(obj)) {
				throw new CommonException(code, message);
			}
		}

		public static void notBlank(String obj, ExceptionEnum error) {
			if (StringUtils.isEmpty(obj)) {
				throw new CommonException(error.getCode(), error.getDesc());
			}
		}

		public static void notEmpty(Object[] array, String message) {
			if (ObjectUtils.isEmpty(array)) {
				throw new CommonException(message);
			}
		}

		public static void notEmpty(Object[] array, int code, String message) {
			if (ObjectUtils.isEmpty(array)) {
				throw new CommonException(code, message);
			}
		}

		public static void notEmpty(Object[] array, ExceptionEnum error) {
			if (ObjectUtils.isEmpty(array)) {
				throw new CommonException(error.getCode(), error.getDesc());
			}
		}

		public static void notEmpty(Collection<?> collection, String message) {
			if (CollectionUtils.isEmpty(collection)) {
				throw new CommonException(message);
			}
		}

		public static void notEmpty(Collection<?> collection, int code, String message) {
			if (CollectionUtils.isEmpty(collection)) {
				throw new CommonException(code, message);
			}
		}

		public static void notEmpty(Collection<?> collection, ExceptionEnum error) {
			if (CollectionUtils.isEmpty(collection)) {
				throw new CommonException(error.getCode(), error.getDesc());
			}
		}

		public static void notEmpty(Map<?, ?> map, String message) {
			if (CollectionUtils.isEmpty(map)) {
				throw new CommonException(message);
			}
		}

		public static void notEmpty(Map<?, ?> map, int code, String message) {
			if (CollectionUtils.isEmpty(map)) {
				throw new CommonException(code, message);
			}
		}

		public static void notEmpty(Map<?, ?> map, ExceptionEnum error) {
			if (CollectionUtils.isEmpty(map)) {
				throw new CommonException(error.getCode(), error.getDesc());
			}
		}

		public static void isRegexWithReg(String str, String reg, ExceptionEnum error){
			isRegex(str,reg,error);
		}

		private static void isRegex(String str, String reg, ExceptionEnum error){
			Pattern compile = Pattern.compile(reg);
			if(str == null || !compile.matcher(str).matches()){
				throw new CommonException(error.getCode(), error.getDesc());
			}
		}

		public static void isPositiveMultiple(Integer param, Integer multiple, ExceptionEnum error){
			if (param == null || param <= 0 || multiple == 0 || param%multiple != 0){
				throw new CommonException(error.getCode(), error.getDesc());
			}
		}

		public static void isPositive(Integer param, ExceptionEnum error) {
			if (param == null || param <= 0) {
				throw new CommonException(error.getCode(), error.getDesc());
			}
		}





}