package systemAdministration.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import systemAdministration.dao.ISystemAdministrationDao;
import systemAdministration.vo.AccountVo;
import systemAdministration.vo.BuyerVo;
import systemAdministration.vo.CodeRequestVo;
import systemAdministration.vo.DepartmentVo;
import systemAdministration.vo.MaterialCateVo;
import systemAdministration.vo.PositionVo;
import systemAdministration.vo.join.CodeRequest_DepartmentVo;

/**
 * 시스템 관리자 dao
 * @author Sohyoung
 * @since 2018.09.14
 */
public class SystemAdministrationDao implements ISystemAdministrationDao {
	
	//싱글톤 작업
	private static SystemAdministrationDao dao;
	
	//DB 연동 준비
	SqlMapClient smc;
	
	private SystemAdministrationDao() {
		try {
			Reader rd = Resources.getResourceAsReader("resources/sqlMap/sqlMapConfig.xml");
			
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
			
		} catch (IOException e) {
			System.out.println("SystemAdministrationDao -> sqlMapconfing연결 ERROR :" + e);
		}
	}
	
	/**
	 *@Method Name : getInstance
	 *@date : 2018. 9. 14.
	 *@author : Sohyoung
	 *@Method 설명 : 싱글톤 작업2
	 *@return
	 */
	public static SystemAdministrationDao getInstance(){
		if(dao == null) {
			dao = new SystemAdministrationDao();
		}
		return dao;
	}

	@Override
	public List<CodeRequest_DepartmentVo> allCodeRequestsList() {
		List<CodeRequest_DepartmentVo> codeRequestDeptVoList = null;
		try {
			codeRequestDeptVoList = smc.queryForList("sys.getAllCodeRequestDeptVoList");
			
		}catch (SQLException e) {
			codeRequestDeptVoList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao allCodeRequestsList ERROR => " + e);
		}
		
		return codeRequestDeptVoList;
	}

	@Override
	public int deleteCodeRequests(List<String> crq_no) {
		int result = 0;
		try {
			result = smc.delete("sys.deleteCodeRequests", crq_no);
		} catch (SQLException e) {
			result=0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao deleteCodeRequests ERROR => " + e);
		}
		return result;
	}

	@Override
	public int updateCodeRequest(CodeRequestVo codeRequestVo) {
		int result = 0;
		try {
			result = smc.update("sys.updateCodeRequest",codeRequestVo);
			
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao updateCodeRequest ERROR => " + e);
		}
		return result;
	}
	
	@Override
	public List<CodeRequest_DepartmentVo> searchCodeRequests(Map<String, String> codeR) {
		List<CodeRequest_DepartmentVo> resultList;
		try {
			resultList = smc.queryForList("sys.searchCodeRequests", codeR);
			
		} catch (SQLException e) {
			resultList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao searchCodeRequests ERROR => " + e);
		}
		return resultList;
	}
	
	@Override
	public List<CodeRequest_DepartmentVo> searchAllCodeRequests(String codeR) {
		List<CodeRequest_DepartmentVo> resultList;
		try {
			resultList = smc.queryForList("sys.searchAllCodeRequests", codeR);
			
		} catch (SQLException e) {
			resultList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao searchAllCodeRequests ERROR => " + e);
		}
		return resultList;
	}

	@Override
	public List<PositionVo> allPositionsList() {
		List<PositionVo> positionVoList = null;
		try {
			positionVoList = smc.queryForList("sys.getAllPostionsList");
			
		}catch (SQLException e) {
			positionVoList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao allPositionsList ERROR => " + e);
		}
		return positionVoList;
	}

	@Override
	public int insertPosition(PositionVo positionVo) {
		int result = 0;
		try {
			result = smc.update("sys.insertPosition",positionVo);
			
		} catch (SQLException e) {
			result= 0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao insertPosition ERROR => " + e);
		}
		return result;
	}

	@Override
	public int deletePositions(List<String> pos_code) {
		int result = 0;
		try {
			result = smc.delete("sys.deletePositions", pos_code);
		} catch (SQLException e) {
			result=0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao deletePositions ERROR => " + e);
		}
		return result;
	}

	@Override
	public int updatePosition(PositionVo positionVo) {
		int result = 0;
		try {
			result = smc.update("sys.updatePosition",positionVo);
			
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao updatePosition ERROR => " + e);
		}
		return result;
	}

	@Override
	public List<DepartmentVo> allDepartmentsList() {
		List<DepartmentVo> departmentVoList = null;
		try {
			departmentVoList = smc.queryForList("sys.getAllDepartmentsList");
			
		}catch (SQLException e) {
			departmentVoList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao allDepartmentsList ERROR => " + e);
		}
		return departmentVoList;
	}

	@Override
	public int insertDepartment(DepartmentVo departmentVo) {
		int result = 0;
		try {
			result = smc.update("sys.insertDepartment",departmentVo);
			
		} catch (SQLException e) {
			result= 0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao insertDepartment ERROR => " + e);
		}
		return result;
	}

	@Override
	public int deleteDepartments(List<String> dept_code) {
		int result = 0;
		try {
			result = smc.delete("sys.deleteDepartments", dept_code);
		} catch (SQLException e) {
			result=0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao deleteDepartments ERROR => " + e);
		}
		return result;
	}

	@Override
	public int updateDepartment(DepartmentVo departmentVo) {
		int result = 0;
		try {
			result = smc.update("sys.updateDepartment",departmentVo);
			
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao updateDepartments ERROR => " + e);
		}
		return result;
	}

