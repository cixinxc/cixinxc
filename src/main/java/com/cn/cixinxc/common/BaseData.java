package com.cn.cixinxc.common;

import java.util.HashMap;

public class BaseData {
	//短信接口
	public static final String SMS_ATTR_URL = "http://gw.api.taobao.com/router/rest";	//地址
	public static final String SMS_ATTR_APPKEY = "23419405";			//appkey
	public static final String SMS_ATTR_SECRET = "dd2eacc4513ad1caa320090113b2b123";	//secret
	public static final String SMS_TEMPLATE_CODE_YZM = "SMS_12816510";	//验证码_模板ID
	public static final String SMS_TEMPLATE_CODE_TZ = "SMS_12836748";	//通知_模板ID
	public static final String SMS_SIGN_CODE = "此心闲处";			//验证码签名1
	public static final String SMS_EXTEND_NOMAL = "";				//短信默认extend
	public static final String SMS_TYPE_NOMAL = "nomal";			//短信默认类型
	public static final HashMap<String, String> SMS_CODE = new HashMap<String,String>();			//短信默认类型
	
	//返回代码
	public static final int RETURN_CODE_TRUE = 1;
	public static final int RETURN_CODE_FALSE = 0;
	public static final String RETURN_STR_TRUE = "true";
	public static final String RETURN_STR_FALSE = "false";
	
	//httpClient
	public static final String REQUEST_METHOD_POST = "POST";
}
