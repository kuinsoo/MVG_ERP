package outsourcing.service;


import outsourcing.dao.IOutsourcingDao;
import outsourcing.dao.OutsourcingDao;
import outsourcing.vo.AccountVo;
import outsourcing.vo.ContractVo;
import outsourcing.vo.ImportVo;
import outsourcing.vo.PlanningVo;
import outsourcing.vo.ScheduleMovieVo;
import outsourcing.vo.SchedulePlanVo;
import outsourcing.vo.ScheduleVo;
import outsourcing.vo.StatementVo;

import java.util.List;
import java.util.Map;


public class OutsourcingService implements IOutsourcingService {

    private IOutsourcingDao dao;
    private static OutsourcingService service;

    private OutsourcingService() {
        dao = OutsourcingDao.getInstance();
    }

    public static OutsourcingService getInstance() {
        if(service == null) {
            service = new OutsourcingService();
        }
        return service;
    }

    @Override
    public List<PlanningVo> getAllPlanning() {
        return dao.getAllPlanning();
    }

    @Override
    public List<PlanningVo> getPlanningList(Map<String, String> planVo) {
        return dao.getPlanningList(planVo);
    }

    @Override
    public List<ContractVo> getAllContract() {
        return dao.getAllContract();
    }

    @Override
    public List<ContractVo> getContract(Map<String, String> contVo) {
        return dao.getContract(contVo);
    }
    
    @Override
	public int insertContract(ContractVo contVo) {
		return dao.insertContract(contVo);
	}

	@Override
	public List<AccountVo> getAllAccount() {
		return dao.getAllAccount();
	}

	@Override
	public AccountVo getAccount(String acc) {
		return dao.getAccount(acc);
	}

	@Override
	public List<ScheduleVo> getAllSchedule() {
		return dao.getAllSchedule();
	}

	@Override
	public ScheduleVo getSchedule(String sche) {
		return dao.getSchedule(sche);
	}

	@Override
	public List<ImportVo> getImport() {
		return dao.getImport();
	}

	@Override
	public List<ImportVo> getImport(Map<String, String> impoVo) {
		return dao.getImport(impoVo);
	}

	@Override
	public List<StatementVo> getStatement() {
		return dao.getStatement();
	}

	@Override
	public int updatePlannig(Map<String, String> planVo) {
		return dao.updatePlanning(planVo);
	}

	@Override
	public int insertPlanning(PlanningVo planVo) {
		return dao.insertPlanning(planVo);
	}

	@Override
	public int deletePlan(List<String> plan_no) {
		return dao.deletePlan(plan_no);
	}

	@Override
	public List<SchedulePlanVo> searchSchPlan() {
		// TODO Auto-generated method stub
		return dao.searchSchPlan();
	}

	@Override
	public int insertSchPlan(Map<String, String> schMap) {
		// TODO Auto-generated method stub
		return dao.insertSchPlan(schMap);
	}

	@Override
	public int deleteCont(List<String> cont_no) {
		return dao.deleteCont(cont_no);
	}

	@Override
	public int updateContract(Map<String, String> contVo) {
		return dao.updateContract(contVo);
	}

	@Override
	public List<StatementVo> getStatement(Map<String, String> stateVo) {
		return dao.getStatement(stateVo);
	}

	@Override
	public int addSchedule(ScheduleVo schVo) {
		// TODO Auto-generated method stub
		return dao.addSchedule(schVo);
	}

	@Override
	public int deleteSchedule(String sch_no) {
		// TODO Auto-generated method stub
		return dao.deleteSchedule(sch_no);
	}

	@Override
	public List<ScheduleMovieVo> locationDateSchMoive(String localSch) {
		// TODO Auto-generated method stub
		return dao.locationDateSchMoive(localSch);
	}

	@Override
	public List<String> getMDOemp() {
		return dao.getMDOemp();
	}

	@Override
	public String getAccCode(String acc_name) {
		return dao.getAccCode(acc_name);
	}

	@Override
	public List<ScheduleMovieVo> allSchMoive() {
		// TODO Auto-generated method stub
		return dao.allSchMoive();
	}

	

	


}
