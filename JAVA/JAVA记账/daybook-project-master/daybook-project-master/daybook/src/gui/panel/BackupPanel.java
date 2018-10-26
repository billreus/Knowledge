package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;

public class BackupPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}

	private static class BackupPanelBuilder {
		private static BackupPanel instance = new BackupPanel();
	}

	public static BackupPanel getInstance() {
		return BackupPanelBuilder.instance;
	}

	JButton bBackup = new JButton("±¸·Ý");

	private BackupPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bBackup);
		this.add(bBackup);
		addListener();
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(BackupPanel.getInstance());
	}

	@Override
	public void updateData() {

	}

	@Override
	public void addListener() {
		BackupListener listener = new BackupListener();
		bBackup.addActionListener(listener);
	}
}
