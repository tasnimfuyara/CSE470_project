/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend_viewcontroller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JFrame;

/**
 *
 * @author student
 */
public class AddInterestDisplay extends JFrame{
    BackendModel theBackendModel;
    public AddInterestDisplay(BackendModel theBackendModel) {
        setTitle("Add an Interest");
        this.theBackendModel = theBackendModel;
        this.initComponents();
    }
    JComboBox interestList;
    String[] interestArray = {"Anime", "Art", "Comedy", "Dance", "Drama", "Drugs", 
        "Gardening", "Music", "Politics","Reading", "Robots", "Sports", 
        "Video Games"};
            
    JButton confirm;
     private void initComponents() {
         //JComboBox
         //button
         //a few labels
         confirm = new JButton("Confirm");
         interestList = new JComboBox(interestArray);
         this.setMinimumSize(new Dimension(250, 100));
         
        Container addInterestDisplayPane = this.getContentPane();
        addInterestDisplayPane.setLayout(new GridBagLayout());
        GridBagConstraints c;
        
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        addInterestDisplayPane.add(this.interestList, c);
        
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 6;
        c.weighty = 1;
        c.weightx = 1;
        addInterestDisplayPane.add(this.confirm, c);
        
        
        
        this.pack();
     }
     
     void addInterest() throws IOException{
         String a = String.valueOf(interestList.getSelectedItem());
         if(! theBackendModel.clientAccount.getInterestList().contains(a)){
         theBackendModel.clientAccount.addInterest(a);
         }
         
         this.setVisible(false);
     }
}
