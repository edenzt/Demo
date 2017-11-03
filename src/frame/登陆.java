package frame;

import java.awt.EventQueue;
import java.awt.Frame;
import user.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.EmeraldDuskSkin;
import org.jvnet.substance.skin.SubstanceAutumnLookAndFeel;
import org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.jvnet.substance.skin.SubstanceBusinessLookAndFeel;
import org.jvnet.substance.skin.SubstanceChallengerDeepLookAndFeel;
import org.jvnet.substance.skin.SubstanceCremeLookAndFeel;
import org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel;
import org.jvnet.substance.skin.SubstanceFieldOfWheatLookAndFeel;
import org.jvnet.substance.skin.SubstanceGreenMagicLookAndFeel;
import org.jvnet.substance.skin.SubstanceMagmaLookAndFeel;
import org.jvnet.substance.skin.SubstanceMangoLookAndFeel;
import org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel;
import org.jvnet.substance.skin.SubstanceMistSilverLookAndFeel;
import org.jvnet.substance.skin.SubstanceModerateLookAndFeel;
import org.jvnet.substance.skin.SubstanceNebulaBrickWallLookAndFeel;
import org.jvnet.substance.skin.SubstanceNebulaLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenGraphiteLookAndFeel;
import org.jvnet.substance.skin.SubstanceSaharaLookAndFeel;
import org.jvnet.substance.theme.SubstanceAquaTheme;
import org.jvnet.substance.theme.SubstanceBarbyPinkTheme;
import org.jvnet.substance.theme.SubstanceBlendBiTheme;
import org.jvnet.substance.theme.SubstanceBottleGreenTheme;
import org.jvnet.substance.theme.SubstanceColorBlindTheme;
import org.jvnet.substance.theme.SubstanceComplexTheme;
import org.jvnet.substance.theme.SubstanceCremeTheme;
import org.jvnet.substance.theme.SubstanceDeuteranopiaTheme;
import org.jvnet.substance.theme.SubstanceEbonyTheme;
import org.jvnet.substance.theme.SubstanceHueShiftTheme;
import org.jvnet.substance.theme.SubstanceInvertedTheme;
import org.jvnet.substance.theme.SubstanceJadeForestTheme;
import org.jvnet.substance.theme.SubstanceLightAquaTheme;
import org.jvnet.substance.theme.SubstanceLimeGreenTheme;
import org.jvnet.substance.theme.SubstanceMixBiTheme;
import org.jvnet.substance.theme.SubstanceMixTheme;
import org.jvnet.substance.theme.SubstanceOliveTheme;
import org.jvnet.substance.theme.SubstanceRaspberryTheme;
import org.jvnet.substance.theme.SubstanceSaturatedTheme;
import org.jvnet.substance.theme.SubstanceShadeTheme;
import org.jvnet.substance.theme.SubstanceSunGlareTheme;
import org.jvnet.substance.theme.SubstanceSunsetTheme;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.title.FlatTitlePainter;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class 登陆 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public Student st = null;
	public Administrator ad = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			// SubstanceLookAndFeel.setCurrentTheme("org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin");
			// SubstanceLookAndFeel.setCurrentTheme(new SubstanceOliveTheme());
			// SubstanceAutumnLookAndFeel.setCurrentTheme(new
			// SubstanceRaspberryTheme());

			SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
			SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());
			// SubstanceLookAndFeel.setCurrentBorderPainter(new
			// StandardBorderPainter());
			SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());
			// SubstanceLookAndFeel.setCurrentTitlePainter(new
			// FlatTitlePainter());
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					登陆 window = new 登陆();
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

	public 登陆() {

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7528\u6237\u767B\u5F55");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(122, 42, 92, 37);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(199, 50, 92, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(122, 103, 54, 15);
		frame.getContentPane().add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(199, 100, 92, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JRadioButton radioButton = new JRadioButton("\u5B66\u751F");
		radioButton.setBounds(122, 155, 97, 21);
		frame.getContentPane().add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("\u7BA1\u7406\u5458");
		radioButton_1.setBounds(236, 154, 142, 23);
		frame.getContentPane().add(radioButton_1);

		JLabel label_2 = new JLabel("\u89D2\u8272");
		label_2.setBounds(84, 159, 54, 15);
		frame.getContentPane().add(label_2);
		frame.setVisible(true);
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (radioButton.isSelected()) {
					String ID = textField.getText();
					String password = textField_1.getText();
					try {
						st = DataProcessing.searchStudent(ID, password);
						if (st == null)
							JOptionPane.showMessageDialog(null, "输入用户名或密码不正确！","提示",JOptionPane.INFORMATION_MESSAGE);
						else {
							frame.setVisible(false);
							学生界面 a = new 学生界面();
							a.st = st;
							a.run();
						}
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

				} else if (radioButton_1.isSelected()) {
					String ID = textField.getText();
					String password = textField_1.getText();
					try {
						ad = DataProcessing.searchAdministrator(ID, password);
						if (ad==null)
							JOptionPane.showMessageDialog(null, "输入用户名或密码不正确！");
						else {
							frame.setVisible(false);
							管理员界面 b = new 管理员界面();
							b.ad = ad;
							b.run();
						}
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

				}
			}
		});
		button.setBounds(106, 199, 93, 23);
		frame.getContentPane().add(button);

		JButton button_2 = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (radioButton.isSelected()) {// 如果是学生忘记了密码，就在学生的表里面找
					String ID = textField.getText();
					Student st;
					try {
						st = DataProcessing.searchStudent(ID);
						if (st != null)// 找到了
						{
							frame.setVisible(false);
							忘记密码 a = new 忘记密码();
							System.out.println(st.getName());
							a.st = st;
							a.run();
						} else {
							JOptionPane.showMessageDialog(null, "账号输入错误！");
						}
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

				}

				else if (radioButton_1.isSelected()) {
					String ID = textField.getText();
					Administrator ad;
					try {
						ad = DataProcessing.searchAdministrator(ID);
						if (ad != null)// 找到了
						{
							//System.out.println(ad.getName());
							frame.setVisible(false);
							忘记密码 a = new 忘记密码();
							a.ad = ad;
							a.run();
						} else {
							JOptionPane.showMessageDialog(null, "账号输入错误！");
						}
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

				}
				else{
					JOptionPane.showMessageDialog(null, "请选择角色！");
				}
			}
		});

		button_2.setBounds(246, 199, 93, 23);
		frame.getContentPane().add(button_2);

	}

	public void run() {
		// TODO Auto-generated method stub
		登陆 window = new 登陆();
		window.initialize();
		window.frame.setVisible(true);
	}
}
