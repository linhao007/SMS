package jxau.linhu.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxau.linhu.service.UserManager;
import jxau.linhu.vo.LoginForm;

/**
 * �û���¼�Ŀ�����
 * @author Administrator
 *
 */
public class LoginServelet  extends HttpServlet{
	/**
	  * ����Get����
	  * @param HttpServletRequest��HttpServletResponse
	  * @param void 
	  */
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
	/**
	  * ����Post����
	  * @param HttpServletRequest��HttpServletResponse
	  * @param void 
	  */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		LoginForm lgfm=new LoginForm();
		HttpSession session = req.getSession();
		String name=null;
		String password=null;
		int shenfen;
		 
		name=req.getParameter("username");
		password=req.getParameter("password");
		shenfen=Integer.parseInt(req.getParameter("shenfen"));
		 
		lgfm.setUsername(name);
		lgfm.setPassword(password);
		lgfm.setShenfen(shenfen);
		
		UserManager userMassage=UserManager.getInstance();
		boolean flag=userMassage.login(lgfm);
		
		 
		if(flag){
			
			session.setAttribute("name", name);
			session.setAttribute("password", password);
			session.setAttribute("shenfen", shenfen);
			
			if(shenfen==1){
			req.getRequestDispatcher("/login.jsp").forward(req, resp);}
			
			if(shenfen==0){
			req.getRequestDispatcher("/studentlogin.jsp").forward(req, resp);}
			
		}else{
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
		
	}
	
}
