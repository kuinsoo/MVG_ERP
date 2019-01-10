package staticMethod.comboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outsourcing.service.IOutsourcingService;
import outsourcing.service.OutsourcingService;
import outsourcing.vo.AccountVo;
import outsourcing.vo.ContractVo;
import outsourcing.vo.PlanningVo;
import systemAdministration.service.ISystemAdministrationService;
import systemAdministration.service.SystemAdministrationService;
import systemAdministration.vo.DepartmentVo;

import java.util.*;

public class ComboList {
	
	/**
	 *@Method Name : makerComboList
	 *@date : 2018. 9. 16.
	 *@author : Mr.KKu
	 *@Method 설명 : 범용 콤보박스 만들기
	 *@param : Map<?, ?> map, String compare    => map (mapkey(vo 콤보박스명리스트) , mapValue(vo DB 코드명)) , compare (비교대상)
	 *@return
	 */
	public static String makerComboList(Map<String, String> map, String compare) {
		String result = "";
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			String str = (String) it.next();
			if (compare.equals(str)) {
				result = map.get(str);
				System.out.println(str);
			}
		}
		System.out.println(result);
		return result;
	}
	/**
	 *@Method Name : positionCombo
	 *@date : 2018. 9. 16.
	 *@author : Mr.KKu
	 *@Method 설명 : 부서용 콤보박스
	 *@return
	 */
	public static ObservableList<String> deptCombo() {
		ISystemAdministrationService sysService = SystemAdministrationService.getInstance();
		List<String> dept_name = new ArrayList<>();
		for (DepartmentVo deptVo : sysService.allDepartmentsList()) {
			dept_name.add(deptVo.getDept_name());
		}
		ObservableList<String> obList = FXCollections.observableArrayList(dept_name);
		return obList;
	}

	/**
	 *@Method Name : positionCombo
	 *@date : 2018. 9. 16.
	 *@author : Mr.KKu
	 *@Method 설명 : 성별용 콤보박스
	 *@return
	 */
	public static ObservableList<String> genderCombo() {
		ObservableList<String> obList = FXCollections.observableArrayList("남성", "여성");
		return obList;
	}

	/**
	 *@Method Name : positionCombo
	 *@date : 2018. 9. 16.
	 *@author : Mr.KKu
	 *@Method 설명 : 직급용 콥보박스
	 *@return
	 */
	public static ObservableList<String> posCombo() {
		ISystemAdministrationService sysService = SystemAdministrationService.getInstance();
		List<String> pos_name = new ArrayList<>();
		for (systemAdministration.vo.PositionVo pVo : sysService.allPositionsList()) {
			pos_name.add(pVo.getPos_name());
		}
		ObservableList<String> obList = FXCollections.observableArrayList(pos_name);
		return obList;
	}

	/**
	 *@Method Name : searchCombo
	 *@date : 2018. 9. 17.
	 *@author : Mr.KKu
	 *@Method 설명 : 인사과 검색용 콤보박스
	 *@return
	 */
	public static ObservableList<String> searchCombo() {
		ObservableList<String> obList = FXCollections.observableArrayList("ID","사원명","부서","직급");
		return obList;
	}

	/**
	 *@Method Name : searchCombo
	 *@date : 2018. 9. 17.
	 *@author : Mr.KKu
	 *@Method 설명 : 인사과 퇴사자 검색 콤보박스
	 *@return
	 */
	public static ObservableList<String> searchRemp() {
		ObservableList<String> obList = FXCollections.observableArrayList("퇴사자코드","퇴사자명","부서");
		return obList;
	}
	
	/**
	 *@Method 설명 : 출결사항을 리스트로 출력한다.
	 *@Method Name : searchAttended
	 *@date : 2018. 9. 21.
	 *@author : Mr.KKu
	 *@return
	 */ 
	public static ObservableList<String> searchAttended() {
		ObservableList<String> obList = FXCollections.observableArrayList("사원명","사원코드","직급","부서");
		return obList;
	}
	
	/**
	 *@Method Name : accountCombo
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 거래처 검색용 콤보 박스
	 *@return 콤보박스에 들어갈 목록 리스트
	 */
	public static List<String> accountCombo(){
		List<String> accountColList = new ArrayList<String>();
		
		accountColList.add("전체");
		accountColList.add("거래처코드");
		accountColList.add("거래처명");
		accountColList.add("대표");
		
		return accountColList;
	}
	
	/**
	 *@Method Name : materialCateCombo
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 품목(자재) 검색용 콤보 박스
	 *@return 콤보박스에 들어갈 목록 리스트
	 */
	public static List<String> materialCateCombo(){
		List<String> matcColList = new ArrayList<String>();
		
		matcColList.add("전체");
		matcColList.add("분류코드");
		matcColList.add("품목명");
		
		return matcColList;
	}
	
	/**
	 *@Method Name : buyerCombo
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 구매처 검색용 콤보 박스
	 *@return 콤보박스에 들어갈 목록 리스트
	 */
	public static List<String> buyerCombo(){
		List<String> buyerColList = new ArrayList<String>();
		
		buyerColList.add("전체");
		buyerColList.add("구매처코드");
		buyerColList.add("구매처명");
		buyerColList.add("대표");
		
		return buyerColList;
	}
	
	/**
	 *@Method Name : codeRCombo
	 *@date : 2018. 9. 22.
	 *@author : Sohyoung
	 *@Method 설명 : 코드 신청서 검색용 콤보 박스
	 *@return 콤보박스에 들어갈 목록 리스트
	 */
	public static List<String> codeRCombo(){
		List<String> codeRColList = new ArrayList<String>();
		
		codeRColList.add("전체");
		codeRColList.add("부서별");
		codeRColList.add("날짜별");
		codeRColList.add("구분항목별");
		codeRColList.add("처리여부");
		
		return codeRColList;
	}
	
	/**
	 *@Method Name : codeR_divCombo
	 *@date : 2018. 9. 22.
	 *@author : Sohyoung
	 *@Method 설명 : 코드 신청서 구분 목록 콤보 박스
	 *@return 콤보박스 내용 String 리스트
	 */
	public static ObservableList<String> codeR_divCombo() {
		ObservableList<String> List = FXCollections.observableArrayList("자재분류","물품분류","기기코드","구매처코드","거래처","직급","부서","기타");
		return List;
	}
	
	/**
	 *@Method Name : matCombo
	 *@date : 2018. 9. 22.
	 *@author : Sohyoung
	 *@Method 설명 : 자재대분류 콤보박스
	 *@return
	 */
	public static ObservableList<String> matCombo() {
		ISystemAdministrationService sysService = SystemAdministrationService.getInstance();
		List<String> matc_name = new ArrayList<String>();
		for (systemAdministration.vo.MaterialCateVo matcVo : sysService.allMaterialCatesList()) {
			matc_name.add(matcVo.getMatc_name());
		}
		ObservableList<String> List = FXCollections.observableArrayList(matc_name);
		return List;
	}
	
	/**
	 *@Method Name : searchPlanCombo
	 *@date : 2018. 9. 27.
	 *@author : 박동주
	 *@Method 설명 : 기획서 거래처코드 콤보박스
	 *@return
	 */
	public static ObservableList<String> searchPlanCombo() {
		IOutsourcingService outService = OutsourcingService.getInstance();
		List<String> outList = new ArrayList<>();
		for (AccountVo accountVo : outService.getAllAccount()) {
			outList.add(accountVo.getAcc_code());
		}
		ObservableList<String> obList = FXCollections.observableArrayList(outList);
		return obList;
	}
	
	/**
	 *@Method 설명 : 계약서 코드 중복 제거 리스트만 출력
	 *@Method Name : searchContCombo
	 *@date : 2018. 10. 1.
	 *@author : Mr.KKu
	 *@return
	 */
	public static ObservableList<String> searchContCombo() {
		IOutsourcingService outService = OutsourcingService.getInstance();
		List<PlanningVo> planList = outService.getAllPlanning();
		List<ContractVo> contList = outService.getAllContract();
		List<String> outList = new ArrayList<>();
		boolean isHaveSch = false;
		for (int i = 0; i < planList.size(); i++) {
    		isHaveSch = false;
			for (int j = 0; j < contList.size(); j++) {
				if(planList.get(i).getPlan_no().equals(contList.get(j).getCont_plan())) {
					isHaveSch = true;
				}
			}
			if(!isHaveSch) {
				outList.add(planList.get(i).getPlan_no());
				System.out.println(planList.get(i).getPlan_no());
			}
		}
		ObservableList<String> obList = FXCollections.observableArrayList(outList);
		return obList;
	}
	
	/**
	 *@Method 설명 : MVG상영3관
	 *@Method Name : scd_scr
	 *@date : 2018. 9. 30.
	 *@author : Mr.KKu
	 *@return
	 */
	public static ObservableList<String> scd_scr() {
		ObservableList<String> List = FXCollections.observableArrayList("MVG상영1관","MVG상영2관","MVG상영3관","MVG상영4관","MVG상영5관");
		return List;
	}
	
	
	
	
	
	
}
