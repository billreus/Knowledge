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
		// �ж������Ԥ��ֵ�Ƿ�Ϊ����
		if (!GUIUtil.checkNumber(p.tfBudget, "����Ԥ��"))
			return;
		String mysqlPath = p.tfMysqlPath.getText();
		// �ж������MYSQL��װ·���Ƿ���ȷ
		if (0 != mysqlPath.length()) {
			File commandFile = new File(mysqlPath, "bin/mysql.exe");
			// �жϰ취�ǿ�·����Ӧ��bin��Ŀ¼���Ƿ���mysql.exe�ļ�����
			if (!commandFile.exists()) {
				JOptionPane.showMessageDialog(p, "Mysql·������ȷ");
				p.tfMysqlPath.grabFocus();
				return;
			}
		}
		
		// ����ж϶�ͨ��������ConfigService�������ݸ���
		ConfigService cs = new ConfigService();
		cs.update(ConfigService.budget, p.tfBudget.getText());
		cs.update(ConfigService.mysqlPath, mysqlPath);

		JOptionPane.showMessageDialog(p, "�����޸ĳɹ�");

	}

}