package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

/**
 * 监听增加、编辑、删除按钮是否触发，并作出相应功能
 * 
 * @author lzp
 *
 */
public class CategoryListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		CategoryPanel p = CategoryPanel.getInstance();

		JButton b = (JButton) e.getSource();

		// 1. 如果是增加，弹出输入框，校验输入内容不为空后，通过CategoryService.add()添加到数据库。
		if (b == p.bAdd) {
			String name = JOptionPane.showInputDialog(null);
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "分类名称不能为空");
				return;
			}
			new CategoryService().add(name);
		}

		// 3. 如果是编辑，弹出输入框，校验输入内容不为空后，根据CategoryPanel中getSelectedCategory()获取id,
		// 然后再通过CategoryService.update更新到数据库
		if (b == p.bEdit) {
			Category c = p.getSelectedCategory();
			int id = c.getId();
			String name = JOptionPane.showInputDialog("修改分类名称", c.getName());
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "分类名称不能为空");
				return;
			}
			new CategoryService().update(id, name);

		}

		// 4. 如果是删除，首先判断是否有消费记录，如果有消费记录，则不能删除。
		// 接着进行删除确认提示，确认后，通过CategoryService.delete()进行删除。
		if(b == p.bDelete){
			Category c = p.getSelectedCategory();
			if(0 != c.getRecordNumber()){
				JOptionPane.showMessageDialog(p, "本分类下有消费记录存在，不能删除");
				return ;
			}
			if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确定要删除？"))
				return ;
			
			int id = c.getId();
			new CategoryService().delete(id);
		}
		p.updateData();
	}

}
