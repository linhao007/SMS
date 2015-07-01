package jxau.linhu.service;

import java.util.List;

import jxau.linhu.dao.StudentDao;
import jxau.linhu.dao.impl.UserDao4MySqlImpl;
import jxau.linhu.po.StudentBean;
import jxau.linhu.vo.LoginForm;
import jxau.linhu.vo.RegisterFrom;


/**
 * �û���ҵ����
 * @author Administrator
 *
 */
 public class UserManager {
	 
	
 static private UserManager instance=null;
 
 private UserManager()
 {
	 
 }
 
 static public UserManager getInstance()
 {
	 if(instance==null)
	 {
		 instance=new UserManager(); 
		 
	 }
     return instance;
 }
 
 /**
	  * �û���¼
	  * @param LoginForm
	  * @param boolean 
	  */
	
	public boolean login(LoginForm loginf){
	StudentDao intsl=new UserDao4MySqlImpl();
	 boolean flag=intsl.con(loginf.getUsername(), loginf.getPassword(),loginf.getShenfen());
	return flag;
	}
	
	/**
	 * �û�ע��
	 * @param RegisterFrom
	 * @param boolean 
	 */
	public boolean Register(RegisterFrom regf)
	{   
		StudentDao intsl=new UserDao4MySqlImpl();
		boolean flag=intsl.registerByName(regf);
		return flag;
	}
    
	 /**
	  * ���������û� 
	  * @param null
	  * @param List 
	  */
	public List findAllUse()
    {
	  StudentDao intsl=new UserDao4MySqlImpl();
      List AllUser=intsl.getAllUser();
      return AllUser;
    }
	
	/**
	 * ɾ��ָ���û� 
	 * @param id
	 * @param int 
	 */
	public int delUserById(String id)  
	{
		StudentDao intsl=new UserDao4MySqlImpl();
		int flag=intsl.delUserById(id);
		return flag;
	}
	
	public StudentBean findUserById(String id)  
	{
		StudentDao intsl=new UserDao4MySqlImpl();
		StudentBean bean=intsl.findUserById(id);
		return bean;
	}
	
	/**
	 *��ݶ��û�����ݽ��б༭
	 * @param RegisterFrom,String id
	 * @return boolean
	 */
	public boolean modifyUser(StudentBean regf,String id)
	{   
		StudentDao intsl=new UserDao4MySqlImpl();
		boolean flag=intsl.modifyUser(regf,id);
		return flag;
	}
 }
