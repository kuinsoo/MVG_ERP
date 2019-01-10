package staticMethod.pdf.hrPDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.Period;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Hr_empPDF {
    public static void makePDF_emp(String name, String regNo1, String regNo2, String pos_name,String addr, String hdate) {
    	try {
        //Loading an existing document
        File file = new File("./mvg/staticMethod/pdf/new.pdf");
        PDDocument doc = PDDocument.load(file);
        //Creating a PDF Document
        PDPage page = doc.getPage(0);

        PDPageContentStream contentStream = new PDPageContentStream(doc, page);

        InputStream fontStream = new FileInputStream("./mvg/staticMethod/pdf/NanumFont_TTF_ALL/NanumGothic.ttf");  // 한글 깨짐와 오류 방지를 위한 한글지원 폰트 선택
		
        PDImageXObject pdImage = PDImageXObject.createFromFile("./mvg/staticMethod/pdf/hrPDF/jejic.jpg", doc);				//  백그라운드 이미지 위치
   
		contentStream.drawImage(pdImage, 40, 100);	// 백그라운드가 그려지는 위치
		 
        PDType0Font fontNanum = PDType0Font.load(doc, fontStream);	// 폰트 설정 
        
        contentStream.setFont(fontNanum, 12); 
        //Begin the Content stream
        contentStream.beginText();

        //Setting the font to the Content stream
//        contentStream.setFont( PDType1Font.TIMES_ROMAN, 16 );

        //Setting the leading
        contentStream.setLeading(14.5f);

        //Setting the position for the line
        contentStream.newLineAtOffset(25, 725);

//		File file2 = new File("./src/pdf/form.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file2));
//		String singleCh = "";
//		String text1 = "";
//		while ((singleCh = br.readLine()) != null) {
////			text1 += singleCh;
//			contentStream.showText(singleCh);
//			contentStream.newLine();
//		}
//        br.close();
    
        /* 하나에 contentStream 변수를 이용하면 마지막으로 위치한 newLineAtOffset 위치에 포인트가 잡힌다. 
         * 그말은 즉 포인트가 잡힌 위치에서 이동해야할 위치를 다음 위치로 지정해야된다.
         * 만약 다른 변수를 생서하여 설정한다면 시작위치는 0, 0 초기 위치로 생각하고 좌표값을 잡아주면 된다.*/ 
        
        // 제직 증명서 (이름)
        contentStream.newLineAtOffset(165, -77);	
        contentStream.showText(name);
        // 제직 증명서 (주민등록번호)
        contentStream.newLineAtOffset(180, 0);
        contentStream.showText(regNo1 + "-" + regNo2);
        // 제직 증명서 (주소)
        contentStream.newLineAtOffset(-185, -29);
        contentStream.showText(addr);
        // 제직 증명서 (소속)
        contentStream.newLineAtOffset(0, -28);
        contentStream.showText("M V G");
        // 제직 증명서 (직위)
        contentStream.newLineAtOffset(185,0);
        contentStream.showText(pos_name);
        // 제직 증명서 (제직기간)
        /* 입사날짜와 오늘 날짜를 뺀 기간 */
        int year = Integer.parseInt(hdate.substring(0,4));
		int month = Integer.parseInt(hdate.substring(5,7));
		int day = Integer.parseInt(hdate.substring(8,10));
		LocalDate  currentDate = LocalDate.now();  // 오늘 날짜
		LocalDate targetDate = currentDate.withYear(year).withMonth(month).withDayOfMonth(day); // 입사년도(String)  LocalDate 로 변경하기
//		Period period = currentDate.until(targetDate);
		Period period = Period.between(targetDate, currentDate); // 제직기간 구하기  Period 클래스 이용
        contentStream.newLineAtOffset(-160,-26);
        contentStream.showText(period.getYears() + ""); // 년
        contentStream.newLineAtOffset(80,0);
        contentStream.showText(period.getMonths() + ""); // 월
        contentStream.newLineAtOffset(80,0);
        contentStream.showText(period.getDays() + ""); // 일
        // 제직 증명서 (용도)
        contentStream.newLineAtOffset(-165,-29);
        contentStream.showText("제 출 용 도");
        /* 오늘 날짜 */
        String year2 = currentDate.getYear() + "";
        String mm2 = currentDate.getMonthValue() + "";
        String dd2 = currentDate.getDayOfMonth() + "";
        // 제직 증명서 (오늘 날찌)
        contentStream.newLineAtOffset(48,-170);
        contentStream.showText(year2.substring(2, 4));
        contentStream.newLineAtOffset(30,0);
        contentStream.showText(mm2);
        contentStream.newLineAtOffset(30,0);
        contentStream.showText(dd2);
        // 제직 증명서 (회사명)
        contentStream.newLineAtOffset(-100, -115);
        contentStream.showText("CO.MVG");
        contentStream.newLineAtOffset(0, -33);
        contentStream.showText("대전광역시 대흥동 중구청역 1번출구 2층 ddit");
        contentStream.newLineAtOffset(0, -32);
        contentStream.showText("010-9947-0728");
        contentStream.newLineAtOffset(0, -33);
        contentStream.showText("구인수");
        contentStream.newLineAtOffset(120, 0);
        contentStream.showText("Mr.KKu");
        // 제직 증명서 (발급번호)
        contentStream.setFont(fontNanum, 9); 
        contentStream.newLineAtOffset(81, -33);
        String mm2_0 = "";
        if(currentDate.getMonthValue() < 10) {
        	mm2_0 = "0"+mm2;
        }
        contentStream.showText("NO." + year2 + mm2_0 + dd2 + (int)(Math.random()*1000+1));
        
        
    
        //Adding text in the form of string

        //Ending the content stream
        contentStream.endText();

        System.out.println("Content added");

        //Closing the content stream
        contentStream.close();

        //Saving the document
        doc.save(new File("./mvg/staticMethod/pdf/hrPDF/jejic.pdf"));
        //Closing the document
        doc.close();
    	} catch (InvalidPasswordException e) {
    		System.out.println("InvalidPasswordException " + e);
		} catch (IOException e) {
			System.out.println("IOException " + e);
		}
    }
}