	@Override
	public List<AccountVo> allAccountsList() {
		List<AccountVo> accountVoList = null;
		try {
			accountVoList = smc.queryForList("sys.getAllAccountsList");
			
		}catch (SQLException e) {
			accountVoList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao allAccountsList ERROR => " + e);
		}
		return accountVoList;
	}

	@Override
	public int insertAccount(AccountVo accountVo) {
		int result = 0;
		try {
			result = smc.update("sys.insertAccount",accountVo);
			
		} catch (SQLException e) {
			result= 0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao insertAccount ERROR => " + e);
		}
		return result;
	}

	@Override
	public int deleteAccounts(List<String> acc) {
		int result = 0;
		try {
			result = smc.delete("sys.deleteAccounts", acc);
		} catch (SQLException e) {
			result=0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao deleteAccounts ERROR => " + e);
		}
		return result;
	}

	@Override
	public int updateAccount(AccountVo accountVo) {
		int result = 0;
		try {
			result = smc.update("sys.updateAccount",accountVo);
			
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao updateAccount ERROR => " + e);
		}
		return result;
	}
	
	@Override
	public List<AccountVo> searchAccounts(Map<String, String> acc) {
		List<AccountVo> resultList;
		try {
			resultList = smc.queryForList("sys.searchAccounts", acc);
			
		} catch (SQLException e) {
			resultList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao searchAccounts ERROR => " + e);
		}
		return resultList;
	}
	
	@Override
	public List<AccountVo> searchAllAccounts(String acc) {
		List<AccountVo> resultList;
		try {
			resultList = smc.queryForList("sys.searchAllAccounts", acc);
		} catch (SQLException e) {
			resultList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao searchAllAccounts ERROR => " + e);
		}
		return resultList;
	}

	@Override
	public List<MaterialCateVo> allMaterialCatesList() {
		List<MaterialCateVo> materialCateVoList = null;
		try {
			materialCateVoList = smc.queryForList("sys.getAllMaterialCatesList");
			
		}catch (SQLException e) {
			materialCateVoList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao allMaterialCatesList ERROR => " + e);
		}
		return materialCateVoList;
	}

	@Override
	public int insertMaterialCate(MaterialCateVo materialCateVo) {
		int result = 0;
		try {
			result = smc.update("sys.insertMaterialCate",materialCateVo);
			
		} catch (SQLException e) {
			result= 0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao insertMaterialCate ERROR => " + e);
		}
		return result;
	}

	@Override
	public int deleteMaterialCates(List<String> mat) {
		int result = 0;
		try {
			result = smc.delete("sys.deleteMaterialCates", mat);
		} catch (SQLException e) {
			result=0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao deleteMaterialCates ERROR => " + e);
		}
		return result;
	}

	@Override
	public int updateMaterialCate(MaterialCateVo materialCateVo) {
		int result = 0;
		try {
			result = smc.update("sys.updateMaterialCate",materialCateVo);
			
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao updateMaterialCate ERROR => " + e);
		}
		return result;
	}
	
	@Override
	public List<MaterialCateVo> searchMaterialCates(Map<String, String> matC) {
		List<MaterialCateVo> resultList;
		try {
			resultList = smc.queryForList("sys.searchMaterialCates", matC);
			
		} catch (SQLException e) {
			resultList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao searchMaterialCates ERROR => " + e);
		}
		return resultList;
	}
	
	@Override
	public List<MaterialCateVo> searchAllMaterialCates(String matc) {
		List<MaterialCateVo> resultList;
		try {
			resultList = smc.queryForList("sys.searchAllMaterialCates",matc);
			
		} catch (SQLException e) {
			resultList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao searchAllMaterialCates ERROR => " + e);
		}
		return resultList;
	}
	
	@Override
	public List<BuyerVo> allBuyersList() {
		List<BuyerVo> buyerVoList = null;
		try {
			buyerVoList = smc.queryForList("sys.getAllBuyersList");
			
		}catch (SQLException e) {
			buyerVoList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao allBuyersList ERROR => " + e);
		}
		return buyerVoList;
	}

	@Override
	public int insertBuyer(BuyerVo buyerVo) {
		int result = 0;
		try {
			result = smc.update("sys.insertBuyer",buyerVo);
			
		} catch (SQLException e) {
			result= 0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao insertBuyer ERROR => " + e);
		}
		return result;
	}

	@Override
	public int deleteBuyers(List<String> buyer) {
		int result = 0;
		try {
			result = smc.delete("sys.deleteBuyers", buyer);
		} catch (SQLException e) {
			result=0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao deleteBuyers ERROR => " + e);
		}
		return result;
	}

	@Override
	public int updateBuyer(BuyerVo buyerVo) {
		int result = 0;
		try {
			result = smc.update("sys.updateBuyer",buyerVo);
			
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao updateBuyer ERROR => " + e);
		}
		return result;
	}

	@Override
	public List<BuyerVo> searchBuyers(Map<String, String> buyer) {
		List<BuyerVo> resultList;
		try {
			resultList = smc.queryForList("sys.searchBuyers", buyer);
			
		} catch (SQLException e) {
			resultList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao searchBuyers ERROR => " + e);
		}
		return resultList;
	}

	@Override
	public List<BuyerVo> searchAllBuyers(String buyer) {
		List<BuyerVo> resultList;
		try {
			resultList = smc.queryForList("sys.searchAllBuyers",buyer);
			
		} catch (SQLException e) {
			resultList = null;
			e.printStackTrace();
			System.out.println("SystemAdministrationDao searchAllBuyers ERROR => " + e);
		}
		return resultList;
	}


	

	
	
}
