package production.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.openmbean.TabularType;

import org.apache.pdfbox.jbig2.segments.SymbolDictionary;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import humanResources.vo.EmployeeVo;
import javafx.scene.control.CheckBox;
import material.vo.AssistantVo;
import oracle.net.aso.n;
import oracle.net.aso.p;
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

public class ProductionDao implements IProductionDao {
	private static ProductionDao dao;
	private SqlMapClient smc;
	
	private ProductionDao () {
		try {
			Reader reader = Resources.getResourceAsReader("resources/sqlMap/sqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			System.out.println("ProductionDao" + e);
		}
	}
	
	
	public static ProductionDao getInstance() {
		if(dao == null) {
			dao = new ProductionDao();
		}
		return dao;
	}
	
	
	@Override
	public List<ProductionVo> getAllProd() {
		  List<ProductionVo> prodList = null;
		    try {
		    	prodList = smc.queryForList("prod.getAllProdcution");
		    } catch (SQLException e) {
		      System.out.println("getAllProd" + e);
		    }
		    return prodList;
	}

	@Override
	public ProductionVo getProd() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<ProductionStockVO> getAllProduction() {
		// TODO Auto-generated method stub
		List<ProductionStockVO> stockList = null;
		try {
			stockList = smc.queryForList("prod.getProductionStock");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("DAO => getAllProdcution() 생산입고 전체출력" + e);
		}
		
		for(ProductionStockVO stockVO : stockList) {
			stockVO.setCheckBox(new CheckBox());
		}
		return stockList;
	}

	@Override
	public List<ProductionJournalVO> getProductionJournal() {
		// TODO Auto-generated method stub
			List<ProductionJournalVO> journaList = null;
			try {
				journaList = smc.queryForList("prod.getProductionJournal");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("DAO => getProductionJournal() 생산일지 전체 출력" + e);
			}
			
			for(ProductionJournalVO journalVO : journaList) {
				System.out.println(journalVO.getProd_code());
				journalVO.setCheckBox(new CheckBox());
			}
		return journaList;
	}

	@Override
	public List<QualityInspectionVO> getQuailtyInspecton() {
		// TODO Auto-generated method stub
		List<QualityInspectionVO> qualList = null;
		try {
			qualList = smc.queryForList("prod.getQualityInspection");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DAO => getQualityInspection() 품질 관리 전체 출력 " + e);
		}
		
		for(QualityInspectionVO qualityVo : qualList) {
			qualityVo.setCheckBox(new CheckBox());
		}
		
		
		
		return qualList;
	}

	@Override
	public List<DefectiveVO> getDefectiveProduction() {
		// TODO Auto-generated method stub
		List<DefectiveVO> defectList = null;
		try {
			defectList = smc.queryForList("prod.getDefectiveProduction");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DAO => getDefectiveProduction" + e);
		}
		
		for(DefectiveVO defectiveVO : defectList) {
			defectiveVO.setCheckBox(new CheckBox());
		}
		
		return defectList;
	}

	@Override
	public List<ProductionMachineVO> getProductionMachine() {
		// TODO Auto-generated method stub
		List<ProductionMachineVO> machineList = null;
		try {
			machineList = smc.queryForList("prod.getMachineManageList");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DAO => getMachineManageList " + e);
		}
		for(ProductionMachineVO machVo : machineList) {
			machVo.setChk(new CheckBox());
		}
		return machineList;
	}

	@Override
	public int insertProduction(AssistantVo assistantVo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.update("prod.insertProduction", assistantVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			cnt = 0;
			System.out.println("DAO => insertProduction ERROR " + e);
		}
		return cnt;
	}

	@Override
	public List<BuyerVO> getBuyerList() {
		// TODO Auto-generated method stub
		List<BuyerVO> buyer = null; 
		try {
			buyer = smc.queryForList("prod.getBuyerList");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DAO => BuyerList  ERROR" + e);
		}
		return buyer;
	}

	@Override
	public int insertMahcine(MachineVO machineVo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.update("prod.insertMachine",machineVo);
		} catch (Exception e) {
			// TODO: handle exception
			cnt = 0;
			System.out.println("DAO => insertMachine ERROR" + e);
		}
		
		
		return cnt;
	}

