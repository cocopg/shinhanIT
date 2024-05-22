package org.firstzone.myapp.dept;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DeptDAOInterface {

	public int deptDelete(int deptid);

	public int deptUpdate(DeptDTO dept);

	public int deptInsert(DeptDTO dept);

	public List<DeptDTO> selectByCondition(int deptid, String deptname, int mid, int lid);

	public DeptDTO selectById(int deptid);

	public List<DeptDTO> selectAll();
}
