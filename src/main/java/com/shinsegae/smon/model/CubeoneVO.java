package com.shinsegae.smon.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CubeoneVO {
	private String status = "200";
	private String msg;
	private int crudLog;
	private String itemCd;
	private String tableName;
	private String columnName;
	private String errorMsg;
	private String retMsg;
}
