package com.lee.birthnotice.request;

import com.lee.birthnotice.model.BirthNotice;

import java.util.List;

public class BirthNoticeMsmMessageSendRequest extends BaseRequest{
  private static final long serialVersionUID = 241883346594044926L;
  private List<BirthNotice> data;

  public List<BirthNotice> getData() {
	return data;
  }

  public void setData(List<BirthNotice> data) {
	this.data = data;
  }

}
