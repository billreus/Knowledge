package gui.model;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {
	// ģ������
	// public List<String> cs = new ArrayList<>();
	//
	// String c;
	// public CategoryComboBoxModel(){
	// cs.add("����");
	// cs.add("��ͨ");
	// cs.add("ס��");
	// cs.add("����");
	// c = cs.get(0);
	// }
	public Category c;

	// ʹ�ô�Service�з��ص�List��ΪTableModel������
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