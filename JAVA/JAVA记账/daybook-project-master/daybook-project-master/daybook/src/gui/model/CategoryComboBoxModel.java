package gui.model;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {
	// 模拟数据
	// public List<String> cs = new ArrayList<>();
	//
	// String c;
	// public CategoryComboBoxModel(){
	// cs.add("餐饮");
	// cs.add("交通");
	// cs.add("住宿");
	// cs.add("话费");
	// c = cs.get(0);
	// }
	public Category c;

	// 使用从Service中返回的List作为TableModel的数据
	public List<Category> cs = new CategoryService().list();

	@Override
	public int getSize() {
		return cs.size();
	}

	@Override
	public Category getElementAt(int index) {
		return cs.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {

	}

	@Override
	public void removeListDataListener(ListDataListener l) {

	}

	@Override
	public void setSelectedItem(Object anItem) {
		c = (Category) anItem;

	}

	@Override
	public Object getSelectedItem() {
		if (!cs.isEmpty())
			return c;
		else
			return null;
	}

}