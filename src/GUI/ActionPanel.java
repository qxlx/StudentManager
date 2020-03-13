package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Student.Student;
import Student.StudentMangerDemo;
/*
 * 信息--主菜单包括：系统（密码修改、重新登录、退出系统），管理（录入、查找、更改、删除）
 * 工具
  （计算器、背景更改、记事本）、帮助（帮助、关于）
   美观要求----界面美观大方，操作简单
   
   
   
   需求:创建一个类去继承JFrame并且实现ActionListener
   创建一个菜单条
    	添加四个菜单项
    	  系统   
    	    	修改密码：new PassPanel()通过填写用户名 旧密码 更新密码
    	    	重写登录  new RegisterPanel() 重写进入用户登录界面
    	    	退出系统  System.exit(0) 整个程序直接退出
    	  管理 
    	  		添加菜单项  new StudentInsert()  为student类进行添加字段
    	  工具
    	  		计算器  直接调用系统的计算器
    	  		记事本   直接调用系统的记事本
    	  帮助 
    	  		关于和帮助 点击时，会弹出两个对话框
    	  		
    	  面板上 
    	  	    查询按钮 默认是查询全部
    	  	             还可以按照姓名查询
    	  	    更新按钮  输入旧的地址就可以更新地址
    	  
 */
public class ActionPanel extends JFrame implements ActionListener{
	//声明组件
	private JMenuBar  bar;
	private JMenu sysMenu,mangerMenu,toolMenu;
	private JMenuItem helpMenu;
	private JMenuItem  passMenu,dengluMenu,exitMenu,insertMenu,helpMenuItem,aboutMenu,clscMenu,notepadMenu;
	private JLabel labName,labImag,labUpda,labInforMation,labUpda2;
	private JTextField txtName,txtUpdate,txtUpdate2;
	private JTextArea txtResult;
	private JButton btn,butDele,butUpda;
	private JScrollPane sp;
	private ImageIcon labIamg;
	public ActionPanel(){
		super("学生管理操作");
		this.init();
	}
	//初始化
	public void init(){
		java.net.URL url = this.getClass().getResource("/image/4.jpg");
		ImageIcon pic = new ImageIcon(url);
		labImag = new JLabel(pic);
		labName = new JLabel("请输入姓名:");
		labUpda2 = new JLabel("请输入旧地址:");
		labUpda = new JLabel("更新的地址:");
		labInforMation  = new JLabel("三年@版权所有,违者必究!");
		txtName = new JTextField(10);
		txtUpdate = new JTextField(10);
		txtUpdate2 = new JTextField(10);
		btn = new JButton("查询");
		butDele = new JButton("删除");
		butUpda = new JButton("修改");
		
		
		txtResult = new JTextArea();
		//滚动条
		sp = new JScrollPane(txtResult,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(labName);
		labName.setBounds(30,10,80, 50);
		this.add(txtName);
		txtName.setBounds(120, 25, 100, 20);
		this.add(btn);
		btn.setBounds(230, 25, 70, 20);
		this.add(butDele);
		butDele.setBounds(310, 25,70, 20);
		this.add(labUpda2);
		labUpda2.setBounds(30, 40,90, 50);
		this.add(txtUpdate2);
		txtUpdate2.setBounds(125, 55, 100, 20);
		this.add(labUpda);
		labUpda.setBounds(230, 40, 80, 50);
		this.add(txtUpdate);
		txtUpdate.setBounds(310, 55, 80, 20);
		this.add(butUpda);
		butUpda.setBounds(400, 55, 70,20);
		this.add(txtResult);
		txtResult.setBounds(10, 100, 460, 200);
		this.add(labInforMation);
		labInforMation.setBounds(180, 305, 200, 15);
		this.add(sp);
		this.setLayout(null);
		//菜单条
		bar = new JMenuBar();
		//菜单
		sysMenu = new JMenu("系统");
		mangerMenu = new JMenu("管理");
		toolMenu = new JMenu("工具");
		helpMenu = new JMenu("帮助");
		//菜单项
		passMenu = new JMenuItem("密码修改");
		dengluMenu = new JMenuItem("重新登录");
		exitMenu = new JMenuItem("退出系统");
		insertMenu = new JMenuItem("添加");
		clscMenu = new JMenuItem("计算器");
		notepadMenu = new JMenuItem("笔记本");
		helpMenuItem = new JMenuItem("help");
		aboutMenu = new JMenuItem("关于");
		//将菜单项添加到菜单上
		sysMenu.add(passMenu);
		sysMenu.add(dengluMenu);
		sysMenu.add(exitMenu);
		//将菜单项添加到管理菜单上
		mangerMenu.add(insertMenu);
		//将计算器和记事本添加到菜单上
		toolMenu.add(clscMenu);
		toolMenu.add(notepadMenu);
		
		//将菜单项添加到帮助菜单上
		helpMenu.add(helpMenuItem);
		helpMenu.add(aboutMenu);
		
		//将菜单添加到菜单条上
		bar.add(sysMenu);
		bar.add(mangerMenu);
		bar.add(toolMenu);
		bar.add(helpMenu);
		this.add(labImag);
		labImag.setBounds(0, 0, 800, 600);
		
		btn.addActionListener(this);
		this.setJMenuBar(bar);//将菜单条添加到面板上
		
		//注册事件处理机制 修改密码
		passMenu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new PassPanel();
				
			}
			
		});
		//注册事件处理机制  作用是关闭学生操作界面
		exitMenu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		//注册事件处理机制
		insertMenu.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new StudentInserPanel();
				
			}
			
		});
		dengluMenu.addActionListener(this);//注册事件监听机制
		butDele.addActionListener(this);//注册事件处理机制
		butUpda.addActionListener(this);
		//注册事件处理机制  调用系统的计算器
		clscMenu.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Runtime r = Runtime.getRuntime();
				Process p = null;
				try {
					p = r.exec("calc.exe");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
				p.destroy();
				}
			}
			
		});
		//调用记事本
		notepadMenu.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Runtime r = Runtime.getRuntime();
				Process p = null;
				try {
					p = r.exec("notepad.exe");
					Thread.sleep(1000);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
				p.destroy();
				}
			}
			
		});//关于菜单注册事件监听机制
		aboutMenu.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null," 欢迎使用本款软件!如有问题请联系客服.");
				
			}
			
		});//帮助菜单注册事件监听机制
		helpMenuItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "感谢您的使用，谢谢！");
				
			}
			
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300, 300, 500, 380);
		this.setResizable(false);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ActionPanel();

	}

	@Override//重写其中方法，用于查询student类对象
	public void actionPerformed(ActionEvent e) {
		List<Student> list;
		StudentMangerDemo  studentManager = new StudentMangerDemo();
		String strCom = e.getActionCommand();
		
		Student student2;//用于存储student对象
		String str = txtName.getText().trim();//去除空格
		String str3 = txtUpdate.getText().trim();
		String str4 = txtUpdate2.getText().trim();
		boolean flag = false;
		if(strCom.equals("查询")){
			//进行操作 查询 如果是""查询全部  否则按照姓名查询
			if(str.equals("")){
				list = studentManager.SelectData();
				Iterator <Student>it = list.iterator();
				txtResult.setText("");
				while(it.hasNext()){
					student2 = it.next();
					String str2 = "学号:"+student2.getSno()+"   "+"姓名"+student2.getSname()+"   "+"出生:"+student2.getBirthday()+"   "+"民族:"+student2.getMinority()+"   "+"地区:"+student2.getPlace()+"   "+"分数:"+student2.getScore();
					txtResult.append(str2);
//					System.out.println("//////////");
					txtResult.append("\n");
				}
				
			}else {
				//按照姓名查询
				student2 = studentManager.selectDateByName(str);
				if(student2!=null){
					String str2 = "学号:"+student2.getSno()+"   "+"姓名"+student2.getSname()+"   "+"出生:"+student2.getBirthday()+"   "+"民族:"+student2.getMinority()+"   "+"地区:"+student2.getPlace()+"   "+"分数:"+student2.getScore();
					txtResult.setText("");
					txtResult.append(str2);
					
				}else{
					JOptionPane.showMessageDialog(null,"没有记录");
				}
			}
		}else if(strCom.equals("删除")){
			//删除操作
			if(str.equals("")){
				JOptionPane.showMessageDialog(null, "输入为空!,请重新先输入");
			}else{
				flag = studentManager.deleteDateBySname(str);
				if(flag){
					JOptionPane.showMessageDialog(null, "删除成功！");
				}else{
					JOptionPane.showMessageDialog(null,"删除失败！");
				}
			}
		}else if(strCom.equals("修改")){
			//修改操作 修改地区
			if(str3.equals("")){
				JOptionPane.showMessageDialog(null, "输入为空，请重新输入！");
				}else{
					flag = studentManager.updataDateByPlace(str3,str4);
					if(flag){
						JOptionPane.showMessageDialog(null,"修改成功!");
					}else{
						JOptionPane.showMessageDialog(null,"修改失败!");
					}
				}
		}else if(strCom.equals("重新登录")){
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			new RegisterPanel();
		}
	}

}
