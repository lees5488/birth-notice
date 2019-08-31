package com.lee.birthnotice.response.birth;

import com.lee.birthnotice.model.BirthNotice;
import com.lee.birthnotice.response.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class AdvanceMonthBirthNoticeResponse extends BaseResponse {
	private static final long serialVersionUID = -4218654188197082842L;
	private List<BirthNotice> data;
}
