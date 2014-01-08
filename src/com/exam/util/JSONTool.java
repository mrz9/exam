package com.exam.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.exam.model.Point;

public class JSONTool {
	
	
	public static JSONArray set(List list){
		return JSONArray.fromObject(list);
	}
	
	public static List get(String str){
		JSONArray js = JSONArray.fromObject(str);
		List list = new ArrayList();
		for(int i=0;i<js.size();i++){
			list.add(js.get(i));
		}
		
		return null;
		
	}
	
	
	public static Object getObject(String str){
		JSONObject obj = JSONObject.fromObject(str);
		return JSONObject.toBean(obj);
	}
	
	/*public static Map getMap(String str){
		JSONArray js = JSONArray.fromObject(str);
		Map map = new HashMap();
		//map.put("id", js.g)
	}*/
public static void main(String[] args) {
	/*List list = new ArrayList();
	list.add("listtest");
	Point point = new Point();
	point.setId(1);
	point.setName("name");
	point.setFartherId(4);
	list.add(point);
	list.add(45);
	
	JSONArray arr = JSONArray.fromObject(list);
	System.out.println(arr.toString());
	String str = arr.toString();
	
	JSONArray a2 = JSONArray.fromObject(str);
	List list2 = new ArrayList();
	list2.add(a2.get(0));
	list2.add(a2.get(1));
	list2.add(a2.get(2));
	
	System.out.println(list2);*/
	//Date date=new Date("2013-12-12 12:9:00");
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	try {
		Date date = df.parse("2012-12-12 12:12:22");
		System.out.println(df.format(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	
}
