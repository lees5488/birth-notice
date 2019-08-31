package com.lee.birthnotice.response.diary;

import com.lee.birthnotice.model.Diary;
import com.lee.birthnotice.response.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class DiaryAllFindResponse extends BaseResponse {
	private static final long serialVersionUID = -4550016619889900200L;
	private List<Diary> diaryList;
}
