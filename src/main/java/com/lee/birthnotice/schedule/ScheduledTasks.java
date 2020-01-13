package com.lee.birthnotice.schedule;

import com.lee.birthnotice.request.birth.BirthNoticeListAllGetRequest;
import com.lee.birthnotice.request.BirthNoticeMsmMessageSendRequest;
import com.lee.birthnotice.request.birth.AdvanceMonthBirthNoticeRequest;
import com.lee.birthnotice.response.birth.BirthNoticeListAllGetResponse;
import com.lee.birthnotice.response.birth.AdvanceMonthBirthNoticeResponse;
import com.lee.birthnotice.service.BirthNoticeService;
import com.lee.birthnotice.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduledTasks {


	@Autowired
	private BirthNoticeService birthNoticeService;

	@Scheduled(cron = "10 0 0 * * ?")
	//@Scheduled(cron = "10 44 19 * * ?")
	public void sendNotice() {
		log.info("sendNotice start ...");
		birthNoticeService.sendBirthNoticeMsmMessage(
				convertBirthNoticeMsmMessageSendRequest(birthNoticeService.getAllBirthNoticeList(new BirthNoticeListAllGetRequest())));
	}

	private BirthNoticeMsmMessageSendRequest convertBirthNoticeMsmMessageSendRequest(BirthNoticeListAllGetResponse allBirthNoticeList) {
		BirthNoticeMsmMessageSendRequest request = new BirthNoticeMsmMessageSendRequest();
		request.setData(allBirthNoticeList.getData());
		request.setTemplateId(Constant.templateId244436);
		return request;
	}


	/**
	 * 最近5次运行时间:
	 * 2019/9/1 0:10:00
	 * 2019/10/1 0:10:00
	 * 2019/11/1 0:10:00
	 * 2019/12/1 0:10:00
	 * 2020/1/1 0:10:00
	 * 这个接口暂时弃用。腾讯短信操作有问题。参数长度限制超出最大
	 * 可以循环发送数据到手机号，有多少当月生日的发送多少条
	 * 可以考虑使用定时消息发送
	 */
	//@Scheduled(cron = "0 10 0 1 * ?")
	@Deprecated
	public void noticeAdvanceMonthBirth() {
		log.info("sendAdvanceNotice begin");
		birthNoticeService.sendBirthNoticeMsmMessage(
				convertBirthNoticeMsmMessageSendRequest(birthNoticeService.noticeAdvanceMonthBirth(new AdvanceMonthBirthNoticeRequest())));
		log.info("sendAdvanceNotice end");
	}

	private BirthNoticeMsmMessageSendRequest convertBirthNoticeMsmMessageSendRequest(AdvanceMonthBirthNoticeResponse response) {
		BirthNoticeMsmMessageSendRequest request = new BirthNoticeMsmMessageSendRequest();
		request.setData(response.getData());
		request.setTemplateId(Constant.templateId244436);
		return request;
	}

}
