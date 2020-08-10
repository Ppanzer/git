package com.example.excalhandler.util;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * @author Rong.Xing
 * @date 2016-1-12
 * @email 278892562@qq.com
 */
public class SpringUtil {
	
	public static <T>  T getSpringBean(Class<T> c){
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		return (T) wac.getBean(c);
	}
	
	public static Object getSpringBean(String beanId){
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		Object obj = wac.getBean(beanId);
		return obj;
	}
}
