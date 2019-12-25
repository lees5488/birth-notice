package com.lee.birthnotice.response.festival;

import com.lee.birthnotice.model.FestivalNotice;
import com.lee.birthnotice.response.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * @author lee5488
 * @version 1.0 2019/12/25
 */
@Data
public class QueryFestivalNoticeResponse extends BaseResponse {

    List<FestivalNotice> festivalNoticeList;
}
