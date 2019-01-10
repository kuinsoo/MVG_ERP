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

public class Write_purchaseApp {
	
	public static void printPurchaseApp(String title, List<List<String>> purchaseList) {
		
		// 워크북 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// 워크시트 생성
		XSSFSheet sheet = workbook.createSheet();
		// 행
		XSSFRow row =null; 
		int rowNum = 0;
		// 셀
		XSSFCell cell=null;
		
/* 결재  */
		
		//셀스타일 - Style 용 객체생성 	    
	    CellStyle signStyle = workbook.createCellStyle();
		
		//정렬
	    signStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
	    signStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	    //라인
	    signStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); 
	    signStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); 
	    signStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); 
	    signStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); 
	    
	    
	    //결재
		row = sheet.createRow(rowNum);
		sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum+2, 5, 5));
		cell = row.createCell(5);
		cell.setCellStyle(signStyle);
	    cell.setCellValue("결 재");
	    
	    //담당자
	    cell = row.createCell(6);
	    cell.setCellStyle(signStyle);
	    cell.setCellValue("담당자");
	    sheet.addMergedRegion(new CellRangeAddress(rowNum+1, rowNum+2, 6, 6));
	    
	    //관리자
	    cell = row.createCell(7);
	    cell.setCellStyle(signStyle);
	    cell.setCellValue("관리자");
	    sheet.addMergedRegion(new CellRangeAddress(rowNum+1, rowNum+2, 7, 7));
	    
	    //사장
	    cell = row.createCell(8);
	    cell.setCellStyle(signStyle);
	    cell.setCellValue("사장");
	    sheet.addMergedRegion(new CellRangeAddress(rowNum+1, rowNum+2, 8, 8));
	    
	    //스타일 적용(모든 셀에 적용해주어야 합니다.)
	    for(rowNum=1 ; rowNum<3 ; rowNum++) {
	    	row = sheet.createRow(rowNum);
		    for(int cellNum=5 ; cellNum<9 ; cellNum++) {
		    	cell = row.createCell(cellNum);
		    	cell.setCellStyle(signStyle);
		    }
	    }

	    
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
	    sheet.addMergedRegion(new CellRangeAddress(rowNum, 6, 0, 8));
	   
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
		for(rowNum=5 ; rowNum<7 ; rowNum++) {
			if(rowNum < 6) {
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
//		rowNum = 9;
		
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
		cell.setCellValue("부　　　　서 : ");
		
		//부서 입력
		cell = row.createCell(1);
		cell.setCellValue(purchaseList.get(0).get(0));
	    
	    rowNum++;
	    rowNum++;
	    
	    //이름
	    row = sheet.createRow(rowNum);
	    cell = row.createCell(0);
	    cell.setCellStyle(bodyStyle);
	    cell.setCellValue("이　　　　름 : ");
	    
	    //이름 입력
	    cell = row.createCell(1);
	    cell.setCellValue(purchaseList.get(0).get(1));
	    
	    rowNum++;
	    rowNum++;
	    

	    row = sheet.createRow(rowNum);
	    //물품명
	    cell = row.createCell(0);
	    sheet.setColumnWidth(0, 3000);
	    cell.setCellStyle(chartTitleStyle);
	    cell.setCellValue("물\t\t\t품\t\t\t명");
	    //구매처
	    cell = row.createCell(1);
	    sheet.setColumnWidth(1, 3000);
	    cell.setCellStyle(chartTitleStyle);
	    cell.setCellValue("구\t\t\t매\t\t\t처");
	    //수량
	    cell = row.createCell(2);
	    sheet.setColumnWidth(2, 1000);
	    cell.setCellStyle(chartTitleStyle);
	    cell.setCellValue("수\t\t\t\t\t\t\t량");
	    //단가
	    cell = row.createCell(3);
	    cell.setCellStyle(chartTitleStyle);
	    cell.setCellValue("단\t\t\t\t\t\t\t가");
	    //규격
	    cell = row.createCell(4);
	    cell.setCellStyle(chartTitleStyle);
	    cell.setCellValue("규\t\t\t\t\t\t\t격");
	    //가격
	    cell = row.createCell(5);
	    cell.setCellStyle(chartTitleStyle);
	    cell.setCellValue("가\t\t\t\t\t\t\t격");
	    //비고
	    sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 6, 8));
	    cell = row.createCell(6);
	    cell.setCellStyle(chartTitleStyle);
	    cell.setCellValue("비\t\t\t\t\t\t\t고");
	    cell = row.createCell(7);
	    cell.setCellStyle(chartTitleStyle);
	    cell = row.createCell(8);
	    cell.setCellStyle(chartTitleStyle);
	    
	    rowNum++;
	    //내용 넣기
	    for(int j=1 ; j<purchaseList.size() ; j++) {
		    row = sheet.createRow(rowNum);
		    for(int i=0 ; i<purchaseList.get(j).size() ; i++) {
			    cell = row.createCell(i);
			    cell.setCellStyle(chartStyle);
			    cell.setCellValue(purchaseList.get(j).get(i));
			    if(i==purchaseList.get(j).size()-1) {
			    	sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 6, 8));
			    	cell = row.createCell(i);
				    cell.setCellStyle(chartStyle);
				    cell.setCellValue(purchaseList.get(j).get(i));
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
	    
	    //작성 날짜
	    row = sheet.createRow(rowNum);
	    sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 6, 7));
	    cell = row.createCell(5);
	    cell.setCellStyle(bodyStyle);
	    cell.setCellValue("작성일");
	    cell = row.createCell(6);
	    cell.setCellStyle(bodyStyle);
	    cell.setCellValue(purchaseList.get(0).get(2));
	    
	    rowNum++;
	    rowNum++;
	    
	    //신청인 (인)
	    row = sheet.createRow(rowNum);
	    cell = row.createCell(5);
	    cell.setCellStyle(bodyStyle);
	    cell.setCellValue("신청인");
	    cell = row.createCell(7);
	    cell.setCellStyle(bodyStyle);
	    cell.setCellValue("(인)");
	    
	    // 출력 		
		// 1)파일생성을 위한 인스턴스 선언
		FileOutputStream fos = null;
		
		try {
			//파일생성 인스턴스에 '파일명.확장자' 기록하기
			fos = new FileOutputStream("./mvg/staticMethod/excelDoc/purchaseApp"+ Codemaker.sysdate_no() + ".xlsx");
			
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



















