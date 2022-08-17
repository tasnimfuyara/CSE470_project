package frontend_viewcontroller;

import backend_models.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class is responsible for manipulating the data in the backend, and
 * letting the user otherwise control the GUI on the screen.
 *
 * Responsibilities of this class include:
 *
 * (1) Ask the MainViewDisplay object to change the GUI on the screen in
 * response to user input actions (without modifying any data in the backend).
 *
 * (2) Ask the backend models to modify its data, and also ask the
 * MainViewDisplay object to update the GUI on the screen (to match the data in
 * the backend), in response to user input actions.
 *
 * There should be no code here directly about painting graphics on the screen!
 * That belongs in the MainViewDisplay class.
 *
 * There should also be no code here directly about modeling the problem or
 * situation your program solves.
 *
 * All problem or situation modeling related code must go in the backend classes
 *
 * The FOUR (4) main steps to creating GUI widgets are labeled below. There are
 * many smaller steps you should get familiar with as well.
 *
 * @author cheng
 */
public class ModelsAndViewsController {

    /*
     *
     * ModelsAndViewsController needs to have an instance variable to reference
     * the backend's models because the frontend's ModelsAndViewsController is
     * responsible for asking the backend to modify its data.
     *
     * Since the backend models is initially set up by an instance of the
     * BackendModelSetup class, we just need this one instance variable here:
     */
    BackendModel theBackendModel;
    
    /*
     *
     * This class also needs to have an instance variable to reference the
     * frontend's MainViewDisplay because the ModelsAndViewsController object is
     * responsible for asking the MainViewDisplay object to update itself.
     */
    LoginAndCreateAccDisplay theMainViewDisplay;
    HomePageDisplay theHomePageDisplay;
    PicSelector thePicSelector;
    MyProfileDisplay theProfile;
    PersonalityTestDisplay thePersonalityTestDisplay;
    AddInterestDisplay theAddInterestDisplay;
    CreateEventDisplay theCreateEventDisplay;
    MeetPeopleDisplay theMeetPeopleDisplay;
    ChatDisplay theChatDisplay;
    /*
     *
     * Step 1 of 2 to provide user controls: write user action as private class
     * ------------------------------------------------------------------------
     *
     * User actions are written as private inner classes that implement
     * ActionListener, and override the actionPerformed method.
     *
     * Use the following as a template for writting more user actions.
     */
//    private class OpenSourceFileAction implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//
//            String pathToFile = theMainViewDisplay.showOpenDialog();
//
//            if (pathToFile == null) {
//
//                return;
//            } else {
//
//                try {
//                    theBackendModel.theTextFile = new TextFile(pathToFile);
//                    theMainViewDisplay.updateTextContent();
//                } catch (IOException ex) {
//                    Logger.getLogger(ModelsAndViewsController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//    }
    private class loginAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                theMainViewDisplay.doLoginAction();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private class checkAccAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                theMainViewDisplay.createUserPass();
                //  theMainViewDisplay.doVerifyAction();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private class showSecondary implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theMainViewDisplay.frame.setVisible(true);
        }
    }

    private class createAcc implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                theMainViewDisplay.doVerifyAction();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    private class openPicSelector implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theHomePageDisplay.changePicture();
        }
    }

    private class goToProfile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theHomePageDisplay.goToProfile();
        }
    }
    private class goToPersonalityTest implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theHomePageDisplay.doPersonalityTest();
        }
    }

    private class changePicture implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                thePicSelector.choosePicture();
            } catch (IOException ex) {
                Logger.getLogger(ModelsAndViewsController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
    }
    private class leaveMeetPeopleDisplay implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theMeetPeopleDisplay.setVisible(false);
            
        }
    }
    private class nextPTQuestion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
           
            try {
                thePersonalityTestDisplay.setAnswer();
                
            } catch (IOException ex) {
                Logger.getLogger(ModelsAndViewsController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }
   
    private class goToAddInterestDisplay implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
           theAddInterestDisplay.setVisible(true);
        }
    }
    private class addInterest implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                theAddInterestDisplay.addInterest();
                theProfile.updateInterestListData();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    private class removeInterest implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                theProfile.removeInterest();
             
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    private class goToCreateEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
                theCreateEventDisplay.setVisible(true);
        }
    }
    private class goToMeetPeople implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
                theHomePageDisplay.goToMeetPeople();
        }
    }
    
    private class createEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                theCreateEventDisplay.createEvent();
                 theHomePageDisplay.eventHistory.setListData(theBackendModel.theEvents.getEvents());
            } catch (IOException ex) {
                Logger.getLogger(ModelsAndViewsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private class viewEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
               
                 theHomePageDisplay.viewEvent();
            } catch (IOException ex) {
                Logger.getLogger(ModelsAndViewsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private class searchUsers implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
          
               theMeetPeopleDisplay.search();
           
        }
    }
    private class addFriend implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
               theMeetPeopleDisplay.addFriend();
                       
        }
    }
    private class goToChat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
               theHomePageDisplay.goToChat();
                       
        }
    }
    private class refreshChat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
               theChatDisplay.refresh();
                       
        }
    }
    private class sendChat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
               theChatDisplay.sendChat();
                       
        }
    }
