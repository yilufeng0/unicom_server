package com.cn.maincenter;

import java.io.IOException;

/**
 * @author Jerry
 * 
 * app网络访问的控制中心
 * app的网络请求在此进行转发及重定向
 * 
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetData extends HttpServlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
		String type=req.getParameter("type");
		
		if("feedback".equals(type)){
			
		}else if("homeitem".equals(type)){
			req.getRequestDispatcher("listviewitem").forward(req, resp);
		}else if("reg".equals(type)){
			
		}else if("login".equals(type)){
			
		}else if("position".equals(type)){
			req.getRequestDispatcher("position").forward(req, resp);			
		}
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
