package gui.page;

/**
 * ҳ����--��ʾ�������������Ҫ����Ϣ
 * 
 * ��ʵ���಻ͬ��ʵ�������������ݿ�Ķ���
 * 
 * @author lzp
 *
 */
public class SpendPage {
	// ��������
	public String monthSpend;
	// ��������
	public String todaySpend;
	// �վ�����
	public String avgSpendPerDay;
	// ����ʣ��
	public String monthAvailable;
	// �վ�����
	public String dayAvgAvailable;
	// ������ĩ
	public String monthLeftDay;
	// ʹ�ñ���
	public int usagePercentage;
	// �Ƿ�֧
	public boolean isOverSpend = false;

	// �����ʾ������
	public SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay, int monthAvailable, int dayAvgAvailable,
			int monthLeftDay, int usagePercentage) {
		this.monthSpend = "��" + monthSpend;
		this.todaySpend = "��" + todaySpend;
		this.avgSpendPerDay = "��" + avgSpendPerDay;
		if (monthAvailable < 0)
			isOverSpend = true;
		if (!isOverSpend) {
			this.monthAvailable = "��" + monthAvailable;
			this.dayAvgAvailable = "��" + dayAvgAvailable;
		}

		this.monthLeftDay = monthLeftDay + "��";
		this.usagePercentage = usagePercentage;
	}
}
