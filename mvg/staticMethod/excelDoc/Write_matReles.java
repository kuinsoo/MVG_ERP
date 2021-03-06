package staticMethod.excelDoc;

//파일 입출력
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* xlsx 파일 출력시 선언 */
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import staticMethod.codemaker.Codemaker;

/* 스타일링  */
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;

public class Write_matReles {
	
	public static void printMatReles(String title, List<List<String>> relesList) {
		
		// 워크북 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// 워크시트 생성
		XSSFSheet sheet = workbook.createSheet();
		// 행
		XSSFRow row =null; 
		int rowNum = 0;
		// 셀
		XSSFCell cell=null;
		
/* TITLE */
		
		// 셀스타일 - Style 용 객체생성 	    
	    CellStyle headStyle = workbook.createCellStyle(); 
	    
	    Font headFont = workbook.createFont();
	    headFont.setFontName("나눔고딕");					//글씨체
	    headFont.setFontHeight((short)(16*20));			//사이즈
	    headFont.setBoldweight(Font.BOLDWEIGHT_BOLD);	//볼드 (굵게)
	    headStyle.setFont(headFont);
	    
	    //배경색 입히기
	    headStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	    headStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	    //정렬
	    headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
	    headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	    // 라인 입히기(위, 좌, 우, 아래)
	    headStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); 
	    headStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); 
	    headStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); 
	    headStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); 
	    
	    rowNum++;
	    
	    //행 생성
	    row = sheet.createRow(rowNum);
	    
	    //병합 영역 설정
	    //열시작, 열종료, 행시작, 행종료 (자바배열과 같이 0부터 시작)
	    sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum+2, 0, 8));
	   
	    //셀 생성
		cell = row.createCell(0);			//위치 
		cell.setCellStyle(headStyle);		//스타일 적용 
		//제목 넣기
		cell.setCellValue(title);
		
		//위 스타일 적용
		for(int i=1 ; i<9 ; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(headStyle);
		}
		
		//좌, 우 스타일 적용(모든 셀에 적용해주어야 합니다.)
		for(rowNum=2 ; rowNum<4 ; rowNum++) {
			if(rowNum < 3) {
				row = sheet.createRow(rowNum);
				cell = row.createCell(0);
				cell.setCellStyle(headStyle);
				cell = row.createCell(8);
				cell.setCellStyle(headStyle);
			//아래 스타일 적용
			}else {
				row = sheet.createRow(rowNum);
				for(int i=0 ; i<9 ; i++) {
					cell = row.createCell(i);
					cell.setCellStyle(headStyle);
				}
			}
		}
		
		rowNum++;
		rowNum++;
		
