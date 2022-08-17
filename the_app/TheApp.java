/**
 * There is essentially nothing in this file for students to edit,
 * especially if you are creating single window apps
 * (which is what you probably should be doing).
 */
package the_app;

import frontend_viewcontroller.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sets up the model-view-controller classes of TheApp.
 *
 * @author cheng
 */
public class TheApp implements Runnable {

    @Override
    public void run() {
        try {
            BackendModel theBackendModel = new BackendModel();
            
            PicSelector thePicSelector = new PicSelector(theBackendModel);
            
            AddInterestDisplay theAddInterestDisplay = new AddInterestDisplay(theBackendModel);
            
            MyProfileDisplay theProfile = new MyProfileDisplay(theBackendModel, thePicSelector);
            
            PersonalityTestDisplay thePersonalityTestDisplay = new PersonalityTestDisplay(theBackendModel, theProfile);
            
            MeetPeopleDisplay theMeetPeopleDisplay = new MeetPeopleDisplay(theBackendModel);
            
            ChatDisplay theChatDisplay = new ChatDisplay(theBackendModel);
            HomePageDisplay theSecondaryViewDisplay = new HomePageDisplay(theBackendModel, thePicSelector, theProfile, thePersonalityTestDisplay
            ,theMeetPeopleDisplay, theChatDisplay);
            
            LoginAndCreateAccDisplay theMainViewDisplay = new LoginAndCreateAccDisplay(theBackendModel, theSecondaryViewDisplay);
            
            CreateEventDisplay theCreateEventDisplay= new CreateEventDisplay(theBackendModel, theSecondaryViewDisplay);
            
            ModelsAndViewsController theMainViewsController = new ModelsAndViewsController(theBackendModel, 
                    theMainViewDisplay,theSecondaryViewDisplay, thePicSelector, theProfile, thePersonalityTestDisplay,
                    theAddInterestDisplay, theCreateEventDisplay, theMeetPeopleDisplay, theChatDisplay);
          
            theMainViewDisplay.setVisible(true);
         
            
            
        } catch (IOException ex) {
            Logger.getLogger(TheApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
}
