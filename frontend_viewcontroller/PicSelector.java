/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend_viewcontroller;

import backend_models.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cerva
 */
//Scrolling?
//Ideally 6 Pictures at a time
//3 skin colors
//2 genders
//8 Radio Buttons
//8 Labels
//1 confirm button
public class PicSelector extends JFrame implements ActionListener {
 
    HomePageDisplay theHomePageDisplay;
    BackendModel theBackendModel;
    MyProfileDisplay theProfile;
    ButtonGroup group;
    JRadioButton button1;
    JRadioButton button2;
    JRadioButton button3;
    JRadioButton button4;
    JRadioButton button5;
    JRadioButton button6;
    JButton backBtn;
    JButton confirm;
    JLabel maleW,
            maleA,
            maleB,
            femaleW,
            femaleA,
            femaleB;

    public PicSelector(BackendModel theBackendModel) {
        setTitle("Choose a Picture");
       this.theBackendModel = theBackendModel;
        this.initComponents();
    }

    private void initComponents() {
        maleW = new JLabel();
        maleA = new JLabel();
        maleB = new JLabel();
        femaleW = new JLabel();
        femaleA = new JLabel();
        femaleB = new JLabel();

        group = new ButtonGroup();
        button1 = new JRadioButton("Male 2"); 
        button2 = new JRadioButton("Male 1");
        button3 = new JRadioButton("Male 3");
        button4 = new JRadioButton("Female 2");
        button5 = new JRadioButton("Female 1");
        button6 = new JRadioButton("Female 3");
        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);
        group.add(button5);
        group.add(button6);
        confirm = new JButton("Confirm");
        backBtn = new JButton("Back");
        backBtn.setActionCommand("myButton");
        backBtn.addActionListener(this);
        this.setMinimumSize(new Dimension(700, 500));
        this.setResizable(false);
        Container picSelectorPane = this.getContentPane();
        picSelectorPane.setLayout(new GridBagLayout());
        GridBagConstraints c;

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        maleW.setIcon(new ImageIcon("Images/male1.png"));
        c.gridx = 2;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(this.maleW, c);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        
        maleA.setIcon(new ImageIcon("Images/male2.png"));
        c.gridx = 1;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(this.maleA, c);
        
        maleB.setIcon(new ImageIcon("Images/male3.png"));
         c.gridx = 3;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(this.maleB, c);
        
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        femaleW.setIcon(new ImageIcon("Images/female1.png"));
        c.gridx = 2;
        c.gridy = 1;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(this.femaleW, c);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        
        femaleA.setIcon(new ImageIcon("Images/female3.png"));
        c.gridx = 3;
        c.gridy = 1;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(this.femaleA, c);
        
        femaleB.setIcon(new ImageIcon("Images/female2.png"));
        c.gridx = 1;
        c.gridy = 1;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(this.femaleB, c);
        
        c = new GridBagConstraints();
        c.gridx = 5;
        c.gridy = 9;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(button1, c);
        
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 9;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(button2, c);
        
        c = new GridBagConstraints();
        c.gridx = 6;
        c.gridy = 9;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(button3, c);
        c = new GridBagConstraints();
        c.gridx = 8;
        c.gridy = 9;
        c.weighty = 1;
        c.weightx = 1;
       picSelectorPane.add(button4, c);
        c = new GridBagConstraints();
        c.gridx = 7;
        c.gridy = 9;
        c.weighty = 1;
        c.weightx = 1;
      picSelectorPane.add(button5, c);
        c = new GridBagConstraints();
        c.gridx = 9;
        c.gridy = 9;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(button6, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 9;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(confirm, c);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 9;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(backBtn, c);

        this.pack();

    }

    void choosePicture() throws IOException{
       
         
        if (button1.isSelected()) {
            theBackendModel.clientAccount.setProfilePicture("male1");
            theHomePageDisplay.profilePicture.setIcon(new ImageIcon(theBackendModel.clientAccount.getProfilePicture()));
            theProfile.updateInfo();
        }
        if ( button2.isSelected() ) {
            theBackendModel.clientAccount.setProfilePicture("male2");
            theHomePageDisplay.profilePicture.setIcon(new ImageIcon(theBackendModel.clientAccount.getProfilePicture()));
            theProfile.updateInfo();
        }
        if ( button3.isSelected() ) {
            theBackendModel.clientAccount.setProfilePicture("male3");
            theHomePageDisplay.profilePicture.setIcon(new ImageIcon(theBackendModel.clientAccount.getProfilePicture()));
            theProfile.updateInfo();
        }
        if (button4.isSelected()) {
            theBackendModel.clientAccount.setProfilePicture("female1");
            theHomePageDisplay.profilePicture.setIcon(new ImageIcon(theBackendModel.clientAccount.getProfilePicture()));
            theProfile.updateInfo();
        }
        if ( button5.isSelected() ) {
            theBackendModel.clientAccount.setProfilePicture("female2");
            theHomePageDisplay.profilePicture.setIcon(new ImageIcon(theBackendModel.clientAccount.getProfilePicture()));
            theProfile.updateInfo();
        }
        if ( button6.isSelected() ) {
            theBackendModel.clientAccount.setProfilePicture("female3");
            theHomePageDisplay.profilePicture.setIcon(new ImageIcon(theBackendModel.clientAccount.getProfilePicture()));
            theProfile.updateInfo();
        }
        this.setVisible(false);
    }

    void setHomePage(HomePageDisplay theHomePage, MyProfileDisplay theProfile){
        this.theHomePageDisplay = theHomePage;
        this.theProfile = theProfile;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            this.setVisible(false);
        }
    }

}
