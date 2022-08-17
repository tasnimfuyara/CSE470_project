/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

import java.util.*;
import java.io.*;


public class Events {

    String eventDB;
    String[][] a = new String[10][6];
    String school;

    public Events(String school) throws IOException {
        TextFile f = new TextFile("eventDB.txt");
        eventDB = f.fileContent;
        this.school = school;
        
         String[] ff = eventDB.split("\n");
         
        for (int i = 0; i < ff.length; i++) {
            if ((i < ff.length)) {
                if (ff[i].startsWith(school) && ff[i] != null) {
                    a[i] = ff[i].split("~ ");
                }
            }
        }
    }

    public void createEvent(String school, String title, String location,
            String time, String user, String description) throws IOException {

        FileWriter fw = new FileWriter("eventDB.txt");
        PrintWriter pw = new PrintWriter(fw);
        if (!eventDB.contains(title + "~")) {
            pw.print(eventDB + school + "~ " + title + "~ " + location + "~ "
                    + time + "~ " + user + "~ " + description + "\n");
            pw.close();
        }
    }

    public String[] getEvents() throws IOException {

        //1 row is one event
        //each column is a different aspect
        //ex row 1 col 2 is title of first event
       
        String returnArray[] = new String[10];
        int ii = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i][1] != null) {
                returnArray[ii] = a[i][1];
                ii++;
            }
        }
        return returnArray;

    }

    public String[] viewEvent(String EventName) {
        String[] returnString = new String[6]; // 1 string for each aspect
        if (a[0][0] != null) {
            for (int i = 0; i < 10; i++) {
                if (a[i][1] == EventName) {
                    returnString = a[i];
                }
            }
        }
        return returnString;
    }
}
