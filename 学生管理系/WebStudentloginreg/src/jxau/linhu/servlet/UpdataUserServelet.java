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


 

public class UpdataUserServelet extends HttpServlet{
	
	String id;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		 
		id=req.getParameter("id");
		UserManager userMassage=UserManager.getInstance();
		StudentBean bean=userMassage.findUserById(id);
		req.setAttribute("user",bean);
		 
        req.getRequestDispatcher("/WEB-INF/jsp/Updata.jsp").forward(req, resp);
	 
		
		
	}
	
}

