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
 * ���ѷ������
 * @author lzp
 *
 */
public class CategoryPanel extends WorkingPanel {
	// ʹ��Ƥ��
	static {
		GUIUtil.useLNF();
	}
	// ��̬�ڲ��൥�����
	private static class CategoryPanelBuilder {
		private static CategoryPanel instance = new CategoryPanel();
	}

	public static CategoryPanel getInstance() {
		return CategoryPanelBuilder.instance;
	}
	// ������尴ť
	public JButton bAdd = new JButton("����");
	public JButton bEdit = new JButton("�༭");
	public JButton bDelete = new JButton("ɾ��");

	// �����ģ��--��Ҫ�������ݿ�
	public CategoryTableModel ctm = new CategoryTableModel();
	
	public JTable t = new JTable(ctm);
	
	// ��幹��
	private CategoryPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bAdd, bEdit, bDelete);
		JScrollPane sp = new JScrollPane(t);  // ����壬Ҫ��������Ϣ��ģ�Ͳ��������
		JPanel pSubmit = new JPanel();  // �����
		// �����Ӱ�ť
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

	// �����ȡJTable�ϵ�ǰѡ�е�Category����--���ѡ��
	public Category getSelectedCategory(){
		int index = t.getSelectedRow();
		return ctm.cs.get(index);
	}
	
	// updateData���������������ӡ�ɾ�����޸�֮�󣬸��±���е���Ϣ��Ĭ��ѡ����һ���У�
	// �жϣ���������û�����ݣ�ɾ�����޸İ�ť�����á�
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
