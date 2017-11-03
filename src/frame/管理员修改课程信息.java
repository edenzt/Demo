package frame;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import user.*;
public class 管理员修改课程信息 {

	private JFrame frame;
	private JTable table=null;
	DefaultTableModel model = null;
	public Administrator ad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					管理员修改课程信息 window = new 管理员修改课程信息();
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
	public 管理员修改课程信息() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8BFE\u7A0B\u64CD\u4F5C");
		frame.setBounds(100, 100,900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[][] datalist = new String[DataProcessing.max][DataProcessing.max];
	    String[] titles = { "课程名", "学分","任课老师","时间","地点","上课学期","属性","容量","描述" };
	    
	  	Enumeration<Course> e;
			try {
				e = DataProcessing.getAllCourses();
				Course c1;
				for(int i=0;e.hasMoreElements();i++){
					c1 =e.nextElement();
					String s1;
					datalist[i][0]=c1.getName();
					s1=Double.toString(c1.getCredit());
					datalist[i][1]=s1;
					datalist[i][2]=c1.getTeacher();
					datalist[i][3]=c1.getTime();
					datalist[i][4]=c1.getPlace();
					datalist[i][5]=c1.getTerm();
					s1=Integer.toString(c1.isRequired());
					datalist[i][6]=s1;
					s1=Integer.toString(c1.getCapacity());
					datalist[i][7]=s1;
					s1=Integer.toString(c1.getNum());
					datalist[i][8]=s1;
					datalist[i][9]=c1.getDes();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    
	    
	      model = new DefaultTableModel(datalist, titles);
	      frame.getContentPane().setLayout(null);
	      table = new JTable(model);

	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setBounds(0, 5, 884, 343);
	      frame.getContentPane().add(scrollPane);

	      table.setBounds(375, 177, -329, -147);
	     
	      JButton button = new JButton("\u4FEE\u6539");
	      button.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		
	      		//frame.setVisible(false);
	     		int index=table.getSelectedRow();
					String name=(String)table.getValueAt(index, 0);
					try {
						Course c=DataProcessing.searchCourse(name);
						frame.setVisible(false);
				   		管理员修改课程信息2 a=new 管理员修改课程信息2 ();
				   		a.ad=ad;
				   		a.c=c;
						a.run();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
	   
	      	}
	      });
	      button.setBounds(300, 378, 93, 23);
	      frame.getContentPane().add(button);
	      
	      JButton button_1 = new JButton("\u5220\u9664");
	      button_1.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		//frame.setVisible(false);
	 
	     		int index=table.getSelectedRow();
				String name=(String)table.getValueAt(index, 0);
				try {
					if(DataProcessing.deleteCourse(name)){
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null,"删除成功！");
						管理员修改课程信息 b=new 管理员修改课程信息();
						b.ad=ad;
						b.run();	
					}
					else
						JOptionPane.showMessageDialog(null,"删除失败！");
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	      	}
	      });
	      button_1.setBounds(516, 378, 93, 23);
	      frame.getContentPane().add(button_1);
	      
	      JButton button_2 = new JButton("\u8FD4\u56DE");
	      button_2.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		frame.setVisible(false);
	      		管理员界面 a=new 管理员界面 ();
				a.run();
	      	}
	      });
	      button_2.setBounds(791, 438, 93, 23);
	      frame.getContentPane().add(button_2);
	       table.setVisible(true);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			管理员修改课程信息 window = new 管理员修改课程信息();
			window.ad=ad;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
