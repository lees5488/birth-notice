package com.lee.birthnotice.request.birth;

import com.lee.birthnotice.model.BirthNotice;
import com.lee.birthnotice.request.BaseRequest;
import lombok.Data;

/**
 * @author lee5488
 * @version 1.0 2019/12/20
 */
@Data
public class QueryNoticeRequest extends BaseRequest {

    private BirthNotice birthNotice;
}
