package com.cn.posdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.JdbcInterceptor;

import com.cn.jdbc.JDBC_Connection;
import com.cn.position.PositionCity;
import com.cn.position.PositionVo;

/**
 * 
 * @author Jerry
 * 完成数据的查询操作
 *	
 */
public class PositionQuery {
	
	public List<PositionVo> setRsToPostionVo(ResultSet rs) throws SQLException{
		List<PositionVo> pv= new ArrayList<PositionVo>();
		while(rs.next()){
			PositionVo newpv= new PositionVo();
			newpv.setId(rs.getInt("id"));
			newpv.setCityName(rs.getString("cityname"));
			newpv.setLongitude(rs.getString("longitude"));
			newpv.setLatitude(rs.getString("latitude"));
			newpv.setShopName(rs.getString("shopname"));
			newpv.setShopInfo(rs.getString("shopinfo"));
			newpv.setPhone(rs.getString("phone"));
			pv.add(newpv);
		}
		
		return pv;
		
	}
	
	public List<PositionVo> getPosition(String cityname) throws SQLException{
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<PositionVo> pv=null;
		
		conn=JDBC_Connection.getConnection();
		
		String sql="select * from position_shop where cityname like ?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, "%"+cityname+"%");
		rs=pstm.executeQuery();
		
		pv= setRsToPostionVo(rs);
		
		
		return  pv;
	}
	
	//查询城市的总数
	public static int getSumCity() throws SQLException {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		conn=JDBC_Connection.getConnection();
		String sql="select count(*) as sum from position_city";
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		rs.next();
		 
		return  rs.getInt("sum");
	}
	
	
	//查询特定城市的商铺个数
	public static int getSumShopByCity(String cityname) throws SQLException{
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		conn=JDBC_Connection.getConnection();
		String sql="select count(*) as sum from position_shop where cityname=?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, cityname);
		rs=pstm.executeQuery();
		rs.next();
		
		return rs.getInt("sum");				
	}
	
	//
	public static int getSumShop() throws SQLException {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		conn=JDBC_Connection.getConnection();
		String sql="select count(*) as sum from position_shop";
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		rs.next();
		
		return rs.getInt("sum");
		
	}
	
	
	public PositionCity getPositionCity(String cityname){
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		PositionCity pc= new PositionCity();
		try {
			conn=JDBC_Connection.getConnection();
			String sql="select * from position_city where cityname=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, cityname);
			rs=pstm.executeQuery();
			if(rs.next()){
				pc.setId(rs.getInt("id"));
				pc.setCityname(rs.getString("cityname"));
				pc.setLongitude(rs.getString("longitude"));
				pc.setLatitude(rs.getString("latitude"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			JDBC_Connection.free(rs, conn, pstm);
			
		}
		
		return pc;
	}
	
	public static void main(String[] args) throws SQLException {
		String cityname="上海";
		PositionQuery pq=new PositionQuery();
		
		List<PositionVo> list= pq.getPosition(cityname);
		System.out.println(list.size());
	}
	
	
	
	
	
	
}
