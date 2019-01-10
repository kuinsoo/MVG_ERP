package production.service;

import java.util.List;

import humanResources.vo.EmployeeVo;
import material.vo.AssistantVo;
import production.vo.AssistantVO;
import production.vo.BuyerVO;
import production.vo.DefectiveProductVo;
import production.vo.DefectiveVO;
import production.vo.MachineVO;
import production.vo.ProductionJournalVO;
import production.vo.ProductionMachineVO;
import production.vo.ProductionStockVO;
import production.vo.ProductionVo;
import production.vo.QualityInspectionVO;
import production.vo.QualityVo;
import production.vo.SaleVO;

public interface IProductionService {
	/**
	 *@Method Name : getAllProd
	 *@date : 2018. 9. 12.
	 *@author : "Mr.KKu"
	 *@Method 설명 : 전체 생산품 
	 *@return
	 */
	public List<ProductionVo> getAllProd();
	
	/**
	 *@Method Name : getProd
	 *@date : 2018. 9. 12.
	 *@author : "Mr.KKu"
	 *@Method 설명 : 
	 *@return
	 */
	public ProductionVo getProd();
	
	/**
	 *@Method Name : getAllProduction
	 *@date : 2018. 9. 17.
	 *@author : Yoo
	 *@Method 설명 : 생산입고 관리 전체 목록 검색
	 *@return
	 */
	public List<ProductionStockVO> getAllProduction();
	
	
	/**
	 *@Method Name : getProductionJournal
	 *@date : 2018. 9. 17.
	 *@author : Yoo
	 *@Method 설명 : 생산 일지 전체 리스트 검색
	 *@return
	 */
	public List<ProductionJournalVO> getProductionJournal();
	
	
	/**
	 *@Method Name : getQuailtyInspecton
	 *@date : 2018. 9. 18.
	 *@author : Yoo
	 *@Method 설명 : 품질 관리 전체 리스트 검색
	 *@return
	 */
	public List<QualityInspectionVO> getQuailtyInspecton();
	
	/**
	 *@Method Name : getDefectiveProduction
	 *@date : 2018. 9. 18.
	 *@author : Yoo
	 *@Method 설명 : 불량관리 전체 리스트 검색
	 *@return
	 */
	public List<DefectiveVO> getDefectiveProduction();
	
	/**
	 *@Method Name : getProductionMachine
	 *@date : 2018. 9. 18.
	 *@author : Yoo
	 *@Method 설명 : 기기 관리 전체 리스트 검색
	 *@return
	 */
	public List<ProductionMachineVO> getProductionMachine();
	
	/**
	 *@Method Name : insertProduction
	 *@date : 2018. 9. 19.
	 *@author : Yoo
	 *@Method 설명 : 생산 입고 등록
	 *@param assistantVo
	 *@return
	 */
	public int insertProduction(AssistantVo assistantVo);
	
	/**
	 *@Method Name : getBuyerList
	 *@date : 2018. 9. 19.
	 *@author : Yoo
	 *@Method 설명 :	 거래처 목록 검색
	 *@return
	 */
	public List<BuyerVO> getBuyerList();
	
	/**
	 *@Method Name : insertMahcine
	 *@date : 2018. 9. 19.
	 *@author : Yoo
	 *@Method 설명 : 기기등록
	 *@return
	 */
	public int insertMahcine(MachineVO machineVo);
	
	/**
	 *@Method Name : deleteMachine
	 *@date : 2018. 9. 19.
	 *@author : Yoo
	 *@Method 설명 : 기기 목록 삭제
	 *@param machList
	 *@return
	 */
	public int deleteMachine(List<String> machList);
	
	
	
	/**
	 *@Method Name : updateMachine
	 *@date : 2018. 9. 20.
	 *@author : Yoo
	 *@Method 설명 : 기기 목록 수정
	 *@param machVO
	 *@return
	 */
	public int updateMachine(MachineVO machVO);
	
	/**
	 *@Method Name : updateQuality
	 *@date : 2018. 9. 23.
	 *@author : Yoo
	 *@Method 설명 :	품질 검사 목록 수정
	 *@param qualVO
	 *@return
	 */
	public int updateQuality(QualityVo qualVO);
	
