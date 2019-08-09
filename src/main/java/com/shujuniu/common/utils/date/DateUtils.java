package com.shujuniu.common.utils.date;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

	public static long getWeekStartLong(long weekTime) {
		Date date = new Date(weekTime);
		Date weekStart = getWeekStart(date);
		return weekStart.getTime();
	}

	public static long getWeekEndLong(long weekTime) {
		Date date = new Date(weekTime);
		Date weekEnd = getWeekEnd(date);
		return weekEnd.getTime();
	}


	/**
	 * 日期格式化 日期格式为：yyyy-MM-dd
	 * @param date  日期
	 * @param pattern  格式，如：DateUtils.DATE_TIME_PATTERN
	 * @return  返回yyyy-MM-dd格式日期
	 */
	public static String format(Date date, String pattern) {
		if(date != null){
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}

	/**
	 * 字符串转换成日期
	 * @param strDate 日期字符串
	 * @param pattern 日期的格式，如：DateUtils.DATE_TIME_PATTERN
	 */
	public static Date stringToDate(String strDate, String pattern) throws ParseException {
		if (StringUtils.isBlank(strDate)){
			return null;
		}

		DateFormat df = new SimpleDateFormat(pattern);
		return df.parse(strDate);
	}

	/***************************************************************************************************/

	/**
	 * 是否在start和end之间
	 */
	public static boolean isBetweenStartEnd(Date currDate, Date start, Date end) {
		currDate = currDate == null ? new Date() : currDate;
		start = start == null ? new Date() : start;
		end = end == null ? new Date() : end;
		if (currDate.getTime() >= start.getTime() && currDate.getTime() <= end.getTime()) {
			return true;
		}
		return false;
	}

	/**
	 * 获得当前毫秒值
	 */
	public static Long getCurrMillis() {
		return System.currentTimeMillis();
	}


	/**
	 * 计算毫秒值+月数（传负数就是减法了）的计算算法(因为每月的天数不固定，所以需要借助日历类来处理。日的加减直接处理即可)
	 */
	public static long addMonthToLong(long base, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(base);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + month);
		return cal.getTimeInMillis();
	}

	/**
	 * 获取当前的前、后 第n天date日期
	 */
	public static Date getDayPreOrNext(Date date, int num) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, num);
		return calendar.getTime();
	}

	/**
	 * 判断传进来的日期是否为当前时间：当前小时，当前日，当前周，当前月，当前季度，当前年
	 */
	public static boolean isCurrTime(Date date, int type) {
		if (type == Calendar.HOUR) {
			return getHourStart(date).getTime() == getHourStart(new Date()).getTime();
		} else if (type == Calendar.DAY_OF_YEAR) {
			return getDayStart(date).getTime() == getDayStart(new Date()).getTime();
		} else if (type == Calendar.WEEK_OF_YEAR) {
			return getWeekStart(date).getTime() == getWeekStart(new Date()).getTime();
		} else if (type == Calendar.MONTH) {
			return getMonthStart(date).getTime() == getMonthStart(new Date()).getTime();
		} else if (type == Calendar.YEAR) {
			return getYearStart(date).getTime() == getYearStart(new Date()).getTime();
		} else
			throw new RuntimeException("无法识别的类型");
	}

	/**
	 * 得到某一年的所有季度开始结束时间，按季度区分去出来 如果年份就是今年，并且isToCurr：true时，那就只拿开始到当前的季度
	 */
	public static Map<String, Date[]> getYearQuartersStartEndMap(Date date, boolean isToCurr) {
		Integer currYear = getYear(new Date());// 当前年
		Quarter currQ = getQuarterEnum(new Date());// 当前季度
		if (isToCurr && currYear.equals(getYear(date)) && currQ == getQuarterEnum(date)) {// 如果是当前年
																							// 就显示截止到当前月份的所有月份
			return getYearCurrQuartersStartEndMap();
		} else
			return getYearQuartersStartEndMap(date);
	}

	/**
	 * 得到某一年的所有月开始结束时间，按月份区分去出来 如果年份就是今年，并且isToCurr：true时，那就只拿开始到当前的月
	 */
	public static Map<String, Date[]> getYearMonthsStartEndMap(Date date, boolean isToCurr) {
		Integer currYear = getYear(new Date());// 当前年
		if (isToCurr && currYear.equals(getYear(date))) {// 如果是当前年
															// 就显示截止到当前月份的所有月份
			return getYearCurrMonthsStartEndMap();
		} else
			return getYearMonthsStartEndMap(date);
	}

	/**
	 * 得到当前日期季度内，按月份分类的map key：月份的枚举 为了保持调用统一，使用isToCurr参数，但不给予意义（因为一共就三月，再少就无意义了）
	 */
	public static Map<String, Date[]> getQuarterMonthsStartEndMap(Date date, boolean isToCurr) {
		date = date == null ? new Date() : date;
		Map<String, Date[]> map = new LinkedHashMap<>();
		Integer year = getYear(date);// 得到当前年
		Quarter quarter = getQuarterEnum(date);// 得到当前日期是第几季度的
		if (Quarter.Q1TH == quarter) {
			setMonthStartEnd(1, 3, year, map);
		} else if (Quarter.Q2ND == quarter) {
			setMonthStartEnd(4, 6, year, map);
		} else if (Quarter.Q3RD == quarter) {
			setMonthStartEnd(7, 9, year, map);
		} else if (Quarter.Q4TH == quarter)
			setMonthStartEnd(10, 12, year, map);
		return map;
	}

	/**
	 * 得到某一个月的所有天开始结束时间，按天区分去出来 如果是当前年并且当前月，并且isToCurr：true时，那就只拿开始到当前的日
	 */
	public static Map<String, Date[]> getMonthDaysStartEndMap(Date date, boolean isToCurr) {
		Integer currYear = getYear(new Date());// 当前年
		Integer currMonth = getMonth(new Date());
		if (isToCurr && currYear.equals(getYear(date)) && currMonth.equals(getMonth(date))) {
			return getMonthCurrDaysStartEndMap();
		} else
			return getMonthDaysStartEndMap(date);
	}

	/**
	 * 得到当前日期周内，按日分类的map key：周的字符串 如果当前年、周 那么只显示到当前的周几为止
	 */
	public static Map<String, Date[]> getWeekDaysStartEndMap(Date date, boolean isToCurr) {
		Integer currYear = getYear(new Date());// 当前年
		Integer currWeekNum = getWeekNum(new Date());
		Week currWeek = getWeek(new Date());
		Map<String, Date[]> weekDaysStartEndMapUtil = getWeekDaysStartEndMapUtil(date);
		Map<String, Date[]> map = new LinkedHashMap<>();
		if (isToCurr == true && currYear.equals(getYear(date)) && currWeekNum.equals(getWeekNum(date))) {// 如果是当前周，就只拿当前的
			for (Map.Entry<String, Date[]> entry : weekDaysStartEndMapUtil.entrySet())
				if (getWeek(entry.getValue()[0]).getId() <= currWeek.getId())
					map.put(entry.getKey(), entry.getValue());
			return map;
		} else
			return weekDaysStartEndMapUtil;
	}

	/**
	 * 得到某一天的所有小时开始结束时间，按小时区分去出来 如果是当前年并且当前月并且当前天，并且isToCurr：true时，那就只拿开始到当前小时数
	 */
	public static Map<String, Date[]> getDayHoursStartEndMap(Date date, boolean isToCurr) {
		Integer currYear = getYear(new Date());// 当前年
		Integer currMonth = getMonth(new Date());
		Integer currDay = getDay(new Date());
		if (isToCurr && currYear.equals(getYear(date)) && currMonth.equals(getMonth(date)) && currDay.equals(getDay(date))) {
			return getDayCurrHoursStartEndMap();
		} else
			return getDayHoursStartEndMap(date);
	}

	/**
	 * 从指定日期，到目前为止，列出所有的YYYY-MM月份显示 根据此key，便可拿到当月的开始、结束时间了
	 */
	public static String[] getMonthsList(Date from, Date to) {
		from = from == null ? new Date() : from;
		to = to == null ? new Date() : to;// 默认是到当前时间
		Set<String> monthSet = new LinkedHashSet<>();// 使用此set是为了保证有序性
		Integer baseYear = getYear(from);
		Integer baseMonth = getMonth(from);
		Integer monthCount = getDateSub(from, to, 1);// 相差的总月数
		monthSet.add(baseYear + "-" + baseMonth);// 先把当前月的装起来
		for (int i = 1; i <= monthCount; i++) {
			if (baseMonth + 1 > 12) {
				baseYear++;
				baseMonth = 1;
			} else
				baseMonth++;
			monthSet.add(baseYear + "-" + baseMonth);
		}
		return monthSet.toArray(new String[monthSet.size()]);
	}

	/**
	 * 得到传进来的日期到当前日期的年的统计 key:2014,2015,2016 此方法很特殊，因为直接统计的是年，范围很大
	 */
	public static Map<String, Date[]> getYearToCurrYearStartEndMap(Date from) {
		from = from == null ? new Date() : from;// 默认就是从当前年开始的
		Integer fromYear = getYear(from);
		Integer currYear = getYear(new Date());
		if (fromYear > currYear) {
			throw new IllegalArgumentException("Can't search in the future");
		} else {
			Map<String, Date[]> currMap = new LinkedHashMap<>();
			for (int i = 0; i <= currYear - fromYear; i++) {
				Integer yearTemp = fromYear + i;
				currMap.put(yearTemp + "", getYearStartEnd(str2Date(yearTemp + "", DateParttern.YYYY)));
			}
			return currMap;
		}
	}

	/**
	 * 获取指定日期的当天开始时间
	 */
	public static Date getDayStart(Date date) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期的当天的结束时间
	 */
	public static Date getDayEnd(Date date) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 得到每周的开始时间 周一为每周的第一天
	 */
	public static Date getWeekStart(Date date) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		if (calendar.getTimeInMillis() > date.getTime()) // 此判断是为了防止周一当作另外一周进行处理了
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 7);
		return calendar.getTime();
	}

	/**
	 * 得到每周的结束时间 周日为每周的最后一天
	 */
	public static Date getWeekEnd(Date date) {
		date = date == null ? new Date() : date;
		date = getWeekStart(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 6);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 得到当前日期所在月的开始时间
	 */
	public static Date getMonthStart(Date date) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.DATE, 1);
		return calendar.getTime();
	}

	/**
	 * 得到当前日期所在月的结束时间
	 */
	public static Date getMonthEnd(Date date) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 获得当前时间所在季度的开始时间
	 */
	public static Date getQuarterStart(Date date) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		if (currentMonth >= 1 && currentMonth <= 3)
			calendar.set(Calendar.MONTH, 0);
		else if (currentMonth >= 4 && currentMonth <= 6)
			calendar.set(Calendar.MONTH, 3);
		else if (currentMonth >= 7 && currentMonth <= 9)
			calendar.set(Calendar.MONTH, 6);
		else if (currentMonth >= 10 && currentMonth <= 12)
			calendar.set(Calendar.MONTH, 9);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.DATE, 1);
		return calendar.getTime();
	}

	/**
	 * 获得当前时间所在季度的结束时间
	 */
	public static Date getQuarterEnd(Date date) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		if (currentMonth >= 1 && currentMonth <= 3)
			calendar.set(Calendar.MONTH, 2);
		else if (currentMonth >= 4 && currentMonth <= 6)
			calendar.set(Calendar.MONTH, 5);
		else if (currentMonth >= 7 && currentMonth <= 9)
			calendar.set(Calendar.MONTH, 8);
		else if (currentMonth >= 10 && currentMonth <= 12)
			calendar.set(Calendar.MONTH, 11);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 得到当前日期所在年的开始时间
	 */
	public static Date getYearStart(Date date) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 得到当前日期所在年的结束时间
	 */
	public static Date getYearEnd(Date date) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DATE, 31);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 获取某个日期的年龄（xx岁xx月xx天） 只获得岁即可
	 */
	public static Integer getAge(Date date) {
		int age = 0;
		Calendar born = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		if (date != null) {
			now.setTime(new Date());
			born.setTime(date);
			if (born.after(now))
				throw new IllegalArgumentException("Can't be born in the future");
			age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);// 年份相减就是年龄
			// if (now.get(Calendar.DAY_OF_YEAR) <
			// born.get(Calendar.DAY_OF_YEAR))
			// age -= 1;
		}
		return age;
	}

	/**
	 * 得到更加精确些的年龄 带有月份的字符串
	 */
	public static String getActualAge(Date date) {
		int days = getDateSub(date, new Date(), 0);// 一共生活的天数
		int months = getDateSub(date, new Date(), 1);// 一共生活的月数
		String myAge = "";
		int year = months / 12;
		int mon = months % 12;
		if (days <= 100)
			myAge += days + "天";// 100天内大的孩子，直接显示天数
		else {
			if (year > 0)
				myAge += year + "岁";
			if (mon > 0)
				myAge += mon + "个月";
		}
		return myAge;
	}

	/**
	 * 得到第二个日期和第一个日期的差值 可能为负数 dateType:1:月,2:年 默认是天
	 */
	@SuppressWarnings("deprecation")
	public static Integer getDateSub(Date startDay, Date endDay, int dateType) {
		startDay = startDay == null ? new Date() : startDay;
		endDay = endDay == null ? new Date() : endDay;
		switch (dateType) {
		case 1:// 月
			return (endDay.getYear() - startDay.getYear()) * 12 + endDay.getMonth() - startDay.getMonth();
		case 2:// 年
			return endDay.getYear() - startDay.getYear();
		default:// 日
			return (int) (((endDay.getTime() - startDay.getTime()) >> 10) / 84375);
		}
	}

	/**
	 * 是否是闰年
	 */
	public static boolean isLeapYear(int year) {
		if (year == 0) {
			year = DateUtils.getYear(new Date());
		}
		boolean flag = false;
		if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 得到一年的毫秒值
	 */
	public static Long getCurrYearMillis() {
		int dayCount = isLeapYear(0) ? 366 : 355;// 闰年366天 平年365天
		return dayCount * 24 * 60 * 60 * 1000L;
	}

	/**
	 * 得到每天的毫秒数 dayCount：天数 默认为拿一天的86400000
	 */
	public static Long getMillisByDay(Integer dayCount) {
		return 24 * 60 * 60 * 1000L * (dayCount == null ? 1 : dayCount);
	}

	/**
	 * 得到一周的毫秒数
	 */
	public static Long getMillisByWeek(Integer weekCount) {
		return 24 * 60 * 60 * 1000L * 7 * (weekCount == null ? 1 : weekCount);
	}

	/**
	 * 将标准的日期字符串转化为日期对象。转换失败返回null。
	 */
	public static Date str2Date(String dateStr, DateParttern dateParttern) {
		if (dateParttern == null)
			dateParttern = DateParttern.YYYY_MM_DD_HH_MM_SS;// 默认的格式
		Date myDate = null;
		if (dateStr != null) {
			try {
				myDate = getDateFormat(dateParttern).parse(dateStr);
			} catch (Exception e) {
				myDate = null;
			}
		}
		return myDate;
	}

	/**
	 * 将日期转化为日期字符串。失败返回null。
	 */
	public static String date2Str(Date date, DateParttern dateParttern) {
		String dateString = null;
		if (date != null) {
			try {
				dateString = getDateFormat(dateParttern).format(date);
			} catch (Exception e) {
				dateString = null;
			}
		}
		return dateString;
	}

	/**
	 * 判断是否为合法的字符串格式
	 */
	public static boolean isDateStr(String dateStr, DateParttern dateParttern) {
		try {
			getDateFormat(dateParttern).parse(dateStr);
			return true;
		} catch (Exception e) {
			return false;// 如果throw
							// java.text.ParseException或者NullPointerException，就说明格式不对
		}
	}

	/**
	 * 增加日期的年份。失败返回null。
	 */
	public static Date addYear(Date date, int yearAmount) {
		return addInteger(date, Calendar.YEAR, yearAmount);
	}

	/**
	 * 增加日期的月份。失败返回null。
	 */
	public static Date addMonth(Date date, int monthAmount) {
		return addInteger(date, Calendar.MONTH, monthAmount);
	}

	/**
	 * 增加日期的天数。失败返回null。
	 */
	public static Date addDay(Date date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount);
	}

	/**
	 * 增加日期的小时。失败返回null。
	 */
	public static Date addHour(Date date, int hourAmount) {
		return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
	}

	/**
	 * 增加日期的分钟。失败返回null。
	 */
	public static Date addMinute(Date date, int hourAmount) {
		return addInteger(date, Calendar.MINUTE, hourAmount);
	}

	/**
	 * 增加日期的秒钟。失败返回null。
	 */
	public static Date addSecond(Date date, int hourAmount) {
		return addInteger(date, Calendar.SECOND, hourAmount);
	}

	/**
	 * 获取日期的年份。失败返回0。
	 */
	public static int getYear(Date date) {
		return getInteger(date, Calendar.YEAR);
	}

	/**
	 * 获取日期的月份。失败返回0。
	 */
	public static int getMonth(Date date) {
		return getInteger(date, Calendar.MONTH) + 1;
	}

	/**
	 * 获取本年的第几周的数字
	 */
	public static int getWeekNum(Date date) {
		return getInteger(date, Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获取日期的天数。失败返回0。
	 */
	public static int getDay(Date date) {
		return getInteger(date, Calendar.DATE);
	}

	/**
	 * 得到当前月的总天数
	 */
	public static int getMonthDayCount(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 获取日期的小时。失败返回0。
	 */
	public static int getHour(Date date) {
		return getInteger(date, Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取日期的分钟。失败返回0。
	 */
	public static int getMinute(Date date) {
		return getInteger(date, Calendar.MINUTE);
	}

	/**
	 * 获取日期的秒钟。失败返回0。
	 */
	public static int getSecond(Date date) {
		return getInteger(date, Calendar.SECOND);
	}

	/**
	 * 得到当前日期为周几 中国人习惯，返回的是星期对象 里面有你想要的各种东西
	 */
	public static Week getWeekEnum(Date date) {
		date = date == null ? new Date() : date;
		return getWeek(date);
	}

	/**
	 * 得到当前日期的季度对象 里面啥都有
	 */
	public static Quarter getQuarterEnum(Date date) {
		date = date == null ? new Date() : date;
		return getQuarter(date);
	}

	/**
	 * 得到当前日期的月份对象 里面啥都有
	 */
	public static Month getMonthEnum(Date date) {
		date = date == null ? new Date() : date;
		return getMonthUtil(date);
	}

	/************************************ 内部方法区start ************************************************/
	// 得到当前日期所在的天的开始时间、结束时间数组 仅以日期对象来装载
	private static Date[] getDayStartEnd(Date date) {
		return new Date[] { getDayStart(date), getDayEnd(date) };
	}

	// 得到当前日期所在的月的开始时间、结束时间数组 仅以日期对象来装载
	private static Date[] getMonthStartEnd(Date date) {
		return new Date[] { getMonthStart(date), getMonthEnd(date) };
	}

	// 得到当前日期所在的季度的开始时间、结束时间数组 仅以日期对象来装载
	private static Date[] getQuarterStartEnd(Date date) {
		return new Date[] { getQuarterStart(date), getQuarterEnd(date) };
	}

	// 得到当前日期所在的年的开始时间、结束时间数组 仅以日期对象来装载
	private static Date[] getYearStartEnd(Date date) {
		return new Date[] { getYearStart(date), getYearEnd(date) };
	}

	// 得到当前日期年内，按月份分类的map key：月份的枚举的id的字符串形式
	private static Map<String, Date[]> getYearMonthsStartEndMap(Date date) {
		date = date == null ? new Date() : date;
		Map<String, Date[]> map = new LinkedHashMap<>();
		Integer year = getYear(date);// 得到当前的年份 一共12个月，有点多，所以采取循环的方式做
		setMonthStartEnd(1, 12, year, map);
		return map;
	}

	// 得到今年截止到本月的所有月的开始结束时间 注意：范围是今年
	private static Map<String, Date[]> getYearCurrMonthsStartEndMap() {
		Integer currMonth = getMonth(new Date());
		Map<String, Date[]> currMap = new LinkedHashMap<>();
		Map<String, Date[]> map = getYearMonthsStartEndMap(new Date());
		for (Map.Entry<String, Date[]> entry : map.entrySet()) {
			Date[] value = entry.getValue();
			if (getMonth(value[0]) <= currMonth)
				currMap.put(entry.getKey(), value);
		}
		return currMap;
	}

	// 得到当前日期月份内，按日分类的map key：day的枚举类的id的string形式
	private static Map<String, Date[]> getMonthDaysStartEndMap(Date date) {
		date = date == null ? new Date() : date;
		Map<String, Date[]> map = new LinkedHashMap<>();
		Integer year = getYear(date);// 得到当前年
		Integer month = getMonth(date);// 得到当前月
		for (int i = 1; i <= getMonthDayCount(date); i++) {
			Date dateTemp = str2Date(year + "-" + month + "-" + i, DateParttern.YYYY_MM_DD);
			map.put(i + "", getDayStartEnd(dateTemp));
		}
		return map;
	}

	// 得到本月截止到本日的所有日的开始结束时间 注意：范围是是本月
	private static Map<String, Date[]> getMonthCurrDaysStartEndMap() {
		Integer currDay = getDay(new Date());// 当前日
		Map<String, Date[]> currMap = new LinkedHashMap<>();
		Map<String, Date[]> map = getMonthDaysStartEndMap(new Date());
		for (Map.Entry<String, Date[]> entry : map.entrySet()) {
			Date[] value = entry.getValue();
			if (getDay(value[0]) <= currDay)
				currMap.put(entry.getKey(), value);
		}
		return currMap;
	}

	// 得到今天截止到现在，每个小时的开始结束时间 注意：范围是是本日
	private static Map<String, Date[]> getDayCurrHoursStartEndMap() {
		Integer currHour = getHour(new Date());// 当前小时
		Map<String, Date[]> currMap = new LinkedHashMap<>();
		Map<String, Date[]> map = getDayHoursStartEndMap(new Date());// 拿当前的时间就行了
		for (Map.Entry<String, Date[]> entry : map.entrySet()) {
			Date[] value = entry.getValue();
			if (getHour(value[0]) <= currHour)
				currMap.put(entry.getKey(), value);
		}
		return currMap;
	}

	// 得到当前日期天内，每一个小时(一共24小时)的开始结束时间
	private static Map<String, Date[]> getDayHoursStartEndMap(Date date) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Map<String, Date[]> map = new LinkedHashMap<>();
		for (int i = 0; i < 24; i++) {
			Date[] startEnd = new Date[2];
			calendar.set(Calendar.HOUR_OF_DAY, i);
			calendar.set(Calendar.MILLISECOND, 0);
			startEnd[0] = calendar.getTime();
			calendar.set(Calendar.HOUR_OF_DAY, i + 1);
			calendar.add(Calendar.MILLISECOND, -1);
			startEnd[1] = calendar.getTime();
			map.put(i + "", startEnd);
			calendar.add(Calendar.MILLISECOND, 1);
		}
		return map;
	}

	// 得到当前日期年内，每个季度(有可能只有两个或者三个嘛)的开始结束时间
	private static Map<String, Date[]> getYearCurrQuartersStartEndMap() {
		Quarter currQ = getQuarterEnum(new Date());
		Map<String, Date[]> currMap = new LinkedHashMap<>();
		Map<String, Date[]> map = getYearQuartersStartEndMap(new Date());
		for (Map.Entry<String, Date[]> entry : map.entrySet()) {
			Date[] value = entry.getValue();
			if (getQuarterEnum(value[0]).getId() <= currQ.getId())
				currMap.put(entry.getKey(), value);
		}
		return currMap;
	}

	// 得到当前日期年内，四个季度按季度分类的map key：季度的枚举
	private static Map<String, Date[]> getYearQuartersStartEndMap(Date date) {
		date = date == null ? new Date() : date;
		Integer year = getYear(date);// 得到当前的年份 一共四个季度，所以直接枚举即可
		DateParttern parttern = DateParttern.YYYY_MM;// 只需使用月份模版便可
		final Date date1 = str2Date(year + "-01", parttern);
		final Date date2 = str2Date(year + "-04", parttern);
		final Date date3 = str2Date(year + "-07", parttern);
		final Date date4 = str2Date(year + "-10", parttern);
		return new LinkedHashMap<String, Date[]>() {
			private static final long serialVersionUID = 1L;
			{
				put(Quarter.Q1TH.getId() + "", getQuarterStartEnd(date1));
				put(Quarter.Q2ND.getId() + "", getQuarterStartEnd(date2));
				put(Quarter.Q3RD.getId() + "", getQuarterStartEnd(date3));
				put(Quarter.Q4TH.getId() + "", getQuarterStartEnd(date4));
			}
		};
	}

	// 得到当前日期周内，按日分类的map key：02-01 02-02等 使用isToCurr参数，但不给予意义
	private static Map<String, Date[]> getWeekDaysStartEndMapUtil(Date date) {
		date = date == null ? new Date() : date;
		final Date date1 = getWeekStart(date);// 周一的最开始的日期
		final Date date2 = addDay(date1, 1);
		final Date date3 = addDay(date1, 2);
		final Date date4 = addDay(date1, 3);
		final Date date5 = addDay(date1, 4);
		final Date date6 = addDay(date1, 5);
		final Date date7 = addDay(date1, 6);
		return new LinkedHashMap<String, Date[]>() {
			private static final long serialVersionUID = 1L;
			{
				// DateParttern parttern = DateParttern.YYYY_MM_DD;//
				// 这里面的年份不要丢了，否则getWeekDaysStartEndMap2会有问题，不知道今夕是何年何月
				put(getWeek(date1).getId() + "", getDayStartEnd(date1));
				put(getWeek(date2).getId() + "", getDayStartEnd(date2));
				put(getWeek(date3).getId() + "", getDayStartEnd(date3));
				put(getWeek(date4).getId() + "", getDayStartEnd(date4));
				put(getWeek(date5).getId() + "", getDayStartEnd(date5));
				put(getWeek(date6).getId() + "", getDayStartEnd(date6));
				put(getWeek(date7).getId() + "", getDayStartEnd(date7));
			}
		};
	}

	// 获取SimpleDateFormat 对象，此日期工具类都用此对象来格式化日期
	private static SimpleDateFormat getDateFormat(DateParttern dateParttern) throws RuntimeException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateParttern.getValue());
		simpleDateFormat.setLenient(false);// 避免二月份校验不正确的情况
		return simpleDateFormat;
	}

	// 获取日期对象中的某数值。如获取月份 dateType:Calendar.YEAR必须为这种枚举值
	private static int getInteger(Date date, int dateType) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(dateType);
	}

	/**
	 * 增加日期中某类型的某数值。如增加日期 dateType:枚举值
	 */
	private static Date addInteger(Date date, int dateType, int amount) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(dateType, amount);
		return calendar.getTime();
	}

	// 获取日期的星期。失败返回null
	private static Week getWeek(Date date) {
		date = date == null ? new Date() : date;
		Week week = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		switch (weekNumber) {
		case 0:
			week = Week.SUNDAY;// 一周的开始从周日开始
			break;
		case 1:
			week = Week.MONDAY;
			break;
		case 2:
			week = Week.TUESDAY;
			break;
		case 3:
			week = Week.WEDNESDAY;
			break;
		case 4:
			week = Week.THURSDAY;
			break;
		case 5:
			week = Week.FRIDAY;
			break;
		case 6:
			week = Week.SATURDAY;
			break;
		}
		return week;
	}

	// 获取日期的季度。失败返回null
	private static Quarter getQuarter(Date date) {
		date = date == null ? new Date() : date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		if (currentMonth >= 1 && currentMonth <= 3)
			return Enum.valueOf(Quarter.class, Quarter.Q1TH.name());
		else if (currentMonth >= 4 && currentMonth <= 6)
			return Enum.valueOf(Quarter.class, Quarter.Q2ND.name());
		else if (currentMonth >= 7 && currentMonth <= 9)
			return Enum.valueOf(Quarter.class, Quarter.Q3RD.name());
		else if (currentMonth >= 10 && currentMonth <= 12)
			return Enum.valueOf(Quarter.class, Quarter.Q4TH.name());
		return null;
	}

	// 获取日期的月份。失败返回null
	private static Month getMonthUtil(Date date) {
		int currentMonth = getMonth(date) - 1;
		return Month.getById(currentMonth);
	}

	// 辅助设置制定月到制定月的月份的开头和结尾
	private static void setMonthStartEnd(Integer monthStart, Integer monthEnd, Integer year, Map<String, Date[]> map) {
		DateParttern parttern = DateParttern.YYYY_MM;// 只需使用月份模版便可
		for (int i = monthStart; i <= monthEnd; i++) {
			Date dateTemp = str2Date(year + "-" + i, parttern);
			map.put(i + "", getMonthStartEnd(dateTemp));
		}
	}

	// 私有化构造函数
	private DateUtils() {
	}

	/**************** 处理小时 ********************/
	private static final SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
	private static final SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 获得传进来时间的小时开始时间
	 */
	public static Date getHourStart(Date date) {
		Date now = date == null ? new Date() : date;
		try {
			now = longHourSdf.parse(longHourSdf.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得传进来时间的小时结束时间
	 */
	public static Date getHourEnd(Date date) {
		Date now = date == null ? new Date() : date;
		try {
			now = longSdf.parse(longHourSdf.format(now) + ":59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/************************************ 内部方法区end ************************************************/

    /**
     * utc时间转换成Date
     * @param dateStr
     * @return
     */
	public static Date utcStrToDate(String dateStr) {
        Date myDate = null;
        if (dateStr != null) {
            try {
                dateStr = dateStr.replace("Z", " UTC");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
                myDate = format.parse(dateStr);
            } catch (Exception e) {
                myDate = null;
            }
        }
        return myDate;
    }
}