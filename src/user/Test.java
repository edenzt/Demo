//package user;
//
//import java.sql.SQLException;
//import java.util.Enumeration;
//import java.util.Scanner;
//
//public class Test {
//	static final String tip_system="网上选课系统";
//	static final String tip_meun="请选择菜单：";
//	static final String tip_exit="系统退出，谢谢使用！";
//	static final String infos="****欢迎进入"+tip_system+"****\n\t"+"1.登录\n\t"+"2.退出\n"+"**************************\n";
//	static final String stuMenu="学生界面\n"+"1.添加课程\n"+"2.修改密码\n"+"3.查看课表\n"+"4.退出\n"+"请选择菜单：";
//	static final String AdMenu="管理员界面\n"+"1.查询学生信息\n"+"2.添加课程\n"+"3.退出\n"+"请选择菜单：";
//	public static void serve()
//	{
//		String name,password,role;//姓名，口令
//		Administrator a;
//		Student s;
//		Scanner sc=new Scanner(System.in);
//		System.out.print("请输入用户名：");
//		name=sc.nextLine();
//		System.out.print("请输入密码：");
//		password=sc.nextLine();
//		System.out.print("请输入角色：");
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
//						courses.concat(",高数");
//						if(DataProcessing.updateStudent( "1", "123", courses))
//							if(DataProcessing.updateCoursePlus("高数"))
//								System.out.println("添加成功!");
//					    break;
//					case 2:
//						s1=DataProcessing.searchStudent("jack", "123");
//						courses=s1.getCourses();
//						if(DataProcessing.updateStudent("1", "567", courses))		
//							System.out.println("修改成功!");
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
//						if(DataProcessing.insertCourse(38,28,5,"打扫房间","房间",1,"张婷婷","sdsa","sdsa","sdsa"))
//								
//							System.out.println("修改成功!");
//					break;
//			
//					
//					}
//					System.out.println(stuMenu);
//					n=sc.nextInt();
//				}
//				}
//		} catch (SQLException e) {
//			System.out.println("数据库错误"+e.getMessage());
//		}
//		}
//	public static void main(String args[]){
//		int n=-1;//选择
//		Scanner sc=new Scanner(System.in);
//		System.out.print(infos+"请选择菜单:");
//		n=sc.nextInt();
//		while(n!=2){
//			switch(n){
//			case 1:serve();break;
//			default:{System.out.print("输入错误，请重新输入:");n=sc.nextInt();};break;
//		}
//		System.out.print(infos+"请选择菜单:");
//		sc.nextLine();
//		n=sc.nextInt();
//		}
//		System.out.print("系统退出，谢谢使用！");
//		sc.close();
//		}	
//}
