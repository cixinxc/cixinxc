package com.cn.cixinxc.common;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;

import java.io.*;

//import org.json.JSONObject;

import net.sf.json.JSONObject;

//全局静态方法
public class GlobalMethod {
	/*
	 * url(String):"/user/showUser"
	 * 
	 * requestMethod(String):"POST"
	 * 
	 * */
	public static JSONObject httpPOST(String url,HashMap<String, String> params){
		try {
			
			printRequest(url,params);
			
			HttpURLConnection connection = (HttpURLConnection) new URL(RestfulService.SERVER_URL + url).openConnection();

			connection.setConnectTimeout(5000);
			// 默认是 GET方式
			connection.setRequestMethod(BaseData.REQUEST_METHOD_POST);	
	        connection.setDoOutput(true);
	        connection.setDoInput(true);

	        // Post 请求不能使用缓存
	        //connection.setUseCaches(false);
	        //connection.setInstanceFollowRedirects(true);
	        
	        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
	        // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
	        connection.setRequestProperty("User-Agent", "Fiddler");
	        connection.setRequestProperty("Content-Type", "application/json");
	        connection.setRequestProperty("Charset", "UTF-8");

			connection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");


			// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
	        // 要注意的是connection.getOutputStream会隐含的进行connect。
	        //connection.connect();
	    	DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
	        dos.writeBytes( String.valueOf(Map2JSONObject(params)) );
	        dos.flush();
	        dos.close();
	        
	        String paramsString = read(connection.getInputStream()).trim().replace("\\", "");
	        
	        return JSONObject.fromObject( paramsString.substring(1, paramsString.length()-1) );
        } catch (Exception e) {
			e.printStackTrace();
		}
		return new JSONObject();
	}
	
	public static JSONObject Map2JSONObject(HashMap<String, String> params)
    {
        JSONObject jsonObject = new JSONObject();
        try{
            for (Iterator it = params.entrySet().iterator(); it.hasNext();)
            {
                Entry e = (Entry) it.next();
                jsonObject.put(e.getKey().toString(), e.getValue().toString());
            }
         }catch (Exception e){}

        return jsonObject;
    }
	
	public static String read(InputStream in) throws Exception {
        byte[] data;

        int length = in.available();
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[]buf = new byte[1024];
        int len;
        while((len = in.read(buf))!=-1){
            bout.write(buf, 0, len);
        }
        data = bout.toByteArray();
        return new String(data,"UTF-8");
    }
	
	 /**
     * 从服务器中获得的所有数据集格式都为：{result:[{},{},{}]}
     * JSONArray->List<Map<String,Object>>
     */
    public static List<Map<?,?>> JSON2ListMap(JSONObject jsonObject)
    {
        List<Map<?,?>> list = new ArrayList<Map<?, ?>>();
        JSONObject object ;
        try {
        	Iterator it ;
        	Map<String, Object> map = new HashMap<String, Object>();
        	object = jsonObject;
        	it = object.keys();
        	while (it.hasNext())
        	{
        		String key = it.next().toString();
        		String value = object.getString(key);
        		map.put(key,value);
        	}
        	list.add(map);
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    /**
     *function output request info about url and param
     *@param url
	 * 	String
     *	request url
     *@param params
     *	HashMap<String, String>
     *@author
     *	cuixinxin
     *@Time 
     *	2016/12/18 19
     */
    public static void printRequest(String url,HashMap<String, String> params){
    	System.out.println("printRequest:	"+RestfulService.SERVER_URL +url);
    	Iterator iter = params.entrySet().iterator();
    	while ( iter.hasNext() ) {
    		Entry entry = (Entry) iter.next();
    		System.out.println( "参数名称:"+(String)entry.getKey()+",参数值:"+(String)entry.getValue() );
    //		System.out.println( (String)iter.next() +":"+params.get( (String)iter.next() ) );
    	}
    	System.out.println("");
    }
}
