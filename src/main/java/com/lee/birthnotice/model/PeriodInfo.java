package com.lee.birthnotice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author lee5488
 */
@Data
public class PeriodInfo implements Serializable {

	private static final long serialVersionUID = 7175048902145627003L;
	private Integer id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@ApiModelProperty("开始时间")
	private Date periodTimeStart;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@ApiModelProperty("结束时间")
	private Date periodTimeEnd;
	@ApiModelProperty("备注")
	private String notes;
	@ApiModelProperty("距离期间")
	private Integer apart;
	@ApiModelProperty("持续区间")
	private Integer interval;
	@ApiModelProperty("用户ID")
	private Integer userId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;

}
