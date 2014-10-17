package com.cn.listviewdb;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;

import com.cb.timestr.TimeStr;
import com.cn.jdbc.JDBC_Connection;
import com.cn.listview.ListViewVo;

/**
 * Servlet implementation class ListviewItem
 */
@WebServlet("/ListviewItem")
public class ListviewItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListviewItem() {
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
		
		final String rootPath="";//在此写入请求中心的地址
		Date now=new Date();
		String timeStr=TimeStr.getAllStr(now);
		HashMap<String, String> hashMap= new HashMap<>();
		DiskFileItemFactory factory=new DiskFileItemFactory();
		File fileDir=new File("D:/upload/images/");
		if(fileDir.isDirectory() && fileDir.exists() == false){
			fileDir.mkdir();
		}
		factory.setRepository(fileDir);
		ServletFileUpload sfu= new ServletFileUpload(factory);
		sfu.setHeaderEncoding("gbk");
		List<FileItem> items= null;
		try {
			items=sfu.parseRequest(request);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Iterator<FileItem> iter=items.iterator();
		File images=new File("D:/upload/images");
		if(images.exists()==false){
			images.mkdirs();
		}
		try {
			while (iter!=null && iter.hasNext()) {
				FileItem item=(FileItem)iter.next();
				if(!item.isFormField()){
					BufferedInputStream in = new BufferedInputStream(item.getInputStream());
					InsertImagedb.insertintodb(in, timeStr);
				}else{
					hashMap.put(item.getFieldName(), item.getString());
				}
			}			
			
		} catch (Exception e) {
			
		}
		
		ListViewVo lv=new ListViewVo();
		lv.setTitle(hashMap.get("title"));
		lv.setImageurl(rootPath+"?type=image&time="+timeStr);
		lv.setTimestr(timeStr);
		lv.setTexturl(rootPath+"?type=content&time="+timeStr);
		InsertIntodb.insertItem(lv);
		InsertIntodb.insertTextDetail(hashMap.get("content"), timeStr);
				
		
	}
		
}


