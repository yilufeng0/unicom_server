package com.cn.position;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.cn.posdb.PositionQuery;


/**
 * 
 * @author Jerry
 * 完成对城市经纬度查询的具体实现
 * 
 */
public class PositionLocationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);		
		this.doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);		
		resp.setContentType("application/json");
//		req.setCharacterEncoding("GBK");
//		String param= req.getParameter("cityName");
//		String cityname= req.getParameter("cityName");
//		String cityname=new String(param.getBytes(""),"GBK");
		String cityname="";
		
		try {
			cityname=req.getParameter("cityName");
//			System.out.println(cityname);
//			String cityname1=new String(cityname.getBytes("ISO-8859-1"),"GBK");
//			System.out.println(cityname1);
			cityname=new String(cityname.getBytes("GBK"),"UTF-8");
			System.out.println(cityname);
			
			if(cityname.indexOf('?') != -1)
			{
//				System.out.println(cityname.indexOf('?'));
				cityname=cityname.substring(0,cityname.length()-2);
			}
			System.out.println(cityname);
		} catch (Exception e) {
			// TODO: handle exception
			cityname="北京市";
		}finally{
			
		}
		
		
		PositionLocation pl=new PositionLocation();

		JSONObject json=new JSONObject();
		
		try {
			req.setAttribute("json", pl.getJsonsPosString(new PositionQuery().getPosition(cityname)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("JSP_getJson.jsp").forward(req, resp);
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
}
