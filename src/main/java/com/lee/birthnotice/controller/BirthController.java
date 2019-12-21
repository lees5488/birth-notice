package com.lee.birthnotice.controller;

import com.lee.birthnotice.request.birth.BirthNoticeInsertRequest;
import com.lee.birthnotice.request.birth.BirthNoticeListAllGetRequest;
import com.lee.birthnotice.request.birth.QueryNoticeRequest;
import com.lee.birthnotice.response.BaseResponse;
import com.lee.birthnotice.response.birth.BirthNoticeListAllGetResponse;
import com.lee.birthnotice.response.birth.QueryNoticeResponse;
import com.lee.birthnotice.service.BirthNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lee5488
 * @version 1.0 2019/12/20
 */
@RestController
@Api(value = "生日api", tags = "生日相关接口")
@RequestMapping(value = "/birth/")
public class BirthController {

    @Resource
    private BirthNoticeService birthNoticeService;

    @PostMapping("/add")
    @ApiOperation("新增生日")
    public BaseResponse noticeInsert(@RequestBody BirthNoticeInsertRequest request) {
        birthNoticeService.insertBirthNotice(request);
        return BaseResponse.success();
    }


    @PostMapping("/query")
    @ApiOperation("查询生日")
    public QueryNoticeResponse queryNotice(@RequestBody QueryNoticeRequest request) {
        return birthNoticeService.queryNotice(request);
    }


    @PostMapping("/query_all")
    @ApiOperation("查询全部生日")
    public BirthNoticeListAllGetResponse getAllBirthNotice(@RequestBody BirthNoticeListAllGetRequest request) {
        return birthNoticeService.getAllBirthNoticeList(request);
    }


    @GetMapping("/delete/{id}")
    @ApiOperation("删除生日")
    public BaseResponse deleteNotice(@PathVariable("id") String id) {
        birthNoticeService.deleteNotice(id);
        return BaseResponse.success();
    }


}
