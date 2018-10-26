package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import gui.panel.RecoverPanel;
import service.ConfigService;
import util.MysqlUtil;

public class RecoverListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		RecoverPanel p = RecoverPanel.getInstance();
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		
		if(0 == mysqlPath.length()){
			JOptionPane.showMessageDialog(p, "恢复前请事先设置好MySQL路径");
			MainPanel.getInstance().workingPanel.show(ConfigPanel.getInstance());
			ConfigPanel.getInstance().tfMysqlPath.grabFocus(); // 获取光标
			return ;
		}
		
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File("daybook.sql"));
		fc.setFileFilter(new FileFilter(){

			@Override
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".sql");
			}

			@Override
			public String getDescription() {
				return ".sql";
			}		
		});
		
		int returnVal = fc.showOpenDialog(p);
		File file = fc.getSelectedFile();
		System.out.println(file);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			try{
				MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
			JOptionPane.showMessageDialog(p, "恢复成功");
			}catch(Exception e1){
				e1.printStackTrace();
				JOptionPane.showMessageDialog(p, "恢复失败\r\n,错误:\r\n"+e1.getMessage());
			}
			
		}
	}

}
