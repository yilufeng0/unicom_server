package com.cn.feedback;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
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
		FeedbackVo fv= new FeedbackVo();	
		fv.setTitle(request.getParameter("title"));
		try {			
			fv.setContent(request.getParameter("content"));
		} catch (Exception e) {
			// TODO: handle exception
			fv.setContent("");
		}
		try {
			fv.setTel(request.getParameter("tel"));
		} catch (Exception e) {
			// TODO: handle exception
			fv.setTel(request.getParameter("tel"));
		}
		InsertIntodb.insertIntoDb(fv);
	}

}
