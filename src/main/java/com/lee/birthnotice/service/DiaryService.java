package com.lee.birthnotice.service;


import com.lee.birthnotice.request.diary.DiaryAllFindRequest;
import com.lee.birthnotice.response.diary.DiaryAllFindResponse;

public interface DiaryService {

	DiaryAllFindResponse findAllDiary(DiaryAllFindRequest request);
	void addDiary();
	void updateDiary();

}
