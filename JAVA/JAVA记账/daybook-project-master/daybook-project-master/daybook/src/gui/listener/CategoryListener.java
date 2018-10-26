package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

/**
 * �������ӡ��༭��ɾ����ť�Ƿ񴥷�����������Ӧ����
 * 
 * @author lzp
 *
 */
public class CategoryListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		CategoryPanel p = CategoryPanel.getInstance();

		JButton b = (JButton) e.getSource();

		// 1. ��������ӣ����������У���������ݲ�Ϊ�պ�ͨ��CategoryService.add()��ӵ����ݿ⡣
		if (b == p.bAdd) {
			String name = JOptionPane.showInputDialog(null);
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "�������Ʋ���Ϊ��");
				return;
			}
			new CategoryService().add(name);
		}

		// 3. ����Ǳ༭�����������У���������ݲ�Ϊ�պ󣬸���CategoryPanel��getSelectedCategory()��ȡid,
		// Ȼ����ͨ��CategoryService.update���µ����ݿ�
		if (b == p.bEdit) {
			Category c = p.getSelectedCategory();
			int id = c.getId();
			String name = JOptionPane.showInputDialog("�޸ķ�������", c.getName());
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "�������Ʋ���Ϊ��");
				return;
			}
			new CategoryService().update(id, name);

		}

		// 4. �����ɾ���������ж��Ƿ������Ѽ�¼����������Ѽ�¼������ɾ����
		// ���Ž���ɾ��ȷ����ʾ��ȷ�Ϻ�ͨ��CategoryService.delete()����ɾ����
		if(b == p.bDelete){
			Category c = p.getSelectedCategory();
			if(0 != c.getRecordNumber()){
				JOptionPane.showMessageDialog(p, "�������������Ѽ�¼���ڣ�����ɾ��");
				return ;
			}
			if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "ȷ��Ҫɾ����"))
				return ;
			
			int id = c.getId();
			new CategoryService().delete(id);
		}
		p.updateData();
	}

}
