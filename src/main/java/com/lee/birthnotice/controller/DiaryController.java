package com.lee.birthnotice.controller;


import com.lee.birthnotice.request.diary.DiaryAddRequest;
import com.lee.birthnotice.response.BaseResponse;
import com.lee.birthnotice.response.diary.DiaryAddResponse;
import com.lee.birthnotice.service.DiaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author lee5488
 * @version 1.0 2020/1/3
 */
@RestController
@Api(value = "日记接口", tags = "日记")
@RequestMapping("/diary/")
public class DiaryController {

    @Resource
    private DiaryService diaryService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增日记")
    public BaseResponse addDiary(@RequestBody DiaryAddRequest request) {
        DiaryAddResponse response = new DiaryAddResponse();
        String result = diaryService.addDiary(request.getDiary());
        if (!StringUtils.isEmpty(result)){
            response.setMessage(result);
        }
        return response;
    }
}
