package com.lee.birthnotice.service.impl;

import com.alibaba.fastjson.JSON;
import com.lee.birthnotice.dao.BirthNoticeDao;
import com.lee.birthnotice.model.BirthNotice;
import com.lee.birthnotice.request.BirthNoticeInsertRequest;
import com.lee.birthnotice.request.BirthNoticeListAllGetRequest;
import com.lee.birthnotice.request.BirthNoticeMsmMessageSendRequest;
import com.lee.birthnotice.response.BirthNoticeInsertResponse;
import com.lee.birthnotice.response.BirthNoticeListAllGetResponse;
import com.lee.birthnotice.response.BirthNoticeMsmMessageSendResponse;
import com.lee.birthnotice.service.BirthNoticeService;
import com.lee.birthnotice.utils.CalendarUtil;
import com.lee.birthnotice.utils.Constant;
import com.lee.birthnotice.utils.SmsSendUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class BirthNoticeServiceImpl implements BirthNoticeService {

  private static final Log logger = LogFactory.getLog(BirthNoticeServiceImpl.class);

  @Autowired
  private BirthNoticeDao birthNoticeDao;


  @Override
  public BirthNoticeListAllGetResponse getAllBirthNoticeList(
		  BirthNoticeListAllGetRequest request) {
	logger.info("getAllBirthNoticeList start：" + JSON.toJSONString(request));
	BirthNoticeListAllGetResponse response = new BirthNoticeListAllGetResponse();
	List<BirthNotice> entity = birthNoticeDao.getEntity();
	response.setData(entity);
	logger.info("getAllBirthNoticeList end：" + JSON.toJSONString(response));
	return response;
  }

  @Override
  public BirthNoticeMsmMessageSendResponse sendBirthNoticeMsmMessage(
		  BirthNoticeMsmMessageSendRequest request) {
	logger.info("sendBirthNoticeMsmMessage start：" + JSON.toJSONString(request));
	BirthNoticeMsmMessageSendResponse response = new BirthNoticeMsmMessageSendResponse();
	List<BirthNotice> birthNoticeList = request.getData();
	int k = 0;
	for (BirthNotice b : birthNoticeList) {
	  if (!StringUtils.isEmpty(b.getPhone()) &&
			  (Objects.nonNull(b.getNewBirth()) || !StringUtils.isEmpty(b.getOldBirth()))) {

		boolean isSend = true;
		//according to old day
		if (!StringUtils.isEmpty(b.getOldBirth()) && CalendarUtil.compareOldBirthDay(b.getOldBirth())) {
		  if (b.getSendType() == Constant.sendType.ONLYMINE.getType()) {
			SmsSendUtil.sendSmsMessage(new String[]{b.getName() + b.getOldBirth()}, Constant.phoneNumbers[0]);
		  } else {
			SmsSendUtil.sendSmsMessage(new String[]{
							!StringUtils.isEmpty(b.getNick()) ? b.getNick() : b.getName()}
					, b.getPhone(), Constant.templateId244436);
			SmsSendUtil.sendSmsMessage(new String[]{b.getName() + b.getOldBirth()}, Constant.phoneNumbers[0]);
			  try {
				  TimeUnit.SECONDS.sleep(35L);//防止短信接口的同一手机号30s频率限制
			  } catch (InterruptedException e) {
				  e.printStackTrace();
			  }
		  }
		  isSend = false;
		  k++;
		}
		//according to new day
		if (Objects.nonNull(b.getNewBirth()) && isSend && CalendarUtil.compareDay(b.getNewBirth())) {
		  if (b.getSendType() == Constant.sendType.ONLYMINE.getType()) {
			SmsSendUtil.sendSmsMessage(new String[]{b.getName() +
					new SimpleDateFormat("MM/dd").format(b.getNewBirth())}, Constant.phoneNumbers[0]);
		  } else {
			SmsSendUtil.sendSmsMessage(new String[]{
							!StringUtils.isEmpty(b.getNick()) ? b.getNick() : b.getName()}
					, b.getPhone(), Constant.templateId244436);
			SmsSendUtil.sendSmsMessage(new String[]{
					b.getName() + new SimpleDateFormat("MM/dd").format(b.getNewBirth())}, Constant.phoneNumbers[0]);
			  try {
				  TimeUnit.SECONDS.sleep(35L);//防止短信接口的同一手机号30s频率限制
			  } catch (InterruptedException e) {
				  e.printStackTrace();
			  }
		  }
		  k++;
		}
	  }
	}
	response.setMessage("成功笔数：" + k );
	logger.info("sendBirthNoticeMsmMessage end：" + JSON.toJSONString(response));
	return response;
  }

  @Override
  public BirthNoticeInsertResponse insertBirthNotice(BirthNoticeInsertRequest request) {
	BirthNoticeInsertResponse response = new BirthNoticeInsertResponse();

	int result = birthNoticeDao.insertEntity(request.getData());
	if (result != request.getData().size()){
	  throw new RuntimeException("新增失败");
	}
	return response;
  }
}
