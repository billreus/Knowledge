package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static long millisecondsOfOneDay = 1000 * 60 * 60 * 24;

	public static java.sql.Date util2sql(java.util.Date d) {
		return new java.sql.Date(d.getTime());
	}

	/*
	 * 获取今天，并且把时、分、秒、毫秒都置为0，因为通过日期控件获取到的日期，就是没有时分秒和毫秒的
	 */
	public static Date today() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // 获取当前时间 new Date()是当前时间的毫秒数
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/*
	 * 获取月初 使用Calendar获取本月第一天。 在统计消费一览信息的时候，就是从本月第一天到最后一天的数据查出来，进行简单统计
	 */
	public static Date monthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE, 1); // 设置为月第1天

		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}

	/*
	 * 获取月末
	 */
	public static Date monthEnd() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);

		c.set(Calendar.DATE, 1); // 设置日期是1号
		c.add(Calendar.MONTH, 1); // 下个月的1号
		c.add(Calendar.DAY_OF_MONTH, -1); // 这个月的最后一天

		return c.getTime();
	}

	/*
	 * 获取本月一共有多少天
	 */
	public static int thisMonthTotalDay() {
		long lastDayMillisSeconds = monthEnd().getTime();
		long firstDayMillisSeconds = monthBegin().getTime();
		return (int) ((lastDayMillisSeconds - firstDayMillisSeconds) / millisecondsOfOneDay) + 1;
	}

	/*
	 * 本月还剩多少天
	 */
	public static int thisMonthLeftDay() {
		long lastDayMillisSeconds = monthEnd().getTime();
		long toDayMillisSeconds = today().getTime();
		return (int) ((lastDayMillisSeconds - toDayMillisSeconds) / millisecondsOfOneDay) + 1;
	}
	
	// 测试
	public static void main(String[] args) {
		System.out.println(DateUtil.today());
		System.out.println(DateUtil.monthBegin());
		System.out.println(DateUtil.monthEnd());
		System.out.println(DateUtil.thisMonthTotalDay());
		System.out.println(DateUtil.thisMonthLeftDay());
	}
}
