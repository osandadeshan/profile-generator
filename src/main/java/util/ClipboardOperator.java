package util;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Project Name    : profile-generator
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 2/4/2020
 * Time            : 10:55 AM
 * Description     : This class can be used to copy a given string to the system clipboard and also to read the copied string from the system clipboard
 **/


public class ClipboardOperator {

    public static void copyToClipboard(String text) {
        StringSelection data = new StringSelection(text);
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.setContents(data, data);
    }

    public static String readFromClipboard() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String result = null;
        try {
            result = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
