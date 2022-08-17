/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

import java.io.*;
import java.util.*;


public class Account {

    private String userString,
            interestString,
            username,
            school,
            gender,
            profilePic,
            profilePicString,
            dbd,
            itdbd,
            IE,
            NS,
            TF,
            PJ;
    private int[] personality;
    private ArrayList<String> interests;

    public Account(String username) throws IOException {

        this.username = username.toLowerCase();
        this.school = "";
        this.gender = "";
        userString = "";
        TextFile f = new TextFile("database.txt");
        this.dbd = f.fileContent;

        TextFile ff = new TextFile("interestDB.txt");
        this.itdbd = ff.fileContent;

        int a = dbd.indexOf(this.username + ":");
        boolean doneLooping = false;
        while (!doneLooping) {
            userString += dbd.charAt(a);
            a++;
            if (userString.contains("\n")) {
                doneLooping = true;
            }
        }   //System.out.println(userString);
        interestString = "";
        a = itdbd.indexOf(this.username + ":");
        doneLooping = false;
        while (!doneLooping) {
            interestString += itdbd.charAt(a);
            a++;
            if (interestString.contains("\n")) {
                doneLooping = true;
            }
        }   //System.out.println(userString);

        this.school = userString.substring(userString.indexOf("¿") + 1, userString.indexOf("¡"));
        this.gender = userString.substring(userString.indexOf("¡") + 1, userString.indexOf("¤"));
        this.profilePic = userString.substring(userString.indexOf("¤") + 1, userString.lastIndexOf("¡"));
        this.profilePicString = "Images/" + profilePic + ".png";
        this.personality = new int[4];
        for (int i = 0; i < 4; i++) {
            this.personality[i] = Integer.parseInt(userString.substring(userString.lastIndexOf("¡") + 1 + i, userString.lastIndexOf("¡") + 2 + i));
        }
        
   
        if (personality[0] == 1) {
            IE = "Extrovert";
        } else if (personality[0] == 0) {
            IE = "Introvert";
        }

        if (personality[1] == 0) {
            NS = "Intuitive";
        } else if (personality[1] == 1) {
            NS = "Sensing";
        }

        if (personality[2] == 0) {
            TF = "Thinking";
        } else if (personality[2] == 1) {
            TF = "Feeling";
        }

        if (personality[3] == 1) {
            PJ = "Judging";
        } else if (personality[3] == 0) {
            PJ = "Perceiving";
        }
        //    interests = Arrays.asList(interestString.split(", "));
        interests = new ArrayList<String>(Arrays.asList(interestString.split(", ")));
        // System.out.println(interests);
    }

    public String getProfilePicture() {
        return this.profilePicString;
    }

