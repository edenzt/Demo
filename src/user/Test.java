//package user;
//
//import java.sql.SQLException;
//import java.util.Enumeration;
//import java.util.Scanner;
//
//public class Test {
//	static final String tip_system="����ѡ��ϵͳ";
//	static final String tip_meun="��ѡ��˵���";
//	static final String tip_exit="ϵͳ�˳���ллʹ�ã�";
//	static final String infos="****��ӭ����"+tip_system+"****\n\t"+"1.��¼\n\t"+"2.�˳�\n"+"**************************\n";
//	static final String stuMenu="ѧ������\n"+"1.��ӿγ�\n"+"2.�޸�����\n"+"3.�鿴�α�\n"+"4.�˳�\n"+"��ѡ��˵���";
//	static final String AdMenu="����Ա����\n"+"1.��ѯѧ����Ϣ\n"+"2.��ӿγ�\n"+"3.�˳�\n"+"��ѡ��˵���";
//	public static void serve()
//	{
//		String name,password,role;//����������
//		Administrator a;
//		Student s;
//		Scanner sc=new Scanner(System.in);
//		System.out.print("�������û�����");
//		name=sc.nextLine();
//		System.out.print("���������룺");
//		password=sc.nextLine();
//		System.out.print("�������ɫ��");
//		role=sc.nextLine();
//		try {
//			if(role.equals("student"))
//			{
//				int n;
//				System.out.println("hello student");
//				s=DataProcessing.searchStudent(name, password);
//				System.out.println(stuMenu);
//				n=sc.nextInt();
//				while(n!=4)
//				{
//					String courses;
//					Student s1;
//					switch(n){
//					case 1:
//						s1=DataProcessing.searchStudent("jack", "123");
//						courses=s1.getCourses();
//						courses.concat(",����");
//						if(DataProcessing.updateStudent( "1", "123", courses))
//							if(DataProcessing.updateCoursePlus("����"))
//								System.out.println("��ӳɹ�!");
//					    break;
//					case 2:
//						s1=DataProcessing.searchStudent("jack", "123");
//						courses=s1.getCourses();
//						if(DataProcessing.updateStudent("1", "567", courses))		
//							System.out.println("�޸ĳɹ�!");
//					break;
//					case 3:
//						Course c;
//						s1=DataProcessing.searchStudent("jack", "123");
//						courses=s1.getCourses();
//						String str[]=courses.split(",");
//						for(int i=0;i<str.length;i++){
//						c=DataProcessing.searchCourse(str[i]);
//						System.out.println(c.getName());
//						}
//					
//					}
//					System.out.println(stuMenu);
//					n=sc.nextInt();
//					
//					
//				}
//			}
//			if(role.equals("administrator"))
//			{
//				System.out.println("hello administrator");
//				a=DataProcessing.searchAdministrator(name, password);
//				System.out.println(AdMenu);
//				int n;
//				
//				n=sc.nextInt();
//				while(n!=3)
//				{
//					String courses;
//					Student s1;
//					switch(n){
//					case 1:
//						Enumeration<Student> e;
//						e=DataProcessing.getAllStudents();
//						while(e.hasMoreElements()){
//						     	s1=e.nextElement();
//						     	System.out.println(s1.getID()+"   "+s1.getName());
//						}
//						
//					    break;
//					case 2:
//						if(DataProcessing.insertCourse(38,28,5,"��ɨ����","����",1,"������","sdsa","sdsa","sdsa"))
//								
//							System.out.println("�޸ĳɹ�!");
//					break;
//			
//					
//					}
//					System.out.println(stuMenu);
//					n=sc.nextInt();
//				}
//				}
//		} catch (SQLException e) {
//			System.out.println("���ݿ����"+e.getMessage());
//		}
//		}
//	public static void main(String args[]){
//		int n=-1;//ѡ��
//		Scanner sc=new Scanner(System.in);
//		System.out.print(infos+"��ѡ��˵�:");
//		n=sc.nextInt();
//		while(n!=2){
//			switch(n){
//			case 1:serve();break;
//			default:{System.out.print("�����������������:");n=sc.nextInt();};break;
//		}
//		System.out.print(infos+"��ѡ��˵�:");
//		sc.nextLine();
//		n=sc.nextInt();
//		}
//		System.out.print("ϵͳ�˳���ллʹ�ã�");
//		sc.close();
//		}	
//}
