package com.shinhan.dept;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class DeptDTO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
}