	/**
	 *@Method Name : deleteQuality
	 *@date : 2018. 9. 24.
	 *@author : Yoo
	 *@Method 설명 : 품질 목록 삭제
	 *@param qualList
	 *@return
	 */
	public int deleteQuality(List<String> qualList);
	
	
	/**
	 *@Method Name : submiteQuality
	 *@date : 2018. 9. 24.
	 *@author : Yoo
	 *@Method 설명 : 품질 등록
	 *@param qualVO
	 *@return
	 */
	public int submiteQuality(QualityVo qualVO);
	
	
	/**
	 *@Method Name : selectProd
	 *@date : 2018. 9. 25.
	 *@author : Yoo
	 *@Method 설명 : 생산품 전체 검색
	 *@return
	 */
	public List<ProductionVo> selectProd();
	
	
	/**
	 *@Method Name : insertDefective
	 *@date : 2018. 9. 25.
	 *@author : Yoo
	 *@Method 설명 : 불량 등록
	 *@param defectVO
	 *@return
	 */
	public int insertDefective(DefectiveProductVo defectVO);
	
	/**
	 *@Method Name : updateDefective
	 *@date : 2018. 9. 26.
	 *@author : Yoo
	 *@Method 설명 : 불량 수정
	 *@param defectVO
	 *@return
	 */
	public int updateDefective(DefectiveProductVo defectVO);
	
	/**
	 *@Method Name : deleteDefective
	 *@date : 2018. 9. 26.
	 *@author : Yoo
	 *@Method 설명 : 불량 삭제
	 *@param dprodList
	 *@return
	 */
	public int deleteDefective(List<String> dprodList);
	
	/**
	 *@Method Name : deleteProdJournal
	 *@date : 2018. 9. 26.
	 *@author : Yoo
	 *@Method 설명 : 생산일지 삭제
	 *@param journalList
	 *@return
	 */
	public int deleteProdJournal(List<String> journalList);
	
	/**
	 *@Method Name : selectStockCodeList
	 *@date : 2018. 9. 26.
	 *@author : Yoo
	 *@Method 설명 : 생산입고 분류코드명 별 검색
	 *@param stock_code
	 *@return
	 */
	public List<ProductionStockVO> selectStockCodeList(String stock_code);
	
	/**
	 *@Method Name : selectStockDateList
	 *@date : 2018. 9. 26.
	 *@author : Yoo
	 *@Method 설명 : 생산입고 날짜별 검색
	 *@param stock_date
	 *@return
	 */
	public List<ProductionStockVO> selectStockDateList(String stock_date);
	
	/**
	 *@Method Name : selectStockNameList
	 *@date : 2018. 9. 26.
	 *@author : Yoo
	 *@Method 설명 : 생산입고 품목별 검색
	 *@param stock_name
	 *@return
	 */
	public List<ProductionStockVO> selectStockNameList(String stock_name);
	
	
	/**
	 *@Method Name : selectJournalCodeList
	 *@date : 2018. 9. 26.
	 *@author : Yoo
	 *@Method 설명 : 생산일지 상품명 별 검색
	 *@param journal_code
	 *@return
	 */
	public List<ProductionJournalVO> selectJournalCodeList(String journal_code);
	
	/**
	 *@Method Name : selectJournalDateList
	 *@date : 2018. 9. 26.
	 *@author : Yoo
	 *@Method 설명 : 생산날짜별 생산일지 검색
	 *@param journal_date
	 *@return
	 */
	public List<ProductionJournalVO> selectJournalDateList(String journal_date);
	
	
	/**
	 *@Method Name : selectQualityNameList
	 *@date : 2018. 9. 26.
	 *@author : Yoo
	 *@Method 설명 : 품질검사 상품명별 검색
	 *@param prod_name
	 *@return
	 */
	public List<QualityInspectionVO> selectQualityNameList(String prod_name);
	
	/**
	 *@Method Name : selectQualityDateList
	 *@date : 2018. 9. 26.
	 *@author : Yoo
	 *@Method 설명 : 품질검사 검사날짜별 검색
	 *@param qual_date
	 *@return
	 */
	public List<QualityInspectionVO> selectQualityDateList(String qual_date);
	
	/**
	 *@Method Name : selectQualityLevelList
	 *@date : 2018. 9. 26.
	 *@author : Yoo
	 *@Method 설명 : 품질검사 등급별 검색
	 *@param qual_level
	 *@return
	 */
	public List<QualityInspectionVO> selectQualityLevelList(int qual_level);
	
