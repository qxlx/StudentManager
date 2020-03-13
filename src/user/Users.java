package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.Close;
import JDBC.ConnectionFactory;
/*
 * 用户类
 *   添加 删除 更改用户
 */
public class Users {
	private static Connection con;
	private static PreparedStatement ps;
	private static boolean  flag = false;
	private static ResultSet rs;
	
	//用户注册
	public static boolean InsertUser(String name,String password){
				try {
					//获取连接
					 con = ConnectionFactory.getConnection();
					//sql语句
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
					Close.close(ps, con);//释放资源
				}
		
				
		return flag;
	}
	
	//用户登录判断
	public static boolean  selectUser(String name,String password){
		try {
			//获取连接
			con = ConnectionFactory.getConnection();
			//sql语句
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
	//修改密码
	public static  boolean updateUser(String newpass,String name,String password){
		//获取连接
		con =  ConnectionFactory.getConnection();
		//sql 语句/
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
			Close.close(ps, con);//释放资源
		}

		return flag;
	}
	
	
	
	
	
}
