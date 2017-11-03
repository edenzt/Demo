package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import user.Course;
import user.Student;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class 课程详细信息 {
	public Course c;
	public Student st;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					课程详细信息 window = new 课程详细信息();
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
	public 课程详细信息() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8BFE\u7A0B\u8BE6\u7EC6\u4FE1\u606F");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(65, 66, 462, 34);
		textField.setEnabled(false);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u63CF\u8FF0");
		label.setBounds(65, 27, 102, 15);
		frame.getContentPane().add(label);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				学生选课 a=new 学生选课();
				a.st=st;
				a.initialize();
				a.run();
			}
		});
		button_1.setBounds(236, 361, 93, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u8BC4\u5206");
		label_1.setBounds(65, 128, 54, 15);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(65, 163, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u8BC4\u4EF7");
		label_2.setBounds(65, 206, 54, 15);
		frame.getContentPane().add(label_2);
		textField_2 = new JTextField();
		textField_2.setBounds(65, 241, 462, 90);
		textField_2.setEnabled(false);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		//导入数据
		textField.setText(c.getDes());
		textField_1.setText(c.getScore()+"");
		textField_2.setText(c.getEvaluation());
		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void run() {
		// TODO Auto-generated method stub
		try {
			课程详细信息 window = new 课程详细信息();
			window.st=st;
			window.c=c;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
