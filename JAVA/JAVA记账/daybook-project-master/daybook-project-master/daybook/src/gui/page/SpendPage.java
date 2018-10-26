package gui.page;

/**
 * 页面类--显示消费总览面板需要的信息
 * 
 * 与实体类不同，实体类是连接数据库的对象
 * 
 * @author lzp
 *
 */
public class SpendPage {
	// 本月消费
	public String monthSpend;
	// 今日消费
	public String todaySpend;
	// 日均消费
	public String avgSpendPerDay;
	// 本月剩余
	public String monthAvailable;
	// 日均可用
	public String dayAvgAvailable;
	// 距离月末
	public String monthLeftDay;
	// 使用比例
	public int usagePercentage;
	// 是否超支
	public boolean isOverSpend = false;

	// 面板显示的数据
	public SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay, int monthAvailable, int dayAvgAvailable,
			int monthLeftDay, int usagePercentage) {
		this.monthSpend = "￥" + monthSpend;
		this.todaySpend = "￥" + todaySpend;
		this.avgSpendPerDay = "￥" + avgSpendPerDay;
		if (monthAvailable < 0)
			isOverSpend = true;
		if (!isOverSpend) {
			this.monthAvailable = "￥" + monthAvailable;
			this.dayAvgAvailable = "￥" + dayAvgAvailable;
		}

		this.monthLeftDay = monthLeftDay + "天";
		this.usagePercentage = usagePercentage;
	}
}
