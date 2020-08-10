package com.example.excalhandler.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class BeanUtils extends org.springframework.beans.BeanUtils {
	
	/**
	 * 进行对象间的比较覆盖，进行合并
	 * @param source
	 * @param target
	 * @throws BeansException
	 * 注意可能会出现对象中的子对象不被比较复制 如: <set>, list
	 */
	public static void copyProperties(Object source, Object target) throws BeansException {
	    Assert.notNull(source, "Source must not be null");
	    Assert.notNull(target, "Target must not be null");
	    Class<?> actualEditable = target.getClass();  
	    PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);  
	    for (PropertyDescriptor targetPd : targetPds) {  
	      if (targetPd.getWriteMethod() != null) {  
	        PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());  
	        if (sourcePd != null && sourcePd.getReadMethod() != null) {  
	          try {  
	            Method readMethod = sourcePd.getReadMethod();  
	            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {  
	              readMethod.setAccessible(true);  
	            }  
	            Object value = readMethod.invoke(source);  
	            // 这里判断以下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等  
	            if (value != null) {  
	              Method writeMethod = targetPd.getWriteMethod();  
	              if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {  
	                writeMethod.setAccessible(true);  
	              }  
	              writeMethod.invoke(target, value);  
	            }  
	          } catch (Throwable ex) {  
	            throw new FatalBeanException("Could not copy properties from source to target", ex);
	          }  
	        }  
	      }  
	    }  
	} 
	
	/**
	 * 深度复制
	 * @param src
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> deepCopyList(List<T> src)
	{
	    List<T> dest = null;
	    try
	    {
	        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
	        ObjectOutputStream out = new ObjectOutputStream(byteOut);
	        out.writeObject(src);
	        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
	        ObjectInputStream in = new ObjectInputStream(byteIn);
	        dest = (List<T>) in.readObject();
	    }
	    catch (IOException e)
	    {
	    	e.getStackTrace();
	    }
	    catch (ClassNotFoundException e)
	    {
	    	e.getStackTrace();
	    }
	    return dest;
	}	
}
