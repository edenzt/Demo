package frame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import user.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class 管理员查询选课情况 {

	private JFrame frame;
	private JTable table=null;
	DefaultTableModel model = null;
	public Administrator ad=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					管理员查询选课情况 window = new 管理员查询选课情况();
					window.initialize();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public 管理员查询选课情况() {
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u9009\u8BFE\u60C5\u51B5");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[][] datalist = new String[DataProcessing.max][DataProcessing.max];
	      String[] titles = { "课程名", "任课老师","容量","已选人数"};
	      
	   	Enumeration<Course> e;
		try {
			e = DataProcessing.getAllCourses();
			Course c1;
			for(int i=0;e.hasMoreElements();i++){
				c1 =e.nextElement();
				String s1;
				datalist[i][0]=c1.getName();
				datalist[i][1]=c1.getTeacher();
				s1=Integer.toString(c1.getCapacity());
				datalist[i][2]=s1;
				s1=Integer.toString(c1.getNum());
				datalist[i][3]=s1;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      
	      model = new DefaultTableModel(datalist, titles);
	      frame.getContentPane().setLayout(null);
	      table = new JTable(model);

	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setBounds(0, 5, 443, 195);
	      frame.getContentPane().add(scrollPane);

	      table.setBounds(375, 177, -329, -147);
	      
	      
	    
	      JButton button = new JButton("\u8FD4\u56DE");
	      button.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		frame.setVisible(false);
	      		管理员界面 a=new 管理员界面 ();
	      		a.ad=ad;
	      		a.initialize();
				a.run();
	      	}
	      });
	      button.setBounds(178, 217, 93, 23);
	      frame.getContentPane().add(button);
	       table.setVisible(true);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			管理员查询选课情况 window = new 管理员查询选课情况();
			window.ad=ad;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
