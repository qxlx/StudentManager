package GUI;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import user.Users;

public class RegisterPanel extends JFrame implements ActionListener{
	//组件声明
	JLabel labName,labPassword,labImag;
	JTextField  txtName,txtPassWord;
	JButton butEnter,butExit,butRegister,butUpdate;
	//初始化
	public RegisterPanel(){
		
		
		super("用户注册");
		java.net.URL url = this.getClass().getResource("/image/3.jpg");
		ImageIcon pic = new ImageIcon(url);
		labImag = new JLabel(pic);
		this.setLayout(null);
		this.setBounds(300, 300, 300, 300);
		
		labName  = new   JLabel("账号:");
		labPassword = new JLabel("密码:");
		
		txtName = new JTextField(10);
		txtPassWord = new JTextField(10);
		
		butEnter = new JButton("登录");
		butExit = new JButton("重置");
		butRegister = new JButton("注册账号");
		butUpdate = new JButton("自动登录");
		//添加组件和设置位置
		this.add(labName);
		labName.setBounds(60, 30, 30, 20);
		this.add(txtName);
		txtName.setBounds(110, 30, 80, 20);
		this.add(labPassword);
		labPassword.setBounds(60, 60, 30,20);
		this.add(txtPassWord);
		txtPassWord.setBounds(110, 60,80, 20);
		this.add(butEnter);
		butEnter.setBounds(80,150, 60, 30);
		this.add(butExit);
		butExit.setBounds(150, 150, 60,30);
		this.add(butRegister);
		butRegister.setBounds(200, 30,90, 20);
		this.add(butUpdate);
		butUpdate.setBounds(200, 60, 90, 20);
		this.add(labImag);
		labImag.setBounds(0, 0, 300, 300);
				
		//注册监听机制
		butRegister.addActionListener(this);
		butEnter.addActionListener(this);
		butExit.addActionListener(this);
		butUpdate.addActionListener(this);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//设置关闭时隐藏
		this.setResizable(false);//设置为不可移动
		this.setVisible(true);//设置可见
	}
	
	
	
	public static void main(String[] args) {
		new RegisterPanel();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = txtName.getText().trim();//获取登录名
		String passWord = txtPassWord.getText().trim();//获取登录密码
		boolean  flag = false;//判断是否成功
		String str = e.getActionCommand();
		 if(name.equals("")&&passWord.equals("")||name.equals("")||passWord.equals("")){
				JOptionPane.showMessageDialog(null, "你输入的为空");
			}else if(str.equals("注册账号")){
//			System.out.println("kkk");z//测试 是否执行到了这一部
			flag = Users.InsertUser(name,passWord);
			if(flag){
				JOptionPane.showMessageDialog(null, "添加成功！");
			}else{
				JOptionPane.showMessageDialog(null,"添加失败");
				txtName.setText("");
				txtPassWord.setText("");
			}
		}else if(str.equals("登录")){
			flag = Users.selectUser(name, passWord);
			if(flag){
				JOptionPane.showMessageDialog(null, "登录成功");
				new ActionPanel();
				//显示操作界面时，当前页面隐藏起来.
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "登录失败");
				txtName.setText("");
				txtPassWord.setText("");
			}
		}else if(str.equals("重置")){
			txtName.setText("");
			txtPassWord.setText("");
		}else if(str.equals("修改密码")){
//			flag = Users.updateUser(passWord, name);
			if(flag){
				JOptionPane.showMessageDialog(null, "修改成功");
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
//			System.out.println("////////////");//测试是否能运行到
		
		}
		
	}
}
