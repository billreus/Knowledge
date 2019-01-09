package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;
/**
 * 消费分类面板
 * @author lzp
 *
 */
public class CategoryPanel extends WorkingPanel {
	// 使用皮肤
	static {
		GUIUtil.useLNF();
	}
	// 静态内部类单例面板
	private static class CategoryPanelBuilder {
		private static CategoryPanel instance = new CategoryPanel();
	}

	public static CategoryPanel getInstance() {
		return CategoryPanelBuilder.instance;
	}
	// 定义面板按钮
	public JButton bAdd = new JButton("新增");
	public JButton bEdit = new JButton("编辑");
	public JButton bDelete = new JButton("删除");

	// 分类表模型--需要连接数据库
	public CategoryTableModel ctm = new CategoryTableModel();
	
	public JTable t = new JTable(ctm);
	
	// 面板构造
	private CategoryPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bAdd, bEdit, bDelete);
		JScrollPane sp = new JScrollPane(t);  // 上面板，要将分类信息表模型插入面板中
		JPanel pSubmit = new JPanel();  // 下面板
		// 面板添加按钮
		pSubmit.add(bAdd);
		pSubmit.add(bEdit);
		pSubmit.add(bDelete);
		
		this.setLayout(new BorderLayout());
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit,BorderLayout.SOUTH);
		
		addListener();
	}
	
	public void addListener() {
		CategoryListener listener = new CategoryListener();
		bAdd.addActionListener(listener);
		bEdit.addActionListener(listener);
		bDelete.addActionListener(listener);
	}

	// 方便获取JTable上当前选中的Category对象--鼠标选中
	public Category getSelectedCategory(){
		int index = t.getSelectedRow();
		return ctm.cs.get(index);
	}
	
	// updateData方法，用于在增加、删除、修改之后，更新表格中的信息，默认选定第一个行；
	// 判断，如果表格里没有数据，删除和修改按钮不可用。
	public void updateData(){
		ctm.cs = new CategoryService().list();
		t.updateUI();
		t.getSelectionModel().setSelectionInterval(0, 0);
		
		if(0 == ctm.cs.size()){
			bEdit.setEnabled(false);
			bDelete.setEnabled(false);
		} else {
			bEdit.setEnabled(true);
			bDelete.setEnabled(true);
		}
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(CategoryPanel.getInstance());
	}
}
