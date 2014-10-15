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
public class UserReg {
		/**
		 * µÇÂ¼ÑéÖ¤
		 * @param uv
		 * @return
		 * @throws SQLException
		 */
	
	
	public static boolean userReg(UserVo uv) throws SQLException{
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		conn=JDBC_Connection.getConnection();
		String sql="SELECT count(*) AS total FROM users WHERE username=?";		
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, uv.getName());
		rs=pstm.executeQuery();
		rs.next();
		System.out.println(rs.getInt("total"));
		if(rs.getInt("total")!=0){
			return false;
		}
		pstm.close();
		sql="INSERT INTO users (username,`password`,mail) VALUES(?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, uv.getName());
		pstm.setString(2, uv.getPassord());
		pstm.setString(3, uv.getEmail());
		int i=pstm.executeUpdate();
		
		System.out.println(i);
		if(i != 1){
			return false;
		}
		return true;
	}
	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		UserVo uv= new UserVo();
		uv.setName("testname");
		uv.setPassord("testpasswd");
		uv.setEmail("test@mail.com");
		UserReg.userReg(uv);
	}

}
