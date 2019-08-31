package com.lee.birthnotice.request;

import com.lee.birthnotice.model.BirthNotice;
import lombok.Data;

import java.util.List;

@Data
public class BirthNoticeMsmMessageSendRequest extends BaseRequest{
  private static final long serialVersionUID = 241883346594044926L;
  private List<BirthNotice> data;
  private Integer templateId;

}
