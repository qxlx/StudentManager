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
 * ѧ����Ϣ������ѧ�ţ�Ψһ��Ϊ8λ���֣���06010211ǰ2λΪ��ݣ�3-4λΪϵ��ţ������ѧ����ţ���
   �������������¡����塢���ᡢ�߿��ɼ������������֣���Χ��100��700����
 */
public class StudentInserPanel extends JFrame implements ActionListener{
	//�������
	private  JLabel  lblsno,lblsname,lblbirthday,lblscore,lblminority,lblJiguan,labImag;
	//�ı���
	private JTextField  txtSno,txtName,txtBirthday,txtScore;
	//��ť
	private Button butEnter,butExit;
	//�����б��
	private JComboBox  comJiguan,comMinority;
	
	//��ʼ��
	public StudentInserPanel(){
		super("��Ϣע��");
		init();
	}
	//
	public  void init(){
		java.net.URL url = this.getClass().getResource("/image/5.jpg");
		ImageIcon pic = new ImageIcon(url);
		labImag = new JLabel(pic);
		//�������
		lblsname = new JLabel("����:");
		lblsno  = new JLabel("ѧ��:");
		lblbirthday = new JLabel("��������");
		lblscore = new JLabel("����:");
		lblminority = new JLabel("����: ");
		lblJiguan = new JLabel("����:");
		//�����ı�
		txtSno = new JTextField(10);
		txtName = new JTextField(10);
		txtBirthday = new JTextField(10);
		txtScore = new JTextField(10);
		//��ť
		butEnter = new Button("�ύ");
		butExit = new Button("����");
		//�����˵�
		comJiguan = new JComboBox();
		comJiguan.addItem("����");
		comJiguan.addItem("�ӱ�");
		comJiguan.addItem("���");
		comJiguan.addItem("ɽ��");
		comJiguan.addItem("����");
		
		comMinority = new JComboBox();
		comMinority.addItem("����");
		comMinority.addItem("����");
		comMinority.addItem("����");
		comMinority.addItem("����");
		
		
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
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//���ùر�ʱ����
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
		//��ȡ������������Ϣ
		String sname = txtName.getText().trim();
		String sno = txtSno.getText().trim();
		String birthday = txtBirthday.getText().trim();
		String score = txtScore.getText().trim();
		String minority = (String)comMinority.getSelectedItem();
		String place = (String)comJiguan.getSelectedItem();
		
		boolean flag  = false;//���ñ�� �ж��Ƿ���
		
		//����ȡ����ѧ��װ����int����
		int sno2 = Integer.parseInt(sno);
		//����ȡ�������ַ���ת���ɻ�����������
		int score2 = Integer.parseInt(score);
		//����ת��
		SimpleDateFormat  sd = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday2 = null;
		try {
			birthday2 = sd.parse(birthday);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str = e.getActionCommand();
		if(str.equals("�ύ")){
			StudentMangerDemo student = new StudentMangerDemo();
			flag = student.insertDate(sno2, sname, birthday2, minority, place, score2);
			System.out.println(flag);
			  if(flag){
				  //�ж�������Ƿ�����ȡ�ķ���
				  if(score2>0&&score2<750){
					  JOptionPane.showMessageDialog(null, "��ӳɹ�");
					  	txtName.setText("");//�������
						txtSno.setText("");
						txtBirthday.setText("");
						txtScore.setText("");
				  }else{
					  JOptionPane.showMessageDialog(null, "�ɼ�����");
					  txtScore.setText("");
				  }
				  
			  }else {
				  JOptionPane.showMessageDialog(null,"���ʧ��");
			  }
		}else  if(str.equals("����")){
			//���������
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
