package com.cn.listview;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import sun.security.action.GetLongAction;

import com.cn.listviewdb.ListViewQuery;

/**
 * 
 * 用于返回条目json字符串
 * 
 * 
 * @author Jerry
 *
 */

public class ListViewJson {
	
	//用于得到单个条目的JSON字符串
	public JSONObject getListViewJson(ListViewVo lv){
		JSONObject js= new JSONObject();
		js.put("id", lv.getId());
		js.put("title", lv.getTitle());
//		js.put("descrip", lv.getDescrip());
		js.put("time", lv.getTimestr());
		js.put("imageurl",lv.getImageurl());
		js.put("texturl", lv.getTexturl());
		
		return js;
	}
	
	
	//用于返回条目组合的组合JSON字符串
	public JSONObject getListViewsJson(List<ListViewVo> lv){
		JSONObject js=new JSONObject();
		int i=0;
		for (ListViewVo lvv : lv) {
			js.put(String.valueOf(i++), getListViewJson(lvv));			
		}
		
		
		return js;
		
	}
	
	public String getListViewString(List<ListViewVo> llv){
		JSONArray js= new JSONArray();
		for (ListViewVo lv : llv) {
			js.add(getListViewJson(lv));
		}
		
		return js.toString();
	}
	
	
	public static void main(String[] args) throws SQLException {
		JSONObject js=null;
		ListViewJson lvj= new ListViewJson();
		ListViewQuery lvq= new ListViewQuery();
		js= lvj.getListViewsJson(lvq.getItemsById(1));
		System.out.print(js);
	}
	

}
