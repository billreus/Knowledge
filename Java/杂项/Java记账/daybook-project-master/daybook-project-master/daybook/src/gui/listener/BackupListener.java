package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

public class BackupListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		BackupPanel p = BackupPanel.getInstance();
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		if(0 == mysqlPath.length()){
			JOptionPane.showMessageDialog(p, "备份前请事先配置mysql的路径");
			// 切到设置MySQL路径的面板
			MainPanel.getInstance().workingPanel.show(ConfigPanel.getInstance());
			// 获取光标
			ConfigPanel.getInstance().tfMysqlPath.grabFocus();  
			return;
		}
		// 文本选择器
		JFileChooser fc = new JFileChooser();
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
		
		int returnVal = fc.showSaveDialog(p);
		File file = fc.getSelectedFile();
		System.out.println(file);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			// 如果保存的文件名不是以.sql结尾，自动加上.sql
			System.out.println(file);
			if(!file.getName().toLowerCase().equals(".sql"))
				file = new File(file.getParent(),file.getName() + ".sql");
			System.out.println(file);
			
			try {
				MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
				JOptionPane.showMessageDialog(p, "备份成功,备份文件位于:\r\n"+file.getAbsolutePath());
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(p, "备份失败\r\n,错误:\r\n"+e1.getMessage());
			}
			
		}
	}

}
