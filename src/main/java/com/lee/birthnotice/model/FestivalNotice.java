package com.lee.birthnotice.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lee5488
 * @version 1.0 2019/12/25
 */
@lombok.Data
public class FestivalNotice implements Serializable {
    private Integer id;
    private Integer noticeType;
    private Date noticeDate;
    private String note;
    private Date createDate;
    private Date updateDate;

}
