package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import user.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class 管理员看学生信息 {

	private JFrame frame;
	private JTable table=null;
	DefaultTableModel model = null;
	private JTextField textField;
	public Administrator ad=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					管理员看学生信息 window = new 管理员看学生信息();
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
	public 管理员看学生信息() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5B66\u751F\u4FE1\u606F");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5B66\u751F\u7684\u5B66\u53F7\uFF1A");
		label.setBounds(36, 62, 108, 15);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(182, 56, 178, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s;
				Student st;
				s=textField.getText();
				try {
					st=DataProcessing.searchStudent(s);
					if(st.equals(null))
						JOptionPane.showMessageDialog(null,"输入学号不存在！");
					else
					{
						frame.setVisible(false);
						管理员看学生信息2 a=new 管理员看学生信息2();
						a.ad=ad;
					    a.st=st;
						a.run();
							
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
					
       
				
			}
		});
		button.setBounds(105, 145, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				管理员界面 a=new 管理员界面();
				a.ad=ad;
	      		a.initialize();
				a.run();
			}
		});
		button_1.setBounds(241, 145, 93, 23);
		frame.getContentPane().add(button_1);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			管理员看学生信息 window = new 管理员看学生信息();
			window.ad=ad;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
