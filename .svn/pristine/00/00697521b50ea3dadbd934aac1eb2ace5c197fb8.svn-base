package staticMethod.pdf.hrPDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Hr_salaryPDF {
    public static void makePDF_salary(String emp_name, int sal_basic, String count, String month, int meals, int vmCost, int  ccAllowance,
    		int nationPension, int hthInsurance, int empInsurance, int ltermCare, int incomeTax, int localIncomeTax, int abtDeduction ) {
    	try {
        //Loading an existing document
        File file = new File("./mvg/staticMethod/pdf/new.pdf");
        PDDocument doc = PDDocument.load(file);
        //Creating a PDF Document
        PDPage page = doc.getPage(0);

        PDPageContentStream contentStream = new PDPageContentStream(doc, page);

        InputStream fontStream = new FileInputStream("./mvg/staticMethod/pdf/NanumFont_TTF_ALL/NanumGothic.ttf");  // 한글 깨짐와 오류 방지를 위한 한글지원 폰트 선택
		
        PDImageXObject pdImage = PDImageXObject.createFromFile("./mvg/staticMethod/pdf/hrPDF/salary.png", doc);				//  백그라운드 이미지 위치
   
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
        
        // 급여명세서 (월)
        contentStream.newLineAtOffset(220, -9 );
        contentStream.showText(month);
        // 급여명세서 (성명)
        contentStream.newLineAtOffset(183,-28);
        contentStream.showText(emp_name);
        // 급여명세서 (기본급)
        contentStream.newLineAtOffset(-220, -63);	
        contentStream.showText(sal_basic + " 원");
        // 급여명세서 (식대)
        contentStream.newLineAtOffset(0, -32);	
        contentStream.showText("　　　　"+ meals + " 원");
        // 급여명세서 (차량유지비)
        contentStream.newLineAtOffset(0, -32);	
        contentStream.showText("　　　　" + vmCost + " 원");
        // 급여명세서 (육아수당)
        contentStream.newLineAtOffset(0, -33);	
        contentStream.showText("　　　　" + ccAllowance + " 원");
        // 급여명세서 (급여계)
        int sumplus = sal_basic+meals+vmCost+ccAllowance;
        contentStream.newLineAtOffset(0, -130);	
        contentStream.showText(sumplus + " 원");
        
        // 급여명세서 (국민연급)
        contentStream.newLineAtOffset(200, 227);	
        contentStream.showText("　　　　" + nationPension + " 원");
        // 급여명세서 (건강보험)
        contentStream.newLineAtOffset(0, -33);	
        contentStream.showText("　　　　" + hthInsurance + " 원");
        // 급여명세서 (고용보험)
        contentStream.newLineAtOffset(0, -33);	
        contentStream.showText("　　　　" + empInsurance + " 원");
        // 급여명세서 (장기요양보험료)
        contentStream.newLineAtOffset(0, -33);	
        contentStream.showText("　　　　" + ltermCare + " 원");
        // 급여명세서 (소득세)
        contentStream.newLineAtOffset(0, -33);	
        contentStream.showText("　　　　" + incomeTax + " 원");
        // 급여명세서 (지방소득세)
        contentStream.newLineAtOffset(0, -32);	
        contentStream.showText("　　　　" + localIncomeTax + " 원");
        // 급여명세서 (결근공제)
        contentStream.newLineAtOffset(0, -32);	
        abtDeduction *= 50000;
        contentStream.showText("" + abtDeduction + " 원");
        // 급여명세서 (공제계)
        int sumMinus = nationPension+hthInsurance+empInsurance+ltermCare+incomeTax+localIncomeTax+abtDeduction;
        contentStream.newLineAtOffset(0, -31);	
        contentStream.showText("" + sumMinus + " 원");
        
        // 급여명세서 (실수령액)
        int sumAll = sumplus - sumMinus;
        contentStream.newLineAtOffset(-43, -30);	
        contentStream.showText("" + sumAll + " 원");
       
        
    
        //Adding text in the form of string

        //Ending the content stream
        contentStream.endText();

        System.out.println("Content added");

        //Closing the content stream
        contentStream.close();

        //Saving the document
        doc.save(new File("./mvg/staticMethod/pdf/hrPDF/salary.pdf"));
        //Closing the document
        doc.close();
    	} catch (InvalidPasswordException e) {
    		System.out.println("InvalidPasswordException " + e);
		} catch (IOException e) {
			System.out.println("IOException " + e);
		}
    }
}