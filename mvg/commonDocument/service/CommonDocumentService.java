package commonDocument.service;

import java.util.List;

import commonDocument.dao.CommonDocumentDao;
import commonDocument.dao.ICommonDocumentDao;
import commonDocument.vo.CodeRequestVo;

/**
 * 공통문서 service
 * @author Sohyoung
 * @since 2018.09.16
 */
public class CommonDocumentService implements ICommonDocumentService {

	//싱글톤 작업
	private static CommonDocumentService service;

	//dao와 연결
	private ICommonDocumentDao dao;

	private CommonDocumentService() {
		//dao와 연결
		dao = CommonDocumentDao.getInstance();
	}

	/**
	 *@Method Name : getInstance
	 *@date : 2018. 9. 14.
	 *@author : Sohyoung
	 *@Method 설명 : 싱글톤 작업2
	 *@return
	 */
	public static CommonDocumentService getInstance(){
		if(service == null) {
			service = new CommonDocumentService();
		}
		return service;
	}

	@Override
	public int insertCodeRequest(CodeRequestVo codeRequestVo) {
		return dao.insertCodeRequest(codeRequestVo);
	}

	@Override
	public List<String> getMatNames(String mat_metc) {
		return dao.getMatNames(mat_metc);
	}

	@Override
	public String getMatQty(String mat_name) {
		return dao.getMatQty(mat_name);
	}
}
