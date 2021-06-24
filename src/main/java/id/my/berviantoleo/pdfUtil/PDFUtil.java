package id.my.berviantoleo.pdfUtil;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import java.io.Console;
import java.io.File;
import java.io.IOException;

public class PDFUtil {

    public static void removePdfPassword(String source, String password, String target) {
        try {
            File file = new File(source);
            PDDocument doc = PDDocument.load(file, password);
            System.out.printf("PDFEncrypt: %b, totalPages: %d \n", doc.isEncrypted(), doc.getPages().getCount());
            doc.setAllSecurityToBeRemoved(true);
            doc.save(target);
            doc.close();
        } catch (InvalidPasswordException ex) {
            System.out.println("Please provide correct password because it's password protected");
        } catch (IOException ex) {
            System.out.println("File not found!");
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("please bring parameter: <source> <target>");
            return;
        }
        Console cnsl = System.console();
        if (cnsl == null) {
            System.out.println("No console available");
            return;
        }
        char[] ch = cnsl.readPassword("Please insert pdf password:");
        removePdfPassword(args[0], String.valueOf(ch), args[1]);
    }
}
