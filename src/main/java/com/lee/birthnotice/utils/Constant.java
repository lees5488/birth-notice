package com.lee.birthnotice.utils;

public class Constant {

  public enum sendType {
    ONLYMINE(8,"只发给自己");
    private int type;
    private String name;

    sendType(int type, String name) {
      this.type = type;
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }
  }

  // 短信应用SDK AppID
  public final static int appid = 1400164804; // 1400开头

  // 短信应用SDK AppKey
  public final static String appkey = "保密处理不予上传";

  // 需要发送短信的手机号码
  public final static String[] phoneNumbers ={"17191073042"};

  // 短信模板ID，需要在短信应用中申请
  //{1}您好，这是{2}发送的短信，请勿回复
  public final static int templateId239733 = 239733; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
  public final static int templateId243807 = 243807; // NOTE: 明天是{1}的生日，请注意查收。
  //public final static int templateId243839 = 243839; // NOTE: 	{1}，祝你生日快乐
  public final static int templateId244436 = 244436; // NOTE: 	{1}，祝你生日快乐。本消息来自微信公众号[李星星的测试账号]
  public final static int templateId392969 = 392969; // NOTE: 	本月人数{1}个。人员名单如下{2}，敬请查收！
  //templateId7839对应的内容是"您的验证码是: {1}"
// 签名
  public final static String smsSign = "李星星的测试账号";
  // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`

  public final static String DATE_PATTERN_YYYY_MM_DD = "yyyyMMdd";
  public final static String DATE_PATTERN_MM_DD = "MMdd";
  public final static String ZERO_STR = "0";
}
