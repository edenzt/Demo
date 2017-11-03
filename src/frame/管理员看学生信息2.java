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

public class 管理员看学生信息2 {

	private JFrame frame;
	private JTable table=null;
	DefaultTableModel model = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	 public Administrator ad=null;
	    public Student st=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					管理员看学生信息2 window = new 管理员看学生信息2();
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
	public 管理员看学生信息2() {
		
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
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setBounds(106, 29, 33, 15);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(169, 26, 121, 21);
		textField.setEditable(false);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(106, 68, 54, 15);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 65, 121, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setBounds(106, 102, 54, 15);
		frame.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 99, 121, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5BC6\u4FDD\u7B54\u6848");
		label_3.setBounds(106, 139, 54, 15);
		frame.getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(169, 136, 121, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u73ED\u7EA7");
		label_4.setBounds(106, 173, 54, 15);
		frame.getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(169, 173, 121, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		//导入数据
		textField.setText(st.getID());
		textField_1.setText(st.getName());
		textField_2.setText(st.getPassword());
		textField_3.setText(st.getPwdHint());
		textField_4.setText(st.getBanji());
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1,s2,s3,s4;
				s1=textField_1.getText();
				s2=textField_2.getText();
				s3=textField_3.getText();
				s4=textField_4.getText();
			try {
				DataProcessing.updateStudentInfo(st.getID(),s1, s2, s3,s4);
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}			
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null,"修改学生信息成功！");
				管理员看学生信息 a=new 管理员看学生信息();
				a.ad=ad;
				a.run();
			}
		});
		button.setBounds(105, 217, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				管理员看学生信息 a=new 管理员看学生信息();
				a.ad=ad;
				a.run();
			}
		});
		button_1.setBounds(221, 217, 93, 23);
		frame.getContentPane().add(button_1);
		
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			管理员看学生信息2 window = new 管理员看学生信息2();
			window.ad=ad;
			window.st=st;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
