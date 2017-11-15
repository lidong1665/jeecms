package com.jeecms.cms.api.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;

import com.jeecms.common.util.AES128Util;
import com.jeecms.common.util.Num62;
import com.jeecms.common.util.PayUtil;
import com.jeecms.common.web.HttpClientUtil;

public class TestMessage {

	public static void main(String[] args) {
		//发信息
		//testMessageSendOrDraft(1);
		//存草稿
		//testMessageSendOrDraft(2);
		//修改草稿
		//testMessageDraftUpdate();
		//草稿发送
		//testMessageDraftToSend();
		//我的信息
		//testMessageMyList();
		//获取信息
		//testMessageGet();
		//删除至回收站
		//testMessageBatchOperate("trash","2");
		//还原
		//testMessageBatchOperate("revert","7");
		//删除
		testMessageBatchOperate("delete","7");
	}
	
	private static String testMessageGet(){
		String url="http://192.168.0.173:8080/jeecmsv8f/api/message/get.jspx";
		StringBuffer paramBuff=new StringBuffer();
		paramBuff.append("appId="+appId);
		paramBuff.append("&id="+2);
		String encryptSessionKey="";
		try {
			encryptSessionKey=AES128Util.encrypt(sessionKey, aesKey,ivKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		paramBuff.append("&sessionKey="+encryptSessionKey);
		Map<String, String>param=new HashMap<String, String>();
		String []params=paramBuff.toString().split("&");
		for(String p:params){
			String keyValue[]=p.split("=");
			param.put(keyValue[0], keyValue[1]);
		};
		String res=HttpClientUtil.getInstance().postParams(url, param);
		System.out.println("res->"+res);
		return res;
	}
	
	private static String testMessageMyList(){
		String url="http://192.168.0.173:8080/jeecmsv8f/api/message/list.jspx";
		StringBuffer paramBuff=new StringBuffer();
		paramBuff.append("first="+0);
		paramBuff.append("&count="+5);
		//0 收件箱   3垃圾箱   2草稿箱  1发件箱
		paramBuff.append("&box="+1);
		paramBuff.append("&appId="+appId);
		String encryptSessionKey="";
		try {
			encryptSessionKey=AES128Util.encrypt(sessionKey, aesKey,ivKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		paramBuff.append("&sessionKey="+encryptSessionKey);
		Map<String, String>param=new HashMap<String, String>();
		String []params=paramBuff.toString().split("&");
		for(String p:params){
			String keyValue[]=p.split("=");
			param.put(keyValue[0], keyValue[1]);
		}
		String res=HttpClientUtil.getInstance().postParams(url, param);
		System.out.println("res->"+res);
		return res;
	}
	
	private static String testMessageSendOrDraft(Integer box){
		String url="http://192.168.0.173:8080/jeecmsv8f/api/message/send.jspx";
		StringBuffer paramBuff=new StringBuffer();
		String username="test1112";
		String title="testMessageTitle";
		String content="testMsgContent";
		paramBuff.append("toUser="+username);
		paramBuff.append("&title="+title);
		paramBuff.append("&content="+content);
		paramBuff.append("&box="+box);
		paramBuff.append("&appId="+appId);
		String encryptSessionKey="";
		try {
			encryptSessionKey=AES128Util.encrypt(sessionKey, aesKey,ivKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		paramBuff.append("&sessionKey="+encryptSessionKey);
		String nonce_str=RandomStringUtils.random(16,Num62.N62_CHARS);
		paramBuff.append("&nonce_str="+nonce_str);
		Map<String, String>param=new HashMap<String, String>();
		String []params=paramBuff.toString().split("&");
		for(String p:params){
			String keyValue[]=p.split("=");
			param.put(keyValue[0], keyValue[1]);
		};
		String sign=PayUtil.createSign(param, appKey);
		paramBuff.append("&sign="+sign);
		param.put("sign", sign);
		String res=HttpClientUtil.getInstance().postParams(url, param);
		System.out.println("res->"+res);
		return res;
	}
	
	private static String testMessageDraftUpdate(){
		String url="http://192.168.0.173:8080/jeecmsv8f/api/message/draftUpdate.jspx";
		StringBuffer paramBuff=new StringBuffer();
		String title="testMessageTitle2";
		String content="testMsgContent2";
		paramBuff.append("id="+2);
		paramBuff.append("&title="+title);
		paramBuff.append("&content="+content);
		paramBuff.append("&appId="+appId);
		String encryptSessionKey="";
		try {
			encryptSessionKey=AES128Util.encrypt(sessionKey, aesKey,ivKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		paramBuff.append("&sessionKey="+encryptSessionKey);
		String nonce_str=RandomStringUtils.random(16,Num62.N62_CHARS);
		paramBuff.append("&nonce_str="+nonce_str);
		Map<String, String>param=new HashMap<String, String>();
		String []params=paramBuff.toString().split("&");
		for(String p:params){
			String keyValue[]=p.split("=");
			param.put(keyValue[0], keyValue[1]);
		};
		String sign=PayUtil.createSign(param, appKey);
		paramBuff.append("&sign="+sign);
		param.put("sign", sign);
		String res=HttpClientUtil.getInstance().postParams(url, param);
		System.out.println("res->"+res);
		return res;
	}
	
	private static String testMessageDraftToSend(){
		String url="http://192.168.0.173:8080/jeecmsv8f/api/message/draftToSend.jspx";
		StringBuffer paramBuff=new StringBuffer();
		paramBuff.append("id="+2);
		paramBuff.append("&appId="+appId);
		String encryptSessionKey="";
		try {
			encryptSessionKey=AES128Util.encrypt(sessionKey, aesKey,ivKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		paramBuff.append("&sessionKey="+encryptSessionKey);
		String nonce_str=RandomStringUtils.random(16,Num62.N62_CHARS);
		paramBuff.append("&nonce_str="+nonce_str);
		Map<String, String>param=new HashMap<String, String>();
		String []params=paramBuff.toString().split("&");
		for(String p:params){
			String keyValue[]=p.split("=");
			param.put(keyValue[0], keyValue[1]);
		};
		String sign=PayUtil.createSign(param, appKey);
		paramBuff.append("&sign="+sign);
		param.put("sign", sign);
		String res=HttpClientUtil.getInstance().postParams(url, param);
		System.out.println("res->"+res);
		return res;
	}
	
	private static String testMessageBatchOperate(String operateType,String ids){
		String url;
		if (operateType=="trash") {
			url="http://192.168.0.173:8080/jeecmsv8f/api/message/trash.jspx";
		}else if(operateType=="revert"){
			url="http://192.168.0.173:8080/jeecmsv8f/api/message/revert.jspx";
		}else{
			url="http://192.168.0.173:8080/jeecmsv8f/api/message/delete.jspx";
		}
		StringBuffer paramBuff=new StringBuffer();
		paramBuff.append("ids="+ids);
		paramBuff.append("&appId="+appId);
		String encryptSessionKey="";
		try {
			encryptSessionKey=AES128Util.encrypt(sessionKey, aesKey,ivKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		paramBuff.append("&sessionKey="+encryptSessionKey);
		String nonce_str=RandomStringUtils.random(16,Num62.N62_CHARS);
		paramBuff.append("&nonce_str="+nonce_str);
		Map<String, String>param=new HashMap<String, String>();
		String []params=paramBuff.toString().split("&");
		for(String p:params){
			String keyValue[]=p.split("=");
			param.put(keyValue[0], keyValue[1]);
		};
		String sign=PayUtil.createSign(param, appKey);
		paramBuff.append("&sign="+sign);
		param.put("sign", sign);
		String res=HttpClientUtil.getInstance().postParams(url, param);
		System.out.println("res->"+res);
		return res;
	}
	
	
	private static String appId="111111";
	private static String appKey="Sd6qkHm9o4LaVluYRX5pUFyNuiu2a8oi";
	private static String sessionKey="9CBB23E7490F2053418499E9A7079ACE";
	private static String aesKey="S9u978Q31NGPGc5H";
	private static String ivKey="X83yESM9iShLxfwS";
}
