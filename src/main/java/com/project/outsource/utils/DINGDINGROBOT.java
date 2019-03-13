package com.project.outsource.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
* 名称: DINGDINGROBOT.java
* 类说明:
*
*/
public class DINGDINGROBOT {
	private static final Logger LOGGER = LoggerFactory.getLogger(DINGDINGROBOT.class);
	private static final HttpClient HTTP_CLIENT = HttpClients.createDefault();
	private static final String URL = "https://oapi.dingtalk.com/robot/send?"
			+ "access_token=591de04030b662e8127c9581a12a15664e4a0ecfea242abb9352c5994e9c440a";
	/**
	 * 
	 * @Title: dingdingNotify
	 * @Description:钉钉机器人
	 * @param m
	 *
	 */
	public static void dingdingNotify(String m) {
        try {
        	HttpPost httppost = new HttpPost(URL);
            httppost.addHeader("Content-Type", "application/json; charset=utf-8");
            JSONObject msg = new JSONObject();
            msg.put("msgtype", "text");
            JSONObject content = new JSONObject();
            content.put("content", m);
            msg.put("text", content);
            String textMsg = msg.toString();
            System.out.println(textMsg);
            StringEntity se = new StringEntity(textMsg, "utf-8");
            httppost.setEntity(se);
            HttpResponse response = HTTP_CLIENT.execute(httppost);
            LOGGER.error("钉钉消息发送返回状态，status = " + response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result= EntityUtils.toString(response.getEntity(), "utf-8");
                LOGGER.error("钉钉消息发送返回result，result = " + result);
            }
        } catch(Exception e) {
        	e.printStackTrace();
        	LOGGER.error("钉钉机器人通知发送失败，", e);
        	throw new RuntimeException(e);
        }
	}
}
