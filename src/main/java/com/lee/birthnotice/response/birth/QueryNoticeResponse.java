package com.lee.birthnotice.response.birth;

import com.lee.birthnotice.model.BirthNotice;
import com.lee.birthnotice.response.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * @author lee5488
 * @version 1.0 2019/12/20
 */
@Data
public class QueryNoticeResponse extends BaseResponse {

    List<BirthNotice> birthNotice;
}
