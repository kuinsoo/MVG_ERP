package humanResources.dao;

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

public interface IEmployeeDao {


	/**
	 * 사원 전체 검색  & 퇴사자도 검색된다
	 * @return
	 */
	public List<EmployeeVo> getAllEmp();
	
	/**
	 * 현재 사원 하나 검색
	 * @return
	 */
	public EmployeeVo getOneEmp(String emp_code);

	/**
	 * 현재 제직중인 사원만 전체 검색
	 * @return
	 */
	public List<GetAllNowEmpVo> getAllNowEmp();


	/**
	 * 사원 하나를 여러가지 옵션으로 검색한다.
	 * @param emp
	 * @return
	 */
	public List<GetAllNowEmpVo> getEmp(Map<String, String> emp);

	/**
	 * 로그인용 메서드
	 * @param login
	 * @return
	 */
	public EmployeeVo loginEmp(Map<String, String> login);

	/**
	 * 회원 비밀번호를 찾을때 이용한다.
	 * @param certification
	 * @return
	 */
	public String searchEmpPw(Map<String, String> certification);

	/**
	 *@Method Name : insertEmp
	 *@date : 2018. 9. 16.
	 *@author : Mr.KKu
	 *@Method 설명 : 사원 하나를 추가 등록
	 *@param empVo
	 *@return
	 */
	public int insertEmp(EmployeeVo empVo);

	/**
	 *@Method Name : deleteEmp
	 *@date : 2018. 9. 16.
	 *@author : Mr.KKu
	 *@Method 설명 : 선택된 회원 삭제
	 *@param emp_code
	 *@return
	 */
	public int deleteEmp(List<String> emp_code);

	/**
	 *@Method Name : updataeEmp
	 *@date : 2018. 9. 16.
	 *@author : Mr.KKu
	 *@Method 설명 : 선택된 회원 정보 수정
	 *@param empVo
	 *@return
	 */
	public int updateEmp(EmployeeVo empVo);

	/* ----------------------------------------------- 퇴사자 --------------------------------------------- */

	
	/**
	 *@Method 설명 : 퇴직사원 하나검색
	 *@Method Name : getOneRemp
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@param emp_code
	 *@return
	 */
	public RetiredEmployeeVo getOneRemp(String remp_code);

	/**
	 *@Method Name : getAllRetiredEmp
	 *@date : 2018. 9. 20.
	 *@author : pc06
	 *@Method 설명 : 퇴사사원 전부를 검색한다.
	 *@return
	 */
	public List<GetAllRetiredEmpVo> getAllRetiredEmp();
	
	/**
	 *@Method Name : getRemp
	 *@date : 2018. 9. 20.
	 *@author : pc06
	 *@Method 설명 : 퇴사사원을 여러가지 방법으로 검색해준다.
	 *@param emp
	 *@return
	 */
	public List<GetAllRetiredEmpVo> getRemp(Map<String, String> remp);
	
	

	/**
	 *@Method Name : insertRemp
	 *@date : 2018. 9. 20.
	 *@author : pc06
	 *@Method 설명 : 퇴사사원을 등록한다.
	 *@param empVo
	 *@return
	 */
	public int insertRemp(RetiredEmployeeVo rempVo);


	/**
	 *@Method Name : deleteRemp
	 *@date : 2018. 9. 20.
	 *@author : pc06
	 *@Method 설명 : 퇴사사원을 삭제 시킨다
	 *@param emp_code
	 *@return
	 */
	public int deleteRemp(List<String> remp_code);


	/**
	 *@Method Name : updateRemp
	 *@date : 2018. 9. 20.
	 *@author : pc06
	 *@Method 설명 : 퇴사사원 정보를 변경해준다.
	 *@param empVo
	 *@return
	 */
	public int updateRemp(RetiredEmployeeVo rempVo);
	
	
	/**
	 *@Method Name : updataeEmp
	 *@date : 2018. 9. 16.
	 *@author : Mr.KKu
	 *@Method 설명 : 직급 전체 출력
	 *@return
	 */
	public List<PositionVo> getAllPosition();
	
	/* ---------------------------------------------------  출결  ---------------------------------------------------- */
	/**
	 *@Method 설명 : 출결 리스트를 출력해준다
	 *@Method Name : listAttend
	 *@date : 2018. 9. 21.
	 *@author : Mr.KKu
	 *@return
	 */
	public List<AttendedEmpVo> listAttend();
	
	/**
	 *@Method 설명 : 오늘 날짜 출결 사항 표시
	 *@Method Name : listToday
	 *@date : 2018. 9. 25.
	 *@author : Mr.KKu
	 *@return
	 */
	public List<AttendedEmpVo> listToday(String today);
	
	/**
	 *@Method 설명 : 출결 리스트 검색
	 *@Method Name : searchAttend
	 *@date : 2018. 9. 21.
	 *@author : Mr.KKu
	 *@return
	 */
	public List<AttendedEmpVo> searchAttend(Map<String, String> attdMap);
	
	/**
	 *@Method 설명 : 출석체크 하기
	 *@Method Name : checkAttend
	 *@date : 2018. 9. 21.
	 *@author : Mr.KKu
	 *@param attdMap
	 *@return
	 */
	public int checkAttend(Map<String, String> attdMap);
	
	/**
	 *@Method 설명 : 출석체크가 되었는지 확인하기
	 *@Method Name : checkAttendEmp
	 *@date : 2018. 9. 21.
	 *@author : Mr.KKu
	 *@param checkAttend
	 *@return
	 */
	public AttendedVo checkAttendEmp(String checkAttend);
	
	/* --------------------------------------- 스케줄 ---------------------------------------*/
	/**
	 *@Method 설명 : 인사과 스케줄 
	 *@Method Name : searchSch
	 *@date : 2018. 9. 21.
	 *@author : Mr.KKu
	 *@return
	 */
	public List<ScheduleEmpVo> searchSch();
	
	/**
	 *@Method 설명 : 인사과 스케줄 삽입
	 *@Method Name : insertSch
	 *@date : 2018. 9. 21.
	 *@author : Mr.KKu
	 *@return
	 */
	public int insertSch(Map<String, String> schMap);
	
	/* ------------------------------------------------------  급여 ----------------------------------------------------- */
	
	/**
	 *@Method 설명 : 급여회원 전부 출력
	 *@Method Name : salaryEmpList
	 *@date : 2018. 9. 25.
	 *@author : Mr.KKu
	 *@return
	 */
	public List<SalaryEmpVo> salaryEmpList(String date);
	
	/**
	 *@Method 설명 : 검색 회원 급여
	 *@Method Name : salaryEmp
	 *@date : 2018. 9. 25.
	 *@author : Mr.KKu
	 *@param salMap
	 *@return
	 */
	public List<SalaryEmpVo> salaryEmp(Map<String, String> salMap);
	
	/**
	 *@Method 설명 : 급여 정보 수정
	 *@Method Name : changeSalary
	 *@date : 2018. 9. 25.
	 *@author : Mr.KKu
	 *@return
	 */
	public int updateSalary(Map<String, String> salMap);
	
	/**
	 *@Method 설명 : 급여 정보 검색
	 *@Method Name : salaryBasic
	 *@date : 2018. 9. 25.
	 *@author : Mr.KKu
	 *@param pos_name
	 *@return
	 */
	public SalaryVo salaryBasic(String pos_name);
}
