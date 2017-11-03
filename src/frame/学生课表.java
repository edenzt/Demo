package frame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import user.Course;
import user.DataProcessing;
import user.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class 学生课表 {
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
					学生课表 window = new 学生课表();
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
	public 学生课表() {
	//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6211\u7684\u8BFE\u8868");
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[][] datalist = new String[DataProcessing.max][DataProcessing.max];
		String[] titles = { "课程名", "学分", "任课老师", "时间", "地点", "上课学期", "属性", "容量", "描述" };
		
		//导入数据
				String courses;
				Course c1;
				courses = st.getCourses();
				String str[] = courses.split("\\$");
				for (int i = 0; i < str.length; i++) {// ****************************************
					try {
						c1 = DataProcessing.searchCourse(str[i]);
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
						s1 = Integer.toString(c1.getCapacity());
						datalist[i][7] = s1;
						datalist[i][8] = c1.getDes();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		
		
		model = new DefaultTableModel(datalist, titles);
		frame.getContentPane().setLayout(null);
		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 5, 874, 367);
		frame.getContentPane().add(scrollPane);

		// table.setSize(400, 300);

		table.setBounds(375, 177, -329, -147);

		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				学生界面 a = new 学生界面();
	      		a.st=st;
				a.run();
			}
		});
		button.setBounds(394, 400, 93, 23);
		frame.getContentPane().add(button);
		table.setVisible(true);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			学生课表 window = new 学生课表();
			window.st=st;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
