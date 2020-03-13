# StudentManager
# 学生管理系统

# 功能介绍
1.1功能简介：完成操作员登录、学生信息的录入、查找、删除等功能
    学生信息包括：学号（唯一，为8位数字，如06010211前2位为年份，3-4位为系编号，后边是学生编号）、
    姓名、出生年月、民族、籍贯、高考成绩（必须是数字，范围是100—700）；
1.2界面要求：
  信息--主菜单包括：系统（密码修改、重新登录、退出系统），管理（录入、查找、更改、删除）工具
  （计算器、背景更改、记事本）、帮助（帮助、关于）
  美观要求----界面美观大方，操作简单
1.3 技术要求：所有信息在数据库中保存，保存登录名和密码的表，保存学生档案信息


需求:
        数据库:创建两张表
            User表 用于储存注册和登录的统计
                字段   name  password
            Student 用于储存Student的个人信息
	      	字段  sno sname  birthday  minority   place  score  
		
	图形界面  1,创建一个登录注册界面  RegisterPanel类 作用是注册账号，登录界面
	          2，创建一个管理界面  ActionPanel   作用是操作管理
	          3.创建一个添加学生界面 StudentInserPanel   作用是添加student类的字段
	          4.创建一个密码修改的界面  PassPanel   作用是修改用户名密码
	JDBC  ConnectionFactory类:创建连接
	      
	      Close类:释放资源
	
	
	 Student类获取Student的信息
	       set get 方法();
	 
	 StudentMangerDemo类进行对student的增删改查
		insertDate();添加student信息
		deletsDateBySname();删除student的信息，根据姓名
		updateDateByPlace();更新地址
		SelectData();查询所有数据
    
	User类
	     insertUser();添加用户名
	     updateUser();更新用户名的密码
	     selectUser();查询用户名
