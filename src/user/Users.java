package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.Close;
import JDBC.ConnectionFactory;
/*
 * �û���
 *   ��� ɾ�� �����û�
 */
public class Users {
	private static Connection con;
	private static PreparedStatement ps;
	private static boolean  flag = false;
	private static ResultSet rs;
	
	//�û�ע��
	public static boolean InsertUser(String name,String password){
				try {
					//��ȡ����
					 con = ConnectionFactory.getConnection();
					//sql���
					String sql = "insert into user (name,password) values (?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, name);
					ps.setString(2,password);
					int i = ps.executeUpdate();
					if(i>0){
						flag = true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					Close.close(ps, con);//�ͷ���Դ
				}
		
				
		return flag;
	}
	
	//�û���¼�ж�
	public static boolean  selectUser(String name,String password){
		try {
			//��ȡ����
			con = ConnectionFactory.getConnection();
			//sql���
			String sql  = "select name,password from user where name=? and password=? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Close.close(rs, ps, con);
		}
		
		return flag;
	}
	//�޸�����
	public static  boolean updateUser(String newpass,String name,String password){
		//��ȡ����
		con =  ConnectionFactory.getConnection();
		//sql ���/
		String sql = "update user set password = ? where name=? and password=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,newpass);
			ps.setString(2,name);
			ps.setString(3, password);
			int i = ps.executeUpdate();
			if(i>0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Close.close(ps, con);//�ͷ���Դ
		}

		return flag;
	}
	
	
	
	
	
}
