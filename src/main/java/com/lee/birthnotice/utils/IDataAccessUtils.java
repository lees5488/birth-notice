package com.lee.birthnotice.utils;

import org.springframework.dao.IncorrectResultSizeDataAccessException;

import java.util.Collection;

public class IDataAccessUtils {
  IDataAccessUtils() {
  }

  public static <T> T requiredSingleResult(Collection<T> results) throws IncorrectResultSizeDataAccessException {
	int size = results != null ? results.size() : 0;
	if (size == 0) {
	  return null;
	} else if (results.size() > 1) {
	  throw new IncorrectResultSizeDataAccessException(1, size);
	} else {
	  return results.iterator().next();
	}
  }
}