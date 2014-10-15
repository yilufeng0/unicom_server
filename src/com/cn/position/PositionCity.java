package com.cn.position;
/**
 * 城市中心点坐标类
 * @author Jerry
 *
 */


public class PositionCity {

	private int id;
	private String cityname;
	private String longitude;//城市中心点经度
	private String latitude;//城市中心点维度
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	

}
