package generator;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.ClipboardOperator.copyToClipboard;
import static util.ClipboardOperator.readFromClipboard;
import static util.TextFileOperator.write;
import static util.TextFileOperator.getDataAsString;

/**
 * Project Name    : profile-generator
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 2/4/2020
 * Time            : 10:30 AM
 * Description     : This class can be used to generate maven profile using the ports from jenkins
 **/


public class ProfileGenerator {

    private static final String PROJECT_DIR = System.getProperty("user.dir");
    private static final String RESOURCES_DIR = PROJECT_DIR + File.separator + "src" + File.separator + "main" + File.separator + "resources";
    private static final String placeHolder = "#placeHolder";

    private static String profile, portsFromJenkins;

    /*
    Read "placeholder_profile.txt" text file and assign the content to "profile".
    Read system clipboard and assign the content to "portsFromJenkins"
    */
    static {
        try {
            profile = getDataAsString(RESOURCES_DIR + File.separator + "placeholder_profile.txt");
            portsFromJenkins = readFromClipboard();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateAndCopyProfileToClipboard() {
        // Split the whole string "portsFromJenkins" by line breaks and assign it to a string array named "portsArray"
        String[] portsArray = portsFromJenkins.split("\\r?\\n");

        // Remove the dash line elements from the array "portsArray"
        portsArray = ArrayUtils.remove(portsArray, 2);
        portsArray = ArrayUtils.remove(portsArray, 7);
        portsArray = ArrayUtils.remove(portsArray, 14);

        // Remove the unwanted elements from the array "portsArray" (Mock Server ActiveMQ:, Fake Email Server:, Emulated Thirdparty Services Port:)
        portsArray = ArrayUtils.remove(portsArray, 1);
        portsArray = ArrayUtils.remove(portsArray, 13);
        portsArray = ArrayUtils.remove(portsArray, 15);

        // Create a string array list named "portsArrayList" from the string array "portsArray"
        ArrayList<String> portsArrayList = new ArrayList<>(Arrays.asList(portsArray));

        // Assign real port number to the string "profile"
        for (int i = 1; i <= portsArrayList.size(); i++) {
            Matcher matcher = Pattern.compile(": ").matcher(portsArrayList.get(i - 1));
            if (matcher.find()) {
                if (i < 10) {
                    profile = profile.replace(placeHolder.concat("0").concat(String.valueOf(i)), portsArrayList.get(i - 1).substring(matcher.end()).trim());
                } else {
                    profile = profile.replace(placeHolder.concat(String.valueOf(i)), portsArrayList.get(i - 1).substring(matcher.end()).trim());
                }
            }
        }

        // Print the processed profile to the console
        System.out.println(profile);

        // Write the processed profile to a text file
        write(profile, "processed_profile.txt");

        // Copy the processed profile to the system clipboard
        copyToClipboard(profile);
    }


}
