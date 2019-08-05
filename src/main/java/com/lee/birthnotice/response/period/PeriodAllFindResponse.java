package com.lee.birthnotice.response.period;

import com.lee.birthnotice.model.PeriodInfo;
import com.lee.birthnotice.response.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * find all period
 */

@Data
public class PeriodAllFindResponse extends BaseResponse {
	private static final long serialVersionUID = 5551730978496313188L;

	List<PeriodInfo> periodInfoList;

}
