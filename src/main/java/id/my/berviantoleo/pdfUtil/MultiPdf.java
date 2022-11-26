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

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

/**
 * MultiPdf handle multiple pdf(s) operational
 */
public class MultiPdf {
    /**
     * Merge n pdf(s) into 1 PDF
     * @param directory source of PDF(s), assuming all of those documents are PDF(s)
     * @param destination location for saving the merged PDF
     */
    public static void mergePdf(String directory, String destination) {
        try {
            System.out.println("Merge PDF");
            var stream = Files.newDirectoryStream(Path.of(directory));
            var iterator = stream.iterator();
            var docs = new PDDocument();
            while (iterator.hasNext()) {
                var currentPath = iterator.next();
                var doc = PDDocument.load(Files.readAllBytes(currentPath));
                var pages = doc.getPages();
                pages.forEach(docs::addPage);
                doc.close();
            }
            if (docs.getPages().getCount() > 0)
            {
                System.out.printf("TotalPages: %d \n", docs.getPages().getCount());
                docs.save(destination);
                docs.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
