package com.cn.cixinxc.user.controller;

import java.util.HashMap;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.cn.cixinxc.user.model.User;
import com.cn.cixin.user.model.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import com.cn.cixinxc.common.TBSms;
//import com.cn.cixinxc.user.model.User;
import com.cn.cixinxc.common.GlobalMethod;


@Controller  
@RequestMapping("/user")  
public class UserController {

    /*
     * 登录
     * 
     * */
	@RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request,Model model){
    	HttpSession session = request.getSession();
    	//if(session.getAttribute("user")==null ||  "".equals(session.getAttribute("user")))
    	String userName = (String)(request.getParameter("userName"));
    	String password = (String)(request.getParameter("password")); 
    	
    	HashMap<String, String> params = new HashMap<String, String>();
    	params.put("userName", userName);
    	params.put("password", password);
    	
    	JSONObject j = GlobalMethod.httpPOST("/user/login",params);
    	try {
    		//System.out.print("j.tostring:	"+j.toString());
        	if(j.getInt("return_code")==1){
        		User user = (User)JSONObject.toBean(j.getJSONObject("data").getJSONObject("user"),User.class);
        		session.setAttribute("user",user);
        		return "/user/showUser";
        	}
        	else{
        		return "/common/error";
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}  
        return "/common/error";
    }
    
    @RequestMapping(value="/login2",method=RequestMethod.POST)
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    	ModelAndView mv = new ModelAndView(); 
    	User user = new User();
    	user.setUserId("123");
    	user.setUserName("345");
    	mv.addObject("user", user);  
    	mv.addObject("message", "i am message");  
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
        mv.setViewName("user/showUser");  
    	return mv;  
    }
    /*
     * 测试发送短信
     * 
     * */
    /*
    @RequestMapping(value="/sendMessage")
    public ModelAndView sendMessage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        TBSms t = new TBSms();
      //  t.sendSms_YZM("2345", "18810328922");
        t.sendSms_XX("崔鑫鑫","你好，密码很长时间没修改了", "18810328922");
     //   t.sendSms(code, recNum, SMSTemplateCode)
     //   t.sendSms(code, recNum, SMSTemplateCode)
     //   t.sendSms("这是一条验证码", "18810328922");
    	return new ModelAndView(); 
    }
    */
    /*
     * 注册
     * 
     * */
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(HttpServletRequest request,Model model){
    	HttpSession session = request.getSession();
    	
    	HashMap<String, String> params = new HashMap<String, String>();
    	params.put("userId", UUID.randomUUID().toString().replaceAll("-", "") );
    	params.put("userName", (String)(request.getParameter("userName")) );
    	params.put("password", (String)(request.getParameter("password")) );

    	JSONObject j = GlobalMethod.httpPOST("/user/register",params);
    	try {
        	if(j.getInt("return_code")==1){
        		User user = (User)JSONObject.toBean(j.getJSONObject("data").getJSONObject("user"),User.class);
        		session.setAttribute("user",user);
        		return "/user/showUser";
        	}
        	else{
        		return "/common/error";
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}  
        return "/common/error";
    }
    
    /*
     * 跳转界面
     * 
     * */
    @RequestMapping("/toLogin")  
    public String toLogin(HttpServletRequest request){
    	String url = request.getParameter("url");
    	return url;
    }
    
}  