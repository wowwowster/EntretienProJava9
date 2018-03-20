package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


 import org.apache.pdfbox.multipdf.PDFMergerUtility;

import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSmartCopy;

import com.itextpdf.text.Document;
import exception.MyException;

public class PDFUtils {

   public static void concatPDFs(List<InputStream> streamOfPDFFiles, OutputStream outputStream, boolean paginate) {

      Document document = new com.itextpdf.text.Document();

      /** La commande suivante permet de gérer les PDFs cryptés */
      PdfReader.unethicalreading = true;

      try {
         List<InputStream> pdfs = streamOfPDFFiles;
         List<PdfReader> readers = new ArrayList<PdfReader>();
         Iterator<InputStream> iteratorPDFs = pdfs.iterator();

         while (iteratorPDFs.hasNext()) {
            InputStream pdf = iteratorPDFs.next();
            PdfReader pdfReader = new PdfReader(pdf);
            pdf.close();
            readers.add(pdfReader);
         }
         // Create a writer for the outputstream
         PdfCopy copy = new PdfSmartCopy(document, outputStream);
         document.open();
         Iterator<PdfReader> iteratorPDFReader = readers.iterator();

         // Loop through the PDF files and add to the output.
         while (iteratorPDFReader.hasNext()) {
            PdfReader pdfReader = iteratorPDFReader.next();
            copy.addDocument(pdfReader);
            pdfReader.close();
         }
         outputStream.flush();
         document.close();
         outputStream.close();
      } catch (Throwable t) {
         t.printStackTrace();
      } finally {
         if (document.isOpen())
            document.close();
         try {
            if (outputStream != null)
               outputStream.close();
         } catch (IOException ioe) {
            ioe.printStackTrace();
         }
      }
   }

   public static void concatPDFsWithPdfBox(List<InputStream> streamOfPDFFiles, OutputStream outputStream, boolean paginate) throws MyException {

      com.itextpdf.text.Document document = new com.itextpdf.text.Document();
      try {
         List<InputStream> pdfs = streamOfPDFFiles;
         Iterator<InputStream> iteratorPDFs = pdfs.iterator();
         PDFMergerUtility merger = new PDFMergerUtility();
         merger.setIgnoreAcroFormErrors(true);
         while (iteratorPDFs.hasNext()) {
            InputStream pdf = iteratorPDFs.next();


            merger.addSource(pdf);
            // pdf.close();

         }

         merger.setDestinationStream(outputStream);
         merger.mergeDocuments(null);
         outputStream.flush();
         outputStream.close();



      } catch (Exception e) {

         throw new MyException(e.getMessage());
      } finally {
         if (document.isOpen())
            document.close();
         try {
            if (outputStream != null)
               outputStream.close();
         } catch (IOException ioe) {
            throw new MyException(ioe.getMessage());
         }
      }
   }
}
