package jxau.linhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxau.linhu.dao.*;
import jxau.linhu.service.UserManager;




public class StudentInfoServelet  extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		UserManager userMassage=UserManager.getInstance();
		List list =userMassage.findAllUse();
		//System.out.println(list.size());
		req.setAttribute("user", list);
		
		req.getRequestDispatcher("/WEB-INF/jsp/studentInfo.jsp").forward(req, resp);
		
	}
	
}

