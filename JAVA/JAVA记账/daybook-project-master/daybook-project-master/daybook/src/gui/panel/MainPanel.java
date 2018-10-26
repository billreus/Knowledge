package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

/*
 * 主面板类
 */
public class MainPanel extends JPanel {
	// 设置皮肤
	static {
		GUIUtil.useLNF();
	}
	public CenterPanel workingPanel;
	// 线程安全的单例模式
	private static class MainPanelBuilder {
		private static MainPanel instance = new MainPanel();
	}

	public static MainPanel getInstance() {
		return MainPanelBuilder.instance;
	}

	// 工具条
	public JToolBar tb = new JToolBar();
	// 按钮
	public JButton bSpend = new JButton();
	public JButton bRecord = new JButton();
	public JButton bCategory = new JButton();
	public JButton bReport = new JButton();
	public JButton bConfig = new JButton();
	public JButton bBackup = new JButton();
	public JButton bRecover = new JButton();

	private MainPanel() {
		// 给按钮设置图标文字
		GUIUtil.setImageIcon(bSpend, "home.png", "消费总览");
		GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
		GUIUtil.setImageIcon(bCategory, "category2.png", "分类");
		GUIUtil.setImageIcon(bReport, "report.png", "月报表");
		GUIUtil.setImageIcon(bConfig, "config.png", "设置");
		GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
		GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");
		// 工具条添加按钮
		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		tb.setFloatable(false);
		
		// 工作面板，用于将来显示不同的功能面板。目前是空白的。
//		CenterPanel workingPanel;
		workingPanel = new CenterPanel(0.8);
		 
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);
        
        addListener();
	}
	// 在主面板加上对工具栏按钮的监控
	private void addListener() {
		ToolBarListener listener = new ToolBarListener();
		
		bSpend.addActionListener(listener);
		bRecord.addActionListener(listener);
		bCategory.addActionListener(listener);
		bReport.addActionListener(listener);
		bConfig.addActionListener(listener);
		bBackup.addActionListener(listener);
		bRecover.addActionListener(listener);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(MainPanel.getInstance(), 1);
	}
}
