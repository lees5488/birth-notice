package com.lee.birthnotice;

import com.alibaba.fastjson.JSON;
import com.lee.birthnotice.service.FestivalNoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author lee5488
 * @version 1.0 2020/1/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FestivalNoticeTests {


    @Resource
    private FestivalNoticeService festivalNoticeService;

    @Test
    public void test1(){
        System.out.println(JSON.toJSONString(festivalNoticeService.findAllFestivalNoticeByType(1)));
    }
}
