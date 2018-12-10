package com.lee.birthnotice.schedule;

import com.lee.birthnotice.request.BirthNoticeListAllGetRequest;
import com.lee.birthnotice.request.BirthNoticeMsmMessageSendRequest;
import com.lee.birthnotice.response.BirthNoticeListAllGetResponse;
import com.lee.birthnotice.service.BirthNoticeService;
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
  public void sendNotice(){
    logger.info("sendNotice begin");
    BirthNoticeListAllGetRequest request1 = new BirthNoticeListAllGetRequest();
    BirthNoticeListAllGetResponse allBirthNoticeList = birthNoticeService.getAllBirthNoticeList(request1);
    BirthNoticeMsmMessageSendRequest request = new BirthNoticeMsmMessageSendRequest();
    request.setData(allBirthNoticeList.getData());
    birthNoticeService.sendBirthNoticeMsmMessage(request);
    logger.info("sendNotice end");
  }
}
