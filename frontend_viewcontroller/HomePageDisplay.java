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
public class HomePageDisplay extends JFrame implements ActionListener {

    BackendModel theBackendModel;
    PicSelector thePicSelector;
    MyProfileDisplay theProfile;
    PersonalityTestDisplay thePersonalityTest;
    CreateEventDisplay theCreateEventDisplay;
    MeetPeopleDisplay theMeetPeopleDisplay;
    ChatDisplay theChatDisplay;
    //apx 7 Buttons
    //2 lists
    //1 image
    JButton changeProfilePicBtn;
    JButton personalityTestBtn;
    JButton myProfileBtn;
    JButton meetPeopleBtn;
    JButton sendChatBtn;
    JButton viewEventBtn;
    JButton createEventBtn;
    JLabel profilePicture;
    JLabel chat;
    JLabel eventHistoryLabel;
    JList chatHistory;
    JList eventHistory;

    public HomePageDisplay(BackendModel aBackend, PicSelector thePicSelector, MyProfileDisplay theProfile, PersonalityTestDisplay thePersonalityTest, MeetPeopleDisplay theMeetPeopleDisplay, ChatDisplay theChatDisplay) {
        setTitle("HomePage");
        this.theBackendModel = aBackend;
        this.thePicSelector = thePicSelector;
        this.theProfile = theProfile;
        this.thePersonalityTest = thePersonalityTest;
        this.theMeetPeopleDisplay = theMeetPeopleDisplay;
        this.theChatDisplay = theChatDisplay;
        this.initComponents();
    }
//Be the home page

    private void initComponents() {
        if (!this.isVisible()) {
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setMinimumSize(new Dimension(500, 700));
            personalityTestBtn = new JButton("Personality Test");
            changeProfilePicBtn = new JButton("Change Profile Picture");
            myProfileBtn = new JButton("My Profile");
            meetPeopleBtn = new JButton("Meet People");
            profilePicture = new JLabel();
            String[] a = {"No chat"};
            chatHistory = new JList(a);
            JScrollPane listScroller = new JScrollPane(chatHistory);
            listScroller.setPreferredSize(new Dimension(250, 80));
            eventHistory = new JList();
            JScrollPane listScroller2 = new JScrollPane(eventHistory);
            listScroller2.setPreferredSize(new Dimension(250, 80));
            sendChatBtn = new JButton("Send Chat");
            viewEventBtn = new JButton("View Event");
            createEventBtn = new JButton("Create Event");
            myProfileBtn.setActionCommand("myButton");
            myProfileBtn.addActionListener(this);
            chat = new JLabel("Chat");
            eventHistoryLabel = new JLabel("Events");

            Container homeDisplayPane = this.getContentPane();
            homeDisplayPane.setLayout(new GridBagLayout());
            this.setResizable(false);
            GridBagConstraints c;

            c = new GridBagConstraints();
            c.anchor = GridBagConstraints.NORTHWEST;
            c.ipady = 30;
            c.ipadx = 30;
            c.gridx = 5;
            c.gridy = 1;
            c.weighty = 5;
            c.weightx = 1;
            homeDisplayPane.add(this.changeProfilePicBtn, c);
            c = new GridBagConstraints();
            c.ipady = 30;
            c.ipadx = 30;
            c.anchor = GridBagConstraints.NORTHWEST;
            c.gridx = 0;
            c.gridy = 0;
            c.weighty = 1;
            c.weightx = 1;
            homeDisplayPane.add(this.personalityTestBtn, c);
            c = new GridBagConstraints();
            c.ipady = 30;
            c.ipadx = 30;
            c.anchor = GridBagConstraints.NORTHWEST;
            c.gridx = 0;
            c.gridy = 1;
            c.weighty = 1;
            homeDisplayPane.add(this.myProfileBtn, c);

            c = new GridBagConstraints();
            c.ipady = 30;
            c.ipadx = 30;
            c.anchor = GridBagConstraints.NORTHWEST;
            c.gridx = 0;
            c.gridy = 2;
            c.weighty = 2;
            c.weightx = 1;
            homeDisplayPane.add(this.meetPeopleBtn, c);

//            c = new GridBagConstraints();
//            c.anchor = GridBagConstraints.NORTHWEST;
//            c.gridx = 0;
//            c.gridy = 4;
//            c.weighty = 2;
//            c.weightx = 1;
//            homeDisplayPane.add(this.chatHistory, c);
//            c = new GridBagConstraints();
//            c.anchor = GridBagConstraints.NORTHWEST;
//            c.gridx = 0;
//            c.gridy = 3;
//            c.weighty = 2;
//            c.weightx = 1;
//            homeDisplayPane.add(this.chat, c);
            c = new GridBagConstraints();
            c.anchor = GridBagConstraints.NORTHWEST;
            c.gridx = 4;
            c.gridy = 4;
            c.ipadx = 4;
            c.ipady = 8;
            c.weighty = 2;
            c.weightx = 1;
            homeDisplayPane.add(this.eventHistory, c);
            c = new GridBagConstraints();
            c.anchor = GridBagConstraints.NORTHWEST;
            c.gridx = 4;
            c.gridy = 3;
            c.weighty = 2;
            c.weightx = 1;
            homeDisplayPane.add(this.eventHistoryLabel, c);

            c = new GridBagConstraints();
            c.anchor = GridBagConstraints.NORTHWEST;
            c.ipady = 30;
            c.gridx = 0;
            c.ipadx = 30;
            c.gridy = 5;
            c.weighty = 2;
            c.weightx = 1;
            homeDisplayPane.add(this.sendChatBtn, c);

            c = new GridBagConstraints();
            c.anchor = GridBagConstraints.NORTHWEST;
            c.ipady = 30;
            c.ipadx = 30;
            c.gridx = 5;
            c.gridy = 4;
            c.weighty = 2;
            c.weightx = 1;
            homeDisplayPane.add(this.viewEventBtn, c);

            c = new GridBagConstraints();
            c.anchor = GridBagConstraints.NORTHWEST;
            c.gridx = 5;
            c.ipadx = 30;
            c.ipady = 30;
            c.gridy = 5;
            c.weighty = 2;
            c.weightx = 1;
            homeDisplayPane.add(this.createEventBtn, c);
            // add(btn);
            c = new GridBagConstraints();
            c.anchor = GridBagConstraints.NORTHWEST;
            c.gridx = 5;
            c.gridy = 0;
            c.weighty = 1;
            c.weightx = 1;
            homeDisplayPane.add(this.profilePicture, c);
            this.pack();
        }
    }

