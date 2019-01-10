package systemAdministration.service;

import java.util.List;
import java.util.Map;

import systemAdministration.dao.ISystemAdministrationDao;
import systemAdministration.dao.SystemAdministrationDao;
import systemAdministration.vo.AccountVo;
import systemAdministration.vo.BuyerVo;
import systemAdministration.vo.CodeRequestVo;
import systemAdministration.vo.DepartmentVo;
import systemAdministration.vo.MaterialCateVo;
import systemAdministration.vo.PositionVo;
import systemAdministration.vo.join.CodeRequest_DepartmentVo;

/**
 * 시스템 관리자 service
 * @author Sohyoung
 * @since 2018.09.14
 */
public class SystemAdministrationService implements ISystemAdministrationService {
	
	//싱글톤 작업
	private static SystemAdministrationService service;
	
	//dao와 연결
	private ISystemAdministrationDao dao;
	
	private SystemAdministrationService() {
		//dao와 연결
		dao = SystemAdministrationDao.getInstance();
	}
	
	/**
	 *@Method Name : getInstance
	 *@date : 2018. 9. 14.
	 *@author : Sohyoung
	 *@Method 설명 : 싱글톤 작업2
	 *@return
	 */
	public static SystemAdministrationService getInstance(){
		if(service == null) {
			service = new SystemAdministrationService();
		}
		return service;
	}

	@Override
	public List<CodeRequest_DepartmentVo> allCodeRequestsList() {
		return dao.allCodeRequestsList();
	}

	@Override
	public int deleteCodeRequests(List<String> crq_no) {
		return dao.deleteCodeRequests(crq_no);
	}

	@Override
	public int updateCodeRequest(CodeRequestVo codeRequestVo) {
		return dao.updateCodeRequest(codeRequestVo);
	}

	@Override
	public List<CodeRequest_DepartmentVo> searchCodeRequests(Map<String, String> codeR) {
		return dao.searchCodeRequests(codeR);
	}
	
	@Override
	public List<CodeRequest_DepartmentVo> searchAllCodeRequests(String codeR) {
		return dao.searchAllCodeRequests(codeR);
	}
	
	@Override
	public List<PositionVo> allPositionsList() {
		return dao.allPositionsList();
	}

	@Override
	public int insertPosition(PositionVo positionVo) {
		return dao.insertPosition(positionVo);
	}

	@Override
	public int deletePositions(List<String> pos_code) {
		return dao.deletePositions(pos_code);
	}

	@Override
	public int updatePosition(PositionVo positionVo) {
		return dao.updatePosition(positionVo);
	}

	@Override
	public List<DepartmentVo> allDepartmentsList() {
		return dao.allDepartmentsList();
	}

	@Override
	public int insertDepartment(DepartmentVo departmentVo) {
		return dao.insertDepartment(departmentVo);
	}

	@Override
	public int deleteDepartments(List<String> dept_code) {
		return dao.deleteDepartments(dept_code);
	}

	@Override
	public int updateDepartment(DepartmentVo departmentVo) {
		return dao.updateDepartment(departmentVo);
	}

	@Override
	public List<AccountVo> allAccountsList() {
		return dao.allAccountsList();
	}

	@Override
	public int insertAccount(AccountVo accountVo) {
		return dao.insertAccount(accountVo);
	}

	@Override
	public int deleteAccounts(List<String> acc) {
		return dao.deleteAccounts(acc);
	}

	@Override
	public int updateAccount(AccountVo accountVo) {
		return dao.updateAccount(accountVo);
	}
	
	@Override
	public List<AccountVo> searchAccounts(Map<String, String> acc) {
		return dao.searchAccounts(acc);
	}
	
	@Override
	public List<AccountVo> searchAllAccounts(String acc) {
		return dao.searchAllAccounts(acc);
	}

	@Override
	public List<MaterialCateVo> allMaterialCatesList() {
		return dao.allMaterialCatesList();
	}

	@Override
	public int insertMaterialCate(MaterialCateVo materialCateVo) {
		return dao.insertMaterialCate(materialCateVo);
	}

	@Override
	public int deleteMaterialCates(List<String> mat) {
		return dao.deleteMaterialCates(mat);
	}

	@Override
	public int updateMaterialCate(MaterialCateVo materialCateVo) {
		return dao.updateMaterialCate(materialCateVo);
	}
	
	@Override
	public List<MaterialCateVo> searchMaterialCates(Map<String, String> matC) {
		return dao.searchMaterialCates(matC);
	}
	
	@Override
	public List<MaterialCateVo> searchAllMaterialCates(String matc) {
		return dao.searchAllMaterialCates(matc);
	}
	
	@Override
	public List<BuyerVo> allBuyersList() {
		return dao.allBuyersList();
	}

	@Override
	public int insertBuyer(BuyerVo buyerVo) {
		return dao.insertBuyer(buyerVo);
	}

	@Override
	public int deleteBuyers(List<String> buyer) {
		return dao.deleteBuyers(buyer);
	}

	@Override
	public int updateBuyer(BuyerVo buyerVo) {
		return dao.updateBuyer(buyerVo);
	}

	@Override
	public List<BuyerVo> searchBuyers(Map<String, String> buyer) {
		return dao.searchBuyers(buyer);
	}

	@Override
	public List<BuyerVo> searchAllBuyers(String buyer) {
		return dao.searchAllBuyers(buyer);
	}

	

	

	
	
}
