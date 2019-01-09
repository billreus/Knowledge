package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

/*
 * �������
 */
public class MainPanel extends JPanel {
	// ����Ƥ��
	static {
		GUIUtil.useLNF();
	}
	public CenterPanel workingPanel;
	// �̰߳�ȫ�ĵ���ģʽ
	private static class MainPanelBuilder {
		private static MainPanel instance = new MainPanel();
	}

	public static MainPanel getInstance() {
		return MainPanelBuilder.instance;
	}

	// ������
	public JToolBar tb = new JToolBar();
	// ��ť
	public JButton bSpend = new JButton();
	public JButton bRecord = new JButton();
	public JButton bCategory = new JButton();
	public JButton bReport = new JButton();
	public JButton bConfig = new JButton();
	public JButton bBackup = new JButton();
	public JButton bRecover = new JButton();

	private MainPanel() {
		// ����ť����ͼ������
		GUIUtil.setImageIcon(bSpend, "home.png", "��������");
		GUIUtil.setImageIcon(bRecord, "record.png", "��һ��");
		GUIUtil.setImageIcon(bCategory, "category2.png", "����");
		GUIUtil.setImageIcon(bReport, "report.png", "�±���");
		GUIUtil.setImageIcon(bConfig, "config.png", "����");
		GUIUtil.setImageIcon(bBackup, "backup.png", "����");
		GUIUtil.setImageIcon(bRecover, "restore.png", "�ָ�");
		// ��������Ӱ�ť
		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		tb.setFloatable(false);
		
		// ������壬���ڽ�����ʾ��ͬ�Ĺ�����塣Ŀǰ�ǿհ׵ġ�
//		CenterPanel workingPanel;
		workingPanel = new CenterPanel(0.8);
		 
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);
        
        addListener();
	}
	// ���������϶Թ�������ť�ļ��
	private void addListener() {
		ToolBarListener listener = new ToolBarListener();
		
		bSpend.addActionListener(listener);
		bRecord.addActionListener(listener);
		bCategory.addActionListener(listener);
		bReport.addActionListener(listener);
		bConfig.addActionListener(listener);
		bBackup.addActionListener(listener);
		bRecover.addActionListener(listener);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(MainPanel.getInstance(), 1);
	}
}
