package outsourcing.dao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


import javafx.scene.control.CheckBox;


import outsourcing.vo.AccountVo;
import outsourcing.vo.ContractVo;
import outsourcing.vo.ImportVo;
import outsourcing.vo.PlanningVo;
import outsourcing.vo.ScheduleMovieVo;
import outsourcing.vo.SchedulePlanVo;
import outsourcing.vo.ScheduleVo;
import outsourcing.vo.StatementVo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OutsourcingDao implements IOutsourcingDao {
    private static OutsourcingDao outDao;
    private SqlMapClient smc;

    private OutsourcingDao() {
        try {
            Reader rd = Resources.getResourceAsReader("resources/sqlMap/sqlMapConfig.xml");
            smc = SqlMapClientBuilder.buildSqlMapClient(rd);
            rd.close();
        } catch (IOException e) {
            System.out.println("OutsorcingDao" + e);
        }
    }

    /* 싱클톤 */
    public static OutsourcingDao getInstance() {
        if(outDao == null) {
            outDao = new OutsourcingDao();
        }
        return outDao;
    }

    /**
     *@Method Name : getAllPlanning
     *@date : 2018. 9. 19.
     *@author : PDJ
     *@Method 설명 : PlanningVo
     *@param 
     */
    @Override
    public List<PlanningVo> getAllPlanning() {
        List<PlanningVo> planList = null;
        try {
			planList = smc.queryForList("out.getAllPlan");
		} catch (SQLException e) {
			System.out.println("planList" + e);
		}
        for (PlanningVo planningVo : planList) {
 			planningVo.setPlan_chk(new CheckBox());
 		}
        return planList;
    }

    /**
     *@Method Name : getPlanningList
     *@date : 2018. 9. 19.
     *@author : PDJ
     *@Method 설명 : 기획서 검색
     *@param 
     */
    @Override
    public List<PlanningVo> getPlanningList(Map<String, String> planVo) {
    	 List<PlanningVo> planList = null;
         try {
 			planList = smc.queryForList("out.getPlan" , planVo);
 		} catch (SQLException e) {
 			System.out.println("planList" + e);
 		}
         for (PlanningVo planningVo : planList) {
 			planningVo.setPlan_chk(new CheckBox());
 		}
         return planList;
    }
    
    /**
     *@Method Name : updatePlannig
     *@date : 2018. 9. 19.
     *@author : PDJ
     *@Method 설명 : 기획서 수정
     *@param 
     */
	@Override
	public int updatePlanning(Map<String, String> planVo) {
		int cnt = 0;
		try {
			cnt = smc.update("out.updatePlan", planVo);
		}  catch (SQLException e) {
			System.out.println("outDao(updatePlan) " + e);
		}
		return cnt;
	}
	
	/**
     *@Method Name : insertPlanning
     *@date : 2018. 9. 27.
     *@author : PDJ
     *@Method 설명 : 기획서 등록
     *@param 
     */
	@Override
	public int insertPlanning(PlanningVo planVo) {
		int cnt = 0;
		try {
			cnt = smc.update("out.insertPlan", planVo);
		} catch (SQLException e) {
			cnt = 0;
			System.out.println("planDao(insertPlan) " + e);
		}
		return cnt;
	}
	
	/**
     *@Method Name : deletePlan
     *@date : 2018. 9. 27.
     *@author : PDJ
     *@Method 설명 : 기획서 삭제
     *@param 
     */
	@Override
	public int deletePlan(List<String> plan_no) {
		int cnt = 0 ;
		try {
			cnt = smc.delete("out.deletePlan" , plan_no);
		} catch (SQLException e) {
			System.out.println("outDao(deletePlan)" + e);
		}
		return cnt;
	}

    /**
     *@Method Name : getAllContract
     *@date : 2018. 9. 19.
     *@author : PDJ
     *@Method 설명 : ContractVo
     *@param 
     */
    @Override
    public List<ContractVo> getAllContract() {
    	List<ContractVo> contList = null;
        try {
			contList = smc.queryForList("out.getAllCont");
		} catch (SQLException e) {
			System.out.println("contList" + e);
		}
        for (ContractVo contractVo : contList) {
        	contractVo.setCont_chk(new CheckBox());
		}
        return contList;
    }

    @Override
    public List<ContractVo> getContract(Map<String, String> contVo) {
    	List<ContractVo> contList = null;
        try {
        	contList = smc.queryForList("out.getCont" , contVo);
		} catch (SQLException e) {
			System.out.println("contList" + e);
		}
        for (ContractVo contractVo : contList) {
        	contractVo.setCont_chk(new CheckBox());
		}
        return contList;
    }
    
    /**
     *@Method Name : insertContract
     *@date : 2018. 9. 28.
     *@author : PDJ
     *@Method 설명 : ContractVo(계약서 등록)
     *@param 
     */
    @Override
	public int insertContract(ContractVo contVo) {
    	int cnt = 0;
		try {
			cnt = smc.update("out.insertCont", contVo);
		} catch (SQLException e) {
			System.out.println("contDao(insertCont) " + e);
		}
		return cnt;
	}
    
    /**
     *@Method Name : deleteCont
     *@date : 2018. 9. 28.
     *@author : PDJ
     *@Method 설명 : List<String> cont_no(계약서 삭제)
     *@param 
     */
    @Override
	public int deleteCont(List<String> cont_no) {
    	int cnt = 0 ;
		try {
			cnt = smc.delete("out.deleteCont" , cont_no);
		} catch (SQLException e) {
			System.out.println("outDao(deleteCont)" + e);
		}
		return cnt;
	}
    
    /**
     *@Method Name : updateContract
     *@date : 2018. 9. 28.
     *@author : PDJ
     *@Method 설명 : Map<String, String> contVo(계약서 수정)
     *@param 
     */
    @Override
	public int updateContract(Map<String, String> contVo) {
    	int cnt = 0;
		try {
			cnt = smc.update("out.updateCont", contVo);
		}  catch (SQLException e) {
			System.out.println("outDao(updateCont) " + e);
		}
		return cnt;
	}

    
    /**
     *@Method Name : getAllAccount
     *@date : 2018. 9. 19.
     *@author : PDJ
     *@Method 설명 : AccountVo
     *@param 
     */
    @Override
    public List<AccountVo> getAllAccount() {
    	List<AccountVo> accList = null;
        try {
        	accList = smc.queryForList("out.getAllAcc");
		} catch (SQLException e) {
			System.out.println("accList" + e);
		}
        return accList;
    }
    
	@Override
	public AccountVo getAccount(String acc) {
		return null;
	}
	
	/**
     *@Method Name : getAllSchedule
     *@date : 2018. 9. 19.
     *@author : PDJ
     *@Method 설명 : ScheduleVo
     *@param 
     */
    @Override
    public List<ScheduleVo> getAllSchedule() {
    	List<ScheduleVo> scheList = null;
        try {
        	scheList = smc.queryForList("out.getAllSche");
		} catch (SQLException e) {
			System.out.println("scheList" + e);
		}
        return scheList;
    }
    
	@Override
	public ScheduleVo getSchedule(String sche) {
		return null;
	}
	
	/**
     *@Method Name : getImport
     *@date : 2018. 9. 19.
     *@author : PDJ
     *@Method 설명 : ImportVo
     *@param 
     */
    @Override
    public List<ImportVo> getImport() {
    	List<ImportVo> impoList = null;
        try {
        	impoList = smc.queryForList("out.getImport");
		} catch (SQLException e) {
			System.out.println("impoList" + e);
		}
        return impoList;
    }
    
    /**
     *@Method Name : getImport
     *@date : 2018. 9. 28.
     *@author : PDJ
     *@Method 설명 : 수입/지출 계획서 검색
     *@param 
     */
    @Override
	public List<ImportVo> getImport(Map<String, String> impoVo) {
    	List<ImportVo> impoList = null;
        try {
        	impoList = smc.queryForList("out.getImpo" , impoVo);
		} catch (SQLException e) {
			System.out.println("impoList" + e);
		}
        return impoList;
	}
	
	/**
     *@Method Name : getStatement
     *@date : 2018. 9. 19.
     *@author : PDJ
     *@Method 설명 : StatementVo
     *@param 
     */
    @Override
    public List<StatementVo> getStatement() {
    	List<StatementVo> stateList = null;
        try {
        	stateList = smc.queryForList("out.getState1");
		} catch (SQLException e) {
			System.out.println("stateList" + e);
		}
        return stateList;
    }
    
    @Override
	public List<StatementVo> getStatement(Map<String, String> stateVo) {
    	List<StatementVo> stateList = null;
        try {
        	stateList = smc.queryForList("out.getState" , stateVo);
		} catch (SQLException e) {
			System.out.println("stateList" + e);
		}
        return stateList;
	}

	
    /* 스케줄 */
    @Override
	public List<SchedulePlanVo> searchSchPlan() {
		List<SchedulePlanVo> ListshcEmp = null;
		try {
			ListshcEmp = smc.queryForList("schPlan.searchSchPlan");
		} catch (SQLException e) {
			System.out.println("OutDao(searchSchPlan) => " + e);
		}
		
		return ListshcEmp;
	}
	@Override
	public int insertSchPlan(Map<String, String> schMap) {
		int cnt = 0 ;
		try {
			cnt = smc.update("schPlan.insertSchPlan", schMap);
		} catch (SQLException e) {
			System.out.println("OutDao(insertSchPlan) => " + e);
		}
		return 0;
	}


	@Override
	public List<ScheduleMovieVo> allSchMoive() {
		List<ScheduleMovieVo> smVoList = null;
		try {
			smVoList = smc.queryForList("schPlan.allSchMoive");
		} catch (SQLException e) {
			System.out.println("OutDao(allSchMoive) => " + e);
		}
		for (ScheduleMovieVo scheduleMovieVo : smVoList) {
			scheduleMovieVo.setScd_chk(new CheckBox());
		}
		return smVoList;
	}
	
	@Override
	public List<ScheduleMovieVo> locationDateSchMoive(String localSch) {
		List<ScheduleMovieVo> smVoList = null;
		try {
			smVoList = smc.queryForList("schPlan.locationDateSchMoive",localSch);
		} catch (SQLException e) {
			System.out.println("OutDao(locationDateSchMoive) => " + e);
		}
		for (ScheduleMovieVo scheduleMovieVo : smVoList) {
			scheduleMovieVo.setScd_chk(new CheckBox());
		}
		return smVoList;
	}

	@Override
	public int addSchedule(ScheduleVo schVo) {
		int cnt = 0 ;
		try {
			cnt = smc.update("schPlan.addSchedule", schVo);
		} catch (SQLException e) {
			System.out.println("OutDao(addSchedule) => " + e);
		}
		return cnt;
	}

	@Override
	public int deleteSchedule(String sch_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getMDOemp() {
		List<String> mdoEmpLIst = null;
		try {
			mdoEmpLIst = smc.queryForList("out.getOutEmp");
		} catch (SQLException e) {
			mdoEmpLIst = null;
			e.printStackTrace();
			System.out.println("OutDao(getMDOemp) => " + e);
		}
		return mdoEmpLIst;
	}

	@Override
	public String getAccCode(String acc_name) {
		String acc_code = null;
		try {
			acc_code = (String)smc.queryForObject("out.getAccCode",acc_name);
		} catch (SQLException e) {
			acc_code = null;
			e.printStackTrace();
			System.out.println("OutDao(getAccCode) => " + e);
		}
		return acc_code;
	}


	
    
}
