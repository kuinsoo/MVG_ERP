package humanResources.service;

import humanResources.dao.EmployeeDao;
import humanResources.dao.IEmployeeDao;
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

import java.util.List;
import java.util.Map;

public class EmployeeService implements IEmployeeService {
	private IEmployeeDao dao;
	static private EmployeeService service;
	private EmployeeService() {
		dao = EmployeeDao.getInstance();
	}
	public static EmployeeService getInstance() {
		if(service == null) {

			service = new EmployeeService();
		}
		return service;
	}

	@Override
	public List<EmployeeVo> getAllEmp() {
		return dao.getAllEmp();
	}
	

	@Override
	public EmployeeVo getOneEmp(String emp_code) {
		return dao.getOneEmp(emp_code);
	}
	@Override
	public List<GetAllNowEmpVo> getAllNowEmp() {
		return dao.getAllNowEmp();
	}

	@Override
	public List<GetAllRetiredEmpVo> getAllRetiredEmp() {
		return dao.getAllRetiredEmp();
	}

	@Override
	public List<GetAllNowEmpVo> getEmp(Map<String, String> emp) {
		return dao.getEmp(emp);
	}

	@Override
	public EmployeeVo loginEmp(Map<String, String> login) {
		return dao.loginEmp(login);
	}

	@Override
	public String searchEmpPw(Map<String, String> certification) {
		return dao.searchEmpPw(certification);
	}
	
	@Override
	public int insertEmp(EmployeeVo empVo) {
		// TODO Auto-generated method stub
		return dao.insertEmp(empVo);
	}
	@Override
	public int deleteEmp(List<String> emp_code) {
		// TODO Auto-generated method stub
		return dao.deleteEmp(emp_code);
	}
	@Override
	public int updateEmp(EmployeeVo empVo) {
		// TODO Auto-generated method stub
		return dao.updateEmp(empVo);
	}

	/* 직급 */

	@Override
	public List<PositionVo> getAllPosition() {
		return dao.getAllPosition();
	}
	
	
	
	/* 퇴사자 */
	
	@Override
	public RetiredEmployeeVo getOneRemp(String remp_code) {
		// TODO Auto-generated method stub
		return dao.getOneRemp(remp_code);
	}
	
	@Override
	public List<GetAllRetiredEmpVo> getRemp(Map<String, String> remp) {
		// TODO Auto-generated method stub
		return dao.getRemp(remp);
	}
	@Override
	public int insertRemp(RetiredEmployeeVo rempVo) {
		// TODO Auto-generated method stub
		return dao.insertRemp(rempVo);
	}
	@Override
	public int deleteRemp(List<String> remp_code) {
		// TODO Auto-generated method stub
		return dao.deleteRemp(remp_code);
	}
	@Override
	public int updateRemp(RetiredEmployeeVo rempVo) {
		// TODO Auto-generated method stub
		return dao.updateRemp(rempVo);
	}
	
	/* 출결 */

	@Override
	public List<AttendedEmpVo> listAttend() {
		// TODO Auto-generated method stub
		return dao.listAttend();
	}
	@Override
	public List<AttendedEmpVo> listToday(String today) {
		// TODO Auto-generated method stub
		return dao.listToday(today);
	}
	@Override
	public List<AttendedEmpVo> searchAttend(Map<String, String> attdMap) {
		// TODO Auto-generated method stub
		return dao.searchAttend(attdMap);
	}
	@Override
	public int checkAttend(Map<String, String> attdMap) {
		// TODO Auto-generated method stub
		return dao.checkAttend(attdMap);
	}
	@Override
	public AttendedVo checkAttendEmp(String checkAttend) {
		// TODO Auto-generated method stub
		return dao.checkAttendEmp(checkAttend);
	}
	@Override
	public List<ScheduleEmpVo> searchSch() {
		// TODO Auto-generated method stub
		return dao.searchSch();
	}
	@Override
	public int insertSch(Map<String, String> schMap) {
		// TODO Auto-generated method stub
		return dao.insertSch(schMap);
	}
	
	
	/* 급여 */
	@Override
	public List<SalaryEmpVo> salaryEmpList(String date) {
		// TODO Auto-generated method stub
		return dao.salaryEmpList(date);
	}
	@Override
	public List<SalaryEmpVo> salaryEmp(Map<String, String> salMap) {
		// TODO Auto-generated method stub
		return dao.salaryEmp(salMap);
	}
	@Override
	public int updateSalary(Map<String, String> salMap) {
		// TODO Auto-generated method stub
		return dao.updateSalary(salMap);
	}
	@Override
	public SalaryVo salaryBasic(String pos_name) {
		// TODO Auto-generated method stub
		return dao.salaryBasic(pos_name);
	}
	

	
	
	
	
	
}
