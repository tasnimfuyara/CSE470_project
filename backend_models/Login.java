/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;
import java.net.*;
import java.io.*;
import java.util.*;


public class Login {

    public boolean userLogin(String username, String pass) throws IOException, Exception {
        //decrypt db
        //check
//      f.decrypt();
       
       username = username.toLowerCase();
        String userPassString = username + ":" + pass + "¿";
        return readDbd().contains(userPassString); //yay
    }
    
    public String readDbd() throws IOException{
        TextFile f = new TextFile("database.txt");
        return f.fileContent;
    }

    
   

   
}
