package commonDocument.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import commonDocument.vo.CodeRequestVo;

/**
 * 공통문서 dao
 * @author Sohyoung
 * @since 2018.09.16
 */
public class CommonDocumentDao implements ICommonDocumentDao {

	//싱글톤 작업
	private static CommonDocumentDao dao;

	//DB 연동 준비
	SqlMapClient smc;

	private CommonDocumentDao() {
		try {
			Reader rd = Resources.getResourceAsReader("resources/sqlMap/sqlMapConfig.xml");

			smc = SqlMapClientBuilder.buildSqlMapClient(rd);

			rd.close();

		} catch (IOException e) {
			System.out.println("CommonDocumentDao -> sqlMapconfing연결 :" + e);
		}
	}

	/**
	 *@Method Name : getInstance
	 *@date : 2018. 9. 14.
	 *@author : Sohyoung
	 *@Method 설명 : 싱글톤 작업2
	 *@return
	 */
	public static CommonDocumentDao getInstance(){
		if(dao == null) {
			dao = new CommonDocumentDao();
		}
		return dao;
	}

	@Override
	public int insertCodeRequest(CodeRequestVo codeRequestVo) {
		int result = 0;
		try {
			result = smc.update("comm.insertCodeRequest",codeRequestVo);
			
		} catch (SQLException e) {
			result= 0;
			e.printStackTrace();
			System.out.println("CommonDocumentDao insertCodeRequest ERROR => " + e);
		}
		return result;
	}

	@Override
	public List<String> getMatNames(String mat_metc) {
		List<String> mat_names = null;
		try {
			mat_names = smc.queryForList("comm.getMatNames",mat_metc);
			
		} catch (Exception e) {
			mat_names= null;
			e.printStackTrace();
			System.out.println("CommonDocumentDao getMatNames ERROR => " + e);
		}
		return mat_names;
	}

	@Override
	public String getMatQty(String mat_name) {
		String qty = null;
		try {
			if(smc.queryForObject("comm.getMatQty",mat_name)==null) {
				qty = "0";
			}else {
				qty = (String)smc.queryForObject("comm.getMatQty",mat_name);
			}
			
		} catch (SQLException e) {
			qty= null;
			e.printStackTrace();
			System.out.println("CommonDocumentDao getMatQty ERROR => " + e);
		}
		return qty;
	}

}
