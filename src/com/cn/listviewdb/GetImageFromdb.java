package com.cn.listviewdb;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.jdbc.JDBC_Connection;

/**
 * Servlet implementation class GetImageFromdb
 * 
 * 根据客户端请求返回所需要的图片
 */
@WebServlet("/GetImageFromdb")
public class GetImageFromdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetImageFromdb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String timeStr=request.getParameter("timestr");
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select * from listviewimage where timestr=?";
		
		try {
			conn=JDBC_Connection.getConnection();
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1, timeStr);
			rs=pstm.executeQuery();
			rs.next();
			InputStream in=rs.getBinaryStream("imagedata");
			ServletOutputStream sos=response.getOutputStream();
			int len=0;
			byte[] b=new byte[1024];
			response.reset();
			response.setContentType("image/gif");
			while((len=in.read(b))>0){
				sos.write(b,0,len);
			}
			in.close();
			sos.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			JDBC_Connection.free(rs, conn, stmt);
		}
		
	}

}
