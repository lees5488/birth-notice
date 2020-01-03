package com.lee.birthnotice.service.impl;

import com.lee.birthnotice.enums.Weather;
import com.lee.birthnotice.mapper.DiaryMapper;
import com.lee.birthnotice.model.Diary;
import com.lee.birthnotice.request.diary.DiaryAllFindRequest;
import com.lee.birthnotice.response.diary.DiaryAllFindResponse;
import com.lee.birthnotice.service.DiaryService;
import com.lee.birthnotice.utils.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lzxy1
 */
@Service
@Slf4j
public class DiaryServiceImpl implements DiaryService {


	@Resource
	private DiaryMapper diaryMapper;

	@Override
	public DiaryAllFindResponse findAllDiary(DiaryAllFindRequest request) {
		DiaryAllFindResponse response = new DiaryAllFindResponse();
		return response;
	}

	@Override
	public String addDiary(Diary diary) {
		if (diary != null){
			Assert.notBlank(diary.getContent(),"content can not be null");
			Assert.notBlank(diary.getWeather(),"content can not be null");
			if (!Weather.contains(diary.getWeather())){
				return "天气必须在如下范围之内" + Weather.contactName();
			}
			//这里可以考虑调用修改接口；
			if (diaryMapper.getDiaryBydiaryDate() > 0){
				return "今天的日志已经新增，请勿重复操作";
			}
			diaryMapper.insertDiary(diary);
		}
		return null;
	}

	@Override
	public void updateDiary() {

	}
}
