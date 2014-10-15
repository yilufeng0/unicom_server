package com.cn.position;

/**
 * 
 * 城市商铺数据的类
 * 
 * @author Jerry
 *
 */

public class PositionVo {
	
	private int id;
	private String cityName;
	private String longitude;
	private String latitude;
	private String shopName;
	private String shopInfo;
	private String shopaddress;
	private String phone;
	
	
	

	public String getShopaddress() {
		return shopaddress;
	}



	public void setShopaddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCityName() {
		return cityName;
	}



	public void setCityName(String cityName) {
		this.cityName = cityName;
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



	public String getShopName() {
		return shopName;
	}



	public void setShopName(String shopName) {
		this.shopName = shopName;
	}



	public String getShopInfo() {
		return shopInfo;
	}



	public void setShopInfo(String shopInfo) {
		this.shopInfo = shopInfo;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
