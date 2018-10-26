package gui.listener;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

public class ConfigListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		ConfigPanel p = ConfigPanel.getInstance();
		// 判断输入的预算值是否为整数
		if (!GUIUtil.checkNumber(p.tfBudget, "本月预算"))
			return;
		String mysqlPath = p.tfMysqlPath.getText();
		// 判断输入的MYSQL安装路径是否正确
		if (0 != mysqlPath.length()) {
			File commandFile = new File(mysqlPath, "bin/mysql.exe");
			// 判断办法是看路径对应的bin子目录下是否有mysql.exe文件存在
			if (!commandFile.exists()) {
				JOptionPane.showMessageDialog(p, "Mysql路径不正确");
				p.tfMysqlPath.grabFocus();
				return;
			}
		}
		
		// 如果判断都通过，调用ConfigService进行数据更新
		ConfigService cs = new ConfigService();
		cs.update(ConfigService.budget, p.tfBudget.getText());
		cs.update(ConfigService.mysqlPath, mysqlPath);

		JOptionPane.showMessageDialog(p, "设置修改成功");

	}

}