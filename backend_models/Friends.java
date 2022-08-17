/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Friends {

    String clientUsername;
    String friendsDB = "";
    String friendsDBString;
    private ArrayList<String> friends;

    int a = 0;

    public Friends(String clientUsername) {
        this.clientUsername = clientUsername.toLowerCase();
        try {
            TextFile ff = new TextFile("FriendsDB.txt");
            this.friendsDB = ff.fileContent;
            friendsDBString = "";
            a = friendsDB.indexOf(clientUsername + ":");

            boolean doneLooping = false;
            while (!doneLooping) {
                friendsDBString += friendsDB.charAt(a);
                a++;

                // System.out.println(friendsDBS);
                if (friendsDBString.contains("\n")) {
                    doneLooping = true;
                }
            }
            // System.out.println(friendsDBS);
            friendsDBString = friendsDBString.substring(0, friendsDBString.lastIndexOf(", "));
            friends = new ArrayList<String>(Arrays.asList(friendsDBString.split(", ")));
            //System.out.println(friends.get(2));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addFriend(String username) {
        try {
            //System.out.println(friendsDB);
            if (!friendsDBString.contains(username + ", ")) {
                friends.add(username);
                friendsDBString = friendsDBString.replace("\n", "");
                friendsDB = friendsDB.replace(friendsDBString, friendsDBString + ", " + username);
                friendsDBString += username + ", \n";
                FileWriter fw = new FileWriter("FriendsDB.txt");
                PrintWriter pw = new PrintWriter(fw);
                pw.print(friendsDB);
                pw.close();

//                TextFile f = new TextFile("chatLog.txt");
//                fw = new FileWriter("chatLog.txt");
//                pw = new PrintWriter(fw);
//                if (!f.fileContent.contains(username + "&&" + clientUsername + " aaskopploo aaskopplooe")) {
//                    pw.print(f.fileContent + clientUsername + "&&" + username + " aaskopploo aaskopplooe");
//                    System.out.println("FUCK FUK");
//                }
//                pw.close();
//                fw.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void removeFriend(String username) {
        try {
            this.friends.remove(this.friends.indexOf(username));
            if (friendsDBString.contains(username + ", ")) { //if its not at the end
                friendsDB = friendsDB.replace(friendsDBString, friendsDBString.replace(", " + username, ""));
                FileWriter fw = new FileWriter("FriendsDB.txt");
                PrintWriter pw = new PrintWriter(fw);
                pw.print(friendsDB);
                pw.close();
                friendsDBString = friendsDBString.replace(", " + username, "");
            } else { //friend is at the end 
                friendsDB = friendsDB.replace(friendsDBString, friendsDBString.replace(", " + username, ""));
                FileWriter fw = new FileWriter("FriendsDB.txt");
                PrintWriter pw = new PrintWriter(fw);
                pw.print(friendsDB);
                pw.close();
                friendsDBString = friendsDBString.replace(", " + username, "\n");
            }
        } catch (IOException e) {

        }
    }

    public String[] getFriends() {
        String[] a = new String[friends.size()];
        int count = 0;
        if (a.length != 1) {
            for (int i = 1; i < a.length; i++) { //because I don't want to include the first element of the list

                a[count] = (String) friends.get(i);
                count++;

            }
            String[] b = new String[count];
            for (int i = 0; i < count; i++) {
                b[i] = a[i];

            }
            //a[a.length - 1] = a[a.length - 1].substring(0, a[a.length - 1].length() - 1); //so that it gets rid of the \n 
            return b;
        } else {
            String[] d = {"No friends"};
            return d;
        }
    }

}
