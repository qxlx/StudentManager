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
 * ��Ϣ--���˵�������ϵͳ�������޸ġ����µ�¼���˳�ϵͳ��������¼�롢���ҡ����ġ�ɾ����
 * ����
  �����������������ġ����±��������������������ڣ�
   ����Ҫ��----�������۴󷽣�������
   
   
   
   ����:����һ����ȥ�̳�JFrame����ʵ��ActionListener
   ����һ���˵���
    	����ĸ��˵���
    	  ϵͳ   
    	    	�޸����룺new PassPanel()ͨ����д�û��� ������ ��������
    	    	��д��¼  new RegisterPanel() ��д�����û���¼����
    	    	�˳�ϵͳ  System.exit(0) ��������ֱ���˳�
    	  ���� 
    	  		��Ӳ˵���  new StudentInsert()  Ϊstudent���������ֶ�
    	  ����
    	  		������  ֱ�ӵ���ϵͳ�ļ�����
    	  		���±�   ֱ�ӵ���ϵͳ�ļ��±�
    	  ���� 
    	  		���ںͰ��� ���ʱ���ᵯ�������Ի���
    	  		
    	  ����� 
    	  	    ��ѯ��ť Ĭ���ǲ�ѯȫ��
    	  	             �����԰���������ѯ
    	  	    ���°�ť  ����ɵĵ�ַ�Ϳ��Ը��µ�ַ
    	  
 */
public class ActionPanel extends JFrame implements ActionListener{
	//�������
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
		super("ѧ���������");
		this.init();
	}
	//��ʼ��
	public void init(){
		java.net.URL url = this.getClass().getResource("/image/4.jpg");
		ImageIcon pic = new ImageIcon(url);
		labImag = new JLabel(pic);
		labName = new JLabel("����������:");
		labUpda2 = new JLabel("������ɵ�ַ:");
		labUpda = new JLabel("���µĵ�ַ:");
		labInforMation  = new JLabel("����@��Ȩ����,Υ�߱ؾ�!");
		txtName = new JTextField(10);
		txtUpdate = new JTextField(10);
		txtUpdate2 = new JTextField(10);
		btn = new JButton("��ѯ");
		butDele = new JButton("ɾ��");
		butUpda = new JButton("�޸�");
		
		
		txtResult = new JTextArea();
		//������
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
		//�˵���
		bar = new JMenuBar();
		//�˵�
		sysMenu = new JMenu("ϵͳ");
		mangerMenu = new JMenu("����");
		toolMenu = new JMenu("����");
		helpMenu = new JMenu("����");
		//�˵���
		passMenu = new JMenuItem("�����޸�");
		dengluMenu = new JMenuItem("���µ�¼");
		exitMenu = new JMenuItem("�˳�ϵͳ");
		insertMenu = new JMenuItem("���");
		clscMenu = new JMenuItem("������");
		notepadMenu = new JMenuItem("�ʼǱ�");
		helpMenuItem = new JMenuItem("help");
		aboutMenu = new JMenuItem("����");
		//���˵�����ӵ��˵���
		sysMenu.add(passMenu);
		sysMenu.add(dengluMenu);
		sysMenu.add(exitMenu);
		//���˵�����ӵ�����˵���
		mangerMenu.add(insertMenu);
		//���������ͼ��±���ӵ��˵���
		toolMenu.add(clscMenu);
		toolMenu.add(notepadMenu);
		
		//���˵�����ӵ������˵���
		helpMenu.add(helpMenuItem);
		helpMenu.add(aboutMenu);
		
		//���˵���ӵ��˵�����
		bar.add(sysMenu);
		bar.add(mangerMenu);
		bar.add(toolMenu);
		bar.add(helpMenu);
		this.add(labImag);
		labImag.setBounds(0, 0, 800, 600);
		
		btn.addActionListener(this);
		this.setJMenuBar(bar);//���˵�����ӵ������
		
		//ע���¼�������� �޸�����
		passMenu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new PassPanel();
				
			}
			
		});
		//ע���¼��������  �����ǹر�ѧ����������
		exitMenu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		//ע���¼��������
		insertMenu.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new StudentInserPanel();
				
			}
			
		});
		dengluMenu.addActionListener(this);//ע���¼���������
		butDele.addActionListener(this);//ע���¼��������
		butUpda.addActionListener(this);
		//ע���¼��������  ����ϵͳ�ļ�����
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
		//���ü��±�
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
			
		});//���ڲ˵�ע���¼���������
		aboutMenu.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null," ��ӭʹ�ñ������!������������ϵ�ͷ�.");
				
			}
			
		});//�����˵�ע���¼���������
		helpMenuItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��л����ʹ�ã�лл��");
				
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

	@Override//��д���з��������ڲ�ѯstudent�����
	public void actionPerformed(ActionEvent e) {
		List<Student> list;
		StudentMangerDemo  studentManager = new StudentMangerDemo();
		String strCom = e.getActionCommand();
		
		Student student2;//���ڴ洢student����
		String str = txtName.getText().trim();//ȥ���ո�
		String str3 = txtUpdate.getText().trim();
		String str4 = txtUpdate2.getText().trim();
		boolean flag = false;
		if(strCom.equals("��ѯ")){
			//���в��� ��ѯ �����""��ѯȫ��  ������������ѯ
			if(str.equals("")){
				list = studentManager.SelectData();
				Iterator <Student>it = list.iterator();
				txtResult.setText("");
				while(it.hasNext()){
					student2 = it.next();
					String str2 = "ѧ��:"+student2.getSno()+"   "+"����"+student2.getSname()+"   "+"����:"+student2.getBirthday()+"   "+"����:"+student2.getMinority()+"   "+"����:"+student2.getPlace()+"   "+"����:"+student2.getScore();
					txtResult.append(str2);
//					System.out.println("//////////");
					txtResult.append("\n");
				}
				
			}else {
				//����������ѯ
				student2 = studentManager.selectDateByName(str);
				if(student2!=null){
					String str2 = "ѧ��:"+student2.getSno()+"   "+"����"+student2.getSname()+"   "+"����:"+student2.getBirthday()+"   "+"����:"+student2.getMinority()+"   "+"����:"+student2.getPlace()+"   "+"����:"+student2.getScore();
					txtResult.setText("");
					txtResult.append(str2);
					
				}else{
					JOptionPane.showMessageDialog(null,"û�м�¼");
				}
			}
		}else if(strCom.equals("ɾ��")){
			//ɾ������
			if(str.equals("")){
				JOptionPane.showMessageDialog(null, "����Ϊ��!,������������");
			}else{
				flag = studentManager.deleteDateBySname(str);
				if(flag){
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
				}else{
					JOptionPane.showMessageDialog(null,"ɾ��ʧ�ܣ�");
				}
			}
		}else if(strCom.equals("�޸�")){
			//�޸Ĳ��� �޸ĵ���
			if(str3.equals("")){
				JOptionPane.showMessageDialog(null, "����Ϊ�գ����������룡");
				}else{
					flag = studentManager.updataDateByPlace(str3,str4);
					if(flag){
						JOptionPane.showMessageDialog(null,"�޸ĳɹ�!");
					}else{
						JOptionPane.showMessageDialog(null,"�޸�ʧ��!");
					}
				}
		}else if(strCom.equals("���µ�¼")){
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			new RegisterPanel();
		}
	}

}
