package com.lee.birthnotice;

import com.alibaba.fastjson.JSON;
import com.lee.birthnotice.dao.BirthNoticeDao;
import com.lee.birthnotice.model.BirthNotice;
import com.lee.birthnotice.request.BirthNoticeListAllGetRequest;
import com.lee.birthnotice.request.BirthNoticeMsmMessageSendRequest;
import com.lee.birthnotice.response.BirthNoticeListAllGetResponse;
import com.lee.birthnotice.service.BirthNoticeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BirthNoticeServiceTests {

  private static final Log logger = LogFactory.getLog(BirthNoticeServiceTests.class);
  @Autowired
  private BirthNoticeDao birthNoticeDao;
  @Autowired
  private BirthNoticeService birthNoticeService;


  @Test
  public void birthNoticeDao(){
	List<BirthNotice> entity = birthNoticeDao.getEntity();
	System.out.println(JSON.toJSONString(entity));
  }

  @Test
  public void getAllBirthNoticeList(){
	BirthNoticeListAllGetRequest request = new BirthNoticeListAllGetRequest();
	BirthNoticeListAllGetResponse response = birthNoticeService.getAllBirthNoticeList(request);
	logger.info(JSON.toJSONString(response));
  }

  @Test
  public void sendBirthNoticeMsmMessage(){
	BirthNoticeMsmMessageSendRequest request = new BirthNoticeMsmMessageSendRequest();
	BirthNoticeListAllGetRequest request1 = new BirthNoticeListAllGetRequest();
	BirthNoticeListAllGetResponse response = birthNoticeService.getAllBirthNoticeList(request1);
	request.setData(response.getData());
	birthNoticeService.sendBirthNoticeMsmMessage(request);
  }
}
