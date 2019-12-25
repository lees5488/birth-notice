package com.lee.birthnotice.service;

import com.lee.birthnotice.model.FestivalNotice;

import java.util.List;

/**
 * @author lee5488
 * @version 1.0 2019/12/25
 */
public interface FestivalNoticeService {

    /**
     * 根据类型查数据
     * @param type 类型
     * @return 节日提醒数据
     */
    List<FestivalNotice> findAllFestivalNoticeByType(Integer type);

    /**
     *  发送消息
     * @param festivalNoticeList 节日
     */
    void sendFestivalNoticeMessage(List<FestivalNotice> festivalNoticeList);
}
