package com.lee.birthnotice.request;

import com.lee.birthnotice.model.BirthNotice;

import java.util.List;

public class BirthNoticeInsertRequest extends BaseRequest{
  private static final long serialVersionUID = -3728888052131767020L;
  List<BirthNotice> data;

  public List<BirthNotice> getData() {
	return data;
  }

  public void setData(List<BirthNotice> data) {
	this.data = data;
  }
}
