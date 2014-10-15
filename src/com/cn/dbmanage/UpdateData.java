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
 * 
 * 完成数据库中数据的更新操作
 * 
 * @author Jerry
 *
 */
public class UpdateData {
	
	/**
	 * @function 
	 * @param pc  
	 * @throws SQLException
	 */
	public static void updateCity(PositionCity pc) throws SQLException{
		
		Connection conn=null;
		
		conn=JDBC_Connection.getConnection();
		String sql="";
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		
	}
	
	//完成对商铺信息的跟新操作
	public static void updateShop(PositionVo pv) throws SQLException{

		Connection conn=null;
		
		conn=JDBC_Connection.getConnection();
		String sql="";
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		
	}
	
	//完成对listview信息的更新
	public static void updatelistView(ListViewVo lv) throws SQLException{

		Connection conn=null;
		
		conn=JDBC_Connection.getConnection();
		String sql="";
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		
	}
	
}