/* 내용  */

		CellStyle bodyStyle = workbook.createCellStyle(); 
		//폰트
		Font bodyFont = workbook.createFont();
		bodyFont.setFontName("나눔고딕");					//글씨체
		bodyFont.setBoldweight(Font.BOLDWEIGHT_BOLD);	//볼드 (굵게)
		bodyStyle.setFont(bodyFont);
		//정렬
		bodyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		bodyStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		
		CellStyle chartTitleStyle = workbook.createCellStyle(); 
		//정렬
		chartTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		chartTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//라인
		chartTitleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); 
		chartTitleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); 
		chartTitleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); 
		chartTitleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); 
		//배경색 입히기
		chartTitleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		chartTitleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		
		CellStyle chartStyle = workbook.createCellStyle(); 
		//라인
		chartStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); 
		chartStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); 
		chartStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); 
		chartStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); 
		//정렬
		chartStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		chartStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		

		//부서
		row = sheet.createRow(rowNum);
		cell = row.createCell(0);
		cell.setCellStyle(bodyStyle);
		cell.setCellValue("부　서 : ");
		
		//부서 입력
		cell = row.createCell(1);
		cell.setCellValue(relesList.get(0).get(0));
	    
	    rowNum++;
	    rowNum++;
	    
	    //이름
	    row = sheet.createRow(rowNum);
	    cell = row.createCell(0);
	    cell.setCellStyle(bodyStyle);
	    cell.setCellValue("신청자 : ");
	    
	    //이름 입력
	    cell = row.createCell(1);
	    cell.setCellValue(relesList.get(0).get(1));
	    
	    rowNum++;
	    rowNum++;
	    
	    //날짜
	    row = sheet.createRow(rowNum);
	    cell = row.createCell(0);
	    cell.setCellStyle(bodyStyle);
	    cell.setCellValue("날　짜 : ");
	    
	    //날짜 입력
	    cell = row.createCell(1);
	    cell.setCellValue(relesList.get(0).get(2));
	    
	    rowNum++;
	    rowNum++;
	    
	    
	    row = sheet.createRow(rowNum);
	    //분류명
	    sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 0, 1));
	    cell = row.createCell(0);
	    cell.setCellStyle(chartTitleStyle);
	    cell.setCellValue("분류명");
	    cell = row.createCell(1);
	    cell.setCellStyle(chartTitleStyle);
	    //자재명
	    sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 2, 3));
	    cell = row.createCell(2);
	    cell.setCellStyle(chartTitleStyle);
	    cell.setCellValue("자　재　량");
	    cell = row.createCell(3);
	    cell.setCellStyle(chartTitleStyle);
	    //출고수량
	    cell = row.createCell(4);
	    cell.setCellStyle(chartTitleStyle);
	    cell.setCellValue("출고수량");
	    //사유
	    sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 5, 8));
	    cell = row.createCell(5);
	    cell.setCellStyle(chartTitleStyle);
	    cell.setCellValue("사　유");
	    cell = row.createCell(6);
	    cell.setCellStyle(chartTitleStyle);
	    cell = row.createCell(7);
	    cell.setCellStyle(chartTitleStyle);
	    cell = row.createCell(8);
	    cell.setCellStyle(chartTitleStyle);
	   
	    
	    rowNum++;
	    //내용 넣기
	    for(int j=1 ; j<relesList.size() ; j++) {
		    row = sheet.createRow(rowNum);
		    for(int i=0 ; i<relesList.get(j).size() ; i++) {
		    	if(i == 0) {
		    		sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, i, i+1));
				    cell = row.createCell(0);
				    cell.setCellStyle(chartStyle);
				    cell.setCellValue(relesList.get(j).get(i));
				    cell = row.createCell(1);
				    cell.setCellStyle(chartStyle);
			    }else if(i == 1) {
			    	sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, i+1, i+2));
			    	cell = row.createCell(2);
				    cell.setCellStyle(chartStyle);
				    cell.setCellValue(relesList.get(j).get(i));
				    cell = row.createCell(3);
				    cell.setCellStyle(chartStyle);
			    }else if(i == 2) {
			    	cell = row.createCell(4);
				    cell.setCellStyle(chartStyle);
				    cell.setCellValue(relesList.get(j).get(i));
			    }else if(i==relesList.get(j).size()-1) {
			    	sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, i+2, i+5));
			    	cell = row.createCell(5);
				    cell.setCellStyle(chartStyle);
				    cell.setCellValue(relesList.get(j).get(i));
				    cell = row.createCell(6);
				    cell.setCellStyle(chartStyle);
				    cell = row.createCell(7);
				    cell.setCellStyle(chartStyle);
				    cell = row.createCell(8);
				    cell.setCellStyle(chartStyle);
			    }
		    }
		    rowNum++;
	    }
	    
	    rowNum++;
	    rowNum++;
	    
	    //위와 같이 신청합니다.
	    row = sheet.createRow(rowNum);
	    sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 0, 8));
	    cell = row.createCell(0);
	    cell.setCellStyle(bodyStyle);
	    cell.setCellValue("위와 같이 신청합니다.");
	    
	    rowNum++;
	    rowNum++;
	    
	    //출고 날짜
	    row = sheet.createRow(rowNum);
	    cell = row.createCell(5);
	    cell.setCellStyle(bodyStyle);
	    cell.setCellValue("출고일");
	    
	    rowNum++;
	    rowNum++;
	    
	    //자재담당 (인)
	    row = sheet.createRow(rowNum);
	    cell = row.createCell(5);
	    cell.setCellStyle(bodyStyle);
	    cell.setCellValue("자재담당");
	    cell = row.createCell(7);
	    cell.setCellStyle(bodyStyle);
	    cell.setCellValue("(인)");
	    
	    // 출력 		
		// 1)파일생성을 위한 인스턴스 선언
		FileOutputStream fos = null;
		
		try {
			//파일생성 인스턴스에 '파일명.확장자' 기록하기
			fos = new FileOutputStream("./mvg/staticMethod/excelDoc/matReles"+ Codemaker.sysdate_no() + ".xlsx");
			
			//엑셀 내용 인스턴스 workbook를 write()메서드를 통해 파일생성 인스턴스 outFile에 기록하기
			workbook.write(fos);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Write_purchaseApp printPurchaseApp FileNotFound ERROR => " + e);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Write_purchaseApp printPurchaseApp IO1 ERROR => " + e);
		} finally {
			try {
				//기록이 끝났으면 파일 생성했던 인스턴스 닫기
				if(workbook!=null) workbook.close();
				if(fos!=null) fos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Write_purchaseApp printPurchaseApp IO2 ERROR => " + e);
			}
		}
	}
	
	
}



















