/**
 * 
 */
package com.cn.dbmanage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;
import com.cn.listview.ListViewVo;
import com.cn.position.PositionCity;
import com.cn.position.PositionVo;

/**
 * 完成向数据库中插入数据的操作
 * 
 * @author Jerry
 *
 */
public class InsertData {
	
	public static void insertCity(PositionCity pc) throws SQLException{
		
		Connection conn= null;
		PreparedStatement pstm=null;		
		
		conn=JDBC_Connection.getConnection();
		String sql="INSERT INTO position_city (cityname,longitude,latitude)VALUES(?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,pc.getCityname());
		pstm.setString(2, pc.getLongitude());
		pstm.setString(3, pc.getLatitude());
		pstm.executeUpdate();
		
	}
	
	public static void insertShop(PositionVo pv) throws SQLException{
		Connection conn=null;
		PreparedStatement pstm=null;
		
		conn=JDBC_Connection.getConnection();
		String sql="INSERT INTO position_shop (cityname,longitude,latitude,shopname,phone,shopaddress) VALUES(?,?,?,?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, pv.getCityName());
		pstm.setString(2, pv.getLongitude());
		pstm.setString(3, pv.getLatitude());
		pstm.setString(4, pv.getShopName());
		pstm.setString(5, pv.getPhone());
		pstm.setString(6, pv.getShopaddress());
		
		pstm.executeUpdate();		
		
	}
	
	public static void insertListItem(ListViewVo lv) throws SQLException{
		Connection conn=null;
		PreparedStatement pstm=null;
		
		conn=JDBC_Connection.getConnection();
		String sql="INSERT INTO listviewinfo (title,timestr,texturl,imageurl,description) VALUES(?,?,?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, lv.getTitle());
		pstm.setString(2, lv.getTimestr());
		pstm.setString(3, lv.getTexturl());
		pstm.setString(4, lv.getImageurl());
		pstm.setString(5, lv.getDescrip());
		
		pstm.executeUpdate();		
	}
	
	
	
	
}
