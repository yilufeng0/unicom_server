/**
 * 
 */
package com.cn.listviewdb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cn.jdbc.JDBC_Connection;

/**
 * @author Jerry
 *
 */
public class InsertImagedb {
	
	public void insertintodb(File file,String timeStr) throws FileNotFoundException{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
//		File file=new File("d:/test1.jpg");
		FileInputStream fis=new FileInputStream(file);
		
		try {
			conn=JDBC_Connection.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into listviewimage(timestr,imagedata) values(?,?)");
			ps.setString(1, timeStr);
			ps.setBinaryStream(2, fis);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);			
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