    public void setProfilePicture(String image) throws IOException {
        dbd = dbd.replace(userString, userString.replace(profilePic, image));
        this.profilePicString = "Images/" + image + ".png";
        FileWriter fw = new FileWriter("database.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.print(dbd);
        pw.close();

    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getSchool() {
        return school;
    }

    public String getEverything() {
        return userString;
    }

    public String getBio() {
        String bio = "Hi! My name is " + username + "! The University I go to is " + school + "!";
        if (gender.equals("none")) {
            bio += " I'm not a boy or a girl!";
        } else {
            bio += " I'm a " + gender + "!";
        }

        if (IE != null) {
            bio += " I'm an " + IE + ", " + NS + ", " + TF + ", " + PJ + " person! ";
        }
        if (interests.size() >= 2) {
            bio += "I like " + interests.get(1) + "!";
        }
        return bio;
    }

    public void setIE(int value) throws IOException { //value will be either 0 or 1
        personality[0] = value;
        if (personality[0] == 1) {
            IE = "Extrovert";
        } else if (personality[0] == 0) {
            IE = "Introvert";
        }
        int temp = personality[0] + 48;
        char[] ch = new char[userString.length()];
        for (int i = 0; i < userString.length(); i++) {
            ch[i] = userString.charAt(i);
        }
        ch[userString.lastIndexOf("¡") + 1] = (char) temp;
        String a = "";
        for (int i = 0; i < ch.length; i++) {
            a += ch[i];
        }
        dbd = dbd.replace(userString, a);
        userString = a;
        FileWriter fw = new FileWriter("database.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.print(dbd);
        pw.close();
    }

    public void setNS(int value) throws IOException {
        personality[1] = value;
        if (personality[1] == 0) {
            NS = "Intuitive";
        } else if (personality[1] == 1) {
            NS = "Sensing";
        }
        int temp = personality[1] + 48;
        char[] ch = new char[userString.length()];
        for (int i = 0; i < userString.length(); i++) {
            ch[i] = userString.charAt(i);
        }
        ch[userString.lastIndexOf("¡") + 2] = (char) temp;
        String a = "";
        for (int i = 0; i < ch.length; i++) {
            a += ch[i];
        }
        dbd = dbd.replace(userString, a);
        userString = a;
        FileWriter fw = new FileWriter("database.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.print(dbd);
        pw.close();

    }

    public void setTF(int value) throws IOException {
        personality[2] = value;
        if (personality[2] == 0) {
            TF = "Thinking";
        } else if (personality[2] == 1) {
            TF = "Feeling";
        }
        int temp = personality[2] + 48;
        char[] ch = new char[userString.length()];
        for (int i = 0; i < userString.length(); i++) {
            ch[i] = userString.charAt(i);
        }
        ch[userString.lastIndexOf("¡") + 3] = (char) temp;
        String a = "";
        for (int i = 0; i < ch.length; i++) {
            a += ch[i];
        }
        dbd = dbd.replace(userString, a);
        userString = a;
        FileWriter fw = new FileWriter("database.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.print(dbd);
        pw.close();
    }

    public void setPJ(int value) throws IOException {
        personality[3] = value;
        if (personality[3] == 1) {
            PJ = "Judging";
        } else if (personality[3] == 0) {
            PJ = "Perceiving";
        }
        int temp = personality[3] + 48;
        char[] ch = new char[userString.length()];
        for (int i = 0; i < userString.length(); i++) {
            ch[i] = userString.charAt(i);
        }
        ch[userString.lastIndexOf("¡") + 4] = (char) temp;
        String a = "";
        for (int i = 0; i < ch.length; i++) {
            a += ch[i];
        }
        dbd = dbd.replace(userString, a);
        userString = a;
        FileWriter fw = new FileWriter("database.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.print(dbd);
        pw.close();
    }

    public void addInterest(String interest) throws IOException {
        if (!interests.contains(interest)) {
            interests.add(interest);
            interestString = interestString.replace("\n", "");
            itdbd = itdbd.replace(interestString, interestString + ", " + interest);
            interestString += ", " + interest + "\n";
            FileWriter fw = new FileWriter("interestDB.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(itdbd);
            pw.close();
        }
    }

    public void removeInterest(String interest) throws IOException {
        this.interests.remove(this.interests.indexOf(interest));
        //  System.out.println(interestString = interestString.replace(interest + ", ", ""));
        if (interestString.contains(interest + ", ")) {
            itdbd = itdbd.replace(interestString, interestString.replace(", " + interest, ""));
            FileWriter fw = new FileWriter("interestDB.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(itdbd);
            pw.close();
            interestString = interestString.replace(", " + interest, "");
        } else { //interest is at the end 
            itdbd = itdbd.replace(interestString, interestString.replace(", " + interest, ""));
            FileWriter fw = new FileWriter("interestDB.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(itdbd);
            pw.close();
            interestString = interestString.replace(", " + interest, "\n");
        }
    }

    public String[] getInterestArray() { //first element is null

        String[] a = new String[interests.size()];
        if (a.length != 1) {
            for (int i = 1; i < a.length; i++) { //because I don't want to include the first element of the list
                a[i] = (String) interests.get(i);
            }

            return a;
       } else {
            String[] d = {"No interests"};
            return d;
        }
    }

    public List getInterestList() {
        return interests;
    }

    public int[] getPersonality() {
        return personality;
    }
}
