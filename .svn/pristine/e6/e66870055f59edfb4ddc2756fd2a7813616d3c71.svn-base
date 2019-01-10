package staticMethod.pdf;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class InsertingImage {

    public static void main(String args[]) throws Exception {
        //Loading an existing document
        File file = new File("D:/MrKKu/DevelopMent/Java/ddit.or.kr.203/layout/savePDF/sample.pdf");
        PDDocument doc = PDDocument.load(file);

        //Retrieving the page
        PDPage page = doc.getPage(0);

        //Creating PDImageXObject object
        PDImageXObject pdImage = PDImageXObject.createFromFile("D:\\MrKKu\\DevelopMent\\Java\\ddit.or.kr.203\\layout\\savePDF\\dd.png",doc);

        //creating the PDPageContentStream object
        PDPageContentStream contents = new PDPageContentStream(doc, page);
        contents.drawImage(pdImage, 10, 200);
        contents.beginText();
        PDFont font = PDType1Font.HELVETICA_BOLD;
        contents.setFont(font, 12);
//        contents.moveTextPositionByAmount(10, 650);
//        contents.drawString("Hello World");
        contents.endText();
        //Drawing the image in the PDF document
      /*  contents.drawImage(pdImage, 30, 30);*/

        contents.beginText();

        //Setting the font to the Content stream
        contents.setFont( PDType1Font.TIMES_ROMAN, 16 );

        //Setting the leading
        contents.setLeading(14.5f);

        //Setting the position for the line
        contents.newLineAtOffset(25, 500);

        String text1 = "This is an example of adding text to a page in the pdf document.       we can add as many lines";
        String text2 = "as we want like this using the ShowText()  method of the       ContentStream class";
        String text3 = "as we want like this using the ShowText()  method of the       ContentStream class";

        //Adding text in the form of string
        contents.showText(text1);
        contents.newLine();
        contents.showText(text2);
        contents.newLine();
        contents.showText(text3);
        //Ending the content stream
        contents.endText();
        System.out.println("Image inserted");

        //Closing the PDPageContentStream object
        contents.close();

        //Saving the document
        doc.save("D:/MrKKu/DevelopMent/Java/ddit.or.kr.203/layout/savePDF/sample.pdf");

        //Closing the document
        doc.close();

    }
}