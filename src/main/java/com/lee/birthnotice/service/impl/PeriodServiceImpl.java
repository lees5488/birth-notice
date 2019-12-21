package com.lee.birthnotice.service.impl;

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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @author lzxy1
 */
@Service
public class PeriodServiceImpl implements PeriodService {


    @Resource
    private PeriodDao periodDao;


    @Override
    public PeriodAllFindResponse findAllPeriod(PeriodAllFindRequest request) {
        PeriodAllFindResponse response = new PeriodAllFindResponse();
        Integer userNumId = request.getUserNumId();
        List<PeriodInfo> periodInfoList = periodDao.findAllPeriodByUserId(userNumId);
        response.setPeriodInfoList(periodInfoList);
        return response;
    }


    @Override
    public PeriodUpdateResponse updatePeriodById(PeriodUpdateRequest request) {
        PeriodUpdateResponse response = new PeriodUpdateResponse();
        Assert.notNull(request.getPeriodInfo().getId(), BizError.PARAM_ERROR);
        periodDao.updatePeriodById(request.getPeriodInfo());
        return response;
    }


    @Override
    public PeriodAddResponse addPeriodInfo(PeriodAddRequest request) {
        Assert.notNull(request, BizError.PARAM_ERROR);
        PeriodAddResponse response = new PeriodAddResponse();
        PeriodInfo periodInfo = request.getPeriodInfo();
        periodInfo.setCreateDate(new Date());
        periodInfo.setUpdateDate(new Date());
        periodDao.insert(periodInfo);
        return response;
    }


}
