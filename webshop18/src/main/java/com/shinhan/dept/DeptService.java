package com.shinhan.dept;

import java.util.List;

public class DeptService {

	DeptDAO deptDAO = new DeptDAO();

	// 1. Create: 새 부서 생성
	public int deptInsert(DeptDTO dept) {
		return deptDAO.deptInsert(dept);
	}

	// 2. Read: 부서 모두 조회
	public List<DeptDTO> selectAll() {
		return deptDAO.selectAll();
	}

	// 3. Update: 부서 정보 수정
	public int deptUpdate(DeptDTO dept) {
		return deptDAO.deptUpdate(dept);
	}

	// 4. Delete: 특정 부서 삭제
	public int deptDelete(int deptid) {
		return deptDAO.deptDelete(deptid);
	}
	
	//특정 부서 조회
	public DeptDTO selectById(int deptid) {
		return deptDAO.selectById(deptid);
	}

}