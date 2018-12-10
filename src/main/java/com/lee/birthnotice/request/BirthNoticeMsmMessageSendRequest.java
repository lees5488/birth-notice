package com.lee.birthnotice.request;

import com.lee.birthnotice.model.BirthNotice;

import java.util.List;

public class BirthNoticeMsmMessageSendRequest {
  private List<BirthNotice> data;

  public List<BirthNotice> getData() {
	return data;
  }

  public void setData(List<BirthNotice> data) {
	this.data = data;
  }

}
