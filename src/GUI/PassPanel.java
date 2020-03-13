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
	//��ʼ��
	public PassPanel(){
		super("�����޸�");
		init();
	}
	public void init(){
		this.setLayout(null);
		//�������
		java.net.URL url = this.getClass().getResource("/image/4.jpg");
		ImageIcon pic = new ImageIcon(url);
		JLabel labImag = new JLabel(pic);
		lblName = new JLabel("�˺ţ�");
		lblPass = new JLabel("������:");
		lblNewPass = new JLabel("������:");
		lblNew1Pass = new JLabel("ȷ��������:");
		
		txtName = new JTextField(10);
		txtPass = new JTextField(10);
		txtNewPass = new JTextField(10);
		txtNew1Pass = new JTextField(10);
		
		butEnter = new JButton("ȷ���޸�");
		butExit  = new JButton("����");
		
		//������
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
		//���ÿ�ܲ���
		this.setBounds(200, 200, 250, 250);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	@Override//ע���¼��������
	public void actionPerformed(ActionEvent e) {
		//��ȡ�ı��е�����
		String name = txtName.getText().trim();
		String pass = txtPass.getText().trim();
		String new1Pass = txtNewPass.getText().trim();
		String new2Pass = txtNew1Pass.getText().trim();
		String str = e.getActionCommand();//��ȡ���������
		
		System.out.println(new1Pass);
		System.out.println(new2Pass);
		
//		System.out.println("�����Ƿ����:"+new2Pass.equals(new1Pass));
		boolean  flag = false;
		
		//�ж���������������Ƿ�����ͬ��
		if(new2Pass.equals(new1Pass)){
//			System.out.println("---------------------");
			if(str.equals("ȷ���޸�")){
				flag = Users.updateUser(new1Pass, name,pass);
//				System.out.println(new1Pass+"   "+name+"  "+pass);
				System.out.println("//////////"+flag);
				if(flag){
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					//���������
					txtName.setText("");
					txtPass.setText("");
					txtNewPass.setText("");
					txtNew1Pass.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "�޸�ʧ��");
					//���������
					txtName.setText("");
					txtPass.setText("");
					txtNewPass.setText("");
					txtNew1Pass.setText("");
				}
			}else {
				//���������
				txtName.setText("");
				txtPass.setText("");
				txtNewPass.setText("");
				txtNew1Pass.setText("");
			}
		}else {
			JOptionPane.showMessageDialog(null,"�������벻һ��!");
			txtNewPass.setText("");
			txtNew1Pass.setText("");
	}
}
		public static void main(String[] args) {
			new PassPanel();
		}
}
