package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import entity.Category;
import entity.Record;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}

	// 静态内部类单例模式
	private static class RecordPanelBuilder {
		private static RecordPanel instance = new RecordPanel();
	}

	public static RecordPanel getInstance() {
		return RecordPanelBuilder.instance;
	}

	// 标签
	JLabel lSpend = new JLabel("花费(￥)");
	JLabel lCategory = new JLabel("分类");
	JLabel lComment = new JLabel("备注");
	JLabel lDate = new JLabel("日期");

	// 文本框
	public JTextField tfSpend = new JTextField("0");

	// 使用分类模型
	public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
	// 下拉窗口
	public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);  
	public JTextField tfComment = new JTextField();
	public JXDatePicker datepick = new JXDatePicker(new Date());

	JButton bSubmit = new JButton("记一笔");

	private RecordPanel() {
		GUIUtil.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
		GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;
		pInput.setLayout(new GridLayout(4, 2, gap, gap));

		pInput.add(lSpend);
		pInput.add(tfSpend);
		pInput.add(lCategory);
		pInput.add(cbCategory);
		pInput.add(lComment);
		pInput.add(tfComment);
		pInput.add(lDate);
		pInput.add(datepick);

		pSubmit.add(bSubmit);

		this.setLayout(new BorderLayout());
		this.add(pInput, BorderLayout.NORTH);
		this.add(pSubmit, BorderLayout.CENTER);
		
		addListener();
	}
	
	public static void main(String[] args){
		GUIUtil.showPanel(RecordPanel.getInstance());
	}
	
	// 提供getSelectedCategory()用于获取当前选中的分类对象。
	public Category getSelectedCategory() {
		return (Category) cbCategory.getSelectedItem();
	}

	// 更新下拉框中的分类信息，并且让各个输入框信息重置，以及让焦点停留在金额的输入框上
	@Override
	public void updateData() {
		tfSpend.setText("0");
		tfComment.setText("");
		if(0 != cbModel.cs.size())
			cbCategory.setSelectedIndex(0);
		datepick.setDate(new Date());
	}

	@Override
	public void addListener() {
		RecordListener listener = new RecordListener();
		bSubmit.addActionListener(listener);
	}
}
