package staticMethod.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class AddMultipleLine {
    public static void main(String args[]) throws IOException {

    	


        //Loading an existing document
        File file = new File("./mvg/staticMethod/pdf/new.pdf");
        PDDocument doc = PDDocument.load(file);

        //Creating a PDF Document
        PDPage page = doc.getPage(0);

        PDPageContentStream contentStream = new PDPageContentStream(doc, page);

        InputStream fontStream = new FileInputStream("./mvg/staticMethod/pdf/NanumFont_TTF_ALL/NanumGothic.ttf");
		
        PDImageXObject pdImage = PDImageXObject.createFromFile("./mvg/staticMethod/pdf/jejic.jpg",doc);
		contentStream.drawImage(pdImage, 40, 100);
		 
        PDType0Font fontNanum = PDType0Font.load(doc, fontStream);
        
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
    
        // 제직 증명서 (이름)
        contentStream.newLineAtOffset(165, -77);
        contentStream.showText("구 인수");
        // 제직 증명서 (주민등록번호)
        contentStream.newLineAtOffset(180, 0);
        contentStream.showText("860822-1444423");
        // 제직 증명서 (주소)
        contentStream.newLineAtOffset(-185, -29);
        contentStream.showText("대전광역시 서구 정림동 금성백조아파트 101동 509호");
        // 제직 증명서 (소속)
        contentStream.newLineAtOffset(0, -28);
        contentStream.showText("M V G");
        // 제직 증명서 (직위)
        contentStream.newLineAtOffset(185,0);
        contentStream.showText("팀  장");
        // 제직 증명서 (제직기간)
        contentStream.newLineAtOffset(-160,-26);
        contentStream.showText("5"); // 년
        contentStream.newLineAtOffset(80,0);
        contentStream.showText("9"); // 월
        contentStream.newLineAtOffset(80,0);
        contentStream.showText("15"); // 일
        // 제직 증명서 (용도)
        contentStream.newLineAtOffset(-165,-29);
        contentStream.showText("제 출 용 도");
        // 제직 증명서 (오늘 날찌)
        contentStream.newLineAtOffset(48,-170);
        contentStream.showText("18");
        contentStream.newLineAtOffset(30,0);
        contentStream.showText("09");
        contentStream.newLineAtOffset(30,0);
        contentStream.showText("23");
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
        contentStream.showText("NO.20180923J001");
        
        
    
        //Adding text in the form of string

        //Ending the content stream
        contentStream.endText();

        System.out.println("Content added");

        //Closing the content stream
        contentStream.close();

        //Saving the document
        doc.save(new File("./mvg/staticMethod/pdf/hr_PDF.new2.pdf"));

        //Closing the document
        doc.close();
    }
}