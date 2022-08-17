/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Notification {
//notificationLog.txt

    String notificationLog[];
    //   String nldbd = "";

    public Notification() {
        try {
            TextFile f = new TextFile("notificationLog.txt");
            // nldbd = f.fileContent;
            notificationLog = f.fileContent.split("\n");
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void createNotification(String userTo, String type, String info) {

        try {
            TextFile f = new TextFile("notificationLog.txt");
            String nldbd = f.fileContent;
            FileWriter fw = new FileWriter("notificationLog.txt");
            
            if(nldbd.indexOf(userTo + ", " + type + ", " + info) == -1){
            nldbd += userTo + ", " + type + ", " + info + "\n";
            PrintWriter pw = new PrintWriter(fw);
            pw.print(nldbd);
            pw.close();
            fw.close();
           }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean checkNotifications(String username) {
        //loop through and check if any notifications exist for the user
        for (String notificationLog1 : notificationLog) {
            if (notificationLog1.startsWith(username)) {
                return true;
            }
        }
        return false;
    }

    public String[] getNotificationInfoArray(String username) { //each index is all the info for the notification
        //loop through and add each line that starts with the username and add it to a list
        //convert list to String array and return it

        ArrayList<String> l = new ArrayList();
        for (int i = 0; i < notificationLog.length; i++) {
            if (notificationLog[i].startsWith(username.toLowerCase())) {
                l.add(notificationLog[i]);
            }
        }

        String[] a = new String[l.size()];
        a = l.toArray(a);
        return a;
    }

    public String[] getNotification(String info) {
        //split
        //each index is what you want to display
        //index one is the type
        //index two is the info
        //remove the notification from the DB
        String[] a = info.split(", "); //usernamec, Friend Request, usernamea, 

        return a;
    }

    public void removeNotification(String info) {
        FileWriter fw;
        try {
            String[] b = new String[notificationLog.length - 1];
            bigLoop:
            for (int i = 0; i < notificationLog.length; i++) {
                if (notificationLog[i].equals(info)) {

                    for (int c = 0; c < b.length; c++) {
                        b[c] = notificationLog[c];
                    }

                    break bigLoop;
                }
            }
            notificationLog = b;
            fw = new FileWriter("notificationLog.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < b.length; i++) {
                pw.println(b[i]);
            }

            pw.close();
            fw.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

}
