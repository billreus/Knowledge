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
 * 消费记录面板监听器--监听按钮，触发按钮功能
 * @author lzp
 *
 */
public class RecordListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		RecordPanel p = RecordPanel.getInstance();
		// 1. 首先判断是否有消费分类信息，如果没有提示先增加消费分类
		if(0 == p.cbModel.cs.size()){
			JOptionPane.showMessageDialog(p, "暂无消费分类，无法添加，请先增加消费分类");
			MainPanel.getInstance().workingPanel.show(CategoryPanel.getInstance());
			return;
		}
		// 2. 输入的金额不能为0
		if(!GUIUtil.checkZero(p.tfSpend, "花费金额"))
			return;
		// 获取面板输入的值
		int spend = Integer.parseInt(p.tfSpend.getText());
		Category c = p.getSelectedCategory();
		String comment = p.tfComment.getText();
		Date d = p.datepick.getDate();
		// 3. 调用RecordService的add添加消费记录
		new RecordService().add(spend,c,comment,d);
		// 4. 提示添加成功
		JOptionPane.showMessageDialog(p, "添加成功");
		
		// 5. 添加成功后，切换到消费总览界面
		MainPanel.getInstance().workingPanel.show(SpendPanel.getInstance());
	}

}
