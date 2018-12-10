package com.lee.birthnotice;

import com.alibaba.fastjson.JSON;
import com.lee.birthnotice.request.BirthNoticeListAllGetRequest;
import com.lee.birthnotice.response.BirthNoticeListAllGetResponse;
import com.lee.birthnotice.service.BirthNoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BirthNoticeApplicationTests {


  @Autowired
  private BirthNoticeService birthNoticeService;

  @Test
  public void contextLoads() {
  }

  @Test
  public void birthNotice(){
    BirthNoticeListAllGetRequest request = new BirthNoticeListAllGetRequest();
    BirthNoticeListAllGetResponse allBirthNoticeList = birthNoticeService.getAllBirthNoticeList(request);
    System.out.println(JSON.toJSONString(allBirthNoticeList));
  }


}
