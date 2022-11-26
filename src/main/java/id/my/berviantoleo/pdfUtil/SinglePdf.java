/**
 *    Copyright 2022 Bervianto Leo Pratama
 * <p>
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * <p>
 *        http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package id.my.berviantoleo.pdfUtil;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import java.io.File;
import java.io.IOException;

/**
 * SinglePdf handle input with 1 PDF utilities
 */
public class SinglePdf {
    /**
     * Removing a password from a PDF
     * @param source file source
     * @param password password of the PDF
     * @param target target or destination PDF
     */
    public static void removePdfPassword(String source, String password, String target) {
        try {
            System.out.println("Remove PDF Password");
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
}
