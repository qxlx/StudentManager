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
	//�������
	JLabel labName,labPassword,labImag;
	JTextField  txtName,txtPassWord;
	JButton butEnter,butExit,butRegister,butUpdate;
	//��ʼ��
	public RegisterPanel(){
		
		
		super("�û�ע��");
		java.net.URL url = this.getClass().getResource("/image/3.jpg");
		ImageIcon pic = new ImageIcon(url);
		labImag = new JLabel(pic);
		this.setLayout(null);
		this.setBounds(300, 300, 300, 300);
		
		labName  = new   JLabel("�˺�:");
		labPassword = new JLabel("����:");
		
		txtName = new JTextField(10);
		txtPassWord = new JTextField(10);
		
		butEnter = new JButton("��¼");
		butExit = new JButton("����");
		butRegister = new JButton("ע���˺�");
		butUpdate = new JButton("�Զ���¼");
		//������������λ��
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
				
		//ע���������
		butRegister.addActionListener(this);
		butEnter.addActionListener(this);
		butExit.addActionListener(this);
		butUpdate.addActionListener(this);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//���ùر�ʱ����
		this.setResizable(false);//����Ϊ�����ƶ�
		this.setVisible(true);//���ÿɼ�
	}
	
	
	
	public static void main(String[] args) {
		new RegisterPanel();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = txtName.getText().trim();//��ȡ��¼��
		String passWord = txtPassWord.getText().trim();//��ȡ��¼����
		boolean  flag = false;//�ж��Ƿ�ɹ�
		String str = e.getActionCommand();
		 if(name.equals("")&&passWord.equals("")||name.equals("")||passWord.equals("")){
				JOptionPane.showMessageDialog(null, "�������Ϊ��");
			}else if(str.equals("ע���˺�")){
//			System.out.println("kkk");z//���� �Ƿ�ִ�е�����һ��
			flag = Users.InsertUser(name,passWord);
			if(flag){
				JOptionPane.showMessageDialog(null, "��ӳɹ���");
			}else{
				JOptionPane.showMessageDialog(null,"���ʧ��");
				txtName.setText("");
				txtPassWord.setText("");
			}
		}else if(str.equals("��¼")){
			flag = Users.selectUser(name, passWord);
			if(flag){
				JOptionPane.showMessageDialog(null, "��¼�ɹ�");
				new ActionPanel();
				//��ʾ��������ʱ����ǰҳ����������.
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "��¼ʧ��");
				txtName.setText("");
				txtPassWord.setText("");
			}
		}else if(str.equals("����")){
			txtName.setText("");
			txtPassWord.setText("");
		}else if(str.equals("�޸�����")){
//			flag = Users.updateUser(passWord, name);
			if(flag){
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			}else{
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
			}
//			System.out.println("////////////");//�����Ƿ������е�
		
		}
		
	}
}
