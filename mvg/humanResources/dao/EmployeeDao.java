package humanResources.dao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import humanResources.vo.AttendedVo;
import humanResources.vo.EmployeeVo;
import humanResources.vo.PositionVo;
import humanResources.vo.RetiredEmployeeVo;
import humanResources.vo.SalaryVo;
import humanResources.vo.ScheduleEmpVo;
import humanResources.vo.join.AttendedEmpVo;
import humanResources.vo.join.GetAllNowEmpVo;
import humanResources.vo.join.GetAllRetiredEmpVo;
import humanResources.vo.join.SalaryEmpVo;
import javafx.scene.control.CheckBox;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class EmployeeDao implements IEmployeeDao {
	private static EmployeeDao empDao;
	private SqlMapClient smc;

	private EmployeeDao() {
		try {
			Reader rd = Resources.getResourceAsReader("resources/sqlMap/sqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println("sqlMapLoad" + e);
		}
	}
	public static EmployeeDao getInstance() {
		if(empDao == null) {
			empDao = new EmployeeDao();
		}
		return empDao;
	}
	
	
	/* 제직 사원 */
	// 사원전체 조회
	@Override
	public List<EmployeeVo> getAllEmp() {
		List<EmployeeVo> empList = null;
		try {	
			empList = smc.queryForList("emp.getAllEmp");
		} catch (SQLException e) {
			System.out.println("getAllEmp" + e);
		}

		for (EmployeeVo employeeVo : empList) {
			employeeVo.setEmp_chk(new CheckBox());
		}
		return empList;
	}

	
	// 사원 하나 조회
	@Override
	public EmployeeVo getOneEmp(String emp_code) {
		EmployeeVo empVo = null;
		try {
			empVo = (EmployeeVo) smc.queryForObject("emp.getOneEmp",emp_code);
		} catch (SQLException e) {
			System.out.println("EmpDao(getOneEmp " + e);
		}
		return empVo;
	}
	
	// 현재 제직중인 사원 출력
	@Override
	public List<GetAllNowEmpVo> getAllNowEmp() {
		List<GetAllNowEmpVo> empList = null;
		try {	
			empList = smc.queryForList("emp.getAllNowEmp");
		} catch (SQLException e) {
			System.out.println("getAllNowEmp" + e);
		}
		/* 리스트 수만큼 checkBox 를 생성해준다. */
		for (GetAllNowEmpVo employeeVo : empList) {
			employeeVo.setEmp_chk(new CheckBox());
		}
		return empList;
	}

	// 제직사원 검색 
	@Override
	public List<GetAllNowEmpVo> getEmp(Map<String, String> emp) {
		List<GetAllNowEmpVo> empList = null;
		try {
			empList =   smc.queryForList("emp.getEmp", emp);			
		} catch (SQLException e) {
			System.out.println("getEmp" + e);
		}

		for (GetAllNowEmpVo employeeVo : empList) {
			employeeVo.setEmp_chk(new CheckBox());
		}
		return empList;
	}

	// 로그인 사원 조회
	@Override
	public EmployeeVo loginEmp(Map<String, String> login) {
		EmployeeVo empVo = null;
		try {
			empVo = (EmployeeVo)smc.queryForObject("emp.loginEmp",login);
		} catch (SQLException e) {
			System.out.println("loginEmp" + e);
		}
		return empVo;
	}

	// 패스워드 검사 
	@Override
	public String searchEmpPw(Map<String, String> certification) {
		return null;
	}

	// 사원 추가 
	@Override
	public int insertEmp(EmployeeVo empVo) {
		int cnt = 0;
		try {
			cnt = smc.update("emp.insertEmp",empVo);
		} catch (SQLException e) {
			System.out.println("empDao(insertEmp) " + e);
		}
		return cnt;
	}
	
	// 사원 삭제 
	@Override
	public int deleteEmp(List<String> emp_code) {
		int cnt = 0 ;
		try {
			cnt = smc.delete("emp.deleteEmp",emp_code);
		} catch (SQLException e) {
			System.out.println("empDao(deleteEmp)" + e);
		}
		return cnt;
	}
	
	// 사원 정보 변경
	@Override
	public int updateEmp(EmployeeVo empVo) {
		int cnt = 0;
		try {
			cnt = smc.update("emp.updateEmp",empVo);
		}  catch (SQLException e) {
			System.out.println("empDao(updateEmp) " + e);
		}
		return cnt;
	}


	/*퇴사자*/
	
	/**
	 *@Method 설명 : 퇴직사원 하나검색
	 *@Method Name : getOneRemp
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@param emp_code
	 *@return
	 */
	
	// 퇴사자 조회
	@Override
	public RetiredEmployeeVo getOneRemp(String remp_code) {
		RetiredEmployeeVo rempVo = null;
		try {
			rempVo = (RetiredEmployeeVo) smc.queryForObject("emp.getOneRemp",remp_code);
		} catch (SQLException e) {
			System.out.println("EmpDao(getOneEmp " + e);
		}
		return rempVo;
	}
	
	// 퇴사자 전부 조회
	@Override
	public List<GetAllRetiredEmpVo> getAllRetiredEmp() {
		List<GetAllRetiredEmpVo> rempList = null;
		try {
			rempList = smc.queryForList("emp.getAllRetiredEmp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 체크박스 생성
		for (GetAllRetiredEmpVo rempVo: rempList) {
			rempVo.setRemp_chk(new CheckBox());
		}
		return rempList;
	}
	
	// 퇴사사원 검색
	@Override
	public List<GetAllRetiredEmpVo> getRemp(Map<String, String> remp) {
		List<GetAllRetiredEmpVo> rempList = null;
		try {
			rempList =   smc.queryForList("emp.getRemp", remp);			
		} catch (SQLException e) {
			System.out.println("getRemp" + e);
		}
		for (GetAllRetiredEmpVo rempVo : rempList) {
			rempVo.setRemp_chk(new CheckBox());
		}
		return rempList;
	}
	
	// 퇴사사원 추가
	@Override
	public int insertRemp(RetiredEmployeeVo rempVo) {
		int cnt = 0;
		try {
			cnt = smc.update("emp.insertRemp",rempVo);
		} catch (SQLException e) {
			System.out.println("rempDao(insertRemp) " + e);
		}
		return cnt;
	}
	
	// 퇴사사원 삭제
	@Override
	public int deleteRemp(List<String> remp_code) {
		int cnt = 0 ;
		try {
			cnt = smc.delete("emp.deleteRemp", remp_code);
		} catch (SQLException e) {
			System.out.println("rempDao(deleteRemp)" + e);
		}
		return cnt;
	}
	
	// 퇴사사원 수정
	@Override
	public int updateRemp(RetiredEmployeeVo rempVo) {
		int cnt = 0;
		try {
			cnt = smc.update("emp.updateRemp", rempVo );
		}  catch (SQLException e) {
			System.out.println("empDao(updateRemp) " + e);
		}
		return cnt;
	}
	
	
	/* 직급 */

	@Override
	public List<PositionVo> getAllPosition() {
		List<PositionVo> posList = null ;
		try {
			posList = smc.queryForList("emp.getAllPosition");
		} catch (SQLException e) {
			System.out.println("empDao(getAllPosition) " + e);
		}
		return posList;
	}
	
	/* 출결 */
	public List<AttendedEmpVo> listAttend() {
			List<AttendedEmpVo> listAtted = null;
			try {
				listAtted = smc.queryForList("attd.listAttend");
			} catch (SQLException e) {
				System.out.println("Employee(listAttend" + e);
			}
			return listAtted;
		}
	
	@Override
	public List<AttendedEmpVo> listToday(String today) {
		List<AttendedEmpVo> listAtted = null;
		try {
			listAtted = smc.queryForList("attd.listToday", today);
		} catch (SQLException e) {
			System.out.println("Employee(listAttend" + e);
		}
		return listAtted;
	}
	@Override
	public List<AttendedEmpVo> searchAttend(Map<String, String> attdMap) {
		List<AttendedEmpVo> listAtted = null;
		try {
			listAtted = smc.queryForList("attd.searchAttend", attdMap);
		} catch (SQLException e) {
			System.out.println("Employee(searchAttend" + e);
		}
		return listAtted;
	}
	
	@Override
	public int checkAttend(Map<String, String> attdMap) {
		int cnt = 0;
		try {
			cnt = smc.update("attd.checkAttend", attdMap);
		} catch (SQLException e) {
			System.out.println("Employee(checkAttend" + e);
		}
		return cnt;
	}
	@Override
	public AttendedVo checkAttendEmp(String checkAttend) {
		AttendedVo attdVo = null;
		try {
			attdVo = (AttendedVo) smc.queryForObject("attd.checkAttendEmp", checkAttend);
		} catch (SQLException e) {
			System.out.println("Employee(checkAttendEmp" + e);
		}
		return attdVo;
	}

	
	/* 확장 인박스 */
	
	@Override
	public List<ScheduleEmpVo> searchSch() {
		List<ScheduleEmpVo> ListshcEmp = null;
		try {
			ListshcEmp = smc.queryForList("schEmp.searchSch");
		} catch (SQLException e) {
			System.out.println("EmpDao(searchSch) => " + e);
		}
		
		return ListshcEmp;
	}
	@Override
	public int insertSch(Map<String, String> schMap) {
		int cnt = 0 ;
		try {
			cnt = smc.update("schEmp.insertSch", schMap);
		} catch (SQLException e) {
			System.out.println("EmpDao(insertSch) => " + e);
		}
		return 0;
	}
	
	
	/* 급여 */
	@Override
	public List<SalaryEmpVo> salaryEmpList(String date) {
		List<SalaryEmpVo> salVoList = null;
		try {
			salVoList = smc.queryForList("sal.salaryEmpList",date);
		} catch (SQLException e) {
			System.out.println("EmpDao(salaryEmpList) => " + e);
		}
		// 결근일 검색
		for (SalaryEmpVo salaryEmpVo : salVoList) {
			salaryEmpVo.setSal_chk(new CheckBox());
			int count = (LocalDate.now().lengthOfMonth() - Integer.parseInt(salaryEmpVo.getAttd_count()));
			salaryEmpVo.setEmp_note("결근: " + count + "일" + " / 차감액 = " + count* 50000 + "원");
		}
		return salVoList;
	}
	@Override
	public List<SalaryEmpVo> salaryEmp(Map<String, String> salMap) {
		List<SalaryEmpVo> salVoList = null;
		try {
			salVoList = smc.queryForList("sal.salaryEmp",salMap);
		} catch (SQLException e) {
			System.out.println("EmpDao(salaryEmpList) => " + e);
		}
		// 결근일 검색
		for (SalaryEmpVo salaryEmpVo : salVoList) {
			salaryEmpVo.setSal_chk(new CheckBox());
			int count = (LocalDate.now().lengthOfMonth() - Integer.parseInt(salaryEmpVo.getAttd_count()));
			salaryEmpVo.setEmp_note("결근: " + count + "일" + " / 차감액 = " + count* 50000 + "원");
		}
		return salVoList;
	}
	@Override
	public int updateSalary(Map<String, String> salMap) {
		int cnt = 0;
		try {
			cnt = smc.update("sal.updateSalary",salMap);
		} catch (SQLException e) {
			System.out.println("EmpDao(salaryEmpList) => " + e);
		}
		return cnt;
	}
	@Override
	public SalaryVo salaryBasic(String pos_name) {
		SalaryVo salVo = null;
		try {
			salVo = (SalaryVo)smc.queryForObject("sal.salaryBasic", pos_name);
		} catch (SQLException e) {
			System.out.println("EmpDao(salaryBasic) => " + e);
		}
		return salVo;
	}
	
	
	
	
	
	
}
