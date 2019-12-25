package com.lee.birthnotice.schedule;

import com.lee.birthnotice.enums.CalendarTypeEnum;
import com.lee.birthnotice.model.FestivalNotice;
import com.lee.birthnotice.service.FestivalNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lee5488
 * @version 1.0 2019/12/25
 */

@Component
@Slf4j
public class FestivalNoticeTasks {

    @Resource
    private FestivalNoticeService festivalNoticeService;


    @Scheduled(cron = "0 30 0 * * ?")
    public void notifyFestival1(){
        List<FestivalNotice> allFestivalNoticeByType = festivalNoticeService.findAllFestivalNoticeByType(CalendarTypeEnum.NEW.getType());
        festivalNoticeService.sendFestivalNoticeMessage(allFestivalNoticeByType);
    }
}
