package frontend_viewcontroller;

import backend_models.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is responsible for displaying the data from the backend, and
 * directly putting data on the screen for users to see.
 *
 * Responsibilities of this class include:
 *
 * (1) Construct the graphical user interface (GUI) on the screen
 *
 * (2) Pull data from the backend to display in the GUI
 *
 * There should be no code here for handling user's keyboard or mouse
 * interaction! That belongs in the ModelsAndViewsController class.
 *
 * There should also be no code here directly about modeling the problem or
 * situation your program solves.
 *
 * All problem or situation modeling related code must go in the backend classes
 *
 * The FOUR (4) main steps to creating GUI widgets are labeled below. There are
 * many smaller steps you should get familiar with as well.
 *

 */
public class LoginAndCreateAccDisplay extends JFrame implements ActionListener {

    /*
     *
     * MainViewDisplay needs to have a instance variable to reference the
     * backend's models because the frontend's MainViewDisplay is responsible
     * for displaying data from the backend.
     *
     * Since the backend models is initially set up by an instance of the
     * BackendModelSetup class, we just need this one instance variable here:
     */
    BackendModel theBackendModel;
    HomePageDisplay theHomePage;
    Login theLogin = new Login();
    CreateAcc accountCreation = new CreateAcc();
    Verify verify = new Verify();
    /*
     *
     * Step 1 of 4 for creating GUI widgets: declare them
     * --------------------------------------------------
     *
     * GUI widgets to be displayed to the user on the screen is declared here
     * (but will be constructed and initialized in the initComponents method).
     * The user will see data and can later interact with these widgets.
     */
    ButtonGroup genderGroup;
    JRadioButton maleGender;
    JRadioButton femaleGender;
    JRadioButton otherGender;
    JButton login;
    JButton next;
    JButton createAcc;
    JTextField username;
    JPasswordField password;
    JTextField usernameC;
    JPasswordField passwordC;
    JPanel panel;
    JLabel passwordLabel;
    JLabel usernameLabel;
    JLabel passwordLabel1;
    JLabel usernameLabel1;
    JFrame frame;
    JFrame triframe;
    JLabel schoolLabel;
    JComboBox school;
    JLabel verifImage;
    String[] schoolStrings = {"--Select a University--", "BRAC University", "North South University", "Dhaka Univeristy", "East West University", "Daffodil University", "South East University", "Independent University", "United International University", "Jahangirnagar University", "Chittagong University", "None of the Above"};
    JPanel panel2 = new JPanel();
    String[] num = {"1", "2", "3", "4", "5", "6"};
    JComboBox verifInput;
    JButton FinalCreateAcc;
    JLabel instructions;

    /*
     *
     * Constructor. Probably nothing for students to change.
     */
    public LoginAndCreateAccDisplay(BackendModel aBackend, HomePageDisplay theHomePage) throws IOException {
        setTitle("Login");
        this.theBackendModel = aBackend;
        this.theHomePage = theHomePage;
        this.initComponents();
    }

