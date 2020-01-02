package com.lee.birthnotice.utils;

import com.alibaba.fastjson.JSON;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;

import java.io.IOException;

public class SmsSendUtil {

  private static final Log logger = LogFactory.getLog(SmsSendUtil.class);

  public static void sendSmsMessage(String[] params,String phone,int template){
    logger.info(JSON.toJSONString(params)+"【phone:"+phone+"】");
	try {
	  //String[] params = {name,"李星星测试账号"};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
	  MySmsSingleSender ssender = new MySmsSingleSender(Constant.appid, Constant.appkey);
	  SmsSingleSenderResult result = ssender.sendWithParam("86", phone,
			  template, params, Constant.smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
	  System.out.println(result);
	} catch (HTTPException e) {
	  // HTTP响应码错误
	  e.printStackTrace();
	} catch (JSONException e) {
	  // json解析错误
	  e.printStackTrace();
	} catch (IOException e) {
	  // 网络IO错误
	  e.printStackTrace();
	}
  }

  /**
   * 自我通知信息
   * @param params
   * @param phone
   */
  public static void sendSmsMessage(String[] params,String phone){
    sendSmsMessage(params,phone,Constant.templateId243807);
  }

  /**
   * 自我通知信息
   * @param params
   * @param phone
   */
  public static void sendFestivalMessage(String[] params,String phone){
    sendSmsMessage(params,phone,Constant.templateId507982);
  }


  //public static void main(String[] args) {
	////SmsSendUtil.sendSmsMessage(new String[]{"李星星"}
	////		, "16619953042", Constant.templateId244436);
	//SmsSendUtil.sendSmsMessage(new String[]{"李鑫|19951104"}, Constant.phoneNumbers[0]);
  //
  //}
}