	/**
	 *@Method Name : selectDefectNameList
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 불량관리 상품명별 검색
	 *@param prod_name
	 *@return
	 */
	public List<DefectiveVO> selectDefectNameList(String prod_name);
	
	/**
	 *@Method Name : selectDefectDateList
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 불량관리 생산날짜별 검색
	 *@param qual_date
	 *@return
	 */
	public List<DefectiveVO> selectDefectDateList(String prod_date);
	
	
	/**
	 *@Method Name : selectDefectLevelList
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 불량관리 등급별 검색
	 *@param qual_level
	 *@return
	 */
	public List<DefectiveVO> selectDefectLevelList(int qual_level);
	
	
	/**
	 *@Method Name : selectMachineNameList
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 기기관리 기기명별 검색
	 *@param mach_name
	 *@return
	 */
	public List<ProductionMachineVO> selectMachineNameList(String mach_name);
	
	
	/**
	 *@Method Name : selectMachineDateList
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 기기관리 입고날짜별 검색
	 *@param mach_date
	 *@return
	 */
	public List<ProductionMachineVO> selectMachineDateList(String mach_date);
	
	/**
	 *@Method Name : selectMachineBuyer
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 기기관리 거래처별 검색
	 *@param buyer_name
	 *@return
	 */
	public List<ProductionMachineVO> selectMachineBuyer(String buyer_name);
	
	
	/**
	 *@Method Name : updateProdJournal
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 생산일지 수정
	 *@param prodVO
	 *@return
	 */
	public int updateProdJournal(ProductionVo prodVO);
	
	
	/**
	 *@Method Name : selectEmployee
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 생산부 직원 리스트 검색
	 *@return
	 */
	public List<EmployeeVo> selectEmployee();
	
	
	public List<AssistantVO> selectAssistant();
	
	public List<MachineVO> selectMachineList();
	
	
	public int insertProduction(ProductionVo productionVo);
	
	/**
	 *@Method Name : selectProd
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 조건에 맞는 상품 검색
	 *@param prod_code
	 *@return
	 */
	public ProductionVo selectProd(String prod_code);
	
	/**
	 *@Method Name : insertSales
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 판매등록
	 *@param sales
	 *@return
	 */
	public int insertSales(SaleVO sales);
	
	
	/**
	 *@Method Name : selectSale
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 매출 전체 검색
	 *@return
	 */
	public List<SaleVO> selectSale();
	
	
	/**
	 *@Method Name : updateSales
	 *@date : 2018. 9. 27.
	 *@author : Yoo
	 *@Method 설명 : 매출 수정
	 *@param sales
	 *@return
	 */
	public int updateSales(SaleVO sales);
	
	/**
	 *@Method Name : deleteSales
	 *@date : 2018. 9. 28.
	 *@author : Yoo
	 *@Method 설명 : 매출 삭제
	 *@param prod_code
	 *@return
	 */
	public int deleteSales(List<String> prod_code);
	
	
	/**
	 *@Method Name : selectProdNameSales
	 *@date : 2018. 9. 28.
	 *@author : Yoo
	 *@Method 설명 : 상품명에 따른 매출 검색
	 *@param prod_name
	 *@return
	 */
	public List<SaleVO> selectProdNameSales(String prod_name);
	
	/**
	 *@Method Name : selectprodDateSales
	 *@date : 2018. 9. 28.
	 *@author : Yoo
	 *@Method 설명 : 상품날짜에 따른 매출 검색
	 *@param prod_date
	 *@return
	 */
	public List<SaleVO> selectprodDateSales(String prod_date);
	
	/**
	 *@Method Name : selectProdLevel
	 *@date : 2018. 9. 28.
	 *@author : Yoo
	 *@Method 설명 : 1-2등급 상품 검색
	 *@return
	 */
	public List<ProductionVo> selectProdLevel();
	
	/**
	 *@Method Name : selectProdQty
	 *@date : 2018. 9. 29.
	 *@author : Yoo
	 *@Method 설명 : 해당 상품에대한 수량 검색
	 *@param prod_code
	 *@return
	 */
	public ProductionVo selectProdQty(String prod_code);
}
