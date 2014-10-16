/**
 * 
 */
package com.cn.feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.JdbcInterceptor;

import com.cn.jdbc.JDBC_Connection;

/**
 * @author Jerry
 *
 */
public class Querydb {
	
	public static List<FeedbackVo> getFvList(ResultSet rs) throws SQLException{
		List<FeedbackVo> fv=new ArrayList<FeedbackVo>();
		while(rs.next()){
			FeedbackVo newfv=new FeedbackVo();
			newfv.setTitle(rs.getString("title"));
			newfv.setContent(rs.getString("content"));
			newfv.setTel(rs.getString("tel"));
			fv.add(newfv);
		}
		return fv;
	}
	
	public static List<FeedbackVo> querydb(){
		List<FeedbackVo> fv=null;
		Connection conn=JDBC_Connection.getConnection();
		String sql="select * from feedback";
		ResultSet rs=null;
		try {
			PreparedStatement pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			fv=Querydb.getFvList(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fv;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
