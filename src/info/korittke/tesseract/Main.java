package info.korittke.tesseract;

import java.io.File;
import net.sourceforge.tess4j.*;

public class Main {
    public static void main(String[] args) {
        System.setProperty("jna.library.path", "32".equals(System.getProperty("sun.arch.data.model")) ? "lib/win32-x86" : "lib/win32-x86-64");

        File imageFile = new File("eurotext.pdf");
        Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
        instance.setLanguage("deu");
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
