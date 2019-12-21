package com.lee.birthnotice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lee.birthnotice.dao.BirthNoticeDao;
import com.lee.birthnotice.model.BirthNotice;
import com.lee.birthnotice.request.birth.BirthNoticeInsertRequest;
import com.lee.birthnotice.request.birth.BirthNoticeListAllGetRequest;
import com.lee.birthnotice.request.BirthNoticeMsmMessageSendRequest;
import com.lee.birthnotice.response.birth.BirthNoticeInsertResponse;
import com.lee.birthnotice.response.birth.BirthNoticeListAllGetResponse;
import com.lee.birthnotice.service.BirthNoticeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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

  @Test
  public void insertBirthNotice(){
	BirthNoticeInsertRequest request = new BirthNoticeInsertRequest();
	List<BirthNotice> list = new ArrayList<>();
	BirthNotice birthNotice = new BirthNotice();
	birthNotice.setName("王五");
	birthNotice.setNick("王武武");
	birthNotice.setOldBirth("20181121");
	birthNotice.setSendType(8);
	birthNotice.setPinyin("wangwu");
	birthNotice.setPhone("13111111111");
	BirthNotice birthNotice1 = new BirthNotice();
	birthNotice1.setName("赵六");
	birthNotice1.setNick("赵柳柳");
	birthNotice1.setOldBirth("20181120");
	birthNotice1.setSendType(8);
	birthNotice1.setPinyin("zhaoliu");
	birthNotice1.setPhone("1333333333333333333333333333333333333");
	list.add(birthNotice1);
	list.add(birthNotice);
	request.setData(list);
	BirthNoticeInsertResponse response = birthNoticeService.insertBirthNotice(request);
	logger.info(JSON.toJSONString(response,SerializerFeature.WriteMapNullValue));
  }
}
