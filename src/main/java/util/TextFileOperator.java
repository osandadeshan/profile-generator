package util;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Project Name    : profile-generator
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 2/4/2020
 * Time            : 10:53 AM
 * Description     : This class can be used to read a given text file as a string and also to write a given string to a given text file
 **/


public class TextFileOperator {

    public static void write(String text, String filePath) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            writer.write(text);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getDataAsString(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        }
    }


}
