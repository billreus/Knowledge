package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.panel.BackupPanel;
import gui.panel.CategoryPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.RecoverPanel;
import gui.panel.ReportPanel;
import gui.panel.SpendPanel;
/**
 * �����Ĺ�������ť��������
 * 
 * ��ť����չʾ��Ϊ��ʵ������л�
 * @author lzp
 *
 */
public class ToolBarListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MainPanel p = MainPanel.getInstance();  // ֻ�ǻ�ȡ������Ϊ����ģʽ����ഴ��
		JButton b = (JButton) e.getSource();
		if (b == p.bReport)
			p.workingPanel.show(ReportPanel.getInstance());
		if (b == p.bCategory)
			p.workingPanel.show(CategoryPanel.getInstance());
		if (b == p.bSpend)
			p.workingPanel.show(SpendPanel.getInstance());
		if (b == p.bRecord)
			p.workingPanel.show(RecordPanel.getInstance());
		if (b == p.bConfig)
			p.workingPanel.show(ConfigPanel.getInstance());
		if (b == p.bBackup)
			p.workingPanel.show(BackupPanel.getInstance());
		if (b == p.bRecover)
			p.workingPanel.show(RecoverPanel.getInstance());
	}

}
