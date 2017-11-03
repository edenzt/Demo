//package user;
////
////import java.sql.*;
////import java.util.Enumeration;
////
////public class MysqlJdbc {
////	public static void main(String args[]) {
////
////		DataProcessing.Init();
////		try {
////			Administrator a1;
////			Administrator a2;
////			Student s1;
////			Student s2=null;
////			Course c1;
////			a1 = DataProcessing.searchAdministrator("1");
//////			a2 = DataProcessing.searchAdministrator("2", "11111");
//////			s1 = DataProcessing.searchStudent("1");
////			s2 = DataProcessing.searchStudent("2", "111111");
////			c1 = DataProcessing.searchCourse("高数");
////
////			System.out.println(a1.getName());
//////			System.out.println(a2.getName());
//////			System.out.println(s1.getName());
////			if(s2==null){
////				System.out.println("***");
////			}
////			System.out.println(s2.getName());
////			System.out.println(c1.getName() + "  " + c1.getDes());
//////			 DataProcessing.updateAdministratorPwd("2", "000000");
//////			 DataProcessing.updateCourse("高数", 3, 1, "daer", 50, "", "", "", "");
//////			 DataProcessing.updateCourseEvaluate("大学英语", 10, 10, "");
//////			
//////			 DataProcessing.updateCourseMinus("电路原理");
//////			 DataProcessing.updateCoursePlus("高级语言程序设计");
//////			 DataProcessing.updateStudentCourses("1", "");
//////			 DataProcessing.updateStudentInfo("2", "mm", "ds", "", "");
//////			 DataProcessing.updateStudentPwd("3", "00001");
////			 
////			 
////			 
////			 
////			 
////			 
////			 
////			 
////			 
////			 
//////			 DataProcessing.deleteCourse("高数");
//////			 DataProcessing.insertCourse("un", 1, 1, "", 100, 0, "", "", "", "");
//////			Enumeration<Course> e = DataProcessing.getAllCourses();
//////
//////			Course c11;
//////			while(e.hasMoreElements()) {
//////				c11 = e.nextElement();
//////				System.out.println(c11.getName());
//////			}
////
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
////}
//
//
//import java.awt.BorderLayout;   
//import java.awt.event.ActionEvent;   
//import java.awt.event.ActionListener;   
//   
//import javax.swing.JButton;   
//import javax.swing.JFrame;   
//import javax.swing.JOptionPane;
//import javax.swing.JProgressBar;   
//   
//public class MysqlJdbc extends JFrame {   
//  JProgressBar bar = new JProgressBar();   
//  JButton step = new JButton("Step");   
//   
//  public  MysqlJdbc() {   
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
//    step.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent e) {   
//        int value = bar.getValue() + 7;   
//        if (value > bar.getMaximum()) {   
//          value = bar.getMinimum();   
//        }
//        JOptionPane.showMessageDialog(null, "不点击确定，但仍然可以点击step", "提示", JOptionPane.INFORMATION_MESSAGE);
//        bar.setValue(value);   
//      }
//       
//    });   
//   
//    getContentPane().add(bar, BorderLayout.NORTH);   
//    getContentPane().add(step, BorderLayout.EAST);   
//    pack();   
//    setVisible(true);   
//  }   
//   
//  public static void main(String arg[]) {   
//    new MysqlJdbc(); 
//    System.out.println((int)(3.0/4.0*100));
//  }   
//}  
