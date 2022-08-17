/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

import java.io.*;
import java.util.*;

/**
 *
 * @author cerva
 */
public class SearchEngine {

    public String[] getSuggestedUsers(Account clientAccount) {
        //clientAccount.getInterestArray -- returns String[]
        //clientaccount.getPersonality -- returns int[]
        ArrayList<String> returnList = new ArrayList();
        String[] interestDBD;
        String[] dbd;
        Friends df = new Friends(clientAccount.getUsername());
        try {

            TextFile f = new TextFile("database.txt");
            TextFile ff = new TextFile("interestDB.txt");
            interestDBD = ff.fileContent.split("\n"); //information of each user
            dbd = f.fileContent.split("\n");
            
            String[] clientInterests = clientAccount.getInterestArray(); //array of client interests
            
            for (int i = 1; i < clientInterests.length; i++) {
                //interests 
                for (int d = 0; d < interestDBD.length; d++) {    

                    if (interestDBD[d].contains(clientInterests[i]) && dbd[d].contains(clientAccount.getSchool())) {
                        String username = "";
                        
                        for (int iii = 0; iii < interestDBD[d].length(); iii++) {

                            username += interestDBD[d].charAt(iii);
                            if (interestDBD[d].charAt(iii+1) == ':') {
                                break;
                            }
                        }
                        boolean friendNotAdded = true;
                        //need to check if friend is not already added
                        for(int dfs = 0; dfs < df.getFriends().length; dfs++){
                            if(df.getFriends()[dfs].equals(username)){
                                friendNotAdded = false;
                            }
                        }
                        
                        if (!(returnList.contains(username)) && !(username.equals(clientAccount.getUsername())) && friendNotAdded ) {
                            returnList.add(username);
                        }
                    }
                    
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return returnList.toArray(new String[0]);
    }

    public boolean searchIfUserExists(String searchString) {
        String a;
        try {
            TextFile f = new TextFile("database.txt");
            a = f.fileContent;
            if (a.contains(searchString.toLowerCase())) {
                return true;
            }
        } catch (IOException e) {
            
        }

       
            return false;
        
    }
    
    

}
