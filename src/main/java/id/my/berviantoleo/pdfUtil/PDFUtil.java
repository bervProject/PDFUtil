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

import java.io.Console;
import java.util.Objects;

public class PDFUtil {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("please bring parameter: <operation> <source> <target>");
            return;
        }
        if (Objects.equals(args[0], "merge")) {
            MultiPdf.mergePdf(args[1], args[2]);
        } else if (Objects.equals(args[0], "removePwd")) {
            Console cnsl = System.console();
            if (cnsl == null) {
                System.out.println("No console available");
                return;
            }
            char[] ch = cnsl.readPassword("Please insert pdf password:");
            SinglePdf.removePdfPassword(args[1], String.valueOf(ch), args[2]);
        } else {
            System.out.println("invalid operation");
        }
    }
}
