package util;

import java.awt.Component;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;

/**
 * 开发用于居中的面板
 *
 */
public class CenterPanel extends JPanel {

	private double rate;// 拉伸比例
	private JComponent c; // 显示的组件
	private boolean strech; // 是否拉伸（是否根据窗口拉伸）

	public CenterPanel(double rate, boolean strech) {
		this.setLayout(null);
		this.rate = rate;
		this.strech = strech;
	}

	public CenterPanel(double rate) {
		this(rate, true);
	}

	// 使用绝对定位的方式将组建放在中间位置
	public void repaint() {
		if (null != c) {
			Dimension containerSize = this.getSize();
			Dimension componentSize = c.getPreferredSize(); // 组件随窗口变化自动调整

			if (strech)
				c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
			else
				c.setSize(componentSize);
			// 计算组件在面板中的位置
			c.setLocation(containerSize.width / 2 - c.getSize().width / 2,
					containerSize.height / 2 - c.getSize().height / 2);
		}
		super.repaint();
	}

	// 显示组件（先remove所有组件再把p加入）
	public void show(JComponent p) {
		this.c = p;
		Component[] cs = getComponents();
		for (Component c : cs) {
			remove(c);
		}
		add(p);

		// 每次切换面板，调用面板的updateData方法，更新面板数据
		if (p instanceof WorkingPanel)
			((WorkingPanel) p).updateData();

		this.updateUI();// 会每次重画面板执行repaint()方法
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