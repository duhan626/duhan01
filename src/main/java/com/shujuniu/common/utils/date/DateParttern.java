package com.shujuniu.common.utils.date;

public enum DateParttern {
	MM_DD(0, "MM-dd"), //
	YYYY_MM(1, "yyyy-MM"), //
	YYYY_MM_DD(2, "yyyy-MM-dd"), //
	MM_DD_HH_MM(3, "MM-dd HH:mm"), //
	MM_DD_HH_MM_SS(4, "MM-dd HH:mm:ss"), //
	YYYY_MM_DD_HH_MM(5, "yyyy-MM-dd HH:mm"), //
	YYYY_MM_DD_HH_MM_SS(6, "yyyy-MM-dd HH:mm:ss"), // 此模版估计是最常用的了吧
	MM_DD_EN(7, "MM/dd"), //
	YYYY_MM_EN(8, "yyyy/MM"), //
	YYYY_MM_DD_EN(9, "yyyy/MM/dd"), //
	MM_DD_HH_MM_EN(10, "MM/dd HH:mm"), //
	MM_DD_HH_MM_SS_EN(11, "MM/dd HH:mm:ss"), //
	YYYY_MM_DD_HH_MM_EN(12, "yyyy/MM/dd HH:mm"), //
	YYYY_MM_DD_HH_MM_SS_EN(13, "yyyy/MM/dd HH:mm:ss"), //
	MM_DD_CN(14, "MM月dd日"), //
	YYYY_MM_CN(15, "yyyy年MM月"), //
	YYYY_MM_DD_CN(16, "yyyy年MM月dd日"), //
	MM_DD_HH_MM_CN(17, "MM月dd日 HH:mm"), //
	MM_DD_HH_MM_SS_CN(18, "MM月dd日 HH:mm:ss"), //
	YYYY_MM_DD_HH_MM_CN(19, "yyyy年MM月dd日 HH:mm"), //
	YYYY_MM_DD_HH_MM_SS_CN(20, "yyyy年MM月dd日 HH:mm:ss"), //
	HH_MM(21, "HH:mm"), //
	HH_MM_SS(22, "HH:mm:ss"), //
	YYYY(23, "yyyy"), //
	MM_SS(24, "mm:ss"); //

	private Integer id;
	private String value;

	DateParttern(Integer id, String value) {
		this.id = id;
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

}