//    private class viewOtherUser implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//            try {
//               
//                theMeetPeopleDisplay.viewUser(theMeetPeopleDisplay.peopleList.getSelectedValue().toString());
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ModelsAndViewsController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

    /*
     *
     * Constructor. Probably nothing for students to change.
     */
    public ModelsAndViewsController(BackendModel aBackend, LoginAndCreateAccDisplay aMainViewDisplay, HomePageDisplay SecondaryViewDisplay, 
            PicSelector thePicSelector, MyProfileDisplay theProfile, PersonalityTestDisplay thePersonalityTestDisplay,
            AddInterestDisplay theAddInterestDisplay, CreateEventDisplay theCreateEventDisplay,
            MeetPeopleDisplay theMeetPeopleDisplay, ChatDisplay theChatDisplay) {

        this.theBackendModel = aBackend;
        this.theMainViewDisplay = aMainViewDisplay;
        this.theHomePageDisplay = SecondaryViewDisplay;
        this.thePicSelector = thePicSelector;
        this.theProfile = theProfile;
        this.thePersonalityTestDisplay = thePersonalityTestDisplay;
        this.theAddInterestDisplay = theAddInterestDisplay;
        this.theCreateEventDisplay = theCreateEventDisplay;
        this.theMeetPeopleDisplay = theMeetPeopleDisplay;
        this.theChatDisplay= theChatDisplay;
        this.initController();
    }


    /*
     *
     * Step 2 of 2 to provide user controls: wire user action to GUI widgets
     * ----------------------------------------------------------------------
     *
     * Once a private inner class has been written for a user action, you can
     * wire it to a GUI widget (i.e. one of the GUI widgets you created in the
     * MainViewDisplay class and which you gave a memorable variable name!).
     *
     * Use the following as templates for wiring in more user actions.
     */
    private void initController() {
        this.theMainViewDisplay.login.addActionListener(new loginAction());
        this.theMainViewDisplay.createAcc.addActionListener(new showSecondary());
        this.theMainViewDisplay.next.addActionListener(new checkAccAction());
        this.theMainViewDisplay.FinalCreateAcc.addActionListener(new createAcc());
        this.theHomePageDisplay.changeProfilePicBtn.addActionListener(new openPicSelector());
        this.theHomePageDisplay.myProfileBtn.addActionListener(new goToProfile());
        this.theHomePageDisplay.createEventBtn.addActionListener(new goToCreateEvent());
        this.theHomePageDisplay.meetPeopleBtn.addActionListener(new goToMeetPeople());
        this.theHomePageDisplay.sendChatBtn.addActionListener(new goToChat());
        this.theHomePageDisplay.viewEventBtn.addActionListener(new viewEvent());
        this.theHomePageDisplay.personalityTestBtn.addActionListener(new goToPersonalityTest());
        this.theProfile.changePic.addActionListener(new openPicSelector());
        this.theProfile.addInterestBtn.addActionListener(new goToAddInterestDisplay());
        this.theProfile.removeInterestBtn.addActionListener(new removeInterest());
        this.thePicSelector.confirm.addActionListener(new changePicture());
        this.thePersonalityTestDisplay.next.addActionListener(new nextPTQuestion());
        this.theAddInterestDisplay.confirm.addActionListener(new addInterest());
        this.theCreateEventDisplay.confirm.addActionListener(new createEvent());
        this.theMeetPeopleDisplay.backBtn.addActionListener(new leaveMeetPeopleDisplay());
        this.theMeetPeopleDisplay.searchBtn.addActionListener(new searchUsers());
        this.theMeetPeopleDisplay.addFriend.addActionListener(new addFriend());
        this.theChatDisplay.refreshBtn.addActionListener(new refreshChat());
        this.theChatDisplay.send.addActionListener(new sendChat());
        
        
        
    }
}
