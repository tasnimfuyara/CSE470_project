/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class CreateAcc extends Login {
String dbd;
    public void createAcc(String username, String pass, String school, String gender) throws IOException {
        //getUser/Pass
        //check if User/Pass exists
        //yes-kick no-savetofile
        //encrypt
        username = username.toLowerCase();
        String userPassString = username + ":" + pass + "¿";
//       f.decrypt();
        //TextFile db = new TextFile("database.txt");
        dbd = readDbd();
        TextFile f = new TextFile("interestDB.txt");
        String itdbd = f.fileContent;

        FileWriter fw = new FileWriter("database.txt");
        PrintWriter pw = new PrintWriter(fw);
        if (school.equals("None of the Above")) {
            school = "none";
        }

        String userInfo = dbd + userPassString + school + "¡" + gender + "¤" + "default¡" + "0000:" + "\n";
        //System.out.print(userInfo);
        pw.print(userInfo);
        pw.close();
        fw.close();
        fw = new FileWriter("interestDB.txt");
        pw = new PrintWriter(fw);
        pw.print(itdbd + username + ":\n");
        pw.close();
        fw.close();

        TextFile friends = new TextFile("FriendsDB.txt");
        FileWriter ffw = new FileWriter("FriendsDB.txt");
        PrintWriter ppw = new PrintWriter(ffw);
        String friendsDB = friends.fileContent;
        //System.out.println(friends.fileContent);
        //friendsDB += username + ":, \n";
        ppw.print(friendsDB += username + ":, \n");
        ppw.close();
        ffw.close();
    }

    public boolean checkAcc(String username, String pass) throws IOException {
        username = username.toLowerCase();
        String usernameandpassword = username + pass;
        String userPassString = username + ":" + pass + "¿";
        dbd = readDbd();
//       f.decrypt();
        if (dbd.contains(username + ":") || userPassString.contains("username:") || usernameandpassword.contains("¤") || usernameandpassword.contains("¿") || usernameandpassword.contains("¡")) {
            return false;
        } else {
            return true;
        }

    }

}
