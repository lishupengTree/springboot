package com.demo.web.wx;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.demo.model.response.active.Text;
import com.demo.model.response.passive.TextMessage;

import com.demo.util.MessageUtil;


@Controller
@RequestMapping("/wechat")
public class WeiXinAction {
	
	
	
	@RequestMapping(value = "/webaccesstest", method = RequestMethod.GET)
	public void webaccesstest(HttpServletRequest request,HttpServletResponse response
			,@RequestParam("signature") String signature
			,@RequestParam("timestamp") String timestamp
			,@RequestParam("nonce") String nonce
			,@RequestParam("echostr") String echostr) throws Exception {
		String token = "demo";   
		PrintWriter pw=null;
		response.setContentType("text/html;charset=utf-8");
		String[] strArr = new String[] { token, timestamp, nonce };
		Arrays.sort(strArr);  
		StringBuffer sb = new StringBuffer();
        for (String str : strArr){
            sb.append(str);
        }
        MessageDigest mdSha1 = null;
        try{
            mdSha1 = MessageDigest.getInstance("SHA-1");
        }catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        mdSha1.update(sb.toString().getBytes());
        byte[] codedBytes = mdSha1.digest();
        String codedString = new BigInteger(1, codedBytes).toString(16);
		pw = response.getWriter();
        if (codedString.equals(signature)){
        	System.out.println("access success");
    		pw.print(echostr);
        }
        else{
        	System.out.println("access failed");
    		pw.print("error");
        }
		pw.flush();
		pw.close();
	}
	
	@RequestMapping(value = "/webaccesstest", method = RequestMethod.POST)
	public void webaccesstest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		PrintWriter pw=null;
		response.setContentType("text/html;charset=utf-8");
		pw = response.getWriter();
		String respMessage = WeiXinAction.processRequest(request); 
		pw.print(respMessage);
		pw.flush();
		pw.close();
	}
	
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			String sql=null;
			
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			
			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respContent = "您发送的是文本消息！";
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 语音消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是语音消息！";
			}
			// 视频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
				respContent = "您发送的是视频消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					//respContent = "谢谢您的关注！<a href=\""+oauth_connect_url+"\">点击进行绑定</a>";
					respContent = ""; 
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
					
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					
				}
				else if (eventType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT_LOCATION)) {//地理位置
					
					
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return respMessage;
	}

}
