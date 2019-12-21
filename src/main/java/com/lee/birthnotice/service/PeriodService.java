package com.lee.birthnotice.service;

import com.lee.birthnotice.request.period.PeriodAddRequest;
import com.lee.birthnotice.request.period.PeriodAllFindRequest;
import com.lee.birthnotice.request.period.PeriodUpdateRequest;
import com.lee.birthnotice.response.period.PeriodAddResponse;
import com.lee.birthnotice.response.period.PeriodAllFindResponse;
import com.lee.birthnotice.response.period.PeriodUpdateResponse;

public interface PeriodService {

	/**
	 * find all period
	 * @param request
	 * @return
	 */
	PeriodAllFindResponse findAllPeriod(PeriodAllFindRequest request);

	/**
	 * update
	 * @param request
	 * @return
	 */
	PeriodUpdateResponse updatePeriodById(PeriodUpdateRequest request);

	/**
	 * add
	 * @param request
	 * @return
	 */
	PeriodAddResponse addPeriodInfo(PeriodAddRequest request);

}
