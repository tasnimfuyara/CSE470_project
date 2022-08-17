package backend_models;

import java.util.*;
import java.io.*;

/**
 *
 * @author Homer
 */
public class TextFile {

    public String fileContent = "";
    public String path = "";

    public TextFile(String path) throws IOException { // throws IOException ?
        this.fileContent = TextFile.readFile(path);
        this.path = path;
    }

    public void encrypt() {
        char[] s = new char[fileContent.length()];
        for (int p = 0; p < s.length; p++) {
            s[p] = fileContent.charAt(p);

        }

        char[] a = EnDecrypter.encrypt(s);
        fileContent = "";
        for (int p = 0; p < a.length; p++) {

            fileContent += a[p];
        }

    }

    public void decrypt() {
        char[] s = new char[fileContent.length()];
        for (int p = 0; p < s.length; p++) {
            s[p] = fileContent.charAt(p);

        }

        char[] a = EnDecrypter.decrypt(s);
        fileContent = "";
        for (int p = 0; p < a.length; p++) {

            fileContent += a[p];
        }
    }
 
    public void saveToDisk(String path) throws IOException { // throws IOException?

        FileWriter fw = new FileWriter(path);
        PrintWriter stringToSave = new PrintWriter(fw);
        stringToSave.print(fileContent);
       
        stringToSave.close();     
        fw.close(); 

    }

    public static String readFile(String path) throws IOException { // throws IOException
        Scanner sc = new Scanner(new File(path));
        String stringtogive = "";
        while (sc.hasNext()) {
            stringtogive += sc.nextLine() + "\n";
        }
        
        //System.out.println(stringtogive);
        sc.close();
        return stringtogive;
    }
}
