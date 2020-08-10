package com.example.excalhandler.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 业务层参数工具
 * @author lyb
 *
 */
public class AppSrvParamUtil {
	
	

	public static JSONObject put(String key,  String value,JSONObject param) {
		JSONObject body = param.getJSONObject("body");
		body.put(key, value);
		param.put("body", body);
		return param;
	}

	public static JSONObject put(String key,  JSONObject value,JSONObject param) {
		JSONObject body = param.getJSONObject("body");
		body.put(key, value);
		param.put("body", body);
		return param;
	}
	
	public static JSONObject put(String key,  JSONArray value,JSONObject param) {
		JSONObject body = param.getJSONObject("body");
		body.put(key, value);
		param.put("body", body);
		return param;
	}
	
	public static Object get(String key,JSONObject param) {
		JSONObject body = param.getJSONObject("body");
		return body.get(key);
	}
	
	
	public static Object getHeader(JSONObject param) {
		JSONObject header = param.getJSONObject("header");
		return header;
	}
}
