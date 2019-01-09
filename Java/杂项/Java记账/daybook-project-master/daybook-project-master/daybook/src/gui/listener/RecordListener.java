package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;
/**
 * ���Ѽ�¼��������--������ť��������ť����
 * @author lzp
 *
 */
public class RecordListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		RecordPanel p = RecordPanel.getInstance();
		// 1. �����ж��Ƿ������ѷ�����Ϣ�����û����ʾ���������ѷ���
		if(0 == p.cbModel.cs.size()){
			JOptionPane.showMessageDialog(p, "�������ѷ��࣬�޷���ӣ������������ѷ���");
			MainPanel.getInstance().workingPanel.show(CategoryPanel.getInstance());
			return;
		}
		// 2. ����Ľ���Ϊ0
		if(!GUIUtil.checkZero(p.tfSpend, "���ѽ��"))
			return;
		// ��ȡ��������ֵ
		int spend = Integer.parseInt(p.tfSpend.getText());
		Category c = p.getSelectedCategory();
		String comment = p.tfComment.getText();
		Date d = p.datepick.getDate();
		// 3. ����RecordService��add������Ѽ�¼
		new RecordService().add(spend,c,comment,d);
		// 4. ��ʾ��ӳɹ�
		JOptionPane.showMessageDialog(p, "��ӳɹ�");
		
		// 5. ��ӳɹ����л���������������
		MainPanel.getInstance().workingPanel.show(SpendPanel.getInstance());
	}

}
