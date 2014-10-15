/**
 * 
 */
package com.cn.userdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

/**
 * @author Jerry
 *
 */
public class UserDelete {
	
	public static boolean userDel(int id) throws SQLException{		
			Connection conn=null;
			PreparedStatement pstm=null;
			
			conn=JDBC_Connection.getConnection();
			String sql="DELETE FROM users WHERE id=?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			int i=pstm.executeUpdate();
			System.out.println(i);
			if(i == 1){
				return true;
				
			}
			
			return false;
		}
	
	
	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		UserDelete.userDel(1);
	}

}
