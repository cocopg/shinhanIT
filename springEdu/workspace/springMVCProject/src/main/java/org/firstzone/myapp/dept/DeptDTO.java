package org.firstzone.myapp.dept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//?��?�� 먼�?
//칼럼 ?���? 같아?�� 좋음
//run sql ?��?�� alt + ?��?��롤해?�� ?��?���??��?�� 복사
//ctrl shift y�? ?��문자, ; 붙이�?

//VO (Value Object)
//DTO(Data Transfer Object
//JavaBeans기술?��?�� ?��?��(Jsp, String, Mybatis?�� javabeans기술?�� ?��?��?��?��.)

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter@Setter
public class DeptDTO {
//	int DEPARTMENT_ID;
	int department_id;
//	String DEPARTMENT_NAME;
	String department_name;
//	int MANAGER_ID;
	int manager_id;
//	int LOCATION_ID;
	int location_id;
}