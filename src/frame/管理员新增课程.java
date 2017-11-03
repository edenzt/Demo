package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import user.Administrator;
import user.Course;
import user.DataProcessing;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class 管理员新增课程 {
	Course c;
	public Administrator ad;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					管理员新增课程 window = new 管理员新增课程();
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
	public 管理员新增课程() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u65B0\u589E\u8BFE\u7A0B");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u540D");
		label.setBounds(51, 25, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u5206");
		lblNewLabel.setBounds(218, 25, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\u4EFB\u8BFE\u8001\u5E08");
		label_1.setBounds(51, 75, 54, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u4E0A\u8BFE\u65F6\u95F4");
		label_2.setBounds(218, 78, 54, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u4E0A\u8BFE\u5730\u70B9");
		label_3.setBounds(51, 115, 54, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u4E0A\u8BFE\u5B66\u671F");
		label_4.setBounds(218, 115, 54, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u5C5E\u6027");
		label_5.setBounds(51, 155, 54, 15);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u5BB9\u91CF");
		label_6.setBounds(218, 155, 54, 15);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u63CF\u8FF0");
		label_7.setBounds(51, 195, 54, 15);
		frame.getContentPane().add(label_7);
		
		textField = new JTextField();
		textField.setBounds(105, 25, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(280, 25, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 75, 66, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(280, 75, 66, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(105, 115, 66, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(280, 115, 66, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(105, 155, 66, 21);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(280, 155, 66, 21);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(105, 195, 66, 21);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField_7.getText();
				int capacity = Integer.parseInt(s);
				String s1 = textField_1.getText();				
				double credit =Double.parseDouble(s1);
				String s2 = textField_6.getText();
				int required = Integer.parseInt(s2);
				try {
					DataProcessing.insertCourse(textField.getText(),credit,required,textField_5.getText(),capacity,0,textField_2.getText(),textField_3.getText(),textField_4.getText(),textField_8.getText());
					frame.setVisible(false);
					JOptionPane.showMessageDialog(null,"新增课程成功！");
		      		管理员界面 a=new 管理员界面 ();
		      		a.ad=ad;
		      		a.initialize();
					a.run();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(173, 228, 93, 23);
		frame.getContentPane().add(button);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			管理员新增课程 window = new 管理员新增课程();
			window.ad=ad;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
