package com.lee.birthnotice.response;

import com.lee.birthnotice.model.BirthNotice;

import java.util.List;

public class BirthNoticeListAllGetResponse extends BaseResponse{

  private static final long serialVersionUID = 930819076701775508L;
  private List<BirthNotice> data;

  public List<BirthNotice> getData() {
	return data;
  }

  public void setData(List<BirthNotice> data) {
	this.data = data;
  }
}
