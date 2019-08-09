package com.shujuniu.common.utils.date;

/**
 * 季度的枚举类
 */
public enum Quarter {

	Q1TH(1, "第一季度", "quarter 1th", "Q1"), //
	Q2ND(2, "第二季度", "quarter 2nd", "Q2"), //
	Q3RD(3, "第三季度", "quarter 3rd", "Q3"), //
	Q4TH(4, "第四季度", "quarter 4th", "Q4");//

	Integer id;
	String name_cn;
	String name_en;
	String name_enShort;

	Quarter(Integer id, String name_cn, String name_en, String name_enShort) {
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
	public static Quarter getById(Integer id) {
		for (Quarter temp : Quarter.values())
			if (temp.getId().equals(id))
				return temp;
		return null;
	}
}
