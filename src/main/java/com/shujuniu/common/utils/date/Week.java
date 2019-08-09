package com.shujuniu.common.utils.date;

/**
 * id不再从零开始，用中国人的时间习惯来弄
 */
public enum Week {
	MONDAY(1, "周一", "Monday", "Mon."), //
	TUESDAY(2, "周二", "Tuesday", "Tues."), //
	WEDNESDAY(3, "周三", "Wednesday", "Wed."), //
	THURSDAY(4, "周四", "Thursday", "Thur."), //
	FRIDAY(5, "周五", "Friday", "Fri."), //
	SATURDAY(6, "周六", "Saturday", "Sat."), //
	SUNDAY(7, "周日", "Sunday", "Sun.");

	Integer id;
	String name_cn;
	String name_en;
	String name_enShort;

	Week(Integer id, String name_cn, String name_en, String name_enShort) {
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
	public static Week getById(Integer id) {
		for (Week temp : Week.values())
			if (temp.getId().equals(id))
				return temp;
		return null;
	}

}
