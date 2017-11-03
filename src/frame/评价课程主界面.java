package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import user.Course;
import user.DataProcessing;
import user.Student;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class 评价课程主界面 {
	public Course c;
	public Student st;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					评价课程主界面 window = new 评价课程主界面();
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
	public 评价课程主界面() {
	//	initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8BC4\u4EF7\u8BFE\u7A0B");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(65, 127, 256, 74);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton radioButton = new JRadioButton("0");
		radioButton.setBounds(65, 60, 39, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setBounds(112, 60, 39, 23);
		frame.getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("4");
		radioButton_2.setBounds(153, 60, 42, 23);
		frame.getContentPane().add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("6");
		radioButton_3.setBounds(197, 60, 39, 23);
		frame.getContentPane().add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("8");
		radioButton_4.setBounds(237, 60, 43, 23);
		frame.getContentPane().add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("10");
		radioButton_5.setBounds(282, 60, 50, 23);
		frame.getContentPane().add(radioButton_5);
		
		JLabel label = new JLabel("\u8BF7\u4E3A\u8BE5\u8BFE\u7A0B\u6253\u5206\uFF1A");
		label.setBounds(65, 27, 102, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u5BF9\u8BE5\u8BFE\u7A0B\u7684\u8BC4\u4EF7\uFF1A");
		label_1.setBounds(65, 102, 140, 15);
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/************* 评价成功 ************/
				int score=0;
				if(radioButton_1.isSelected())
					score=2;
				if(radioButton_2.isSelected())
					score=4;
				if(radioButton_3.isSelected())
					score=6;
				if(radioButton_4.isSelected())
					score=8;
				if(radioButton_5.isSelected())
					score=10;
				
				int number=c.getEvaluateNum();
				double oldScore=c.getScore();
				double newScore=(oldScore*number+score)/(number+1);
				number++;
				String evaluation=c.getEvaluation();
				String new_evaluation=textField.getText();
				evaluation=evaluation+new_evaluation+"$";
				try {
					DataProcessing.updateCourseEvaluate(c.getName(), newScore, number, evaluation);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null,"评价该课程成功！");
				评价课程 a=new 评价课程();
				a.st=st;
				a.run();
			}
		});
		button.setBounds(91, 221, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				评价课程 a=new 评价课程();
				a.st=st;
				a.run();
			}
		});
		button_1.setBounds(215, 221, 93, 23);
		frame.getContentPane().add(button_1);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			评价课程主界面 window = new 评价课程主界面();
			window.st=st;
			window.c=c;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
