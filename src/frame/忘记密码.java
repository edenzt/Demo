package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import user.Administrator;
import user.DataProcessing;
import user.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class 忘记密码 {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	   public Student st=null;
	    public Administrator ad=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					忘记密码 window = new 忘记密码();
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
	public 忘记密码() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5FD8\u8BB0\u5BC6\u7801");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("密保问题");
		label.setBounds(100, 41, 104, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u95EE\u9898\u7B54\u6848");
		label_1.setBounds(100, 91, 104, 22);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(197, 38, 150, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		textField.setText("你的生日是什么时候？");
		
		textField_1 = new JTextField();
		textField_1.setBounds(197, 92, 150, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField_1.getText()+"!!!");
				
				if (st != null && st.getPwdHint().equals(textField_1.getText())) {
					frame.setVisible(false);
					忘记密码链接 a=new 忘记密码链接();
					a.ad=ad;
					a.st=st;
					a.run();
				}
				else if (ad != null && ad.getPwdHint().equals(textField_1.getText())) {
					frame.setVisible(false);
					忘记密码链接 a=new 忘记密码链接();
					a.ad=ad;
					a.st=st;
					a.run();
				}
				
				else 
					JOptionPane.showMessageDialog(null,"密保答案输入错误！");
			}
		});
		button.setBounds(167, 184, 93, 23);
		frame.getContentPane().add(button);
	}

	public void run() {
		// TODO Auto-generated method stub
		忘记密码 window = new 忘记密码();
		window.st=st;
		window.ad=ad;
		window.initialize();
		window.frame.setVisible(true);
		
	}

}
