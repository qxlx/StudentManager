package Student;

import java.util.Date;

/*
 * 1.1���ܼ�飺��ɲ���Ա��¼��ѧ����Ϣ��¼�롢���ҡ�ɾ���ȹ���
   ѧ����Ϣ������ѧ�ţ�Ψһ��Ϊ8λ���֣���06010211ǰ2λΪ��ݣ�3-4λΪϵ��ţ������ѧ����ţ���
   �������������¡����塢���ᡢ�߿��ɼ������������֣���Χ��100��700����
   1.2����Ҫ��
    ��Ϣ--���˵�������ϵͳ�������޸ġ����µ�¼���˳�ϵͳ��������¼�롢���ҡ����ġ�ɾ�������ߣ����������������ġ����±��������������������ڣ�
    ����Ҫ��----�������۴󷽣�������
    1.3 ����Ҫ��������Ϣ�����ݿ��б��棬�����¼��������ı�����ѧ��������Ϣ
		create table Student(
		sno int  primary key auto_increment,
		sname char(10) not null,
		birthday date,
		minority char(4),
		place char(6),
		score char(6));
		ע��:��static���εı��� �Ṳ��һ�����ݣ�����ʱ��ǰһ�����ݻᱻ��һ�����ݸ��ǵ���
 */
public class Student {
	//ѧ������
	private  int sno = 0;//ѧ��ѧ��
	private  String  sname = null;//ѧ������
	private  Date birthday;//ѧ������
	private  String minority = null;//ѧ������
	private  String place = null;//ѧ����ͥסַ
	private  int score = 0;//ѧ���߿�����
	
	//����ѧ����ѧ��
	public void setSno(int sno){
		this.sno = sno;
	}
	//��ȡѧ��
	public  int getSno(){
		return sno;
	}
	//����ѧ��������
	public void setSname(String sname){
		this.sname = sname;
	}
	//��ȡѧ��������
	public String getSname(){
		return sname;
	}
	//����ѧ��������
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	//��ȡѧ��������
	public Date getBirthday(){
		return birthday;
	}
	//��������
	public void setMinority(String minority){
		this.minority = minority;
	}
	//��ȡ����
	public String getMinority(){
		return minority;
	}
	//���ü�ͥסַ
	public void setPlace(String place){
		this.place = place;
	}
	//��ȡ��ͥסַ
	public String getPlace(){
		return place;
	}
	//���ø߿�����
	public void setScore(int score){
		this.score = score;
	}
	//��ȡ�߿�����
	public int  getScore(){
		return  score;
	}
	
}	
