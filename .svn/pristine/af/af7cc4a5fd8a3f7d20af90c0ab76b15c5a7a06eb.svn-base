package production.service;

import java.util.List;

import humanResources.vo.EmployeeVo;
import material.vo.AssistantVo;
import production.dao.IProductionDao;
import production.dao.ProductionDao;
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

public class ProductionService implements IProductionService {
	private IProductionDao dao;
	private static ProductionService service;
	
	private ProductionService() {
		dao = ProductionDao.getInstance();
	}
	
	public static ProductionService getInstance() {
		if(service == null ) {
			service = new ProductionService();
		}
		return service;
	}
	@Override
	public List<ProductionVo> getAllProd() {
		// TODO Auto-generated method stub
		return dao.getAllProd();
	}

	@Override
	public ProductionVo getProd() {
		// TODO Auto-generated method stub
		return dao.getProd();
	}

	@Override
	public List<ProductionStockVO> getAllProduction() {
		// TODO Auto-generated method stub
		return dao.getAllProduction();
	}

	@Override
	public List<ProductionJournalVO> getProductionJournal() {
		// TODO Auto-generated method stub
		return dao.getProductionJournal();
	}

	@Override
	public List<QualityInspectionVO> getQuailtyInspecton() {
		// TODO Auto-generated method stub
		return dao.getQuailtyInspecton();
	}

	@Override
	public List<DefectiveVO> getDefectiveProduction() {
		// TODO Auto-generated method stub
		return dao.getDefectiveProduction();
	}

	@Override
	public List<ProductionMachineVO> getProductionMachine() {
		// TODO Auto-generated method stub
		return dao.getProductionMachine();
	}

	@Override
	public int insertProduction(AssistantVo assistantVo) {
		// TODO Auto-generated method stub
		return dao.insertProduction(assistantVo);
	}

	@Override
	public List<BuyerVO> getBuyerList() {
		// TODO Auto-generated method stub
		return dao.getBuyerList();
	}

	@Override
	public int insertMahcine(MachineVO machineVo) {
		// TODO Auto-generated method stub
		return dao.insertMahcine(machineVo);
	}

	@Override
	public int deleteMachine(List<String> machList) {
		// TODO Auto-generated method stub
		return dao.deleteMachine(machList);
	}

	@Override
	public int updateMachine(MachineVO machVO) {
		// TODO Auto-generated method stub
		return dao.updateMachine(machVO);
	}

	@Override
	public int updateQuality(QualityVo qualVO) {
		// TODO Auto-generated method stub
		return dao.updateQuality(qualVO);
	}

	@Override
	public int deleteQuality(List<String> qualList) {
		// TODO Auto-generated method stub
		return dao.deleteQuality(qualList);
	}

	@Override
	public int submiteQuality(QualityVo qualVO) {
		// TODO Auto-generated method stub
		return dao.submiteQuality(qualVO);
	}

	@Override
	public List<ProductionVo> selectProd() {
		// TODO Auto-generated method stub
		return dao.selectProd();
	}

	@Override
	public int insertDefective(DefectiveProductVo defectVO) {
		// TODO Auto-generated method stub
		return dao.insertDefective(defectVO);
	}

	@Override
	public int updateDefective(DefectiveProductVo defectVO) {
		// TODO Auto-generated method stub
		return dao.updateDefective(defectVO);
	}

	@Override
	public int deleteDefective(List<String> dprodList) {
		// TODO Auto-generated method stub
		return dao.deleteDefective(dprodList);
	}

	@Override
	public int deleteProdJournal(List<String> journalList) {
		// TODO Auto-generated method stub
		return dao.deleteProdJournal(journalList);
	}

	@Override
	public List<ProductionStockVO> selectStockCodeList(String stock_code) {
		// TODO Auto-generated method stub
		return dao.selectStockCodeList(stock_code);
	}

	@Override
	public List<ProductionStockVO> selectStockDateList(String stock_date) {
		// TODO Auto-generated method stub
		return dao.selectStockDateList(stock_date);
	}

	@Override
	public List<ProductionStockVO> selectStockNameList(String stock_name) {
		// TODO Auto-generated method stub
		return dao.selectStockNameList(stock_name);
	}

