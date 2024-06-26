package org.firstzone.myapp.dept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//? ?¼ ë¨¼ì?
//ì¹¼ë¼ ?´ë¦? ê°ì?¼ ì¢ì
//run sql ?? alt + ?¤?¬ë¡¤í´? ?°?´ë¦??´? ë³µì¬
//ctrl shift yë¡? ?ë¬¸ì, ; ë¶ì´ê¸?

//VO (Value Object)
//DTO(Data Transfer Object
//JavaBeansê¸°ì ?? ?´?©(Jsp, String, Mybatis? javabeansê¸°ì ? ?´?©??¤.)

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