/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend_viewcontroller;

import backend_models.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author student
 */
//2 lists
//1 image
//1 really big label OR textField
//4 buttons
public class MyProfileDisplay extends JFrame implements ActionListener {

    PicSelector thePicSelector;
    BackendModel theBackendModel;
    AddInterestDisplay theAddInterestDisplay;

    public MyProfileDisplay(BackendModel theBackendModel, PicSelector thePicSelector) {
        setTitle("My Profile");
        this.theBackendModel = theBackendModel;
        this.thePicSelector = thePicSelector;
        this.initComponents();
    }
    JTextArea bio;
    JScrollPane bioContent;
    JLabel username;
    JLabel picture;
    JButton changePic;
    JButton addInterestBtn;
    JButton backBtn;
    JList interests;
    JLabel myFriends;
    JList friends;
    String[] b = {};
    String[] a = {"No Friends"};
    JButton removeInterestBtn;

    private void initComponents() {

        username = new JLabel();
        JLabel interestsLabel = new JLabel("My Interests");
        picture = new JLabel();
        bio = new JTextArea();
        backBtn = new JButton("Back");
        backBtn.setActionCommand("myButton");
        backBtn.addActionListener(this);
        changePic = new JButton("Change Profile Picture");
        addInterestBtn = new JButton("Add Interest");
        //move these later
        removeInterestBtn = new JButton("Remove Interest");

        interests = new JList(b);
        friends = new JList(a);
        myFriends = new JLabel("My Friends");
        this.bio.setLineWrap(true);
        this.bio.setEditable(false);
        this.bio.setWrapStyleWord(true);
        this.bioContent = new JScrollPane(this.bio);
        this.setMinimumSize(new Dimension(400, 600));
        this.setResizable(false);
        Container myProfilePane = this.getContentPane();
        myProfilePane.setLayout(new GridBagLayout());
        GridBagConstraints c;

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 4;
        c.weightx = 4;
        myProfilePane.add(username, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 4;
        c.weightx = 4;
        myProfilePane.add(changePic, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        myProfilePane.add(picture, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 4;
        c.gridy = 3;
        c.weighty = 1;
        c.weightx = 1;
        myProfilePane.add(addInterestBtn, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 2;
        c.gridy = 2;
        c.weighty = 1;
        c.weightx = 1;
        myProfilePane.add(friends, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 2;
        c.gridy = 1;
        c.weighty = 1;
        c.weightx = 1;
        myProfilePane.add(myFriends, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 3;
        c.gridy = 4;
        c.weighty = 1;
        c.weightx = 1;
        c.ipadx = 20;
        c.ipady = 100;
        myProfilePane.add(new JScrollPane(interests), c);
        
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 3;
        c.gridy = 2;
        c.weighty = 1;
        c.weightx = 1;
        myProfilePane.add(interestsLabel, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 3;
        c.gridy = 5;
        c.weighty = 1;
        c.weightx = 1;
        myProfilePane.add(removeInterestBtn, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 4;
        c.ipadx = 150;
        c.ipady = 150;
        myProfilePane.add(this.bioContent, c);

        c = new GridBagConstraints();
        c.gridx = 5;
        c.gridy = 5;
        myProfilePane.add(this.backBtn, c);

        this.pack();
    }

    void updateInfo() {

        username.setText(theBackendModel.clientAccount.getUsername());
        picture.setIcon(new ImageIcon(theBackendModel.clientAccount.getProfilePicture()));
        bio.setText(theBackendModel.clientAccount.getBio());
        friends.setListData(theBackendModel.friendList.getFriends());
        updateInterestListData();
        
    }

    void removeInterest() throws IOException {
        if (! interests.isSelectionEmpty()) {
            theBackendModel.clientAccount.removeInterest(interests.getSelectedValue().toString());
         updateInterestListData();
            
        } else {
            //error 
             JOptionPane.showMessageDialog(this, "Please select an interest to remove", ">:'(", JOptionPane.ERROR_MESSAGE);
        }
    }
    void updateInterestListData() {
    interests.setListData(theBackendModel.clientAccount.getInterestArray());
}

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            this.setVisible(false);
        }
    }

}
