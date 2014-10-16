/**
 * 
 */
package com.cn.listviewdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;
import com.cn.listview.ListViewVo;

/**
 * @author Jerry
 *
 */
public class InsertIntodb {
	
	public static void insertItem(ListViewVo lv){
		Connection conn=JDBC_Connection.getConnection();
		String sql="insert into listviewinfo(title,timestr,contenturl,imageurl) values(?,?,?,?)";
		try {
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1, lv.getTitle());
			pstm.setString(2, lv.getTimestr());
			pstm.setString(3, lv.getTexturl());
			pstm.setString(4, lv.getImageurl());
//			pstm.setString(5, lv.getDescrip());		
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insertTextDetail(String content,String timeStr){
		Connection conn=JDBC_Connection.getConnection();
		String sql="insert into listviewdetail(timestr,content) values(?,?)";
		try {
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1, timeStr);
			pstm.setString(2, content);
			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
