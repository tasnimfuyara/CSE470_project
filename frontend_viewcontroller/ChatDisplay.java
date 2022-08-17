/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend_viewcontroller;

import backend_models.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author student
 */
public class ChatDisplay extends JFrame {
//A send button
//a text space
//A scrollable list that serves as the chat log
//A JComboBox with all the user's friends so they can choose who to chat with
//A select button to confirm they want to talk to that friend
    //the chatList updates when the user clicks confirm
//An error message that pops up if the user tries to send two consecutive chats

    JButton send;
    JTextField message;
    JComboBox friendsList;
    JButton confirm;
    JList chatHistory;
    JButton refreshBtn; 
    BackendModel theBackendModel;
    Chat theChat;
    String personTalkingTo;
    DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] {});
    public ChatDisplay(BackendModel theBackendModel) {
        this.theBackendModel = theBackendModel;
        this.initComponents();
    }

    private void initComponents() {
        send = new JButton("Send");
        message = new JTextField();
        friendsList = new JComboBox(model);
        confirm = new JButton("Confirm");
        refreshBtn = new JButton("Refresh");
        chatHistory = new JList();
        JScrollPane listScroller = new JScrollPane(chatHistory);
        listScroller.setPreferredSize(new Dimension(250, 80));
        this.setMinimumSize(new Dimension(700, 600));
        Container chatDisplayPane = this.getContentPane();
        chatDisplayPane.setLayout(new GridBagLayout());
        this.setResizable(false);
        
        
        GridBagConstraints c;
        
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        chatDisplayPane.add(this.friendsList, c);
        
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.SOUTHEAST;
        c.gridx = 9;
        c.gridy = 9;
        c.weighty = 1;
        c.weightx = 1;
        chatDisplayPane.add(this.send, c);
        
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.SOUTH;
        c.gridx = 2;
        c.gridy = 9;
        c.ipadx = 500;
        c.weighty = 1;
        c.weightx = 1;
        chatDisplayPane.add(this.message, c);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 2;
        c.gridy = 9;
        c.ipadx = 500;
        c.ipady = 400;
        c.weighty = 1;
        c.weightx = 1;
        chatDisplayPane.add(new JScrollPane(chatHistory), c);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHEAST;
        c.gridx = 2;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        chatDisplayPane.add(this.refreshBtn, c);

        
    }

    public void update() {
        Friends f = new Friends(theBackendModel.clientAccount.getUsername());
        for (String friend : f.getFriends()) {
            if(model.getIndexOf(friend) == -1){
            model.addElement(friend);
            }
        }
    }
    
    public void refresh(){
        
        try {
            personTalkingTo = (String)friendsList.getSelectedItem();
            theChat = new Chat(theBackendModel.clientAccount, new Account(personTalkingTo));
            chatHistory.setListData(theChat.getChatHistory());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void sendChat(){
        if(message.getText().equals("") || message.getText().contains("aaskopploo")){
            JOptionPane.showMessageDialog(this, "Please type a more coherent message", "Bro", JOptionPane.ERROR_MESSAGE);
        }
        else if(theChat == null){
            JOptionPane.showMessageDialog(this, "Choose a person to talk to first and click Refresh", "Bro", JOptionPane.ERROR_MESSAGE);
        }
        else{
        theChat.sendChat(message.getText());
        message.setText("");
        chatHistory.setListData(theChat.getChatHistory());
        Notification.createNotification(personTalkingTo, "Chat", theBackendModel.clientAccount.getUsername());
        }
    }
    
}   