    /*
     *
     * initComponents is all about fulfilling Responsibility #1 of this class:
     * (1) Construct the graphical user interface (GUI) on the screen
     */
    private void initComponents() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(400, 200));

        /*
         *
         * Step 2 of 4 for creating GUI widgets: construct them
         * ----------------------------------------------------
         *
         *  this.textContentLabel = new JLabel();
             this.textContentLabel.setText("Text Content");
         *
         *
         * Construct GUI widget components here, and add them into the
         * mainDisplayPane later
         */
        instructions = new JLabel("Enter how many dots you see");
        this.frame = new JFrame();
        this.triframe = new JFrame();
        this.login = new JButton();
        this.login.setText("Login");
        login.setActionCommand("myButton");
        login.addActionListener(this);
        this.usernameLabel = new JLabel();
        this.passwordLabel = new JLabel();
        this.usernameLabel.setText("Username");

        this.schoolLabel = new JLabel();
        this.schoolLabel.setText("University");

        this.passwordLabel.setText("Password");
        this.usernameLabel1 = new JLabel();
        this.passwordLabel1 = new JLabel();
        this.usernameLabel1.setText("Username");
        this.passwordLabel1.setText("Password");
        this.createAcc = new JButton();
        this.createAcc.setText("Create Account");
        this.next = new JButton();
        this.next.setText("Next Step"); //perform captcha after this is pressed
        this.panel = new JPanel();
        this.username = new JTextField();
        this.username.setText("Username");
        this.password = new JPasswordField();
        this.password.setText("Password");
        this.usernameC = new JTextField();
        this.usernameC.setText("Username");
        this.passwordC = new JPasswordField();
        this.passwordC.setText("Password");
        this.school = new JComboBox(schoolStrings);
        this.school.setSelectedIndex(0);

        this.verifInput = new JComboBox(num);
        this.verifInput.setSelectedIndex(0);

        this.maleGender = new JRadioButton("Male");
        this.femaleGender = new JRadioButton("Female");
        this.otherGender = new JRadioButton("Other");

        this.genderGroup = new ButtonGroup();
        this.genderGroup.add(maleGender);
        this.genderGroup.add(femaleGender);
        this.genderGroup.add(otherGender);

        this.verifImage = new JLabel();
        this.FinalCreateAcc = new JButton();
        this.FinalCreateAcc.setText("Create Account");
        /*
         * Choose your LayoutManager for the mainDisplayPane here. See:
         * http://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
         *
         * I suggest GridBagLayout. For more details, see:
         * http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
         */
        Container mainDisplayPane = this.getContentPane();
        mainDisplayPane.setLayout(new GridBagLayout());

        Container secondaryDisplayPane = frame.getContentPane();
        secondaryDisplayPane.setLayout(new GridBagLayout());

        Container ternaryDisplayPane = triframe.getContentPane();
        ternaryDisplayPane.setLayout(new GridBagLayout());

        /*
         * you should construct a new GridBagConstraints object each time you
         * use it, in order to avoid subtle bugs...
         */
        GridBagConstraints c;
        //  GridBagConstraints n;


        /*
         *
         * Step 3 of 4 for creating GUI widgets: add them to the pane
         * ----------------------------------------------------------
         *
         * For each GUI widget you constructed earlier, you will now specify a
         * GridBagConstraints for it, then add the widget into the
         * mainDisplayPane
         */
        // construct a new GridBagConstraints each time you use it, to avoid subtle bugs...
        //c.fill = GridBagConstraints.BOTH; // many options! See online tutorial
        //c.ipady = 0;
        //c.weightx = 0;
        //c.weighty = 0;
        //c.anchor = GridBagConstraints.CENTER;
        //c.insets = new Insets(0, 0, 0, 0);
