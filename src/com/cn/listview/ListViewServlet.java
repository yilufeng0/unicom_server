package com.cn.listview;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.cb.timestr.TimeStr;
import com.cn.listviewdb.ListViewQuery;
import com.cn.listviewdb.QueryItem;

/**
 * 
 * id为最新一条目的编号，如果请求中带id，则返回id以后的消息条目
 * id为空则返会最近的20条数据
 * 
 * @author Jerry
 *
 */

public class ListViewServlet extends HttpServlet {

	
	
	
	
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
//		int id;
//		id=Integer.parseInt(req.getParameter("id"));
				
//		json.put("test", 1);
//		ListViewJson lvj= new ListViewJson();
//		try {
//			json=lvj.getListViewsJson(new ListViewQuery().getItemsById(id));			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		req.setAttribute("json", json);
		ListViewJson lvj= new ListViewJson();
		String id=req.getParameter("id");
//		String id="-1";
		if("-1".equals(id)){
			try {
				String timeStr=TimeStr.getDateStr(new Date());
//				String timeStr="e";
				req.setAttribute("json", lvj.getListViewString(new QueryItem().queryItem(timeStr)));
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("json", "[]");
			}
		}
		else{	
			try {
				req.setAttribute("json", lvj.getListViewString(new QueryItem().queryItem(Integer.valueOf(id))));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				req.setAttribute("json", "[]");
			}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
