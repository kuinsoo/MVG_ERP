package material.service;


import material.vo.AssistantVo;
import material.vo.BuyerVo;
import material.vo.MaterialCateVo;
import material.vo.MaterialMainVo;
import material.vo.MaterialVo;

import java.util.List;
import java.util.Map;


public interface IMaterialService {
	
	
	/**
	 *@Method Name : getAllMat
	 *@date : 2018. 9. 15.
	 *@author : JeeSeon
	 *@Method 설명 : 자재전체 검색 
	 *@param 
	 *@return
	 */
	public List<MaterialVo> getAllMat();
	

	/**
	 *@Method Name : getMatWearingMain
	 *@date : 2018. 9. 15.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 입고 관리 기본테이블 
	 *@param 
	 *@return
	 */
	public List<MaterialMainVo> getMatWearingMain();


	/**
	 *@Method Name : insertMatAdd
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 입고 등록
	 *@param matMainVo
	 *@return
	 */
	public int insertMatAdd(MaterialVo matMainVo);
	



	/**
	 *@Method Name : matClassificationCode
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 입고등록시 자재분류 콤보박스
	 *@param 
	 *@return
	 */
	public List<MaterialCateVo> matClassificationCode();


	/**
	 *@Method Name : matAccountCode
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 입고등록시 거래처코드 콤보박스
	 *@param 
	 *@return
	 */
	public List<BuyerVo> matAccountCode();


	/**
	 *@Method Name : matUpdate
	 *@date : 2018. 9. 20.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 입고 수정
	 *@param matVo
	 *@return
	 */
	public int matUpdate(MaterialVo matVo);


	/**
	 *@Method Name : deleteMat
	 *@date : 2018. 9. 16.
	 *@author : JeeSeon
	 *@Method 설명 : 선택된 자재 삭제
	 *@param mat_code
	 *@return
	 */
	public int deleteMat(List<String> mat_code);
	
	
	/**
	 *@Method Name : getMat
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 자재를 여러가지 옵션으로 검색한다
	 *@param mat
	 *@return
	 */
	public List<MaterialMainVo> getMat(Map<String, String> mat);
	
	
	
	/**
	 *@Method Name : getMatDeferentMain
	 *@date : 2018. 9. 15.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 수불 관리 기본테이블 
	 *@param 
	 *@return
	 */
	public List<AssistantVo> getMatDeferentMain();

	
	/**
	 *@Method Name : insertAstAdd
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 수불 등록
	 *@param astVo
	 *@return
	 */
	public int insertAstAdd(AssistantVo astVo);
	
	
	/**
	 *@Method Name : assUpdate
	 *@date : 2018. 9. 20.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 수불 수정 
	 *@param assVo
	 *@return
	 */
	public int assUpdate(AssistantVo assVo);
	
	
	/**
	 *@Method Name : deleteAss
	 *@date : 2018. 9. 24.
	 *@author : JeeSeon
	 *@Method 설명 : 선택된 수불 삭제
	 *@param ast_no
	 *@return
	 */
	public int deleteAss(List<String> ast_no);
	
	
	/**
	 *@Method Name : getAst
	 *@date : 2018. 9. 24.
	 *@author : JeeSeon
	 *@Method 설명 : 수불을 여러가지 옵션으로 검색한다.
	 *@param ast
	 *@return
	 */
	public List<AssistantVo> getAst(Map<String, String> ast);
	

	
	/**
	 *@Method Name : getMatArticle
	 *@date : 2018. 9. 25.
	 *@author : JeeSeon
	 *@Method 설명 : 자재부 물품관리 기본테이블
	 *@param 
	 *@return
	 */
	public List<MaterialMainVo> getMatArticle();
	
	
	/**
	 *@Method Name : insertArticleAdd
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 물품 등록
	 *@param matMainVo
	 *@return
	 */
	public int insertArticleAdd(MaterialVo matMainVo);

	
	/**
	 *@Method Name : articleUpdate
	 *@date : 2018. 9. 20.
	 *@author : JeeSeon
	 *@Method 설명 : 물품 수정
	 *@param matVo
	 *@return
	 */
	public int articleUpdate(MaterialVo matVo);
	
	
	/**
	 *@Method Name : deleteArticle
	 *@date : 2018. 9. 16.
	 *@author : JeeSeon
	 *@Method 설명 : 선택된 물품 삭제
	 *@param mat_code
	 *@return
	 */
	public int deleteArticle(List<String> mat_code);

	
	/**
	 *@Method Name : getAct
	 *@date : 2018. 9. 27.
	 *@author : JeeSeon
	 *@Method 설명 : 물품을 여러가지 옵션으로 검색한다
	 *@param act
	 *@return
	 */
	public List<MaterialMainVo> getAct(Map<String, String> act);
	
	/**
	 *@Method Name : MaterialQty
	 *@date : 2018. 10. 1.
	 *@author : Yoo
	 *@Method 설명 : 수불에서 빠진 수량 만큼 자재 수량 수정
	 *@return
	 */
	public int MaterialQty (Map<String, String> mat_qty);
	
	
	
}
