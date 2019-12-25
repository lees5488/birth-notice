package com.lee.birthnotice.controller;

import com.lee.birthnotice.response.festival.QueryFestivalNoticeResponse;
import com.lee.birthnotice.service.FestivalNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lee5488
 * @version 1.0 2019/12/25
 */
@RestController
@Api(value = "节日api", tags = "节日相关接口")
@RequestMapping(("/festival/"))
public class FestivalNoticeController {

    @Resource
    private FestivalNoticeService festivalNoticeService;

    @PostMapping("/query")
    @ApiOperation("查询节日")
    public QueryFestivalNoticeResponse queryFestivalNotice(Integer type) {
        QueryFestivalNoticeResponse response = new QueryFestivalNoticeResponse();
        response.setFestivalNoticeList(festivalNoticeService.findAllFestivalNoticeByType(type));
        return response;
    }


}
