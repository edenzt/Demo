package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import user.Course;
import user.DataProcessing;
import user.Student;

import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class 学生退课 {
	public Student st;
	private JFrame frame;
	private JTable table = null;
	DefaultTableModel model = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					学生退课 window = new 学生退课();
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
	 * 
	 * @wbp.parser.entryPoint
	 */
	public 学生退课() {
		// initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5B66\u751F\u9009\u8BFE\u754C\u9762");
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[][] datalist = new String[DataProcessing.max][DataProcessing.max];
		String[] titles = { "课程名", "学分", "任课老师", "时间", "地点", "上课学期", "属性" };

		// 导入数据
		String courses;
		Course c1;
		courses = st.getCourses();
//		System.out.println(courses);
		String str[] = courses.split("\\$");
//		System.out.println(str[0] + "~~~");
		for (int i = 0; i < str.length; i++) {// ****************************************
			try {
				c1 = DataProcessing.searchCourse(str[i]);

//				System.out.println(c1.getName() + "!!!");
				String s1;
				datalist[i][0] = c1.getName();
				s1 = Double.toString(c1.getCredit());
				datalist[i][1] = s1;
				datalist[i][2] = c1.getTeacher();
				datalist[i][3] = c1.getTime();
				datalist[i][4] = c1.getPlace();
				datalist[i][5] = c1.getTerm();
				s1 = Integer.toString(c1.isRequired());
				datalist[i][6] = s1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		model = new DefaultTableModel(datalist, titles);
		frame.getContentPane().setLayout(null);
		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 10, 874, 352);
		frame.getContentPane().add(scrollPane);

		// table.setSize(400, 300);

		table.setBounds(375, 177, -329, -147);


		JButton button_1 = new JButton("\u9000\u8BFE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/****************************************************
				 ***************** 退课ing ****************************
				 ****************************************************/
				int index = table.getSelectedRow();
				String course_delete = (String) table.getValueAt(index, 0);
				String courses_old, courses_new = "";
				int temp = 0;
				courses_old = st.getCourses();
				String str[] = courses.split("\\$");
				for (int i = 0; i < str.length; i++) {// ****************************************
					if (str[i].equals(course_delete)) {// 找到这门课
					} else {
						courses_new = courses_new + str[i] + "$";
					}
				}
				// 更新student表
				try {
					// 更新course表
					if(DataProcessing.updateCourseMinus(course_delete))
						if(DataProcessing.updateStudentCourses(st.getID(), courses_new)){
							JOptionPane.showMessageDialog(null, "退课成功！");
							frame.getContentPane().repaint();
							temp=1;
							frame.setVisible(false);
							学生退课 a=new 学生退课();
							a.st=DataProcessing.searchStudent(st.getID(), st.getPassword());
							a.run();							
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (temp == 0)
					JOptionPane.showMessageDialog(null, "退课失败！");
				
			}
			
		});
		button_1.setBounds(513, 394, 93, 23);
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				学生界面 a = new 学生界面();
				a.st = st;
				a.initialize();
				a.run();
			}
		});
		button_2.setBounds(791, 438, 93, 23);
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("\u67E5\u770B\u8BFE\u7A0B\u8BE6\u7EC6\u4FE1\u606F");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/****************************************************
				 ***************** 显示课程详细信息 ****************************
				 ****************************************************/
				int index = table.getSelectedRow();
				String name = (String) table.getValueAt(index, 0);
				try {
					Course c1 = DataProcessing.searchCourse(name);
					if (c1 != null) {
						frame.setVisible(false);
						课程详细信息 a = new 课程详细信息();
						a.c = c1;
						a.st = st;
						a.run();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_3.setBounds(730, 362, 144, 23);
		frame.getContentPane().add(button_3);
		table.setVisible(true);

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void run() {
		// TODO Auto-generated method stub
		try {

			学生退课 window = new 学生退课();
			window.st = st;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
