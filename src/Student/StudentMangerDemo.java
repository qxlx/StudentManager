package Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import JDBC.Close;
import JDBC.ConnectionFactory;
/*
 * 
	create table Student(
	sno int  primary key auto_increment,
	sname char(10) not null,
	birthday date,
	minority char(4),
	place char(6),
	score int;
 */
public class StudentMangerDemo {
	private  Connection con;
	private  PreparedStatement  ps;
	private  boolean flag = false;
	private  ResultSet rs;
	
	public   boolean insertDate(int sno,String sname,Date birthday,String minority,String place,int score){
		//获取连接
		con = ConnectionFactory.getConnection();
		//sql语句
		String sql = "insert into student(sno,sname,birthday,minority,place,score) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, sno);
			ps.setString(2, sname);
			ps.setDate(3,new  java.sql.Date(birthday.getTime()));
			ps.setString(4, minority);
			ps.setString(5, place);
			ps.setInt(6, score);
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
	
	public  boolean  deleteDateBySname(String sname){
		//获取连接
		con = ConnectionFactory.getConnection();
		//sql
		String sql = "delete  from student where sname=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sname);
			int i =  ps.executeUpdate();
			if(i>0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Close.close(ps, con);
		}
		
		return flag;
	}
	
	public  boolean updataDateByPlace(String place,String oldPlace){
		//获取连接
		con = ConnectionFactory.getConnection();
		//sql语句
		try {
			String sql = "update student  set place = ? where place=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, place);
			ps.setString(2,oldPlace);
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
			return  flag;
	}
	
	public  Student  selectDateByName(String name){
		Student student = null;
		try {
			//获取连接
			con = ConnectionFactory.getConnection();
			String sql = "select * from student where sname = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,name );
			rs =  ps.executeQuery();
			while(rs.next()){
				student = new Student();
				student.setSno(rs.getInt("sno"));
				student.setSname(rs.getString("sname"));
				student.setBirthday(rs.getDate("birthday"));
				student.setMinority(rs.getString("minority"));
				student.setScore(rs.getInt("score"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Close.close(rs, ps, con);
		}
		
		return student;
	}
	 //查询所有学生的信息
	public  List<Student> SelectData(){
		//声明一个集合用于存储student对象
		Connection conn = null;
		Statement pss = null;
		ResultSet rss = null;
		List<Student> list = new ArrayList<Student>();
		//Student student;
		//加载连接
		try {
			conn = ConnectionFactory.getConnection();
			//sql 语句
			String sql  ="select sno,sname,birthday,minority,place,score from student";
			//预处理语句
			pss = conn.createStatement();
			rss = pss.executeQuery(sql);
			//获取
			while(rss.next()){
				Student student = new Student();
				
				student.setSno(rss.getInt("sno"));
				student.setSname(rss.getString("sname"));
				student.setBirthday(rss.getDate("birthday"));
				student.setMinority(rss.getString("minority"));
				student.setPlace(rss.getString("place"));
				student.setScore(rss.getInt("score"));
				
//				System.out.println(student.getSno());
//				System.out.println(student.getMinority());
//				System.out.println(student.getPlace());
//				System.out.println(student.getBirthday());
//				System.out.println(student.getSno());
//				System.out.println();
				list.add(student);//将对象存储到集合中
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Close.close(ps, con);
		}	
		return list;
	}
	
//	public static void main(String[] args) {
//		StudentMangerDemo sm = new StudentMangerDemo();
//		List<Student> list = sm.SelectData();
//		for(Student s:list){
//			System.out.println(s.getSno());
//			System.out.println(s.getMinority());
//			System.out.println(s.getPlace());
//			System.out.println(s.getBirthday());
//			System.out.println(s.getSno());
//			System.out.println();
//		}
//	}
}
