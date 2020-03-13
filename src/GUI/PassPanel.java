package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import user.Users;

public class PassPanel extends JFrame implements ActionListener{
	JLabel lblName,lblPass,lblNewPass,lblNew1Pass,lblImg;
	JTextField txtName,txtPass,txtNewPass,txtNew1Pass;
	JButton butEnter,butExit;
	//初始化
	public PassPanel(){
		super("密码修改");
		init();
	}
	public void init(){
		this.setLayout(null);
		//声明组件
		java.net.URL url = this.getClass().getResource("/image/4.jpg");
		ImageIcon pic = new ImageIcon(url);
		JLabel labImag = new JLabel(pic);
		lblName = new JLabel("账号：");
		lblPass = new JLabel("旧密码:");
		lblNewPass = new JLabel("新密码:");
		lblNew1Pass = new JLabel("确认新密码:");
		
		txtName = new JTextField(10);
		txtPass = new JTextField(10);
		txtNewPass = new JTextField(10);
		txtNew1Pass = new JTextField(10);
		
		butEnter = new JButton("确认修改");
		butExit  = new JButton("重置");
		
		//添加组件
		this.add(lblName);
		lblName.setBounds(20, 20, 50, 20);
		this.add(txtName);
		txtName.setBounds(80, 20,100, 20);
		this.add(lblPass);
		lblPass.setBounds(20, 50, 50,20);
		this.add(txtPass);
		txtPass.setBounds(80, 50, 100, 20);
		this.add(lblNewPass);
		lblNewPass.setBounds(20, 80, 80, 20);
		this.add(txtNewPass);
		txtNewPass.setBounds(80, 80, 100,20);
		this.add(lblNew1Pass);
		lblNew1Pass.setBounds(20, 110, 80, 20);
		this.add(txtNew1Pass);
		txtNew1Pass.setBounds(100, 110, 80, 20);
		this.add(butEnter);
		butEnter.setBounds(20, 160, 90, 30);
		this.add(butExit);
		butExit.setBounds(130, 160, 90, 30);
		butEnter.addActionListener(this);
		butExit.addActionListener(this);
		this.add(labImag);
		labImag.setBounds(0, 0, 250, 250);
		//设置框架布局
		this.setBounds(200, 200, 250, 250);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	@Override//注册事件处理机制
	public void actionPerformed(ActionEvent e) {
		//获取文本中的内容
		String name = txtName.getText().trim();
		String pass = txtPass.getText().trim();
		String new1Pass = txtNewPass.getText().trim();
		String new2Pass = txtNew1Pass.getText().trim();
		String str = e.getActionCommand();//获取到组件名称
		
		System.out.println(new1Pass);
		System.out.println(new2Pass);
		
//		System.out.println("密码是否相等:"+new2Pass.equals(new1Pass));
		boolean  flag = false;
		
		//判断两次输入的密码是否是相同的
		if(new2Pass.equals(new1Pass)){
//			System.out.println("---------------------");
			if(str.equals("确认修改")){
				flag = Users.updateUser(new1Pass, name,pass);
//				System.out.println(new1Pass+"   "+name+"  "+pass);
				System.out.println("//////////"+flag);
				if(flag){
					JOptionPane.showMessageDialog(null, "修改成功");
					//将内容清除
					txtName.setText("");
					txtPass.setText("");
					txtNewPass.setText("");
					txtNew1Pass.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "修改失败");
					//将内容清除
					txtName.setText("");
					txtPass.setText("");
					txtNewPass.setText("");
					txtNew1Pass.setText("");
				}
			}else {
				//将内容清除
				txtName.setText("");
				txtPass.setText("");
				txtNewPass.setText("");
				txtNew1Pass.setText("");
			}
		}else {
			JOptionPane.showMessageDialog(null,"输入密码不一致!");
			txtNewPass.setText("");
			txtNew1Pass.setText("");
	}
}
		public static void main(String[] args) {
			new PassPanel();
		}
}
