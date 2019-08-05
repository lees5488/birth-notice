package com.lee.birthnotice.service;

import com.lee.birthnotice.request.BirthNoticeInsertRequest;
import com.lee.birthnotice.request.BirthNoticeListAllGetRequest;
import com.lee.birthnotice.request.BirthNoticeMsmMessageSendRequest;
import com.lee.birthnotice.response.BirthNoticeInsertResponse;
import com.lee.birthnotice.response.BirthNoticeListAllGetResponse;
import com.lee.birthnotice.response.BirthNoticeMsmMessageSendResponse;

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
}