	@Override
	public int deleteMachine(List<String> machList) {
		// TODO Auto-generated method stub
		int cnt = 0 ;
		try {
			cnt = smc.delete("prod.deleteMachinProd", machList);
		} catch (Exception e) {
			// TODO: handle exception
			cnt =0;
			System.out.println("DAO => deleteMachine ERROR" + e);
		}
		
		return cnt;
	}

	@Override
	public int updateMachine(MachineVO machVO) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.update("prod.updateMatchProd", machVO);
		} catch (Exception e) {
			cnt = 0;
			System.out.println("DAO => updateMachine ERROR" + e);
			// TODO: handle exception
		}
		
		return cnt;
	}

	@Override
	public int updateQuality(QualityVo qualVO) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.update("prod.updateQuality",qualVO);
		} catch (Exception e) {
			// TODO: handle exception
			cnt =0;
			System.out.println("DAO => updateQuality ERROR =>" + e);
		}
		
		
		return cnt;
	}

	@Override
	public int deleteQuality(List<String> qualList) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.delete("prod.deleteQuality", qualList);
		} catch (Exception e) {
			// TODO: handle exception
			cnt = 0;
			System.out.println("DAO ==> deleteQuality ERROR =>" + e);
		}
		return cnt;
	}

	@Override
	public int submiteQuality(QualityVo qualVO) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.update("prod.insertQuality", qualVO);
		} catch (Exception e) {
			// TODO: handle exception
			cnt = 0;
			System.out.println("DAO => insertQuality ERROR =>" + e);
		}
		
		return cnt;
	}

	@Override
	public List<ProductionVo> selectProd() {
		// TODO Auto-generated method stub
		List<ProductionVo> prodList = new ArrayList<>();
		try {
			prodList = smc.queryForList("prod.selectProduction");
		} catch (Exception e) {
			// TODO: handle exception
			prodList = null;
		}
		return prodList;
	}

	@Override
	public int insertDefective(DefectiveProductVo defectVO) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt  = smc.update("prod.insertDefective", defectVO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}

	@Override
	public int updateDefective(DefectiveProductVo defectVO) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.update("prod.updateDefective", defectVO);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DAO => updateDefective ERROR =>" + e);
			cnt = 0;
		}
		
		return cnt;
	}

	@Override
	public int deleteDefective(List<String> dprodList) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.delete("prod.deleteDefective", dprodList);
		} catch (Exception e) {
			// TODO: handle exception
			cnt = 0;
			System.out.println("DAO => deleteDefective ERROR =>" + e);
		}
		return cnt;
	}

	@Override
	public int deleteProdJournal(List<String> journalList) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.delete("prod.deletProdJournal", journalList);
		} catch (Exception e) {
			// TODO: handle exception
			cnt = 0;
			System.out.println("DAO => deleteProdJournal ERROR => "+ e);
		}
		return cnt;
	}

	@Override
	public List<ProductionStockVO> selectStockCodeList(String stock_code) {
		// TODO Auto-generated method stub
		List<ProductionStockVO> stockList = null;
		try {
			stockList = smc.queryForList("prod.ProductionStockCode",stock_code);
		} catch (Exception e) {
			// TODO: handle exception
			stockList = null;
			System.out.println("DAO => selectStockCodeList ERROR => " + e);
		}
		
		for(ProductionStockVO stockVO : stockList){
			stockVO.setCheckBox(new CheckBox());
		}
		
		return stockList;
	}

	@Override
	public List<ProductionStockVO> selectStockDateList(String stock_date) {
		// TODO Auto-generated method stub
		List<ProductionStockVO> stockList = null;
		try {
			stockList = smc.queryForList("prod.ProdcutionStockDate", stock_date);
		} catch (Exception e) {
			// TODO: handle exception
			stockList = null;
			System.out.println("DAO => selectStockDateList ERROR =>" + e);
		}
		
		for(ProductionStockVO stockVO : stockList){
			stockVO.setCheckBox(new CheckBox());
		}
		
		return stockList;
	}

	@Override
	public List<ProductionStockVO> selectStockNameList(String stock_name) {
		// TODO Auto-generated method stub
		List<ProductionStockVO> stockList = null;
		try {
			stockList = smc.queryForList("prod.ProductionStockName", stock_name);
		} catch (Exception e) {
			// TODO: handle exception
			stockList = null;
			System.out.println("DAO => selectStockNameList ERROR => "+ e);
		}
		
		for(ProductionStockVO stockVO : stockList){
			stockVO.setCheckBox(new CheckBox());
		}
		
		return stockList;
	}

	@Override
	public List<ProductionJournalVO> selectJournalCodeList(String journal_code) {
		// TODO Auto-generated method stub
		List<ProductionJournalVO> journalList = null;
		try {
			journalList = smc.queryForList("prod.getProductionJournalCode", journal_code);
		} catch (Exception e) {
			// TODO: handle exception
			journalList = null;
			System.out.println("DAO => selectJournalCodeList ERROR => " +  e);
		}
		
		for(ProductionJournalVO journalVO : journalList ) {
			journalVO.setCheckBox(new CheckBox());
		}
		
		return journalList;
	}

	@Override
	public List<ProductionJournalVO> selectJournalDateList(String journal_date) {
		// TODO Auto-generated method stub
		List<ProductionJournalVO> journalList = null;
		try {
			journalList = smc.queryForList("prod.getProductionJournalDate", journal_date);
		} catch (Exception e) {
			// TODO: handle exception
			journalList = null;
			System.out.println("DAO => selectJournalDateList ERROR => " + e);
		}
		
		for(ProductionJournalVO journalVO : journalList ) {
			journalVO.setCheckBox(new CheckBox());
		}
		
		return journalList;
	}

	@Override
	public List<QualityInspectionVO> selectQualityNameList(String prod_name) {
		// TODO Auto-generated method stub
		List<QualityInspectionVO> qualList = null;
		try {
			qualList = smc.queryForList("prod.selectQualityInspectionName", prod_name);
		} catch (Exception e) {
			// TODO: handle exception
			qualList = null;
			System.out.println("DAO => selectQualityNameList ERROR =>" + e);
		}
		
		for(QualityInspectionVO qualVO : qualList) {
			qualVO.setCheckBox(new CheckBox());
		}
		
		return qualList;
	}

	@Override
	public List<QualityInspectionVO> selectQualityDateList(String qual_date) {
		// TODO Auto-generated method stub
		List<QualityInspectionVO> qualList = null;
		try {
			qualList = smc.queryForList("prod.selectQualityInspectionDate", qual_date);
		} catch (Exception e) {
			// TODO: handle exception
			qualList = null;
			System.out.println("DAO => selectQualityDateList ERROR =>" + e);
		}
		
		for(QualityInspectionVO qualVO : qualList) {
			qualVO.setCheckBox(new CheckBox());
		}
		
		return qualList;
	}

	@Override
	public List<QualityInspectionVO> selectQualityLevelList(int qual_level) {
		// TODO Auto-generated method stub
		List<QualityInspectionVO> qualList = null;
		try {
			qualList = smc.queryForList("prod.selectQualityInspectionLevel", qual_level);
		} catch (Exception e) {
			// TODO: handle exception
			qualList = null;
			System.out.println("DAO => selectQualityLevelList ERROR => " + e);
		}
		
		for(QualityInspectionVO qualVO : qualList) {
			qualVO.setCheckBox(new CheckBox());
		}
		
		return qualList;
	}

	@Override
	public List<DefectiveVO> selectDefectNameList(String prod_name) {
		// TODO Auto-generated method stub
		List<DefectiveVO> defectList = null;
		try {
			defectList = smc.queryForList("prod.selectDefectiveName", prod_name);
		} catch (Exception e) {
			// TODO: handle exception
			defectList = null;
			System.out.println("DAO => defectNameList ERROR => " + e);
		}
		
		for(DefectiveVO defectVO : defectList) {
			defectVO.setCheckBox(new CheckBox());
		}
		
		return defectList;
	}

	@Override
	public List<DefectiveVO> selectDefectDateList(String prod_date) {
		// TODO Auto-generated method stub
		List<DefectiveVO> defectList = null;
		try {
			defectList = smc.queryForList("prod.selectDefectiveDate", prod_date);
		} catch (Exception e) {
			// TODO: handle exception
			defectList = null;
			System.out.println("DAO => selectDefectiveDate ERROR => " + e);
		}
		
		for(DefectiveVO defectVO : defectList) {
			defectVO.setCheckBox(new CheckBox());
		}
		
		return defectList;
	}

	@Override
	public List<DefectiveVO> selectDefectLevelList(int qual_level) {
		// TODO Auto-generated method stub
		List<DefectiveVO> defectList = null;
		try {
			defectList = smc.queryForList("prod.selectDefectiveLevel", qual_level);
		} catch (Exception e) {
			// TODO: handle exception
			defectList = null;
			System.out.println("DAO => selectDefectiveLevel ERROR => " + e);
		}
		
		for(DefectiveVO defectVO : defectList) {
			defectVO.setCheckBox(new CheckBox());
		}
		
		return defectList;
	}

	@Override
	public List<ProductionMachineVO> selectMachineNameList(String mach_name) {
		// TODO Auto-generated method stub
		List<ProductionMachineVO> machList = null;
		try {
			machList = smc.queryForList("prod.selectMachineName", mach_name);
		} catch (Exception e) {
			// TODO: handle exception
			machList = null;
			System.out.println("DAO => selectMachineNameList ERROR => " + e);
		}
		
		for(ProductionMachineVO machVO : machList) {
			machVO.setChk(new CheckBox());
		}
		
		return machList;
	}

	@Override
	public List<ProductionMachineVO> selectMachineDateList(String mach_date) {
		// TODO Auto-generated method stub
		List<ProductionMachineVO> machList = null;
		try {
			machList = smc.queryForList("prod.selectMachineDate", mach_date);
		} catch (Exception e) {
			// TODO: handle exception
			machList = null;
			System.out.println("DAO => selectMachineDate ERROR => " + e);
		}
		
		for(ProductionMachineVO machVO : machList) {
			machVO.setChk(new CheckBox());
		}
		
		return machList;
	}

	@Override
	public List<ProductionMachineVO> selectMachineBuyer(String buyer_name) {
		// TODO Auto-generated method stub
		List<ProductionMachineVO> machList = null;
		try {
			machList = smc.queryForList("prod.selectMachineBuyer", buyer_name);
		} catch (Exception e) {
			// TODO: handle exception
			machList = null;
			System.out.println("DAO => selectMachineBuyer ERROR => " + e);
		}
		
		for(ProductionMachineVO machVO : machList) {
			machVO.setChk(new CheckBox());
		}
		
		return machList;
	}

	@Override
	public int updateProdJournal(ProductionVo prodVO) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.update("prod.updateprodJournal", prodVO);
		} catch (Exception e) {
			// TODO: handle exception
			cnt = 0;
			System.out.println("DAO => updateprodJournal ERROR => " + e);
		}
		return cnt;
	}


	@Override
	public List<EmployeeVo> selectEmployee() {
		// TODO Auto-generated method stub
		List<EmployeeVo> empList = null;
		try {
			empList = smc.queryForList("prod.selectProdEmp");
		} catch (Exception e) {
			// TODO: handle exception
			empList = null;
			System.out.println("DAO => selectEmployee ERROR => " + e);
		}
		return empList;
	}


	@Override
	public List<AssistantVO> selectAssistant() {
		// TODO Auto-generated method stub
		List<AssistantVO> assistantList = null;
		try {
			assistantList = smc.queryForList("prod.selectAssistant");
		} catch (Exception e) {
			// TODO: handle exception
//			assistantList = null;
			System.out.println("DAO => selectAssistant ERROR => " + e);
		}
		return assistantList;
	}


	@Override
	public List<MachineVO> selectMachineList() {
		// TODO Auto-generated method stub
		List<MachineVO> machList = null;
		try {
			machList = smc.queryForList("prod.selectMachine");
		} catch (Exception e) {
			// TODO: handle exception
			machList = null;
			System.out.println("DAO => selectMachineList ERROR => " + e);
		}
		return machList;
	}


	@Override
	public int insertProduction(ProductionVo productionVo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.update("prod.insertJournal",productionVo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}


	@Override
	public ProductionVo selectProd(String prod_code) {
		// TODO Auto-generated method stub
		ProductionVo prod = null;
		try {
			prod = (ProductionVo) smc.queryForObject("prod.prodSelect", prod_code);
		} catch (Exception e) {
			// TODO: handle exception
			prod = null;
			System.out.println("DAO => selectProd ERROR => "+ e );
		}
		return prod;
	}


	@Override
	public int insertSales(SaleVO sales) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.update("prod.prodSales", sales);
		} catch (Exception e) {
			// TODO: handle exception
			cnt = 0;
			System.out.println("DAO => insertSale ERROR => " + e);
		}
		return cnt;
	}


	@Override
	public List<SaleVO> selectSale() {
		// TODO Auto-generated method stub
		List<SaleVO> saleList = null;
		try {
			saleList = smc.queryForList("prod.selectSale");
		} catch (Exception e) {
			// TODO: handle exception
			saleList = null;
			System.out.println("DAO => selectSale ERROR => " + e);
		}
		
		for(SaleVO saleVO : saleList) {
			saleVO.setCheckBox(new CheckBox());
		}
		
		return saleList;
	}


	@Override
	public int updateSales(SaleVO sales) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.update("prod.updateSale", sales);
		} catch (Exception e) {
			// TODO: handle exception
			cnt = 0;
			System.out.println("DAO => updateSales ERROR => " + e);
		}
		return cnt;
	}


	@Override
	public int deleteSales(List<String> prod_code) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.delete("prod.deleteSale", prod_code);
		} catch (Exception e) {
			// TODO: handle exception
			cnt = 0;
			System.out.println("DAO => deleteSales ERROR => " + e);
		}
		return cnt;
	}


	@Override
	public List<SaleVO> selectProdNameSales(String prod_name) {
		// TODO Auto-generated method stub
		List<SaleVO> saleList = null;
		try {
			saleList = smc.queryForList("prod.selectSalesName", prod_name);
		} catch (Exception e) {
			// TODO: handle exception
			saleList = null;
			System.out.println("DAO => selectPRodNameSales ERROR => " + e);
		}
		for(SaleVO saleVO : saleList) {
			saleVO.setCheckBox(new CheckBox());
		}
		return saleList;
	}


	@Override
	public List<SaleVO> selectprodDateSales(String prod_date) {
		// TODO Auto-generated method stub
		List<SaleVO> saleList = null;
		try {
			saleList = smc.queryForList("prod.selectSaleDate", prod_date);
		} catch (Exception e) {
			// TODO: handle exception
			saleList = null;
			System.out.println("DAO => selectProdDateSales ERROR => " + e);
		}
		for(SaleVO saleVO : saleList) {
			saleVO.setCheckBox(new CheckBox());
		}
		return saleList;
	}


	@Override
	public List<ProductionVo> selectProdLevel() {
		// TODO Auto-generated method stub
		List<ProductionVo> prodList = null;
		try {
			prodList = smc.queryForList("prod.selectProdlevel");
		} catch (Exception e) {
			// TODO: handle exception
			prodList=null;
		}
		return prodList;
	}


	@Override
	public ProductionVo selectProdQty(String prod_code) {
		// TODO Auto-generated method stub
		ProductionVo prodVO = null;
		try {
			prodVO = (ProductionVo) smc.queryForObject("prod.selectProdQty", prod_code);
		} catch (Exception e) {
			// TODO: handle exception
			prodVO = null;
			System.out.println("DAO => selectProdQty ERROR => " + e);
		}
		return prodVO;
	}
	
	



}
