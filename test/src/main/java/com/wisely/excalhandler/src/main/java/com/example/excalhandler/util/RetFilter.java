package com.example.excalhandler.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于根据指定的返回值，将对象被指定的属性值抽取，封闭成map返回
 * @author fulong
 *
 */
public class RetFilter {
	
	/**
	 * 
	 * @param retFieldStr 指定返回的属性，多个字段用半角逗号分隔，全部返回填*，如“name,age”
	 * @param srcObject 原本返回的对象，要包含retFieldStr中指定的字段
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Map<String, Object> getRetMap(String retFieldStr, Object srcObject) throws ClassNotFoundException{
		//List<Field> feilds = Arrays.asList(clazz.getFields());
		List<String> fieldNameList = Arrays.asList(getFiledName(srcObject));
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		boolean selectAll = false;
		
		if (fieldNameList.size() <= 0){
			retMap.put("retCode", "0");
			retMap.put("retDesc", "该类型无属性字段");
			return retMap;
		}
		
		String[] retFeildList = null;
		
		if (retFieldStr == null || "*".equals(retFieldStr.trim())){
			selectAll = true;
		}else{
			retFeildList = retFieldStr.split(",");			
		}
		
		
		if (selectAll == true){
			for (String str : fieldNameList){				
				Object value = getFieldValueByName(str, srcObject);
				retMap.put(str, value);
			}
		}else{
			
			if (retFeildList == null || retFeildList.length == 0){
				retMap.put("retCode", "0");
				retMap.put("retDesc", "指定输出字段格式无效");
				return retMap;
			}
			
			for (String str : retFeildList){
				int i = fieldNameList.indexOf(str);
				if (i == -1){
					retMap.put("retCode", "0");
					retMap.put("retDesc", "指定字段[" + str + "]不存在");
					return retMap;
				}
				Object value = getFieldValueByName(str, srcObject);
				retMap.put(str, value);
			}
		}		
		
		//retMap.put("retCoe", "1");
		//retMap.put("retDesc", "成功");
		
		return retMap;
	}
	
	/**
	 * 根据属性名获取属性值
	 * */
	public static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}
	} 
	
	/**
	 * 获取属性名数组
	 * */
	public static String[] getFiledName(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			//System.out.println(fields[i].getType());
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}
	
	public static Map<String, Object> getRetMap(List<String> returnFieldList, Object srcObject) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		HashMap<String, Object> retMap = new HashMap<String, Object>();

		boolean selectAll = false;
		if (null!= returnFieldList&&returnFieldList.size()==1
				&& "*".equals(returnFieldList.get(0).trim())) {
			selectAll = true;
		}
		
		Class<? extends Object> clazz = srcObject.getClass();
		if(selectAll == true){
			Field[] fields = clazz.getDeclaredFields();
			returnFieldList.clear();
			for(Field f :fields){
				System.out.print(f.getName()+",");
				returnFieldList.add(f.getName());
			}
			returnFieldList = addFatherFieldName(returnFieldList,clazz);
		}
		if (null == returnFieldList || returnFieldList.size() == 0){
			retMap.put("retCode", "0");
			retMap.put("retDesc", "指定输出字段格式无效");
			return retMap;
		}
		for(String feild:returnFieldList){
			String methodName = "get"+feild.substring(0, 1).toUpperCase()+feild.substring(1);
			System.out.println(methodName);
			Method method;
			Object value=null;
			try {
				method = clazz.getMethod(methodName);
				value = method.invoke(srcObject);
			} catch (NoSuchMethodException | SecurityException e) {
				retMap.put("retCode", "0");
				retMap.put("retDesc", "指定字段[" + feild + "]不存在");
			}
			retMap.put(feild, value);
		}
		
		return retMap;
		
	}

	private static List<String> addFatherFieldName(List<String> fields,Class<?> clazz){
		Class<?> fatherClazz = clazz.getSuperclass();
		while (null!=fatherClazz && !"java.lang.Object".equals(fatherClazz.getName())) {
			List<Field> fatherFieldList = Arrays.asList(fatherClazz.getDeclaredFields());
			for(Field f: fatherFieldList){
				fields.add(f.getName());
			}
			fields = addFatherFieldName(fields,fatherClazz);
			fatherClazz = fatherClazz.getSuperclass();
		}
		return fields;
	}
	
	/*public static void main(String[] args){
		TestA a = new TestA();
		a.name = "张三";
		a.age = 5;
		a.sex = "男";
		Map<String, Object> retMap = null;
		List<String> rlist = new ArrayList<>();
		rlist.add("name");
		rlist.add("age");
		try {
			retMap = getRetMap("name,age", a);
			System.out.println(retMap);
			retMap = getRetMap(rlist,a);
			System.out.println(retMap);
		} catch (ClassNotFoundException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
