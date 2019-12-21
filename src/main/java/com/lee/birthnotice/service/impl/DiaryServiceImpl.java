package com.lee.birthnotice.service.impl;

import com.lee.birthnotice.request.diary.DiaryAllFindRequest;
import com.lee.birthnotice.response.diary.DiaryAllFindResponse;
import com.lee.birthnotice.service.DiaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lzxy1
 */
@Service
@Slf4j
public class DiaryServiceImpl implements DiaryService {



	@Override
	public DiaryAllFindResponse findAllDiary(DiaryAllFindRequest request) {
		DiaryAllFindResponse response = new DiaryAllFindResponse();
		return response;
	}

	@Override
	public void addDiary() {

	}

	@Override
	public void updateDiary() {

	}
}
