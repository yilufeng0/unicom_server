/**
 * 
 */
package com.cn.listviewdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cb.timestr.TimeStr;
import com.cn.jdbc.JDBC_Connection;
import com.cn.maincenter.GetData;
import com.cn.listview.*;

/**
 * @author Jerry
 *
 */
public class QueryItem {
	
	
	public List<ListViewVo> setItem(ResultSet rs) throws SQLException{
		List<ListViewVo> lv=new ArrayList<ListViewVo>();
		while(rs.next()){
			ListViewVo temp_lv=new ListViewVo();
			temp_lv.setId(rs.getInt("id"));
			temp_lv.setTitle(rs.getString("title"));
			temp_lv.setTimestr(rs.getString("timestr"));
			temp_lv.setTexturl(rs.getString("contenturl"));
			temp_lv.setImageurl(rs.getString("imageurl"));
			temp_lv.setDescrip(rs.getString("description"));
			lv.add(temp_lv);
		}
		return lv;
	}
	
	
	public List<ListViewVo> queryItem(int id){
		List<ListViewVo> lv=null;
		Connection conn=JDBC_Connection.getConnection();
		try {
			PreparedStatement pstm= conn.prepareStatement("select * from listviewinfo WHERE id>?");
			pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			lv=setItem(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return lv;
	}
	
	public List<ListViewVo> queryItem(String timeStr){
		List<ListViewVo> lv=null;
//		Date now=new Date();
//		String timeStr= TimeStr.getDateStr(now);
		Connection conn=JDBC_Connection.getConnection();
		try {
			PreparedStatement pstm=conn.prepareStatement("select * from listviewinfo WHERE timestr like ?");
			pstm.setString(1, timeStr+"%");
			ResultSet rs= pstm.executeQuery();
			lv=setItem(rs);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lv;
	}
	
	public static void main(String[] args){
		QueryItem qi= new QueryItem();
		List<ListViewVo> lv=qi.queryItem("e");
		System.out.print("111");
	}
	
}
