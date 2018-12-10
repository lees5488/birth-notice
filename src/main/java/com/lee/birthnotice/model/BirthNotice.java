package com.lee.birthnotice.model;

import java.io.Serializable;
import java.util.Date;

public class BirthNotice implements Serializable {
  private static final long serialVersionUID = 1933094261791566047L;
  private long id;
  private String pinyin;
  private String name;
  private String nick;
  private Date newBirth;
  private String oldBirth;
  private String notes;
  private String idCard;
  private String phone;
  private String email;
  private int sendType;

  public int getSendType() {
	return sendType;
  }

  public void setSendType(int sendType) {
	this.sendType = sendType;
  }

  public long getId() {
	return id;
  }

  public void setId(long id) {
	this.id = id;
  }


  public String getPinyin() {
	return pinyin;
  }

  public void setPinyin(String pinyin) {
	this.pinyin = pinyin;
  }


  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }


  public String getNick() {
	return nick;
  }

  public void setNick(String nick) {
	this.nick = nick;
  }

  public Date getNewBirth() {
	return newBirth;
  }

  public void setNewBirth(Date newBirth) {
	this.newBirth = newBirth;
  }

  public void setNewBirth(java.sql.Timestamp newBirth) {
	this.newBirth = newBirth;
  }


  public String getOldBirth() {
	return oldBirth;
  }

  public void setOldBirth(String oldBirth) {
	this.oldBirth = oldBirth;
  }


  public String getNotes() {
	return notes;
  }

  public void setNotes(String notes) {
	this.notes = notes;
  }


  public String getIdCard() {
	return idCard;
  }

  public void setIdCard(String idCard) {
	this.idCard = idCard;
  }


  public String getPhone() {
	return phone;
  }

  public void setPhone(String phone) {
	this.phone = phone;
  }


  public String getEmail() {
	return email;
  }

  public void setEmail(String email) {
	this.email = email;
  }

}