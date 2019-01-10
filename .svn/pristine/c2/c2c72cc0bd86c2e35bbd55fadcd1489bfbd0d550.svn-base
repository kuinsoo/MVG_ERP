package systemAdministration.service;

import java.util.List;
import java.util.Map;

import systemAdministration.vo.AccountVo;
import systemAdministration.vo.BuyerVo;
import systemAdministration.vo.CodeRequestVo;
import systemAdministration.vo.DepartmentVo;
import systemAdministration.vo.MaterialCateVo;
import systemAdministration.vo.PositionVo;
import systemAdministration.vo.join.CodeRequest_DepartmentVo;

public interface ISystemAdministrationService {

// 코드 신청서
	/**
	 *@Method Name : allCodeRequestsList
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 모든 코드신청서 목록을 가져오는 메서드
	 *@return 코드신청서 리스트
	 */
	public List<CodeRequest_DepartmentVo> allCodeRequestsList();

	/**
	 *@Method Name : deleteCodeRequests
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 코드신청서들을 삭제하는 메서드
	 *@param crq_no 지우고자 하는 코드신청서들의 게시번호
	 *@return 성공하면 1을 반환, 실패시 0 반환
	 */
	public int deleteCodeRequests(List<String> crq_no);

	/**
	 *@Method Name : updateCodeRequest
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 코드신청서의 수정된 정보를 DB에 적용하는 메서드
	 *@param codeRequestVo 코드신청서의 수정된 내용들을 담은 VO
	 *@return 수정한 컬럼 수 만큼 반환
	 */
	public int updateCodeRequest(CodeRequestVo codeRequestVo);

	/**
	 *@Method Name : searchCodeRequests
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 검색 설정에 맞는 결과들을 가져오는 메서드
	 *@param codeR → Map<콤보박스, 검색창 내용>
	 *@return
	 */
	public List<CodeRequest_DepartmentVo> searchCodeRequests(Map<String, String> codeR);

	/**
	 *@Method Name : searchAllCodeRequests
	 *@date : 2018. 9. 22.
	 *@author : Sohyoung
	 *@Method 설명 : 코드 신청서 전체 컬럼에 대한 검색의 내용
	 *@param codeR 검색하고자 하는 내용
	 *@return 조건에 맞는 모든 코드 신청서 리스트
	 */
	public List<CodeRequest_DepartmentVo> searchAllCodeRequests(String codeR);
	
// 인사부 - 권한별코드관리
	/**
	 *@Method Name : allPositionsList
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 모든 권한코드 목록을 가져오는 메서드
	 *@return 권한코드신청서 리스트
	 */
	public List<PositionVo> allPositionsList();

	/**
	 *@Method Name : insertPosition
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 새로운 권한코드 등록
	 *쿼리문은 update로 합니다.
	 *@param positionVo 새로운 권한코드에 대한 내용이 들어있는 VO
	 *@return 성공하면 1 반환, 실패시 0 반환
	 */
	public int insertPosition(PositionVo positionVo);

	/**
	 *@Method Name : deletePositions
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 권한코드들을 삭제하는 메서드
	 *@param pos 지우고자 하는 권한코드들의 게시번호
	 *@return 성공하면 1을 반환, 실패시 0 반환
	 */
	public int deletePositions(List<String> pos_code);

	/**
	 *@Method Name : updatePosition
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 권한코드의 수정된 정보를 DB에 적용하는 메서드
	 *@param positionVo 권한코드의 수정된 내용들을 담은 VO
	 *@return 수정한 컬럼 수 만큼 반환
	 */
	public int updatePosition(PositionVo positionVo);

	// 인사부 - 부서코드 관리
	/**
	 *@Method Name : allDepartmentsList
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 모든 부서코드 목록을 가져오는 메서드
	 *@return 부서코드 목록
	 */
	public List<DepartmentVo> allDepartmentsList();

	/**
	 *@Method Name : insertDepartment
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 새로운 부서코드 등록
	 *쿼리문은 update로 합니다.
	 *@param departmentVo 새로운 부서코드에 대한 내용이 들어있는 VO
	 *@return 성공하면 1 반환, 실패시 0 반환
	 */
	public int insertDepartment(DepartmentVo departmentVo);

	/**
	 *@Method Name : deleteDepartments
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 부서코드들을 삭제하는 메서드
	 *@param dept 지우고자 하는 부서코드들의 게시번호
	 *@return 성공한 갯수만큼 반환
	 */
	public int deleteDepartments(List<String> dept_code);

	/**
	 *@Method Name : updatePosition
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 부서코드의 수정된 정보를 DB에 적용하는 메서드
	 *@param departmentVo 부서코드의 수정된 내용들을 담은 VO
	 *@return 수정한 컬럼 수 만큼 반환
	 */
	public int updateDepartment(DepartmentVo departmentVo);

// 외주부 - 거래처코드관리
	/**
	 *@Method Name : allAccountsList
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 모든 거래처 목록을 가져오는 메서드
	 *@return 거래처 목록
	 */
	public List<AccountVo> allAccountsList();

	/**
	 *@Method Name : insertAccount
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 새로운 거래처 등록
	 *쿼리문은 update로 합니다.
	 *@param accountVo 새로운 거래처에 대한 내용이 들어있는 VO
	 *@return 성공하면 1 반환, 실패시 0 반환
	 */
	public int insertAccount(AccountVo accountVo);

