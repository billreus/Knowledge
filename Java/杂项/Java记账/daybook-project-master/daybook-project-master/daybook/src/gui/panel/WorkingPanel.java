package gui.panel;

import javax.swing.JPanel;

/**
 * 各种面板类都需要的功能，可以抽象出来
 * 
 * @author lzp
 *
 */
public abstract class WorkingPanel extends JPanel {
	public abstract void updateData();
	public abstract void addListener();
}
