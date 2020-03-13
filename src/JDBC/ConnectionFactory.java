package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//����������
 public class ConnectionFactory{
	//��̬��ʼ���飬�������ʱ��ֻ����һ�Σ�������Դ���˷�
	static {
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//��ȡ���ӷ���
	public  static Connection getConnection(){
		Connection con = null;
		String url = "";
		//��ȡ����
		try {
			url = "jdbc:mysql://localhost:3306/student";
			String user = "root";
			String password = "123456";
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}
}
//�����ر���
class JDBCclose{
	//�����رս���������������
	public static void close(ResultSet rs,Statement st,Connection con){
		close(rs);
		close(st);
		close(con);
	}
	//�ر����������
	public static void close(Statement st,Connection con){
		close(st);
		close(con);
	}
	//�رս����
	public static void close(ResultSet rs){
		if(rs!=null){
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}
	//�ر�����
	public static void close(Statement st){
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//�ر�����
	public static void close(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
