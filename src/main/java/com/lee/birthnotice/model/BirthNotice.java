package com.lee.birthnotice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
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

}