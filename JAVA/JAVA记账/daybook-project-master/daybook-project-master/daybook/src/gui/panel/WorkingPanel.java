package gui.panel;

import javax.swing.JPanel;

/**
 * ��������඼��Ҫ�Ĺ��ܣ����Գ������
 * 
 * @author lzp
 *
 */
public abstract class WorkingPanel extends JPanel {
	public abstract void updateData();
	public abstract void addListener();
}
