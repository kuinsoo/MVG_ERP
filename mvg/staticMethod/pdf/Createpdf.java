package staticMethod.pdf;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Createpdf {

    public static void main(String args[]) throws IOException {

        //Creating PDF document object
        PDDocument document = new PDDocument();

        for (int i=0; i<1; i++) {
            //Creating a blank page
            PDPage blankPage = new PDPage();

            //Adding the blank page to the document
            document.addPage( blankPage );
        }

        //Saving the document
        document.save("./mvg/staticMethod/pdf/new.pdf");
        System.out.println("PDF created");

        //Closing the document
        document.close();

    }
}
