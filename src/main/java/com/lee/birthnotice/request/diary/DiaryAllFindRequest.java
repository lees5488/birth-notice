package com.lee.birthnotice.request.diary;

import com.lee.birthnotice.model.Diary;
import com.lee.birthnotice.response.BasePageResponse;
import lombok.Data;


@Data
public class DiaryAllFindRequest extends BasePageResponse {
	private static final long serialVersionUID = -819088565298510749L;
	private Diary diary;

}
