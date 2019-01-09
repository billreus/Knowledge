package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static long millisecondsOfOneDay = 1000 * 60 * 60 * 24;

	public static java.sql.Date util2sql(java.util.Date d) {
		return new java.sql.Date(d.getTime());
	}

	/*
	 * ��ȡ���죬���Ұ�ʱ���֡��롢���붼��Ϊ0����Ϊͨ�����ڿؼ���ȡ�������ڣ�����û��ʱ����ͺ����
	 */
	public static Date today() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // ��ȡ��ǰʱ�� new Date()�ǵ�ǰʱ��ĺ�����
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/*
	 * ��ȡ�³� ʹ��Calendar��ȡ���µ�һ�졣 ��ͳ������һ����Ϣ��ʱ�򣬾��Ǵӱ��µ�һ�쵽���һ������ݲ���������м�ͳ��
	 */
	public static Date monthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE, 1); // ����Ϊ�µ�1��

		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}

	/*
	 * ��ȡ��ĩ
	 */
	public static Date monthEnd() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);

		c.set(Calendar.DATE, 1); // ����������1��
		c.add(Calendar.MONTH, 1); // �¸��µ�1��
		c.add(Calendar.DAY_OF_MONTH, -1); // ����µ����һ��

		return c.getTime();
	}

	/*
	 * ��ȡ����һ���ж�����
	 */
	public static int thisMonthTotalDay() {
		long lastDayMillisSeconds = monthEnd().getTime();
		long firstDayMillisSeconds = monthBegin().getTime();
		return (int) ((lastDayMillisSeconds - firstDayMillisSeconds) / millisecondsOfOneDay) + 1;
	}

	/*
	 * ���»�ʣ������
	 */
	public static int thisMonthLeftDay() {
		long lastDayMillisSeconds = monthEnd().getTime();
		long toDayMillisSeconds = today().getTime();
		return (int) ((lastDayMillisSeconds - toDayMillisSeconds) / millisecondsOfOneDay) + 1;
	}
	
	// ����
	public static void main(String[] args) {
		System.out.println(DateUtil.today());
		System.out.println(DateUtil.monthBegin());
		System.out.println(DateUtil.monthEnd());
		System.out.println(DateUtil.thisMonthTotalDay());
		System.out.println(DateUtil.thisMonthLeftDay());
	}
}
