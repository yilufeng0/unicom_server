package com.cn.position;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

import com.cn.posdb.PositionQuery;

/**
 * 
 * @author Jerry
 * 将所需的数据转化为Json对象返回
 *
 */
public class PositionLocation {
	public JSONObject getJsonPos(PositionVo pv){
		JSONObject js= new JSONObject();
		js.put("id", pv.getId());
		js.put("cityName", pv.getCityName());
		js.put("shopLongitude", Double.parseDouble(pv.getLongitude()));
		js.put("shopLatitude", Double.parseDouble(pv.getLatitude()));
		js.put("shopName", pv.getShopName());
//		js.put("shopinfo", pv.getShopInfo());
		js.put("shopAddress", pv.getShopaddress());
		js.put("shopTel", pv.getPhone());		
		return js;
	}
	
	
	public JSONObject getJsonPosCity(PositionCity pc){
		JSONObject js= new JSONObject();
		js.put("id", pc.getId());
		js.put("cityName", pc.getCityname());
		js.put("cityLongitude", Double.parseDouble(pc.getLongitude()));
		js.put("cityLatitude", Double.parseDouble(pc.getLatitude()));
		return js;
	}
	
	public JSONObject getJsonsPos(List<PositionVo> pv){
		JSONObject js= new JSONObject();
		for(int i=0;i<pv.size();i++){
			js.put(String.valueOf(i),getJsonPos(pv.get(i)));
		}
		return js;
	}
	
	
	public String getJsonsPosString(List<PositionVo> lpv){
		JSONArray js=new JSONArray();
		for (PositionVo pv : lpv) {
			js.add(getJsonPos(pv));
		}
		return js.toString();
	}
	
	
	
	public static void  main(String[] args) {
		PositionLocation pl=new PositionLocation();
		JSONObject json;
		try {
			json = pl.getJsonsPos(new PositionQuery().getPosition("北京市"));
			System.out.println(json.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
