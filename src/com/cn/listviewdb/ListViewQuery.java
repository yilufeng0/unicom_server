/**
 * 
 */
package com.cn.listviewdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.jdbc.JDBC_Connection;
import com.cn.listview.ListViewVo;

/**
 * @author Jerry
 *
 *完成与listview相关的查询操作
 *
 */
public class ListViewQuery {
	
	private List<ListViewVo> setRsToListView(ResultSet rs) throws SQLException{
		List<ListViewVo> llv= new ArrayList<ListViewVo>();
		while(rs.next()){
		
			ListViewVo lv= new ListViewVo();
			lv.setId(rs.getInt("id"));
			lv.setTitle(rs.getString("title"));
			lv.setDescrip(rs.getString("description"));
			lv.setTimestr(rs.getString("timestr"));
			lv.setImageurl(rs.getString("imageurl"));
			lv.setTexturl(rs.getString("contentturl"));
			
			llv.add(lv);
		
		}
		return llv;
	}
	
	public ListViewVo getItemById(int id) throws SQLException{
		ListViewVo lv= null;
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs= null;	
		
		conn=JDBC_Connection.getConnection();
		String sql="select * from listviewinfo where id=?";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rs=pstm.executeQuery();
		lv= setRsToListView(rs).get(0);			
	
		
		return lv;
		
	}
	
	public List<ListViewVo> getItemsById(int id) throws SQLException{
		List<ListViewVo> lv= null;
		Connection conn=JDBC_Connection.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		conn=JDBC_Connection.getConnection();
		String sql="select * from listviewinfo where id>?";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rs=pstm.executeQuery();
		lv= setRsToListView(rs);
		
		return lv;
	}
	
	
	
	public static void  main(String[] args) throws SQLException {
		ListViewQuery lvq=new ListViewQuery();
		List<ListViewVo> lv= null;
		lv=lvq.getItemsById(1);
		
		
//		ListViewVo lv=null;
//		lv=lvq.getItemById(1);
	}

}
