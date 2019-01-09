package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import util.ChartUtil;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class Test {

	public static void main(String[] args) {
		GUIUtil.useLNF();
//		// 面板
//		JPanel p = new JPanel();
//		// 进度条组件
//		CircleProgressBar cpb = new CircleProgressBar();
//		cpb.setBackground(ColorUtil.blueColor);
//		cpb.setProgress(0);
//		// 按钮
//		JButton b = new JButton("点击");
//		// 添加组件
//		p.setLayout(new BorderLayout());
//		p.add(cpb, BorderLayout.CENTER);
//		p.add(b, BorderLayout.SOUTH);
//		// 显示面板
//		GUIUtil.showPanel(p);
//
//		// 给按钮加监听
//		b.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new SwingWorker() {
//
//					@Override
//					protected Object doInBackground() throws Exception {
//						for (int i = 0; i < 100; i++) {
//							cpb.setProgress(i + 1);
//							cpb.setForegroundColor(ColorUtil.getByPercentage(i + 1));
//							try {
//								Thread.sleep(100);
//							} catch (InterruptedException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//						}
//						return null;
//					}
//
//				}.execute();
//
//			}
//		});

		JPanel p = new JPanel();
		JLabel l = new JLabel();
		Image img = ChartUtil.getImage(300, 200);
		Icon icon = new ImageIcon(img);
		l.setIcon(icon);
		p.add(l);
		GUIUtil.showPanel(p);
	}
	

}
