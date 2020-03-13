package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//�����ر���
 public class Close{
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