package commonDocument.dao;

import java.util.List;

import commonDocument.vo.CodeRequestVo;

public interface ICommonDocumentDao {
	
	/**
	 *@Method Name : insertCodeRequest
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 새로운 코드신청서 등록
	 *쿼리문은 update로 합니다.
	 *@param CodeRequest_DepartmentVo 새로운 코드신청서에 대한 내용이 들어있는 VO
	 *@return 성공하면 1 반환, 실패시 0 반환
	 */
	public int insertCodeRequest(CodeRequestVo codeRequestVo);

	/**
	 *@Method Name : getMatNames
	 *@date : 2018. 9. 27.
	 *@author : Sohyoung
	 *@Method 설명 : 자재분류별 입고 자재명 구하기
	 *@param mat_metc 특정 분류
	 *@return 입고 자재들
	 */
	public List<String> getMatNames(String mat_metc);
	
	/**
	 *@Method Name : getMatQty
	 *@date : 2018. 9. 27.
	 *@author : Sohyoung
	 *@Method 설명 : 자재의 남은 수량 구하기
	 *@param mat_name 특정 자재
	 *@return 남은 수량
	 */
	public String getMatQty(String mat_name);
}











