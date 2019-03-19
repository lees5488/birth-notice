package com.lee.birthnotice.service;

import com.lee.birthnotice.request.BirthNoticeInsertRequest;
import com.lee.birthnotice.request.BirthNoticeListAllGetRequest;
import com.lee.birthnotice.request.BirthNoticeMsmMessageSendRequest;
import com.lee.birthnotice.response.BirthNoticeInsertResponse;
import com.lee.birthnotice.response.BirthNoticeListAllGetResponse;
import com.lee.birthnotice.response.BirthNoticeMsmMessageSendResponse;

public interface BirthNoticeService {

  BirthNoticeListAllGetResponse getAllBirthNoticeList(
          BirthNoticeListAllGetRequest request);

  BirthNoticeMsmMessageSendResponse sendBirthNoticeMsmMessage(
          BirthNoticeMsmMessageSendRequest request);

  BirthNoticeInsertResponse insertBirthNotice(
          BirthNoticeInsertRequest request);
}
