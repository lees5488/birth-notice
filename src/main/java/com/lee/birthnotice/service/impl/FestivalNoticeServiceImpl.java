package com.lee.birthnotice.service.impl;

import com.lee.birthnotice.dao.BirthNoticeDao;
import com.lee.birthnotice.mapper.FestivalNoticeMapper;
import com.lee.birthnotice.model.BirthNotice;
import com.lee.birthnotice.model.FestivalNotice;
import com.lee.birthnotice.service.FestivalNoticeService;
import com.lee.birthnotice.utils.CalendarUtil;
import com.lee.birthnotice.utils.SmsSendUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lee5488
 * @version 1.0 2019/12/25
 */
@Service
public class FestivalNoticeServiceImpl implements FestivalNoticeService {

    private final FestivalNoticeMapper festivalNoticeMapper;

    @Autowired
    private BirthNoticeDao birthNoticeDao;

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
        List<FestivalNotice> needSendList = festivalNoticeList.stream().filter(o -> CalendarUtil.compareDay(o.getNoticeDate())).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(needSendList)) {
            List<BirthNotice> birthNoticeList = birthNoticeDao.getEntity();
            if (!CollectionUtils.isEmpty(birthNoticeList)) {
                List<BirthNotice> needSendPhoneList = birthNoticeList.stream().filter(o -> !StringUtils.isEmpty(o.getPhone())).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(needSendPhoneList)) {
                    needSendList.forEach(each -> needSendPhoneList.forEach(each2 -> SmsSendUtil.sendFestivalMessage(new String[]{each2.getName(), each.getNote()}, each2.getPhone())));
                }
            }
        }

    }
}
