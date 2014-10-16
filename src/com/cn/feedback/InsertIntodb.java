/**
 * 
 */
package com.cn.feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

/**
 * @author Jerry
 *
 */
public class InsertIntodb {

	
	
	public static void insertIntoDb(FeedbackVo fv){
		Connection conn=JDBC_Connection.getConnection();
		String sql="insert into feedback(title,content,tel) values(?,?,?)";
		try {
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1, fv.getTitle());
			pstm.setString(2, fv.getContent());
			pstm.setString(3, fv.getTel());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
