package com.lee.birthnotice.controller;

import com.lee.birthnotice.model.PeriodInfo;
import com.lee.birthnotice.request.period.PeriodAddRequest;
import com.lee.birthnotice.request.period.PeriodAllFindRequest;
import com.lee.birthnotice.request.period.PeriodUpdateRequest;
import com.lee.birthnotice.response.BaseResponse;
import com.lee.birthnotice.response.period.PeriodAllFindResponse;
import com.lee.birthnotice.response.period.PeriodUpdateResponse;
import com.lee.birthnotice.service.PeriodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lee5488
 * @version 1.0 2019/12/20
 */

@RestController
@RequestMapping(value = "/period/")
@Api(value = "区间api",tags = {"区间相关接口"})
public class PeriodController {


    @Resource
    private PeriodService periodService;


    @PostMapping("/find_all_period")
    @ApiOperation("根据用户ID查询全部区间")
    public PeriodAllFindResponse findAllPeriodInfo(Integer userNumId){
        PeriodAllFindRequest request = new PeriodAllFindRequest();
        request.setUserNumId(userNumId);
        return periodService.findAllPeriod(request);
    }

    @PostMapping("/update_period")
    @ApiOperation("更新区间")
    public PeriodUpdateResponse updateById(@RequestBody PeriodInfo periodInfo){
        PeriodUpdateRequest request = new PeriodUpdateRequest();
        request.setPeriodInfo(periodInfo);
        return periodService.updatePeriodById(request);
    }


    @RequestMapping(name = "/add_period", method = RequestMethod.POST)
    @ApiOperation("新增区间")
    public BaseResponse addPeriodInfo(@RequestBody PeriodInfo periodInfo){
        PeriodAddRequest request = new PeriodAddRequest();
        request.setPeriodInfo(periodInfo);
        periodService.addPeriodInfo(request);
        return BaseResponse.success();
    }

}