	@Override
	public List<ProductionJournalVO> selectJournalCodeList(String journal_code) {
		// TODO Auto-generated method stub
		return dao.selectJournalCodeList(journal_code);
	}

	@Override
	public List<ProductionJournalVO> selectJournalDateList(String journal_date) {
		// TODO Auto-generated method stub
		return dao.selectJournalDateList(journal_date);
	}

	@Override
	public List<QualityInspectionVO> selectQualityNameList(String prod_name) {
		// TODO Auto-generated method stub
		return dao.selectQualityNameList(prod_name);
	}

	@Override
	public List<QualityInspectionVO> selectQualityDateList(String qual_date) {
		// TODO Auto-generated method stub
		return dao.selectQualityDateList(qual_date);
	}

	@Override
	public List<QualityInspectionVO> selectQualityLevelList(int qual_level) {
		// TODO Auto-generated method stub
		return dao.selectQualityLevelList(qual_level);
	}

	@Override
	public List<DefectiveVO> selectDefectNameList(String prod_name) {
		// TODO Auto-generated method stub
		return dao.selectDefectNameList(prod_name);
	}

	@Override
	public List<DefectiveVO> selectDefectDateList(String prod_date) {
		// TODO Auto-generated method stub
		return dao.selectDefectDateList(prod_date);
	}

	@Override
	public List<DefectiveVO> selectDefectLevelList(int qual_level) {
		// TODO Auto-generated method stub
		return dao.selectDefectLevelList(qual_level);
	}

	@Override
	public List<ProductionMachineVO> selectMachineNameList(String mach_name) {
		// TODO Auto-generated method stub
		return dao.selectMachineNameList(mach_name);
	}

	@Override
	public List<ProductionMachineVO> selectMachineDateList(String mach_date) {
		// TODO Auto-generated method stub
		return dao.selectMachineDateList(mach_date);
	}

	@Override
	public List<ProductionMachineVO> selectMachineBuyer(String buyer_name) {
		// TODO Auto-generated method stub
		return dao.selectMachineBuyer(buyer_name);
	}

	@Override
	public int updateProdJournal(ProductionVo prodVO) {
		// TODO Auto-generated method stub
		return dao.updateProdJournal(prodVO);
	}

	@Override
	public List<EmployeeVo> selectEmployee() {
		// TODO Auto-generated method stub
		return dao.selectEmployee();
	}

	@Override
	public List<AssistantVO> selectAssistant() {
		// TODO Auto-generated method stub
		return dao.selectAssistant();
	}

	@Override
	public List<MachineVO> selectMachineList() {
		// TODO Auto-generated method stub
		return dao.selectMachineList();
	}

	@Override
	public int insertProduction(ProductionVo productionVo) {
		// TODO Auto-generated method stub
		return dao.insertProduction(productionVo);
	}

	@Override
	public ProductionVo selectProd(String prod_code) {
		// TODO Auto-generated method stub
		return dao.selectProd(prod_code);
	}

	@Override
	public int insertSales(SaleVO sales) {
		// TODO Auto-generated method stub
		return dao.insertSales(sales);
	}

	@Override
	public List<SaleVO> selectSale() {
		// TODO Auto-generated method stub
		return dao.selectSale();
	}

	@Override
	public int updateSales(SaleVO sales) {
		// TODO Auto-generated method stub
		return dao.updateSales(sales);
	}

	@Override
	public int deleteSales(List<String> prod_code) {
		// TODO Auto-generated method stub
		return dao.deleteSales(prod_code);
	}

	@Override
	public List<SaleVO> selectProdNameSales(String prod_name) {
		// TODO Auto-generated method stub
		return dao.selectProdNameSales(prod_name);
		
	}

	@Override
	public List<SaleVO> selectprodDateSales(String prod_date) {
		// TODO Auto-generated method stub
		return dao.selectprodDateSales(prod_date);
	}

	@Override
	public List<ProductionVo> selectProdLevel() {
		// TODO Auto-generated method stub
		return dao.selectProdLevel();
	}

	@Override
	public ProductionVo selectProdQty(String prod_code) {
		// TODO Auto-generated method stub
		return dao.selectProdQty(prod_code);
	}


 
}
