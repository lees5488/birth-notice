package com.lee.birthnotice.service;

import com.lee.birthnotice.request.birth.BirthNoticeInsertRequest;
import com.lee.birthnotice.request.birth.BirthNoticeListAllGetRequest;
import com.lee.birthnotice.request.BirthNoticeMsmMessageSendRequest;
import com.lee.birthnotice.request.birth.AdvanceMonthBirthNoticeRequest;
import com.lee.birthnotice.request.birth.DeleteNoticeRequest;
import com.lee.birthnotice.request.birth.QueryNoticeRequest;
import com.lee.birthnotice.response.birth.BirthNoticeInsertResponse;
import com.lee.birthnotice.response.birth.BirthNoticeListAllGetResponse;
import com.lee.birthnotice.response.BirthNoticeMsmMessageSendResponse;
import com.lee.birthnotice.response.birth.AdvanceMonthBirthNoticeResponse;
import com.lee.birthnotice.response.birth.QueryNoticeResponse;

/**
 *
 * @Description:
 * birth service
 *
 * @auther: sheen.lee
 * @param:
 * @return:
 *
 */
public interface BirthNoticeService {

  /**
   * find all noticeList
   * @param request
   * @return
   */
  BirthNoticeListAllGetResponse getAllBirthNoticeList(
          BirthNoticeListAllGetRequest request);

  /**
   * send notice
   * 接口发送短信通知，主要逻辑如下：
   * 先判断是否这个人的当天生日，（这里有两个点，一个是新历生日，一个是旧历生日）如果是当天生日，进入发送短信的循环
   * 根据发送类型判断是否只发送给自己，
   * @param request
   * @return
   */
  BirthNoticeMsmMessageSendResponse sendBirthNoticeMsmMessage(
          BirthNoticeMsmMessageSendRequest request);

  /**
   * add birth notice
   * @param request
   * @return
   */
  BirthNoticeInsertResponse insertBirthNotice(
          BirthNoticeInsertRequest request);

  /**
   * 按照新历，查询本月的（包括本月旧历）所有生日的人
   * advance notice
   * @param request
   * @return
   */
  AdvanceMonthBirthNoticeResponse noticeAdvanceMonthBirth(
          AdvanceMonthBirthNoticeRequest request);

  /**
   * 查询生日信息
   * @param request
   * @return
   */
  QueryNoticeResponse queryNotice(QueryNoticeRequest request);


  void deleteNotice(String id);

}
