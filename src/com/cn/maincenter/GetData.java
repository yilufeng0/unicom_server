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
			req.getRequestDispatcher("Feedback").forward(req, resp);
			
		}else if("homeitem".equals(type)){
			req.getRequestDispatcher("ListViewServlet").forward(req, resp);
		}else if("image".equals(type)){
			req.getRequestDispatcher("GetImageFromdb").forward(req, resp);
			
		}else if("content".equals(type)){
			req.getRequestDispatcher("ReadContent").forward(req, resp);
						
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
