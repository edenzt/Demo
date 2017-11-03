package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class ���ۿγ� {
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
					���ۿγ� window = new ���ۿγ�();
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
	public ���ۿγ�() {
		// initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();

		frame.setTitle("\u9700\u8BC4\u4EF7\u8BFE\u7A0B\u5217\u8868");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[][] datalist = new String[DataProcessing.max][DataProcessing.max];
		String[] titles = { "�γ���", "ѧ��", "�ο���ʦ" };
		
		// ��������
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
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		
		
		model = new DefaultTableModel(datalist, titles);
		frame.getContentPane().setLayout(null);
		table = new JTable(model);
		table.setBounds(375, 177, -329, -147);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 5, 443, 153);
		frame.getContentPane().add(scrollPane);

		

		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********************************
				 *********** ���ۿγ� *****************
				 **********************************/
				int index = table.getSelectedRow();
				String name = (String) table.getValueAt(index, 0);
				System.out.println(name);
				try {
					Course c1 = DataProcessing.searchCourse(name);
					if(c1 != null){
						frame.setVisible(false);
						���ۿγ������� a = new ���ۿγ�������();
						a.c=c1;
						a.st = st;
						a.run();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		button.setBounds(66, 190, 93, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ѧ������ a = new ѧ������();
				a.st=st;
				a.run();
			}
		});
		button_1.setBounds(256, 190, 93, 23);
		frame.getContentPane().add(button_1);

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			���ۿγ� window = new ���ۿγ�();
			window.st=st;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
