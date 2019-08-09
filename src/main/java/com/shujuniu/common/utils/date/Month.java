package com.shujuniu.common.utils.date;

public enum Month {
	JANUARY(1, "一月", "January", "Jan."), //
	FEBRUARY(2, "二月", "February", "Feb."), //
	MARCH(3, "三月", "March", "Mar."), //
	APRIL(4, "四月", "April", "Apr."), //
	MAY(5, "五月", "May", "May."), //
	JUNE(6, "六月", "June", "June."), //
	JULY(7, "七月", "July", "July."), //
	AUGUST(8, "八月", "August", "Aug."), //
	SEPTEMBER(9, "九月", "September", "Sept."), //
	OCTOBER(10, "十月", "October", "Oct."), //
	NOVEMBER(11, "十一月", "November", "Nov."), //
	DECEMBER(12, "十二月", "December", "Dec."); //

	Integer id;
	String name_cn;
	String name_en;
	String name_enShort;

	Month(Integer id, String name_cn, String name_en, String name_enShort) {
		this.id = id;
		this.name_cn = name_cn;
		this.name_en = name_en;
		this.name_enShort = name_enShort;
	}

	public Integer getId() {
		return id;
	}

	public String getName_cn() {
		return name_cn;
	}

	public String getName_en() {
		return name_en;
	}

	public String getName_enShort() {
		return name_enShort;
	}

	/**
	 * 根据id获取枚举对象
	 */
	public static Month getById(Integer id) {
		for (Month temp : Month.values())
			if (temp.getId().equals(id))
				return temp;
		return null;
	}

}
