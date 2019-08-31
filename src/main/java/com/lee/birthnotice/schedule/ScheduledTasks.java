package com.lee.birthnotice.schedule;

import com.lee.birthnotice.request.BirthNoticeListAllGetRequest;
import com.lee.birthnotice.request.BirthNoticeMsmMessageSendRequest;
import com.lee.birthnotice.request.birth.AdvanceMonthBirthNoticeRequest;
import com.lee.birthnotice.response.BirthNoticeListAllGetResponse;
import com.lee.birthnotice.response.birth.AdvanceMonthBirthNoticeResponse;
import com.lee.birthnotice.service.BirthNoticeService;
import com.lee.birthnotice.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ScheduledTasks {

	private Logger logger = Logger.getLogger("ScheduledTasks");

	@Autowired
	private BirthNoticeService birthNoticeService;

	@Scheduled(cron = "10 0 0 * * ?")
	//@Scheduled(cron = "10 44 19 * * ?")
	public void sendNotice() {
		logger.info("sendNotice begin");
		BirthNoticeListAllGetRequest request1 = new BirthNoticeListAllGetRequest();
		BirthNoticeListAllGetResponse allBirthNoticeList = birthNoticeService.getAllBirthNoticeList(request1);
		BirthNoticeMsmMessageSendRequest request = new BirthNoticeMsmMessageSendRequest();
		request.setData(allBirthNoticeList.getData());
		request.setTemplateId(Constant.templateId244436);
		birthNoticeService.sendBirthNoticeMsmMessage(request);
		logger.info("sendNotice end");
	}


	/**
	 * 最近5次运行时间:
	 * 2019/9/1 0:10:00
	 * 2019/10/1 0:10:00
	 * 2019/11/1 0:10:00
	 * 2019/12/1 0:10:00
	 * 2020/1/1 0:10:00
	 * 这个接口暂时弃用。腾讯短信操作有问题。参数长度限制超出最大
	 */
	//@Scheduled(cron = "0 10 0 1 * ?")
	@Deprecated
	public void noticeAdvanceMonthBirth() {
		logger.info("sendAdvanceNotice begin");
		AdvanceMonthBirthNoticeRequest request1 = new AdvanceMonthBirthNoticeRequest();
		AdvanceMonthBirthNoticeResponse response = birthNoticeService.noticeAdvanceMonthBirth(request1);
		BirthNoticeMsmMessageSendRequest request = new BirthNoticeMsmMessageSendRequest();
		request.setData(response.getData());
		request.setTemplateId(Constant.templateId244436);
		birthNoticeService.sendBirthNoticeMsmMessage(request);
		logger.info("sendAdvanceNotice end");
	}

}
