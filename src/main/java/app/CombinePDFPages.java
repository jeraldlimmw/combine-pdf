package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class CombinePDFPages {
    public static void main(String[] args) {
        try {
            // Load the first PDF document
            PDDocument document1 = PDDocument.load(new File(args[0]));

            // Load the second PDF document
            PDDocument document2 = PDDocument.load(new File(args[1]));

            // Create a list to store the merged pages
            List<PDPage> mergedPages = new ArrayList<>();

            // Get the number of pages in the first document
            int numPages1 = document1.getNumberOfPages();

            // Get the number of pages in the second document
            int numPages2 = document2.getNumberOfPages();

            // // Determine the total number of pages in the merged document
            // int numPages = numPages1 + numPages2;

            // check numPages of both documents are equal
            if (numPages1 == numPages2) {
                System.out.println(">>>> Number of pages are equal");
            }

            // Merge the pages from both documents
            for (int i = 0; i < numPages1; i++) {
                // Add the next page from document 1
                if (i < numPages1) {
                    mergedPages.add(document1.getPage(i));
                }

                // Add the next page from document 2
                if (i < numPages2) {
                    mergedPages.add(document2.getPage(numPages2-1-i));
                }

                // // Add the next page from document 1
                // if (i + 1 < numPages1) {
                //     mergedPages.add(document1.getPage(i + 1));
                // }

                // // Add the next page from document 2
                // if (i + 1 < numPages2) {
                //     mergedPages.add(document2.getPage(i + 1));
                // }
            }

            // Create a new PDF document and add the merged pages
            PDDocument mergedDocument = new PDDocument();
            for (PDPage page : mergedPages) {
                mergedDocument.addPage(page);
            }

            // Save the merged document to a file
            PDFMergerUtility merger = new PDFMergerUtility();
            merger.setDestinationFileName("merged.pdf");
            mergedDocument.save("merged.pdf");

            // Close all open documents
            document1.close();
            document2.close();
            mergedDocument.close();

            System.out.println(">>>> Documents merged successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

