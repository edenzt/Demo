package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

public class ѧ��ѡ�� {
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
					ѧ��ѡ�� window = new ѧ��ѡ��();
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
	 * @wbp.parser.entryPoint
	 */
	public ѧ��ѡ��() {
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
		String[] titles = { "�γ���", "ѧ��", "�ο���ʦ", "ʱ��", "�ص�", "�Ͽ�ѧ��", "����", "����", "��ѡ����" };
		
		//��������
		Enumeration<Course> e;
		try {
			e = DataProcessing.getAllCourses();
			Course c1;
			for (int i = 0; e.hasMoreElements(); i++) {
				c1 = e.nextElement();
				
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
				s1 = Integer.toString(c1.getNum());
				datalist[i][8] = s1;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		model = new DefaultTableModel(datalist, titles);
		frame.getContentPane().setLayout(null);
		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 10, 874, 352);
		frame.getContentPane().add(scrollPane);

		// table.setSize(400, 300);

		table.setBounds(375, 177, -329, -147);

		
		


		JButton button = new JButton("\u9009\u8BFE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/****************************************************
				 ***************** ѡ��ing ****************************
				 ****************************************************/
				int flag=0;
				int index = table.getSelectedRow();
				String name = (String) table.getValueAt(index, 0);
				String courses;
				courses = st.getCourses();
				String str[] = courses.split("\\$");
				for (int i = 0; i < str.length; i++) {
					if (str[i].equals(name)) {
						JOptionPane.showMessageDialog(null, "��ѡ�ÿΣ�");
						flag=1;
						break;
					}
				}
				if(flag==0){
					// δѡ���ſ�
					
					courses=courses+name+"$";
					System.out.println(courses);
					int temp = 0;
					try {
						Course c1 = DataProcessing.searchCourse(name);
						if (c1.getCapacity() > c1.getNum())
							//����student��
							if (DataProcessing.updateStudentCourses(st.getID(), courses))
								//����course��
								if (DataProcessing.updateCoursePlus(name)) {
									temp = 1;
									JOptionPane.showMessageDialog(null, "ѡ�γɹ���");
									st=DataProcessing.searchStudent(st.getID(), st.getPassword());
									
								}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (temp == 0)
						JOptionPane.showMessageDialog(null, "ѡ��ʧ�ܣ�");
				
				}
			}	
		});

		button.setBounds(314, 394, 93, 23);
		frame.getContentPane().add(button);


		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ѧ������ a = new ѧ������();
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
				 ***************** ��ʾ�γ���ϸ��Ϣ ****************************
				 ****************************************************/
				int index = table.getSelectedRow();
				String name = (String) table.getValueAt(index, 0);
				try {
					Course c1 = DataProcessing.searchCourse(name);
					if(c1 != null){
						frame.setVisible(false);
						�γ���ϸ��Ϣ a = new �γ���ϸ��Ϣ();
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

			ѧ��ѡ�� window = new ѧ��ѡ��();
			window.st=st;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
