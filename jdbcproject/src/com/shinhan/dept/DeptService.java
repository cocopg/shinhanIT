package com.shinhan.dept;

import java.util.List;

//비즈니스로직 수행
public class DeptService {
	DeptDAO deptDAO = new DeptDAO();

	//모두 조회
	public List<DeptDTO> selectAll() {
		return deptDAO.selectAll();
	}
	//특정지역조회
	public List<DeptDTO> selectBylocid(int locid) {
		return deptDAO.selectBylocid(locid);
	}
	
}
