package com.lee.birthnotice.service.impl;

import com.alibaba.fastjson.JSON;
import com.lee.birthnotice.dao.PeriodDao;
import com.lee.birthnotice.exception.BizError;
import com.lee.birthnotice.model.PeriodInfo;
import com.lee.birthnotice.request.period.PeriodAddRequest;
import com.lee.birthnotice.request.period.PeriodAllFindRequest;
import com.lee.birthnotice.request.period.PeriodUpdateRequest;
import com.lee.birthnotice.response.period.PeriodAddResponse;
import com.lee.birthnotice.response.period.PeriodAllFindResponse;
import com.lee.birthnotice.response.period.PeriodUpdateResponse;
import com.lee.birthnotice.service.PeriodService;
import com.lee.birthnotice.utils.Assert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class PeriodServiceImpl implements PeriodService {


	private static final Log logger = LogFactory.getLog(PeriodServiceImpl.class);



	@Resource
	private PeriodDao periodDao;



	@Override
	public PeriodAllFindResponse findAllPeriod(PeriodAllFindRequest request) {
		logger.info("findAllPeriod start：" + JSON.toJSONString(request));
		PeriodAllFindResponse response = new PeriodAllFindResponse();
		Integer userNumId = request.getUserNumId();
		List<PeriodInfo> periodInfoList = periodDao.findAllPeriodByUserId(userNumId);
		response.setPeriodInfoList(periodInfoList);
		logger.info("findAllPeriod end：" + JSON.toJSONString(response));
		return response;
	}



	@Override
	public PeriodUpdateResponse updateById(PeriodUpdateRequest request) {
		logger.info("updateById start：" + JSON.toJSONString(request));
		PeriodUpdateResponse response = new PeriodUpdateResponse();
		Assert.notNull(request.getPeriodInfo().getId(),BizError.PARAM_ERROR);
		periodDao.update(request.getPeriodInfo());
		logger.info("updateById end：" + JSON.toJSONString(response));
		return response;
	}



	@Override
	public PeriodAddResponse addPeriodInfo(PeriodAddRequest request) {
		logger.info("addPeriodInfo start：" + JSON.toJSONString(request));
		Assert.notNull(request,BizError.PARAM_ERROR);
		PeriodAddResponse response = new PeriodAddResponse();
		PeriodInfo periodInfo = request.getPeriodInfo();
		periodInfo.setCreateDate(new Date());
		periodInfo.setUpdateDate(new Date());
		periodDao.insert(periodInfo);
		logger.info("addPeriodInfo end：" + JSON.toJSONString(response));
		return response;
	}


}
