/**
 * 
 */
package com.cn.listviewdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

/**
 * @author Jerry
 *
 */
public class ReadContentdb {
	
	public static String  readContent(String timeStr){
		Connection conn=JDBC_Connection.getConnection();
		String sql="select * from listviewdetail where timestr=?";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String result="";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, timeStr);
			rs=pstm.executeQuery();
			if(rs.next()){
				result=rs.getString("content");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstm);
		}
				
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReadContentdb.readContent("sss"));
	}

}
