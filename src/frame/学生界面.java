package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import user.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ѧ������ {
	JFrame frame;
	public Student st;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ѧ������ window = new ѧ������();
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
	public ѧ������() {
//		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5B66\u751F\u754C\u9762");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u529F\u80FD");
		label.setBounds(67, 34, 72, 15);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("\u9009\u8BFE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
					ѧ��ѡ��  a=new ѧ��ѡ��();
					a.st=st;
					a.run();					
				}
			
		});
		button.setBounds(149, 30, 110, 23);
		frame.getContentPane().add(button);
		
		JButton button_2 = new JButton("\u67E5\u770B\u5DF2\u9009\u8BFE\u8868");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ѧ���α� a=new ѧ���α� ();
				a.st=st;
				a.run();
			}
		});
		button_2.setBounds(149, 124, 110, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				�޸����� a=new �޸�����();
				a.st=st;
				System.out.println(a.st.getName());
				a.run();
			}
		});
		button_3.setBounds(149, 218, 110, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("\u6CE8\u9500");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null,"ע���ɹ���");
				��½ a=new ��½();
				a.st=st;
				a.run();
			}
		});
		button_4.setBounds(341, 0, 93, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_1 = new JButton("\u8BC4\u4EF7\u8BFE\u7A0B");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				���ۿγ� a=new ���ۿγ�();
				a.st=st;
				a.run();
			}
		});
		button_1.setBounds(149, 171, 110, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_5 = new JButton("\u9000\u8BFE");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ѧ���˿� a=new ѧ���˿�();
				a.st=st;
				a.run();
			}
		});
		button_5.setBounds(149, 77, 110, 23);
		frame.getContentPane().add(button_5);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			ѧ������ window = new ѧ������();
			window.st=st;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
