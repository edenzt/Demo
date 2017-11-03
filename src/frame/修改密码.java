package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import user.*;

public class ÐÞ¸ÄÃÜÂë {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public Student st = null;
	public Administrator ad = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ÐÞ¸ÄÃÜÂë window = new ÐÞ¸ÄÃÜÂë();
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
	public ÐÞ¸ÄÃÜÂë() {

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u4FEE\u6539\u5BC6\u7801");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u539F\u5BC6\u7801");
		label.setBounds(90, 33, 85, 15);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801");
		label_1.setBounds(90, 92, 85, 21);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u8BF7\u518D\u6B21\u8F93\u5165\u65B0\u5BC6\u7801");
		label_2.setBounds(90, 153, 107, 21);
		frame.getContentPane().add(label_2);

		textField = new JTextField();
		textField.setBounds(200, 30, 85, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(200, 92, 85, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(200, 153, 87, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_1.getText().equals(textField_2.getText())) {
					JOptionPane.showMessageDialog(null, "Á½´ÎÐÂÃÜÂëÊäÈë²»Ò»ÖÂ£¡£¡");
				} else {
					if (st != null) {
//						System.out.println("student");
//						System.out.println(st.getName());
						try {
							DataProcessing.updateStudentPwd(st.getID(), textField_1.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (ad != null) {
					//	System.out.println("ad");
						try {
							DataProcessing.updateAdministratorPwd(ad.getID(), textField_1.getText());

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					frame.setVisible(false);
					JOptionPane.showMessageDialog(null, "ÐÞ¸ÄÃÜÂë³É¹¦£¬ÇëÖØÐÂµÇÂ¼£¡");
					µÇÂ½ a = new µÇÂ½();
					a.run();
				}
			}

		});
		button.setBounds(90, 216, 93, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				µÇÂ½ a = new µÇÂ½();
				a.run();

			}
		});
		button_1.setBounds(200, 216, 93, 23);
		frame.getContentPane().add(button_1);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			ÐÞ¸ÄÃÜÂë window = new ÐÞ¸ÄÃÜÂë();
			window.st = st;
			window.ad = ad;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
