package material.dao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import javafx.scene.control.CheckBox;
import material.vo.AssistantVo;
import material.vo.BuyerVo;
import material.vo.MaterialCateVo;
import material.vo.MaterialMainVo;
import material.vo.MaterialVo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class MaterialDao implements IMaterialDao {
	private static MaterialDao matDao;
	private SqlMapClient smc;

	private MaterialDao() {
		try {
			Reader rd = Resources.getResourceAsReader("resources/sqlMap/sqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println("sqlMapLoad" + e);
		}
	}
	public static MaterialDao getInstance() {
		if(matDao == null) {
			matDao = new MaterialDao();
		}
		return matDao;
	}

	
	/**
	 *@Method Name : getAllMat
	 *@date : 2018. 9. 15.
	 *@author : JeeSeon
	 *@Method 설명 : 자재전체 검색 
	 *@param 
	 *@return 
	 */
	@Override
	public List<MaterialVo> getAllMat() {
		List<MaterialVo> matList = null;
		try {
			matList = smc.queryForList("mat.getAllMat");
		} catch (SQLException e) {
			System.out.println("getAllMat" + e);
		}
		return matList;
	}

	/**
	 *@Method Name : getMatWearingMain
	 *@date : 2018. 9. 15.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 입고 관리 기본테이블 
	 *@param 
	 *@return
	 */
	@Override
	public List<MaterialMainVo> getMatWearingMain() {
		List<MaterialMainVo> matMainList = null;
		try {
			matMainList = smc.queryForList("mat.getMatWearingMain");

		} catch (SQLException e) {
			System.out.println("getMatWearingMain" + e);
		}

		for (MaterialMainVo mmVo  : matMainList) {
			mmVo.setMat_chk(new CheckBox());
		}


		return matMainList;
	}

	
	/**
	 *@Method Name : insertMatAdd
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 입고 등록
	 *@param matMainVo
	 *@return
	 */
	@Override
	public int insertMatAdd(MaterialVo matMainVo) {
		int cnt = 0;
		try {
			cnt = smc.update("mat.insertMatAdd",matMainVo);
		} catch (SQLException e) {
			System.out.println("insertMatAdd" + e);
		}
		return cnt;
	}



	/**
	 *@Method Name : matClassificationCode
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 입고등록시 자재분류 콤보박스
	 *@param 
	 *@return
	 */
	@Override
	public List<MaterialCateVo> matClassificationCode() {
		System.out.println("다오 들어옴");
		List<MaterialCateVo> matc = null;
		try {
			System.out.println("xml연결전");
			matc = smc.queryForList("mat.matClassificationCode");
			System.out.println("xml 갔다옴");

		} catch (SQLException e) {
			System.out.println("matClassificationCode" + e);
		}
		return matc;
	}


	/**
	 *@Method Name : matAccountCode
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 입고등록시 거래처코드 콤보박스
	 *@param 
	 *@return
	 */
	@Override
	public List<BuyerVo> matAccountCode() {
		System.out.println("다오 들어옴");
		List<BuyerVo> buyer = null;
		try {
			System.out.println("xml연결전");
			buyer = smc.queryForList("mat.matAccountCode");
			System.out.println("xml 갔다옴");

		} catch (SQLException e) {
			System.out.println("matAccountCode" + e);
		}
		return buyer;
	}



	/**
	 *@Method Name : matUpdate
	 *@date : 2018. 9. 20.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 입고 수정
	 *@param matVo
	 *@return
	 */
	@Override
	public int matUpdate(MaterialVo matVo) {
		int cnt = 0;
		try {
			cnt = smc.update("mat.matUpdate",matVo);
			System.out.println(cnt);
			matVo.getMat_name();
		}  catch (SQLException e) {
			System.out.println("matUpdate" + e);
		}
		return cnt;
	}


	/**
	 *@Method Name : deleteEmp
	 *@date : 2018. 9. 16.
	 *@author : JeeSeon
	 *@Method 설명 : 선택된 자재 삭제
	 *@param mat_code
	 *@return
	 */
	public int deleteMat(List<String> mat_code) {
		int cnt = 0 ;
		try {
			cnt = smc.delete("mat.deleteMat",mat_code);
		} catch (SQLException e) {
			System.out.println("deleteMat" + e);
		}
		return cnt;
	}
	
	/**
	 *@Method Name : getMat
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 자재를 여러가지 옵션으로 검색한다
	 *@param mat
	 *@return
	 */
	@Override
	public List<MaterialMainVo> getMat(Map<String, String> mat) {
		List<MaterialMainVo> matList = null;
		try {
			matList =   smc.queryForList("mat.getMat", mat);			
		} catch (SQLException e) {
			System.out.println("getMat" + e);
		}

		for (MaterialMainVo matVo : matList) {
			matVo.setMat_chk(new CheckBox());
		}
		return matList;
	}


	/**
	 *@Method Name : getMatDeferentMain
	 *@date : 2018. 9. 19.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 수불관리 기본리스트 
	 *@param 
	 *@return
	 */
	@Override
	public List<AssistantVo> getMatDeferentMain() {
		System.out.println("다오 들어옴");
		List<AssistantVo> ass = null;
		try {
			System.out.println("xml연결전");
			ass = smc.queryForList("mat.getMatDeferentMain");
			System.out.println("xml 갔다옴");

		} catch (SQLException e) {
			System.out.println("getMatDeferentMain" + e);
		}

		for (AssistantVo asVo  : ass) {
			asVo.setMat_chk(new CheckBox());
		}
		return ass;
	}

	

	/**
	 *@Method Name : insertAstAdd
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 수불 등록
	 *@param astVo
	 *@return
	 */
	@Override
	public int insertAstAdd(AssistantVo astVo) {
		int cnt = 0;
		try {
			cnt = smc.update("mat.insertAstAdd",astVo);
		} catch (SQLException e) {
			System.out.println("insertAstAdd" + e);
		}
		return cnt;
	}


	/**
	 *@Method Name : assUpdate
	 *@date : 2018. 9. 20.
	 *@author : JeeSeon
	 *@Method 설명 : 자재 수불 수정 
	 *@param assVo
	 *@return
	 */
	@Override
	public int assUpdate(AssistantVo assVo) {
		int cnt = 0;
		try {
			cnt = smc.update("mat.assUpdate",assVo);
			System.out.println(cnt);
			assVo.getAst_name();
		}  catch (SQLException e) {
			System.out.println("matUpdate" + e);
		}
		return cnt;
	}

	/**
	 *@Method Name : deleteAss
	 *@date : 2018. 9. 24.
	 *@author : JeeSeon
	 *@Method 설명 : 선택된 수불 삭제
	 *@param ast_no
	 *@return
	 */
	@Override
	public int deleteAss(List<String> ast_no) {
		int cnt = 0 ;
		try {
			cnt = smc.delete("mat.deleteAss",ast_no);
		} catch (SQLException e) {
			System.out.println("deleteAss" + e);
		}
		return cnt;
	}
	
	/**
	 *@Method Name : getAst
	 *@date : 2018. 9. 24.
	 *@author : JeeSeon
	 *@Method 설명 : 수불을 여러가지 옵션으로 검색한다.
	 *@param ast
	 *@return
	 */
	@Override
	public List<AssistantVo> getAst(Map<String, String> ast) {
		List<AssistantVo> astList = null;
		try {
			astList =   smc.queryForList("mat.getAst", ast);			
		} catch (SQLException e) {
			System.out.println("getAst" + e);
		}

		for (AssistantVo astVo : astList) {
			astVo.setMat_chk(new CheckBox());
		}
		return astList;
	}
	
	
	/**
	 *@Method Name : getMatArticle
	 *@date : 2018. 9. 25.
	 *@author : JeeSeon
	 *@Method 설명 : 자재부 물품관리 기본테이블
	 *@param 
	 *@return
	 *
	 */
	@Override
	public List<MaterialMainVo> getMatArticle() {
		List<MaterialMainVo> matMainList = null;
		try {
			matMainList = smc.queryForList("mat.getMatArticle");

		} catch (SQLException e) {
			System.out.println("getMatArticle" + e);
		}

		for (MaterialMainVo mmVo  : matMainList) {
			mmVo.setMat_chk(new CheckBox());
		}

		return matMainList;
	}
	
	
	/**
	 *@Method Name : insertArticleAdd
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 물품 등록
	 *@param matMainVo
	 *@return
	 */
	@Override
	public int insertArticleAdd(MaterialVo matMainVo) {
		int cnt = 0;
		try {
			cnt = smc.update("mat.insertArticleAdd",matMainVo);
		} catch (SQLException e) {
			System.out.println("insertArticleAdd" + e);
		}
		return cnt;
	}
	
	
	/**
	 *@Method Name : articleUpdate
	 *@date : 2018. 9. 20.
	 *@author : JeeSeon
	 *@Method 설명 : 물품 수정
	 *@param matVo
	 *@return
	 */
	@Override
	public int articleUpdate(MaterialVo matVo) {
		int cnt = 0;
		try {
			cnt = smc.update("mat.articleUpdate",matVo);
			System.out.println(cnt);
			matVo.getMat_name();
		}  catch (SQLException e) {
			System.out.println("articleUpdate" + e);
		}
		return cnt;
	}
	
	
	/**
	 *@Method Name : deleteArticle
	 *@date : 2018. 9. 16.
	 *@author : JeeSeon
	 *@Method 설명 : 선택된 물품 삭제
	 *@param mat_code
	 *@return
	 */
	@Override
	public int deleteArticle(List<String> mat_code) {
		int cnt = 0 ;
		try {
			cnt = smc.delete("mat.deleteArticle",mat_code);
		} catch (SQLException e) {
			System.out.println("deleteArticle" + e);
		}
		return cnt;
	}
	
	
	
	/**
	 *@Method Name : getAct
	 *@date : 2018. 9. 27.
	 *@author : JeeSeon
	 *@Method 설명 : 물품을 여러가지 옵션으로 검색한다
	 *@param act
	 *@return
	 */
	@Override
	public List<MaterialMainVo> getAct(Map<String, String> act) {
		List<MaterialMainVo> actList = null;
		try {
			actList =   smc.queryForList("mat.getAct", act);			
		} catch (SQLException e) {
			System.out.println("getAct" + e);
		}

		for (MaterialMainVo actVo : actList) {
			System.out.println("들어갔냥 다오오오ㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗ");
			actVo.setMat_chk(new CheckBox());
			
		}
		return actList;
	}
	@Override
	public int MaterialQty(Map<String, String> mat_qty) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			cnt = smc.update("mat.updateMaterials",mat_qty);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Dao => updateMaterials ERROR =>" + e);
		}
		return cnt;
	}
}




