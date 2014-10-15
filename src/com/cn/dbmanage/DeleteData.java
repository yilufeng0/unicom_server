/**
 * 
 */
package com.cn.dbmanage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

/**
 * 
 * 完成对数据库数据的删除操作
 * 
 * @author Jerry
 *
 */
public class DeleteData {
	
	//删除特定的城市
	public static void deleteCity(String city) throws SQLException{
		Connection conn=null;
		PreparedStatement pstm=null;
		
		conn=JDBC_Connection.getConnection();
		String sql="DELETE FROM position_city WHERE cityname=?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, city);
		pstm.executeUpdate();		
	}
	
	public static void deleteCity(int id) throws SQLException{
		Connection conn=null;
		PreparedStatement pstm=null;
		
		conn=JDBC_Connection.getConnection();
		String sql="DELETE FROM position_city WHERE id=?";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1, id);
		
		pstm.executeUpdate();
	}
	
	//删除特定城市的所有商铺数据
	public static void deleteShop(String city) throws SQLException{
		Connection conn=null;
		PreparedStatement pstm=null;
		
		conn=JDBC_Connection.getConnection();
		String sql="DELETE FROM position_shop WHERE cityname=?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, city);
		pstm.executeUpdate();
	}
	
	//删除特定的商铺条目	
	public static void deleteShop(int id) throws SQLException{
		Connection conn=null;
		PreparedStatement pstm=null;
		
		conn=JDBC_Connection.getConnection();
		String sql="DELETE FROM position_city WHERE id=?";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1, id);
	}
	
	
		
		
}
