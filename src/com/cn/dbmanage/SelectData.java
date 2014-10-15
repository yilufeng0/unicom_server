/**
 * 
 */
package com.cn.dbmanage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

/**
 * @author Jerry
 *
 */
public class SelectData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * @function
	 * @param 
	 * @author Jerry
	 * @return
	 * @throws SQLException 
	 */
	public static boolean name(String username,String password) throws SQLException {
		Connection conn=JDBC_Connection.getConnection();
		String sql="";
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		
		
		
		return true;	
		
	}
	
	
	
	

}
