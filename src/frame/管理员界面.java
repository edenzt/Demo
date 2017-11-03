package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import user.*;

public class ����Ա���� {

	private JFrame frame;
	 public   Administrator  ad;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					����Ա���� window = new ����Ա����();
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
	public ����Ա����() {

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7BA1\u7406\u5458\u754C\u9762");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u4FEE\u6539\u4FE1\u606F");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				����Ա��ѧ����Ϣ a=new ����Ա��ѧ����Ϣ();
				a.ad=ad;
				a.run();
				
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u4FEE\u6539\u8BFE\u7A0B\u4FE1\u606F");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				����Ա�޸Ŀγ���Ϣ b=new ����Ա�޸Ŀγ���Ϣ();
				b.ad=ad;
				b.run();
			
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u67E5\u770B\u4FE1\u606F");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u67E5\u8BE2\u9009\u8BFE\u60C5\u51B5");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				����Ա��ѯѡ����� c=new ����Ա��ѯѡ�����();
				c.ad=ad;
				c.run();
			}
		});
		menu_1.add(menuItem_2);
		
		JMenu menu_2 = new JMenu("\u8BFE\u7A0B\u64CD\u4F5C");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u65B0\u589E\u8BFE\u7A0B");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				����Ա�����γ� d=new ����Ա�����γ�();
				d.ad=ad;
				d.run();
			}
		});
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5220\u9664\u8BFE\u7A0B");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				����Ա�޸Ŀγ���Ϣ b=new ����Ա�޸Ŀγ���Ϣ();
				b.ad=ad;
				b.run();
			}
		});
		menu_2.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				�޸����� a=new �޸�����();
				a.ad=ad;
				System.out.println(a.ad.getName());
				a.run();
			}
		});
		menuBar.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("\u6CE8\u9500");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null,"ע���ɹ���");
				��½ a=new ��½();
				a.run();
						
			}
		});
		menuBar.add(menuItem_6);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			����Ա���� window = new ����Ա����();
			window.ad=ad;
			window.initialize();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

}
