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

	// ��̬�ڲ��൥��ģʽ
	private static class RecordPanelBuilder {
		private static RecordPanel instance = new RecordPanel();
	}

	public static RecordPanel getInstance() {
		return RecordPanelBuilder.instance;
	}

	// ��ǩ
	JLabel lSpend = new JLabel("����(��)");
	JLabel lCategory = new JLabel("����");
	JLabel lComment = new JLabel("��ע");
	JLabel lDate = new JLabel("����");

	// �ı���
	public JTextField tfSpend = new JTextField("0");

	// ʹ�÷���ģ��
	public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
	// ��������
	public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);  
	public JTextField tfComment = new JTextField();
	public JXDatePicker datepick = new JXDatePicker(new Date());

	JButton bSubmit = new JButton("��һ��");

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
	
	// �ṩgetSelectedCategory()���ڻ�ȡ��ǰѡ�еķ������
	public Category getSelectedCategory() {
		return (Category) cbCategory.getSelectedItem();
	}

	// �����������еķ�����Ϣ�������ø����������Ϣ���ã��Լ��ý���ͣ���ڽ����������
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