	/**
	 *@Method Name : deleteAccounts
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 거래처들을 삭제하는 메서드
	 *@param acc 지우고자 하는 거래처들의 게시번호
	 *@return 성공한 갯수만큼 반환
	 */
	public int deleteAccounts(List<String> acc);

	/**
	 *@Method Name : updateAccounts
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 거래처의 수정된 정보를 DB에 적용하는 메서드
	 *@param accountVo 거래처의 수정된 내용들을 담은 VO
	 *@return 수정한 컬럼 수 만큼 반환
	 */
	public int updateAccount(AccountVo accountVo);

	/**
	 *@Method Name : searchAccounts
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 검색 설정에 맞는 결과들을 가져오는 메서드
	 *@param acc → Map<콤보박스, 검색창 내용>
	 *@return 조건에 맞는 모든 거래처 리스트
	 */
	public List<AccountVo> searchAccounts(Map<String, String> acc);

	/**
	 *@Method Name : searchAllAccounts
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 거래처코드 전체 컬럼에 대한 검색의 내용
	 *@param acc 검색하고자 하는 내용
	 *@return 조건에 맞는 모든 거래처 리스트
	 */
	public List<AccountVo> searchAllAccounts(String acc);
	
	
// 생산부 - 품목별코드
	/**
	 *@Method Name : allMaterialCatesList
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 모든 품목별코드 목록을 가져오는 메서드
	 *@return 품목별코드 목록
	 */
	public List<MaterialCateVo> allMaterialCatesList();

	/**
	 *@Method Name : insertMaterialCate
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 새로운 품목별코드 등록
	 *쿼리문은 update로 합니다.
	 *@param materialCateVo 새로운 품목별코드에 대한 내용이 들어있는 VO
	 *@return 성공하면 1 반환, 실패시 0 반환
	 */
	public int insertMaterialCate(MaterialCateVo materialCateVo);

	/**
	 *@Method Name : deleteMaterialCates
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 품목별코드들을 삭제하는 메서드
	 *@param mat 지우고자 하는 품목별코드들의 게시번호
	 *@return 성공한 갯수만큼 반환
	 */
	public int deleteMaterialCates(List<String> mat);

	/**
	 *@Method Name : updateMaterialCates
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 품목별코드의 수정된 정보를 DB에 적용하는 메서드
	 *@param materialCateVo 품목별코드의 수정된 내용들을 담은 VO
	 *@return 수정한 컬럼 수 만큼 반환
	 */
	public int updateMaterialCate(MaterialCateVo materialCateVo);

	/**
	 *@Method Name : searchMaterialCates
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 검색 설정에 맞는 결과들을 가져오는 메서드
	 *@param matC → Map<콤보박스, 검색창 내용>
	 *@return 조건에 맞는 모든 자재코드 리스트
	 */
	public List<MaterialCateVo> searchMaterialCates(Map<String, String> matC);
	
	/**
	 *@Method Name : searchAllMaterialCates
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 자재코드 전체 컬럼에 대한 검색의 내용
	 *@param matc 검색하고자 하는 내용
	 *@return 조건에 맞는 모든 자재코드 리스트
	 */
	public List<MaterialCateVo> searchAllMaterialCates(String matc);

// 생산부 - 구매처코드
	/**
	 *@Method Name : allBuyersList
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 모든 구매처코드 목록을 가져오는 메서드
	 *@return 구매처코드 목록
	 */
	public List<BuyerVo> allBuyersList();

	/**
	 *@Method Name : insertBuyer
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 새로운 구매처코드 등록
	 *쿼리문은 update로 합니다.
	 *@param buyerVo 새로운 구매처코드에 대한 내용이 들어있는 VO
	 *@return 성공하면 1 반환, 실패시 0 반환
	 */
	public int insertBuyer(BuyerVo buyerVo);

	/**
	 *@Method Name : deleteBuyers
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 구매처코드들을 삭제하는 메서드
	 *@param buyer 지우고자 하는 구매처코드들의 게시번호
	 *@return 성공한 갯수만큼 반환
	 */
	public int deleteBuyers(List<String> buyer);

	/**
	 *@Method Name : updateBuyers
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 구매처코드의 수정된 정보를 DB에 적용하는 메서드
	 *@param buyerVo 구매처코드의 수정된 내용들을 담은 VO
	 *@return 수정한 컬럼 수 만큼 반환
	 */
	public int updateBuyer(BuyerVo buyerVo);

	/**
	 *@Method Name : searchBuyers
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 검색 설정에 맞는 결과들을 가져오는 메서드
	 *@param buyer → Map<콤보박스, 검색창 내용>
	 *@return 조건에 맞는 모든 구매처 코드 리스트
	 */
	public List<BuyerVo> searchBuyers(Map<String, String> buyer);
	
	/**
	 *@Method Name : searchAllBuyers
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 구매처 코드 전체 컬럼에 대한 검색의 내용
	 *@param buyer 검색하고자 하는 내용
	 *@return 조건에 맞는 모든 구매처 코드 리스트
	 */
	public List<BuyerVo> searchAllBuyers(String buyer);


}
