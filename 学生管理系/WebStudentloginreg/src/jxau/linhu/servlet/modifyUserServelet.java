package jxau.linhu.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import jxau.linhu.po.StudentBean;
import jxau.linhu.service.UserManager;
import jxau.linhu.vo.RegisterFrom;




public class modifyUserServelet extends HttpServlet {
	
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   req.setCharacterEncoding("utf-8");
		   StudentBean rgf =new StudentBean();
		   rgf.setName(req.getParameter("name"));
		   rgf.setPassword(req.getParameter("password"));
		   rgf.setSex(req.getParameter("sex"));
		   rgf.setEmail(req.getParameter("email"));
		   String id = req.getParameter("id");
		   
		    
		   UserManager userMassage=UserManager.getInstance();
		   boolean flag=userMassage.modifyUser(rgf,id);
		 
		if(flag)
		{
		 
		
			 req.getRequestDispatcher("/studentInfo").forward(req, resp);
		}
		 
	}
	
}
