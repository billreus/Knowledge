package gui.panel;

import javax.swing.JButton;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel extends WorkingPanel {
	static{
		GUIUtil.useLNF();
	}
	
	private static class RecoverPanelBuilder {
		private static RecoverPanel instance = new RecoverPanel();
	}

	public static RecoverPanel getInstance() {
		return RecoverPanelBuilder.instance;
	}

	JButton bRecover = new JButton("»Ö¸´");

	private RecoverPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bRecover);
		this.add(bRecover);
		
		addListener();
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(RecoverPanel.getInstance());
	}

	@Override
	public void updateData() {
		
	}

	@Override
	public void addListener() {
		RecoverListener listener = new RecoverListener();
		bRecover.addActionListener(listener);
	}
}
