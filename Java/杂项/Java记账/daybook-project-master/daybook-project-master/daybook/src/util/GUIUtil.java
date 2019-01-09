package util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * ͼ����湤������һЩUI������
 */
public class GUIUtil {
	private static String imageFolder = "D:/CS/Knowledge/JAVA/JAVA����/daybook-project-master/daybook-project-master/daybook/img";
	/*
	 * ����ť����ͼ����ı��Լ���ʾ����
	 */
	public static void setImageIcon(JButton b, String fileName, String tip) {
		ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		b.setIcon(i);
		b.setPreferredSize(new Dimension(61, 81));
		b.setToolTipText(tip);
		b.setVerticalTextPosition(JButton.BOTTOM);
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setText(tip);
	}
	/*
	 * ������������ǰ��ɫ
	 */
	public static void setColor(Color color, JComponent... cs) {
		for (JComponent c : cs) {
			c.setForeground(color);
		}
	}

	/*
	 * ��ʼ��ʾһ����������--������ʾ��壬�������Ĳ���
	 *  �������1��ʾ����Ļ
	 */
	public static void showPanel(JPanel p, double strechRate) {
		GUIUtil.useLNF();  // ʹ��ˮ��Ƥ��
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(strechRate);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}

	public static void showPanel(JPanel p) {
		showPanel(p, 0.85);
	}
	/*
	 * У��һ����������Ƿ������ָ�ʽ
	 */
	public static boolean checkNumber(JTextField tf, String input) {
		if (!checkEmpty(tf, input))
			return false;
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, input + " ��Ҫ������");
			tf.grabFocus();
			return false;
		}
	}
	/*
	 * У��һ����������Ƿ�Ϊ0
	 */
	public static boolean checkZero(JTextField tf, String input) {
		if (!checkNumber(tf, input))
			return false;
		String text = tf.getText().trim();

		if (0 == Integer.parseInt(text)) {
			JOptionPane.showMessageDialog(null, input + " ����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}

	/*
	 * У��һ������������Ƿ�Ϊ��
	 */
	public static boolean checkEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();
		if (0 == text.length()) { // ͨ��text�����жϣ������Ƿ�Ϊ��
			// �Ի�����ʾ�û�
			JOptionPane.showMessageDialog(null, input + " ����Ϊ��");
			tf.grabFocus(); // ������ȡ����
			return false;
		}
		return true;

	}

	public static int getInt(JTextField tf) {
		return Integer.parseInt(tf.getText());
	}
	/*
	 * ʹ��ˮ��Ƥ��
	 * ��Ҫ��jar���ŵ�libĿ¼�£����뵽��Ŀ��
	 */
	public static void useLNF() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}