//        
//        c = new GridBagConstraints();
//        c.gridx = 1;
//        c.gridy = 2;
//        c.fill = GridBagConstraints.BOTH;
//        c.ipadx= 400;
//        c.ipady= 200;
////        mainDisplayPane.add(this.textContentPane, c);
//
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 4;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 4;
        c.ipady = 4;
        mainDisplayPane.add(this.login, c);

        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 5;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 4;
        c.ipady = 4;
        mainDisplayPane.add(this.createAcc, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 85;
        c.ipady = 4;
        mainDisplayPane.add(this.username, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 100;
        c.ipady = 4;
        mainDisplayPane.add(this.password, c);
        c = new GridBagConstraints();
        c.gridx = -1;
        c.gridy = 0;
        c.ipadx = 85;
        c.ipady = 4;
        mainDisplayPane.add(this.usernameLabel, c);

        c = new GridBagConstraints();
        c.gridx = -1;
        c.gridy = 1;
        c.ipadx = 100;
        c.ipady = 4;
        mainDisplayPane.add(this.passwordLabel, c);

        this.pack(); // leave this line last in this method.
        // must pack this JFrame before it can be displayed on screen

        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 5;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 4;
        c.ipady = 4;
        secondaryDisplayPane.add(this.next, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 85;
        c.ipady = 4;
        secondaryDisplayPane.add(this.usernameC, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 100;
        c.ipady = 4;
        secondaryDisplayPane.add(this.passwordC, c);

        c = new GridBagConstraints();
        c.gridx = -1;
        c.gridy = 0;

        c.ipadx = 85;
        c.ipady = 4;
        secondaryDisplayPane.add(this.usernameLabel1, c);

        c = new GridBagConstraints();
        c.gridx = -1;
        c.gridy = 1;

        c.ipadx = 100;
        c.ipady = 4;
        secondaryDisplayPane.add(this.passwordLabel1, c);

        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 1;

        c.ipadx = 100;
        c.ipady = 4;
        secondaryDisplayPane.add(this.school, c);
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 1;

        c.ipadx = 100;
        c.ipady = 4;
        secondaryDisplayPane.add(this.schoolLabel, c);

        c = new GridBagConstraints();
        c.gridx = 5;
        c.gridy = 1;

        c.ipadx = 105;

        c.ipady = 4;
        secondaryDisplayPane.add(this.maleGender, c);
        c = new GridBagConstraints();

        c.gridx = 5;
        c.gridy = 2;

        c.ipadx = 90;

        c.ipady = 4;
        secondaryDisplayPane.add(this.femaleGender, c);
        c = new GridBagConstraints();
        c.gridx = 5;
        c.gridy = 3;

        c.ipadx = 100;
        c.ipady = 4;
        secondaryDisplayPane.add(this.otherGender, c);

        frame.pack();

        frame.setMinimumSize(new Dimension(400, 200));

        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 4;

        ternaryDisplayPane.add(this.FinalCreateAcc, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 4;

        ternaryDisplayPane.add(this.verifInput, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        this.verifImage.setIcon(new ImageIcon(verify.getVerifImgStr()));
        ternaryDisplayPane.add(this.verifImage, c);

        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 0;
        ternaryDisplayPane.add(this.instructions, c);

        triframe.pack();

        triframe.setMinimumSize(new Dimension(400, 400));

    }

    /*
     *
     * Step 4 of 4 for creating GUI widgets: write methods to update them
     * -------------------------------------------------------------------
     *
     * The methods below are all about fulfilling Responsibility #2 of this
     * class: (2) Pull data from the backend to display in the GUI
     *
     * Write below all the methods for displaying data into the GUI using this
     * MainViewDisplay object
     */
    void doLoginAction() throws IOException, Exception {
        boolean success = theLogin.userLogin(username.getText(), password.getText());
        if (success == false) {
            JOptionPane.showMessageDialog(panel, "Username or Password is incorrect", "You messed up!", JOptionPane.ERROR_MESSAGE);

        } else {
            //open new window
            JOptionPane.showMessageDialog(panel, "Successfully logged in!");
            this.setVisible(false);
            theBackendModel.clientAccount = new Account(username.getText());
            theBackendModel.friendList = new Friends(username.getText().toLowerCase());
            theBackendModel.theEvents = new Events(theBackendModel.clientAccount.getSchool());
           
            //
            //   System.out.println(theBackendModel.clientAccount.getEverything());
            theHomePage.setVisible(true);

        }

    }

    void doVerifyAction() throws IOException {

        if (verify.imageTest(num[verifInput.getSelectedIndex()])) {
            createAcc();

        } else {
            JOptionPane.showMessageDialog(panel, "Verification Failed", ";-;", JOptionPane.ERROR_MESSAGE);
            this.verifImage.setIcon(new ImageIcon(verify.getVerifImgStr()));

        }

    }

    void createUserPass() throws IOException {
//         JOptionPane.showMessageDialog(panel,"Username or Password is already taken or contains : or ¿ ","You messed up!",JOptionPane.ERROR_MESSAGE);
        String gender;
        if (maleGender.isSelected()) {
            gender = "Male";
        } else if (femaleGender.isSelected()) {
            gender = "Female";
        } else {
            gender = "other";
        }
        boolean success = accountCreation.checkAcc(usernameC.getText(), passwordC.getText());

        if (gender == null) {
            JOptionPane.showMessageDialog(panel, "Please select a gender", "", JOptionPane.ERROR_MESSAGE);
        } else if (schoolStrings[school.getSelectedIndex()].equals(schoolStrings[0])) {

            JOptionPane.showMessageDialog(panel, "Select a University", ":\\", JOptionPane.ERROR_MESSAGE);

        } else if (success == false) {
            JOptionPane.showMessageDialog(panel, "Username is already taken or contains : ¿ or ¡", "UNACCEPTABLE CONDITION!", JOptionPane.ERROR_MESSAGE);

        } else {

            frame.setVisible(false);
            triframe.setVisible(true);
        }

    }

    void createAcc() throws IOException {
        String gender;
        if (maleGender.isSelected()) {
            gender = "Male";
        } else if (femaleGender.isSelected()) {
            gender = "Female";
        } else {
            gender = "other";
        }
        accountCreation.createAcc(usernameC.getText(), passwordC.getText(), schoolStrings[school.getSelectedIndex()], gender);
        triframe.setVisible(false);
        JOptionPane.showMessageDialog(panel, "Account Successfully Created!!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton") && theBackendModel.clientAccount != null) {

            theHomePage.profilePicture.setIcon(new ImageIcon(theBackendModel.clientAccount.getProfilePicture()));
            theHomePage.getNotifications(theBackendModel.clientAccount.getUsername());
            
            try {
                theHomePage.updateEventList();
            } catch (IOException ex) {
                Logger.getLogger(LoginAndCreateAccDisplay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
