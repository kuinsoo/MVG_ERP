package staticMethod.pdf.hrPDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Hr_rempPDF {
    public static void makePDF_remp(String dept_name, String pos_name,String name, String birth, String hdate, String regNo1, String regNo2, String retiredDate, String note, String addr)  {
    	try {
        //Loading an existing document
        File file = new File("./mvg/staticMethod/pdf/new.pdf");
        PDDocument doc = PDDocument.load(file);
        //Creating a PDF Document
        PDPage page = doc.getPage(0);

        PDPageContentStream contentStream = new PDPageContentStream(doc, page);

        InputStream fontStream = new FileInputStream("./mvg/staticMethod/pdf/NanumFont_TTF_ALL/NanumGothic.ttf");  // 한글 깨짐와 오류 방지를 위한 한글지원 폰트 선택
		
        PDImageXObject pdImage = PDImageXObject.createFromFile("./mvg/staticMethod/pdf/hrPDF/retired.png", doc);				//  백그라운드 이미지 위치
   
		contentStream.drawImage(pdImage, 10, 0);	// 백그라운드가 그려지는 위치
		 
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
        
        // 퇴직 증명서 (소속)
        contentStream.newLineAtOffset(165, -57 );
        contentStream.showText("MVG_" + dept_name);
        // 퇴직 증명서 (직위)
        contentStream.newLineAtOffset(260,0);
        contentStream.showText(pos_name);
        // 퇴직 증명서 (이름)
        contentStream.newLineAtOffset(-260, -40);	
        contentStream.showText(name);
        // 생년월일
        contentStream.newLineAtOffset(227, 2);
        contentStream.showText("19"+regNo1.substring(0, 2));
        contentStream.newLineAtOffset( 50, 0);
        contentStream.showText(regNo1.substring(3,4));
        contentStream.newLineAtOffset(27, 0);
        contentStream.showText(regNo1.substring(5,6));
        // 퇴직 증명서 (입사 날찌)
        contentStream.newLineAtOffset(-310,-37);
        contentStream.showText(hdate.substring(0,4));
        contentStream.newLineAtOffset(45,0);
        contentStream.showText(hdate.substring(5,7));
        contentStream.newLineAtOffset(28,0);
        contentStream.showText(hdate.substring(8,10));
        // 퇴직 증명서 (주민등록번호)
        contentStream.newLineAtOffset(161, -2);
        contentStream.showText(regNo1 + "-" + regNo2);
        // 퇴직 증명서 (퇴사 날찌)
        contentStream.newLineAtOffset(-236,-37);
        contentStream.showText(retiredDate.substring(0,4));
        contentStream.newLineAtOffset(46,0);
        contentStream.showText(retiredDate.substring(5,7));
        contentStream.newLineAtOffset(28,0);
        contentStream.showText(retiredDate.substring(8,10));
        // 퇴직 사유 (내용)
        contentStream.newLineAtOffset(165,0);
        if(note == null) {
        	contentStream.showText(" ");
        }else {
        	contentStream.showText(note);
        }
        // 퇴직 증명서 (주소)
        contentStream.newLineAtOffset(-245, -40);
        contentStream.showText(addr);
    
		LocalDate  currentDate = LocalDate.now();  // 오늘 날짜
	    /* 오늘 날짜 */
        String year2 = currentDate.getYear() + "";
        String mm2 = currentDate.getMonthValue() + "";
        String dd2 = currentDate.getDayOfMonth() + "";
        // 제직 증명서 (오늘 날찌)
        contentStream.newLineAtOffset(230,-345);
        contentStream.showText("20"+year2.substring(2, 4));
        contentStream.newLineAtOffset(49,0);
        contentStream.showText(mm2);
        contentStream.newLineAtOffset(22,0);
        contentStream.showText(dd2);
       
        
    
        //Adding text in the form of string

        //Ending the content stream
        contentStream.endText();

        System.out.println("Content added");

        //Closing the content stream
        contentStream.close();

        //Saving the document
        doc.save(new File("./mvg/staticMethod/pdf/hrPDF/retired.pdf"));
        //Closing the document
        doc.close();
    	} catch (InvalidPasswordException e) {
    		System.out.println("InvalidPasswordException " + e);
		} catch (IOException e) {
			System.out.println("IOException " + e);
		}
    }
}