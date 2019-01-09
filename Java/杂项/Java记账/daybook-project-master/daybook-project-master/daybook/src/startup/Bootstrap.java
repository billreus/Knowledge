package startup;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;

/**
 * ������--���н��̵��������
 * @author lzp
 *
 */
public class Bootstrap {
	public static void main(String[] args) {
		GUIUtil.useLNF();
		
		try {
			// ����ͼ�ν���
			SwingUtilities.invokeAndWait(new Runnable(){

				@Override
				public void run() {
					MainFrame.getInstance().setVisible(true);
					MainPanel.getInstance().workingPanel.show(SpendPanel.getInstance());
				}
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
	}
}
