package staticMethod.codemaker;

import java.time.LocalDateTime;

public class Codemaker {
	
	static int year;
	static int month;
	static int day;
	static int hr;
	static int min;
	static int sec;
	
	public static String remp_Code(String emp_Code) {
		/* 퇴사 회원 코드 생성기 */
		String remp_code = "";
//		int rd_code = (int)(Math.random()*999999)+1;
		year = LocalDateTime.now().getYear();
		month = LocalDateTime.now().getMonthValue();
		day = LocalDateTime.now().getDayOfMonth();
		remp_code = emp_Code+year + month + day;
		return remp_code;
	}
	
	/**
	 *@Method 설명 : 회원 코드 생성기
	 *@Method Name : Emp_Code
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@return
	 */
	public static String emp_Code() {
		/* 회원 코드 생성기 */
		String emp_code = "";
		int rd_code = (int)(Math.random()*999999)+1;
		year = LocalDateTime.now().getYear();
		month = LocalDateTime.now().getMonthValue();
		day = LocalDateTime.now().getDayOfMonth();
		emp_code = ""+year + month + day + rd_code;
		return emp_code;
	}
	
	/**
	 *@Method Name : sysdate_no
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 오늘 시간을 게시번호로 사용하기 위해 한데 합친 코드 입니다. 
	 *@return 지금 년/월/일/시/분/초
	 */
	public static String sysdate_no() {
		year 	= LocalDateTime.now().getYear();
		month	= LocalDateTime.now().getMonthValue();
		day 	= LocalDateTime.now().getDayOfMonth();
		hr 		= LocalDateTime.now().getHour();
		min 	= LocalDateTime.now().getMinute();
		sec 	= LocalDateTime.now().getSecond();
		
		return ""+year+month+day+hr+min+sec;
	}
	
	/**
	 *@Method Name : sysdate
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 현 시간 입니다.
	 *@return 년/월/일
	 */
	public static String sysdate() {
		year 	= LocalDateTime.now().getYear();
		month	= LocalDateTime.now().getMonthValue();
		day 	= LocalDateTime.now().getDayOfMonth();
		
		String mm;
		String dd;
		
		if(month < 10) {
			mm = "0"  +month;
		}else {
			mm = "" + month;
		}
		if(day < 10) {
			dd = "0" + day;
		}else {
			dd = "" + day;
		}
		
		return ""+year+"-"+mm+"-"+dd;
	}
	

	/**
	 *@Method Name : mat_Code
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 자재코드 생성기
	 *@return 
	 */
	public static String mat_Code() {
		/* 자재 코드 생성기 */
		String mat_code = "";
		String mat_name = "M";
		int matCode = (int)(Math.random()*999999)+1;
		year = LocalDateTime.now().getYear();
		month = LocalDateTime.now().getMonthValue();
		day = LocalDateTime.now().getDayOfMonth();
		mat_code = ""+ mat_name + year + month + day +  matCode;
		
		return mat_code;
	}
	
	/**
	 *@Method Name : mach_code
	 *@date : 2018. 9. 25.
	 *@author :Yoo
	 *@Method 설명 : 기기 코드 생성기
	 *@return
	 */
	public static String mach_code() {
		String mach_name = "mach";
		int mach_code = (int)(Math.random()*999+1);
		year = LocalDateTime.now().getYear();
		month = LocalDateTime.now().getMonthValue();
		day = LocalDateTime.now().getDayOfMonth();
		String mach_no = mach_name + mach_code + year + month + day;
		return mach_no;
	}
	
	/**
	 *@Method Name : ast_mat
	 *@date : 2018. 9. 19.
	 *@author : JeeSeon
	 *@Method 설명 : 수불번호 자동생성 
	 *@return 
	 */
	public static String ast_mat() {
		/* 자재 코드 생성기 */
		String ast_code = "";
		String ast_name = "ast";
		int astCode = (int)(Math.random()*999)+1;
		year = LocalDateTime.now().getYear();
		month = LocalDateTime.now().getMonthValue();
		day = LocalDateTime.now().getDayOfMonth();
		ast_code = ""+ ast_name +  astCode + year + month + day ;
		
		return ast_code;
	}

	
	/**
	 *@Method Name : defective_code
	 *@date : 2018. 9. 25.
	 *@author : Yoo
	 *@Method 설명 : 불량코드 생성기
	 *@return
	 */
	public static String defective_code() {
		String defect_name = "dp";
		int defect_code = (int)(Math.random()*999+1);
		year = LocalDateTime.now().getYear();
		month = LocalDateTime.now().getMonthValue();
		day = LocalDateTime.now().getDayOfMonth();
		String defect_no = defect_name + defect_code + year + month + day;
		return defect_no;
	}

	/**
	 *@Method Name : plan_code
	 *@date : 2018. 9. 28.
	 *@author : 박동주
	 *@Method 설명 : 기획서 코드
	 *@return
	 */
	public static String plan_code() {
		String code = "mvgpln" + (int)(Math.random()*9999 + 1);
		String plan_code = code;
		return plan_code;
	}
	
	/**
	 *@Method Name : cont_code
	 *@date : 2018. 9. 28.
	 *@author : 박동주	
	 *@Method 설명 : 계약서 기획번호 코드
	 *@return
	 */
	public static String cont_code() {
		int cnt = (int)(Math.random()*999) + 1;
		System.out.println(cnt);
		String code = "mvgpln000" + cnt;
		String cont_code = code;
		System.out.println(cont_code);
		return cont_code;
	}
	
	public static String prod_code() {
		String prod = "p0";
		int prod_code = (int)(Math.random()*999)+1;
		year = LocalDateTime.now().getYear();
		month = LocalDateTime.now().getMonthValue();
		day = LocalDateTime.now().getDayOfMonth();
		
		String prod_no = prod + prod_code + year + month + day;
		
		return prod_no;
	}
	
	
	public static String scd_code() {
		String code = "mvgsch000" + (int)(Math.random()*9999) + 1;
		String scd_code = code;
		return scd_code;
	}

}
