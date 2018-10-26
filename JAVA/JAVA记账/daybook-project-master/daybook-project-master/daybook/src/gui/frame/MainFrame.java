package gui.frame;

import javax.swing.JFrame;
import gui.panel.MainPanel;


public class MainFrame extends JFrame {
	private static class MainFrameBuilder {
		private static MainFrame instance = new MainFrame();
	}

	public static MainFrame getInstance() {
		return MainFrameBuilder.instance;
	}
	private MainFrame(){
		this.setSize(500,450);
		this.setTitle("Á÷Ë®ÕË²á");
		this.setContentPane(MainPanel.getInstance());
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		getInstance().setVisible(true);
	}
}
