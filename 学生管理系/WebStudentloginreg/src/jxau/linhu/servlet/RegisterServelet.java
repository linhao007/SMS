package jxau.linhu.servlet;
import javax.servlet.http.HttpServlet;


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
import jxau.linhu.service.UserManager;
import jxau.linhu.vo.RegisterFrom;

/**
 * �û�ע��Ŀ�����
 * @author Administrator
 *
 */

public class RegisterServelet extends HttpServlet {
	/**
	  * ����Post����
	  * @param HttpServletRequest��HttpServletResponse
	  * @param void 
	  */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   req.setCharacterEncoding("utf-8");
		   RegisterFrom rgf =new RegisterFrom();
		   rgf.setName(req.getParameter("name"));
		   rgf.setPassword(req.getParameter("password"));
		   rgf.setRadio(req.getParameter("radio"));
		   rgf.setEmail(req.getParameter("email"));
		    
		   UserManager userMassage=UserManager.getInstance();
		   boolean flag=userMassage.Register(rgf);
		   if (flag==true){
		  
		   req.getRequestDispatcher("/index.jsp").forward(req, resp);
		   }
			else 
			req.getRequestDispatcher("/errorcf.jsp").forward(req, resp);
			 
	}
	
	/**
	  * ����Get����
	  * @param HttpServletRequest��HttpServletResponse
	  * @param void 
	  */
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				doPost(req,resp);
	}
	
}
