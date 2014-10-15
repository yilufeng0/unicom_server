package com.cn.userdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class UserLogin {
	
	public static boolean userLogin(UserVo uv) throws SQLException{
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		conn=JDBC_Connection.getConnection();
		String sql="SELECT count(*) AS total FROM users WHERE username=? AND `password`=?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, uv.getName());
		pstm.setString(2, uv.getPassord());
		rs=pstm.executeQuery();
		rs.next();
		if(rs.getInt("total") == 1){
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws SQLException{
		UserVo uv= new UserVo();
		uv.setName("testname");
		uv.setPassord("testpasswd");
		uv.setEmail("test@mail.com");
		System.out.println(UserLogin.userLogin(uv));
	}
}
