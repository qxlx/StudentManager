package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//创建连接类
 public class ConnectionFactory{
	//静态初始化块，加载类的时候只加载一次，避免资源的浪费
	static {
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//获取连接方法
	public  static Connection getConnection(){
		Connection con = null;
		String url = "";
		//获取连接
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
//创建关闭类
class JDBCclose{
	//创建关闭结果集，语句块和连接
	public static void close(ResultSet rs,Statement st,Connection con){
		close(rs);
		close(st);
		close(con);
	}
	//关闭语句块和连接
	public static void close(Statement st,Connection con){
		close(st);
		close(con);
	}
	//关闭结果集
	public static void close(ResultSet rs){
		if(rs!=null){
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}
	//关闭语句块
	public static void close(Statement st){
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//关闭连接
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
