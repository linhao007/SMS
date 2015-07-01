package jxau.linhu.dao;

import java.util.List;

import jxau.linhu.po.StudentBean;
import jxau.linhu.vo.RegisterFrom;



/**
 * �û�Dao��ӿ�
 */
public interface StudentDao {
	/**
	 * �û���¼
	 * @param �û������룬���
	 * @return boolean 
	 */
	public boolean con(String name,String password,int shenfen);
	
	/**
	 * �û�ע��
	 * @param RegisterFrom
	 * @return boolean 
	 */
	public boolean registerByName(RegisterFrom regf);
	
	/**
	 * ���������û�
	 * @param null
	 * @return list 
	 */
	public List getAllUser();
	
	/**
	 * ɾ��ָ���û�
	 * @param String id
	 * @return int rs
	 */
	public int delUserById(String id);
	
	/**
	 *���id����ָ���û�
	 * @param String id
	 * @return StudentBean
	 */
	public StudentBean findUserById(String id);
	
	/**
	 *��ݶ��û�����ݽ��б༭
	 * @param RegisterFrom,String id
	 * @return boolean
	 */
	public boolean modifyUser(StudentBean regf,String id);
}
