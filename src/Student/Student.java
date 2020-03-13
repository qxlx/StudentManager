package Student;

import java.util.Date;

/*
 * 1.1功能简介：完成操作员登录、学生信息的录入、查找、删除等功能
   学生信息包括：学号（唯一，为8位数字，如06010211前2位为年份，3-4位为系编号，后边是学生编号）、
   姓名、出生年月、民族、籍贯、高考成绩（必须是数字，范围是100—700）；
   1.2界面要求：
    信息--主菜单包括：系统（密码修改、重新登录、退出系统），管理（录入、查找、更改、删除）工具（计算器、背景更改、记事本）、帮助（帮助、关于）
    美观要求----界面美观大方，操作简单
    1.3 技术要求：所有信息在数据库中保存，保存登录名和密码的表，保存学生档案信息
		create table Student(
		sno int  primary key auto_increment,
		sname char(10) not null,
		birthday date,
		minority char(4),
		place char(6),
		score char(6));
		注意:被static修饰的变量 会共用一份数据，操作时，前一份数据会被后一份数据覆盖掉。
 */
public class Student {
	//学生属性
	private  int sno = 0;//学生学号
	private  String  sname = null;//学生姓名
	private  Date birthday;//学生生日
	private  String minority = null;//学生民族
	private  String place = null;//学生家庭住址
	private  int score = 0;//学生高考分数
	
	//设置学生的学号
	public void setSno(int sno){
		this.sno = sno;
	}
	//获取学号
	public  int getSno(){
		return sno;
	}
	//设置学生的姓名
	public void setSname(String sname){
		this.sname = sname;
	}
	//获取学生的姓名
	public String getSname(){
		return sname;
	}
	//设置学生的生日
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	//获取学生的生日
	public Date getBirthday(){
		return birthday;
	}
	//设置民族
	public void setMinority(String minority){
		this.minority = minority;
	}
	//获取民族
	public String getMinority(){
		return minority;
	}
	//设置家庭住址
	public void setPlace(String place){
		this.place = place;
	}
	//获取家庭住址
	public String getPlace(){
		return place;
	}
	//设置高考分数
	public void setScore(int score){
		this.score = score;
	}
	//获取高考分数
	public int  getScore(){
		return  score;
	}
	
}	
