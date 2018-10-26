package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}

	private static class ConfigPanelBuilder {
		private static ConfigPanel instance = new ConfigPanel();
	}

	public static ConfigPanel getInstance() {
		return ConfigPanelBuilder.instance;
	}

	// 按钮
	JButton bSubmit = new JButton("更新");
	// 标签
	JLabel lBudget = new JLabel("本月预算(￥)");
	JLabel lMysql = new JLabel("MySQL安装目录");

	// 文本框
	public JTextField tfBudget = new JTextField("0");
	public JTextField tfMysqlPath = new JTextField("");

	private ConfigPanel() {
		GUIUtil.setColor(ColorUtil.grayColor, lBudget, lMysql);
		GUIUtil.setColor(ColorUtil.blueColor, bSubmit);

		// 面板
		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;
		pInput.setLayout(new GridLayout(4, 1, gap, gap));

		pInput.add(lBudget);
		pInput.add(tfBudget);
		pInput.add(lMysql);
		pInput.add(tfMysqlPath);
		this.setLayout(new BorderLayout());
		this.add(pInput, BorderLayout.NORTH);

		pSubmit.add(bSubmit);
		this.add(pSubmit, BorderLayout.CENTER);
		
		addListener();

	}
	// 监听面板按钮
	public void addListener(){
		ConfigListener listener = new ConfigListener();
		bSubmit.addActionListener(listener);
	}
	
	@Override
	public void updateData() {
		String budget = new ConfigService().get(ConfigService.budget);
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		
		tfBudget.setText(budget);
		tfMysqlPath.setText(mysqlPath);
		tfBudget.grabFocus();
	}
	
	public static void main(String[] args){
		GUIUtil.showPanel(ConfigPanel.getInstance());
	}


}
