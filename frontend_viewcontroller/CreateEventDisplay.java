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

/**
 *
 * @author student
 */
//three text fields
//one button
//two Spinners
public class CreateEventDisplay extends JFrame {

    BackendModel theBackendModel;
    HomePageDisplay theHomePageDisplay;
    public CreateEventDisplay(BackendModel theBackendModel, HomePageDisplay theHomePageDisplay) {
        this.theBackendModel = theBackendModel;
        this.theHomePageDisplay = theHomePageDisplay;
        this.initComponents();
    }
    JTextField title;
    JTextField location;
    JSpinner hour;
    JSpinner minute;
    JTextField description;
    JButton confirm;
    JLabel timeLabel;

    private void initComponents() {
        //SpinnerModel model = new SpinnerNumberModel(initValue, min, max, step);
        SpinnerModel model = new SpinnerNumberModel(0, 0, 23, 1);
        SpinnerModel model1 = new SpinnerNumberModel(0, 0, 59, 1);
        title = new JTextField("Title");
        location = new JTextField("Where");
        description = new JTextField("Brief Description");
        confirm = new JButton("Create Event");
        hour = new JSpinner(model);
        minute = new JSpinner(model1);
        timeLabel = new JLabel("Time");

        Container createEventPane = this.getContentPane();
        createEventPane.setLayout(new GridBagLayout());
        this.setMinimumSize(new Dimension(200, 400));
        this.setResizable(false);
        GridBagConstraints c;

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 200;
        c.weighty = 5;
        c.weightx = 1;
        createEventPane.add(title, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 200;
        c.weighty = 5;
        c.weightx = 1;
        createEventPane.add(location, c);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 4;
        c.ipadx = 200;
        c.ipady = 80;
        c.weighty = 5;
        c.weightx = 1;
        createEventPane.add(description, c);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 5;
        c.gridy = 5;
        c.weighty = 5;
        c.weightx = 1;
        createEventPane.add(confirm, c);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 2;
        c.gridy = 1;
        c.weighty = 5;
        c.weightx = 1;
        createEventPane.add(hour, c);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 5;
        c.weightx = 1;
        createEventPane.add(timeLabel, c);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 3;
        c.gridy = 1;
        c.weighty = 5;
        c.weightx = 1;
        createEventPane.add(minute, c);
        this.pack();
    
    }
    
    void createEvent() throws IOException {
        String a = "";
        int aa = (Integer)minute.getValue();
        if(aa < 10 ){
            a = 0+Integer.toString((Integer)minute.getValue());
        } else{
            a = Integer.toString((Integer)minute.getValue());
        }
        theBackendModel.theEvents.createEvent(theBackendModel.clientAccount.getSchool(),
        title.getText(), location.getText(), Integer.toString((Integer)hour.getValue())
        + ":" + a, theBackendModel.clientAccount.getUsername(), description.getText());
       theHomePageDisplay.updateEventList();
        this.setVisible(false);
    }
}
