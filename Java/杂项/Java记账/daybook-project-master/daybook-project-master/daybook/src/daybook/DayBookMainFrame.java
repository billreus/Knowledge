package daybook;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
/**
 * 本类仅用于测试，项目外
 * @author lzp
 *
 */
public class DayBookMainFrame {
	public static void main(String[] args) {
		// 设置主窗体
		JFrame f = new JFrame();
		f.setSize(500, 450);
		f.setTitle("流水账册");
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 工具条
		JToolBar tb = new JToolBar();
		// 按钮
		JButton bSpend = new JButton("消费一览");
		JButton bRecord = new JButton("记一笔");
		JButton bCategory = new JButton("消费分类");
		JButton bReport = new JButton("月消费报表");
		JButton bConfig = new JButton("设置");
		JButton bBackup = new JButton("备份");
		JButton bRecover = new JButton("恢复");
		
		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		// 把工具栏放到north的位置
		f.setLayout(new BorderLayout());
		f.add(tb, BorderLayout.NORTH);
		f.add(new JPanel(), BorderLayout.CENTER);
		
		f.setVisible(true);
		
		bSpend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bConfig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bBackup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bRecover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
	}
}
