package util;

import java.awt.Component;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;

/**
 * �������ھ��е����
 *
 */
public class CenterPanel extends JPanel {

	private double rate;// �������
	private JComponent c; // ��ʾ�����
	private boolean strech; // �Ƿ����죨�Ƿ���ݴ������죩

	public CenterPanel(double rate, boolean strech) {
		this.setLayout(null);
		this.rate = rate;
		this.strech = strech;
	}

	public CenterPanel(double rate) {
		this(rate, true);
	}

	// ʹ�þ��Զ�λ�ķ�ʽ���齨�����м�λ��
	public void repaint() {
		if (null != c) {
			Dimension containerSize = this.getSize();
			Dimension componentSize = c.getPreferredSize(); // ����洰�ڱ仯�Զ�����

			if (strech)
				c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
			else
				c.setSize(componentSize);
			// �������������е�λ��
			c.setLocation(containerSize.width / 2 - c.getSize().width / 2,
					containerSize.height / 2 - c.getSize().height / 2);
		}
		super.repaint();
	}

	// ��ʾ�������remove��������ٰ�p���룩
	public void show(JComponent p) {
		this.c = p;
		Component[] cs = getComponents();
		for (Component c : cs) {
			remove(c);
		}
		add(p);

		// ÿ���л���壬��������updateData�����������������
		if (p instanceof WorkingPanel)
			((WorkingPanel) p).updateData();

		this.updateUI();// ��ÿ���ػ����ִ��repaint()����
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(200, 200);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(0.85, true);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		JButton b = new JButton("abc");
		cp.show(b);

	}

}