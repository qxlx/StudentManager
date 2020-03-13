package GUI;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Student.StudentMangerDemo;
/*
 * 学生信息包括：学号（唯一，为8位数字，如06010211前2位为年份，3-4位为系编号，后边是学生编号）、
   姓名、出生年月、民族、籍贯、高考成绩（必须是数字，范围是100—700）；
 */
public class StudentInserPanel extends JFrame implements ActionListener{
	//组件声明
	private  JLabel  lblsno,lblsname,lblbirthday,lblscore,lblminority,lblJiguan,labImag;
	//文本框
	private JTextField  txtSno,txtName,txtBirthday,txtScore;
	//按钮
	private Button butEnter,butExit;
	//下拉列表框
	private JComboBox  comJiguan,comMinority;
	
	//初始化
	public StudentInserPanel(){
		super("信息注册");
		init();
	}
	//
	public  void init(){
		java.net.URL url = this.getClass().getResource("/image/5.jpg");
		ImageIcon pic = new ImageIcon(url);
		labImag = new JLabel(pic);
		//设置组件
		lblsname = new JLabel("姓名:");
		lblsno  = new JLabel("学号:");
		lblbirthday = new JLabel("出生日期");
		lblscore = new JLabel("分数:");
		lblminority = new JLabel("民族: ");
		lblJiguan = new JLabel("籍贯:");
		//设置文本
		txtSno = new JTextField(10);
		txtName = new JTextField(10);
		txtBirthday = new JTextField(10);
		txtScore = new JTextField(10);
		//按钮
		butEnter = new Button("提交");
		butExit = new Button("重置");
		//下拉菜单
		comJiguan = new JComboBox();
		comJiguan.addItem("北京");
		comJiguan.addItem("河北");
		comJiguan.addItem("天津");
		comJiguan.addItem("山西");
		comJiguan.addItem("湖南");
		
		comMinority = new JComboBox();
		comMinority.addItem("汉族");
		comMinority.addItem("藏族");
		comMinority.addItem("回族");
		comMinority.addItem("白族");
		
		
		this.setLayout(null);
		this.add(lblsname);
		lblsname.setBounds(70, 20, 30, 20);
		this.add(txtName);
		txtName.setBounds(120, 20,80,20);
		this.add(lblsno);
		lblsno.setBounds(70, 60,30, 20);
		this.add(txtSno);
		txtSno.setBounds(120, 60, 80, 20);
		this.add(lblbirthday);
		lblbirthday.setBounds(70, 100, 60, 20);
		this.add(txtBirthday);
		txtBirthday.setBounds(130, 100, 80, 20);
		this.add(lblminority);
		lblminority.setBounds(70, 140, 40, 20);
		this.add(comMinority);
		comMinority.setBounds(120, 140, 60, 20);
		this.add(lblJiguan);
		lblJiguan.setBounds(70, 180, 30, 20);
		this.add(comJiguan);
		comJiguan.setBounds(120, 180, 60,20);
		this.add(lblscore);
		lblscore.setBounds(70, 220, 30, 20);
		this.add(txtScore);
		txtScore.setBounds(120, 220, 60, 20);
		this.add(butEnter);
		butEnter.setBounds(80, 280,50, 30);
		this.add(butExit);
		butExit.setBounds(150, 280, 50, 30);
		this.add(labImag);
		labImag.setBounds(0,0, 300, 400);
		
		butEnter.addActionListener(this);
		butExit.addActionListener(this);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//设置关闭时隐藏
		this.setBounds(300, 300, 300, 400);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		 new StudentInserPanel();
//		 StudentInserPanel  stp = new StudentInserPanel();
//			stp.aa();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//获取面板上输入的信息
		String sname = txtName.getText().trim();
		String sno = txtSno.getText().trim();
		String birthday = txtBirthday.getText().trim();
		String score = txtScore.getText().trim();
		String minority = (String)comMinority.getSelectedItem();
		String place = (String)comJiguan.getSelectedItem();
		
		boolean flag  = false;//设置标记 判断是否是
		
		//将获取到的学号装换成int类型
		int sno2 = Integer.parseInt(sno);
		//将获取到分数字符串转换成基本数据类型
		int score2 = Integer.parseInt(score);
		//日期转换
		SimpleDateFormat  sd = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday2 = null;
		try {
			birthday2 = sd.parse(birthday);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str = e.getActionCommand();
		if(str.equals("提交")){
			StudentMangerDemo student = new StudentMangerDemo();
			flag = student.insertDate(sno2, sname, birthday2, minority, place, score2);
			System.out.println(flag);
			  if(flag){
				  //判断输入的是否是争取的分数
				  if(score2>0&&score2<750){
					  JOptionPane.showMessageDialog(null, "添加成功");
					  	txtName.setText("");//清除数据
						txtSno.setText("");
						txtBirthday.setText("");
						txtScore.setText("");
				  }else{
					  JOptionPane.showMessageDialog(null, "成绩有误");
					  txtScore.setText("");
				  }
				  
			  }else {
				  JOptionPane.showMessageDialog(null,"添加失败");
			  }
		}else  if(str.equals("重置")){
			//将数据清除
			txtName.setText("");
			txtSno.setText("");
			txtBirthday.setText("");
			txtScore.setText("");
		}
	}
	
//	public void aa(){
//		URL url = this.getClass().getResource("image/1.jpg");
//		System.out.println(url);
//	}
}
