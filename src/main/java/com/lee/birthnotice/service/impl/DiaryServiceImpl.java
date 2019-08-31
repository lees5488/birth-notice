package com.lee.birthnotice.service.impl;

import com.alibaba.fastjson.JSON;
import com.lee.birthnotice.request.diary.DiaryAllFindRequest;
import com.lee.birthnotice.response.diary.DiaryAllFindResponse;
import com.lee.birthnotice.service.DiaryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService {

	private static final Log logger = LogFactory.getLog(DiaryServiceImpl.class);


	@Override
	public DiaryAllFindResponse findAllDiary(DiaryAllFindRequest request) {
		logger.info("findAllDiary start：" + JSON.toJSONString(request));
		DiaryAllFindResponse response = new DiaryAllFindResponse();

		logger.info("findAllDiary start：" + JSON.toJSONString(response));
		return response;
	}

	@Override
	public void addDiary() {

	}

	@Override
	public void updateDiary() {

	}
}
