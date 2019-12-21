package com.lee.birthnotice.service;


import com.lee.birthnotice.request.diary.DiaryAllFindRequest;
import com.lee.birthnotice.response.diary.DiaryAllFindResponse;

/**
 * @author lee5488
 */
public interface DiaryService {

	/**
	 * 查询全部日记
	 * @param request
	 * @return
	 */
	DiaryAllFindResponse findAllDiary(DiaryAllFindRequest request);

	/**
	 * 新增日记
	 */
	void addDiary();

	/**
	 * 更新日记
	 */
	void updateDiary();

}
