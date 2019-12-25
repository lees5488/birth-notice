package com.lee.birthnotice.service.impl;

import com.lee.birthnotice.mapper.FestivalNoticeMapper;
import com.lee.birthnotice.model.FestivalNotice;
import com.lee.birthnotice.service.FestivalNoticeService;
import com.lee.birthnotice.utils.CalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lee5488
 * @version 1.0 2019/12/25
 */
@Service
public class FestivalNoticeServiceImpl implements FestivalNoticeService {

    private final FestivalNoticeMapper festivalNoticeMapper;

    @Autowired
    public FestivalNoticeServiceImpl(FestivalNoticeMapper festivalNoticeMapper) {
        this.festivalNoticeMapper = festivalNoticeMapper;
    }

    @Override
    public List<FestivalNotice> findAllFestivalNoticeByType(Integer type) {
        return festivalNoticeMapper.findAllFestivalNoticeByType(type);
    }

    @Override
    public void sendFestivalNoticeMessage(List<FestivalNotice> festivalNoticeList) {
        festivalNoticeList.stream().filter(o -> CalendarUtil.compareDay(o.getNoticeDate())).forEach(f -> {
            //TODO 发送节日祝福
        });

    }
}
