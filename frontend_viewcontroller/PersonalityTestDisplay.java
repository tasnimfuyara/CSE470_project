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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author cerva
 */
public class PersonalityTestDisplay extends JFrame implements ActionListener {

    BackendModel theBackendModel;
    MyProfileDisplay theProfile;
    boolean done = false;
    ButtonGroup group;
    JRadioButton button1;
    JRadioButton button2;
    JLabel question;
    JButton next;
    int i = 1;
    PersonalityTest thePersonalitytest = new PersonalityTest();

    public PersonalityTestDisplay(BackendModel theBackendModel, MyProfileDisplay theProfile) throws IOException {
        this.theBackendModel = theBackendModel;
        this.theProfile = theProfile;
        this.initComponents();
    }

    private void initComponents() throws IOException {

        group = new ButtonGroup();
        question = new JLabel(thePersonalitytest.getQuestion(i));
        button1 = new JRadioButton(thePersonalitytest.getAnswer1());
        button2 = new JRadioButton(thePersonalitytest.getAnswer2());
        group.add(button1);
        group.add(button2);
        next = new JButton("Next");
        next.setActionCommand("myButton");
        next.addActionListener(this);
        this.setMinimumSize(new Dimension(700, 500));
        Container picSelectorPane = this.getContentPane();
        picSelectorPane.setLayout(new GridBagLayout());

        GridBagConstraints c;
        c = new GridBagConstraints();
        c.gridx = 5;
        c.gridy = 9;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(button1, c);

        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 9;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(button2, c);

        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 2;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(question, c);

        c = new GridBagConstraints();
        c.gridx = 7;
        c.gridy = 8;
        c.weighty = 1;
        c.weightx = 1;
        picSelectorPane.add(next, c);
        this.pack();

    }

    void getNextQuestion() throws IOException {
        question.setText(thePersonalitytest.getQuestion(i));
        button1.setText(thePersonalitytest.getAnswer1());
        button2.setText(thePersonalitytest.getAnswer2());
    }

    void setAnswer() throws IOException {

        if (button1.isSelected() && i == 1) {
            theBackendModel.clientAccount.setIE(0);
            i++;
        } else if (button2.isSelected() && i == 1) {
            theBackendModel.clientAccount.setIE(1);
            i++;
        } else if (button1.isSelected() && i == 2) {
            theBackendModel.clientAccount.setNS(0);
            i++;
        } else if (button2.isSelected() && i == 2) {
            theBackendModel.clientAccount.setNS(1);
            i++;
        } else if (button1.isSelected() && i == 3) {
            theBackendModel.clientAccount.setTF(0);
            i++;
        } else if (button2.isSelected() && i == 3) {
            theBackendModel.clientAccount.setTF(1);
            i++;
        } else if (button1.isSelected() && i == 4) {
            theBackendModel.clientAccount.setPJ(0);
            i++;
            done = true;
            this.setVisible(false);
            theProfile.updateInfo();
        } else if (button2.isSelected() && i == 4) {
            theBackendModel.clientAccount.setPJ(1);
            i++;
            done = true;
            this.setVisible(false);
            theProfile.updateInfo();
        } else {
            JOptionPane.showMessageDialog(this, "Please pick an answer", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            try {
                this.getNextQuestion();
                group.clearSelection();
            } catch (IOException ex) {
                Logger.getLogger(PersonalityTestDisplay.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    boolean checkIfFinished(){
        return done;
    }

}
