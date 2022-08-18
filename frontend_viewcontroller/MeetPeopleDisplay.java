/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend_viewcontroller;

/**
 *
 * @author student
 */
import backend_models.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MeetPeopleDisplay extends JFrame implements ActionListener {
//a list
//two buttons? maybe one
//Searchbar
//need more than one panel

    BackendModel theBackendModel;
    SearchEngine theSearchEngine = new SearchEngine();
    JFrame frame;
    Account viewedAccount;

    public MeetPeopleDisplay(BackendModel theBackendModel) {
        this.theBackendModel = theBackendModel;
        this.setResizable(false);
        this.initComponents();
    }
    //this frame
    JButton viewPersonBtn;
    JButton backBtn;
    JButton searchBtn;
    JList peopleList;
    JTextField searchField;
    String[] users;

    //frame 2
    JButton addFriend;
    JLabel profilePicture;
    JTextArea bio;
    JList friends;
    JList interests;
    JLabel username;
    JScrollPane bioContent;

    private void initComponents() {
        frame = new JFrame();
        JLabel label = new JLabel("Suggested Users");
        viewPersonBtn = new JButton("View User");
        viewPersonBtn.setActionCommand("myButton");
        viewPersonBtn.addActionListener(this);
        backBtn = new JButton("Back");
        searchBtn = new JButton("Search");
        String[] names = {"George", "Michael", "Jane"};
        peopleList = new JList(names);
        searchField = new JTextField("Search");
        JLabel interestsLabel = new JLabel("Interests");

        addFriend = new JButton("Add Friend");
        profilePicture = new JLabel();
        bio = new JTextArea();
        this.bio.setLineWrap(true);
        this.bio.setEditable(false);
        this.bio.setWrapStyleWord(true);
        this.bioContent = new JScrollPane(this.bio);
        friends = new JList();
        interests = new JList();
        username = new JLabel();

        this.setMinimumSize(new Dimension(450, 500));
        Container meetPeopleDisplayPane = this.getContentPane();
        meetPeopleDisplayPane.setLayout(new GridBagLayout());

        frame.setMinimumSize(new Dimension(400, 600));
        Container secondaryDisplayPane = frame.getContentPane();
        secondaryDisplayPane.setLayout(new GridBagLayout());
        frame.setResizable(false);
        GridBagConstraints c;

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 5;
        c.gridy = 1;
        c.weighty = 5;
        c.weightx = 1;

        meetPeopleDisplayPane.add(this.viewPersonBtn, c);

        c = new GridBagConstraints();

        c.gridx = 9;
        c.gridy = 15;
        c.weighty = 5;
        c.weightx = 1;
        meetPeopleDisplayPane.add(this.backBtn, c);

        c = new GridBagConstraints();

        c.gridx = 1;
        c.gridy = 15;
        c.weighty = 5;
        c.weightx = 1;
        meetPeopleDisplayPane.add(this.searchBtn, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 3;
        c.gridy = 3;
        c.weighty = 5;
        c.weightx = 1;
        c.ipady = 175;
        c.ipadx = 150;
        meetPeopleDisplayPane.add(this.peopleList, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 3;
        c.gridy = 2;
        c.weighty = 5;
        c.weightx = 1;
        meetPeopleDisplayPane.add(label, c);

        c = new GridBagConstraints();

        c.gridx = 3;
        c.gridy = 15;
        c.weighty = 5;
        c.weightx = 1;
        c.ipady = 8;
        c.ipadx = 175;
        meetPeopleDisplayPane.add(this.searchField, c);
        //frame 2
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 4;
        c.weightx = 4;
        secondaryDisplayPane.add(username, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        secondaryDisplayPane.add(profilePicture, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 2;
        c.gridy = 2;
        c.weighty = 1;
        c.weightx = 1;
        secondaryDisplayPane.add(friends, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 3;
        c.gridy = 4;
        c.weighty = 1;
        c.weightx = 1;
        c.ipadx = 20;
        c.ipady = 100;
        secondaryDisplayPane.add(new JScrollPane(interests), c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 3;
        c.gridy = 2;
        c.weighty = 1;
        c.weightx = 1;
        secondaryDisplayPane.add(interestsLabel, c);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 4;
        c.gridy = 2;
        c.weighty = 1;
        c.weightx = 1;
        secondaryDisplayPane.add(addFriend, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 4;
        c.ipadx = 15;
        c.ipady = 150;
        secondaryDisplayPane.add(bioContent, c);
    }

    //when click search update list
    void update() {
        users = theSearchEngine.getSuggestedUsers(theBackendModel.clientAccount);
        peopleList.setListData(users);
    }

    void viewUser(String username) throws IOException {
        viewedAccount = new Account(username);
        this.username.setText(username);
        profilePicture.setIcon(new ImageIcon(viewedAccount.getProfilePicture()));
        bio.setText(viewedAccount.getBio());
        interests.setListData(viewedAccount.getInterestArray());

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            try {
                if (!peopleList.isSelectionEmpty()) {
                    viewUser(peopleList.getSelectedValue().toString());
                }
            } catch (IOException ex) {
                Logger.getLogger(MeetPeopleDisplay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void search() {
        if (theSearchEngine.searchIfUserExists(searchField.getText())) {
            try {
                viewUser(searchField.getText());
            } catch (IOException ex) {
                Logger.getLogger(MeetPeopleDisplay.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "User not found", "Gosh dangit", JOptionPane.ERROR_MESSAGE);
        }

    }

    void addFriend() {
        theBackendModel.friendList.addFriend(viewedAccount.getUsername());
        Friends f = new Friends(viewedAccount.getUsername());
        f.addFriend(theBackendModel.clientAccount.getUsername());

        Notification.createNotification(viewedAccount.getUsername(), "Friend Request", theBackendModel.clientAccount.getUsername());
        frame.setVisible(false);
    }

}
