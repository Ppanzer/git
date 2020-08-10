package com.example.excalhandler.util;

import com.alibaba.fastjson.JSON;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
	
	public static String requestWithJson(HttpServletRequest request) throws IOException, UnsupportedEncodingException {

		// 读取请求内容
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		StringBuilder sb = new StringBuilder();
		char[] charBuffer = new char[128];
		int bytesRead = -1;
		while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
			sb.append(charBuffer, 0, bytesRead);
		}
		// 将资料解码
		String reqBody = sb.toString();
		return URLDecoder.decode(reqBody, "UTF-8");
	}	
	
	/** 
	 * 以JSON格式输出 
	 * @param response 
	 */  
	public static void responseOutWithJson(HttpServletResponse response, Object responseObject) {
	    //将实体对象转换为JSON Object转换  
//	    JSONObject responseJSONObject = JSONObject.parseObject(JSON.toJSONString(responseObject));  
	    
		try {
			response.setContentType("application/json; charset=utf-8");  
			response.getOutputStream().write(JSON.toJSONString(responseObject).getBytes());
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    /*response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8");  
	    PrintWriter out = null;  
	    try {  
	        out = response.getWriter();  
	        out.append(responseJSONObject.toString());  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (out != null) {  
	            out.close();  
	       }  
	    }  */ 
	}  	
	/**
	 * 获取当前请求参数
	 * 
	 * @return Map
	 * @author Rong.Xing
	 * @date 2014-05-15
	 */
	public static Map<String, Object> param() {
		return requestMap(req());
	}

	/**
	 * 获取request
	 * 
	 * @return req
	 * @author Rong.Xing
	 * @date 2014-05-15
	 */
	public static HttpServletRequest req() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
	}

	/**
	 * request转换 Map
	 * 
	 * @param request
	 * @return HashMap
	 * @author Rong.Xing
	 * @date 2014-05-15
	 */
	public static Map<String, Object> requestMap(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			request.setCharacterEncoding("UTF-8");
			Enumeration<String> names = request.getParameterNames();
			while (names.hasMoreElements()) {
				String name = names.nextElement();
				String[] values = request
						.getParameterValues(name);
				if (values != null && values.length == 1) {
					map.put(name, values[0]);
				} else {
					map.put(name, values);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		map.remove("request_method");
		return map;
	}

	/**
	 * 
	 * @param list 需要搜索的list
	 * @param obj 需要匹配的元素
	 * @param clazz 元素类型
	 * @param field clazz中的成员变量名
	 * @return 匹配到的元素或null
	 * @throws Exception
	 */
	
	public static Object findItemInList(List<?> list, Object obj,
			Class<?> clazz, String field) throws Exception {
		if (field == null || field.length() <= 0) {
			throw new Exception("传入成员变量名不能为空");
		}
		String camelField = null;
		if (Character.isLowerCase(field.charAt(0))) {
			camelField = (new StringBuilder())
					.append(Character.toUpperCase(field
							.charAt(0)))
					.append(field.substring(1)).toString();
		}
		Method method = clazz.getMethod("get" + camelField, null);
		for (Object object : list) {
			if (method.invoke(object, null).equals(obj)) {
				return object;
			}
		}
		return null;
	}
}