    void changePicture() {
        if (!thePicSelector.isVisible()) {
            thePicSelector.setVisible(true);
            thePicSelector.setHomePage(this, theProfile);
        }
    }

    void goToProfile() {
        theProfile.setVisible(true);
    }

    void goToMeetPeople() {
        //update meetPeopleDisplay\
        theMeetPeopleDisplay.update();
        theMeetPeopleDisplay.setVisible(true);

    }

    void doPersonalityTest() {
        if (!thePersonalityTest.checkIfFinished()) {
            thePersonalityTest.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Already finished test for this session!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            theProfile.updateInfo();
        }
    }

    public void updateEventList() throws IOException {

        if (theBackendModel.theEvents.getEvents()[0] == null) {
            String[] a = {"No Events"};
            eventHistory.setListData(a);
            return;
        }
        eventHistory.setListData(theBackendModel.theEvents.getEvents());

    }

    public void viewEvent() throws IOException {
        if (!eventHistory.isSelectionEmpty()) {
            String[] a = theBackendModel.theEvents.viewEvent(eventHistory.getSelectedValue().toString());
            if (a[1] != null) {
                JOptionPane.showMessageDialog(this, a[1] + " hosted at " + a[2] + " \nAt " + a[3] + " by " + a[4] + ".\nAdditional Details: " + a[5]);
            }
        } //else if ( eventHistory.getElementAt(0).equals("")){
        //error 
        else {
            JOptionPane.showMessageDialog(this, "Please select an event to view", ">:'(", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void getNotifications(String username) {
        Notification a = new Notification();
        int notificationCount = 0;
        //String[] d = a.getNotificationInfoArray(username);
        while (a.checkNotifications(username)) {
            String info;
            System.out.println(a.getNotificationInfoArray(username)[notificationCount]);
            if (a.getNotification(a.getNotificationInfoArray(username)[notificationCount])[1].equals("Friend Request")) {
                //loop through and get info
                String dfs = a.getNotification(a.getNotificationInfoArray(username)[notificationCount])[2];
                info = "You have been added as a friend by " + dfs;
                JOptionPane.showMessageDialog(this, info);
                a.removeNotification(a.getNotificationInfoArray(username)[notificationCount]);
                notificationCount++;
            } else if (a.getNotification(a.getNotificationInfoArray(username)[notificationCount])[1].equals("Chat")) {
                String dfs = a.getNotification(a.getNotificationInfoArray(username)[notificationCount])[2];
                info = "You have recieved a new message from " + dfs;
                JOptionPane.showMessageDialog(this, info);
                a.removeNotification(a.getNotificationInfoArray(username)[notificationCount]);
                notificationCount++;
            }

        }
    }

    void goToChat() {
        theChatDisplay.update();
        theChatDisplay.setVisible(true);
    }

}
