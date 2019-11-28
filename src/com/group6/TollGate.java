package com.group6;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Date;

import static com.group6.Fonts.*;
import static com.group6.Colors.*;
import static com.group6.Icons.*;
import static java.awt.EventQueue.invokeLater;

/*
 * created by Mubarack Tahir on 14th of November, 2019.
 *
 * */
public class TollGate extends  JFrame{
    private boolean isAdminValid;
    private boolean adminAvailable = false;
    private int mousePressedX;
    private int mousePressedY;
    private boolean refreshed;
    private static double totalAmountRemit;
    private JLabel homeIcon = new JLabel("Home");
    private JLabel online = new JLabel(Icons.online);
    private JLabel userIcon = new JLabel(Icons.smallUserIcon);
    private JLabel regIcon = new JLabel(Icons.smallRegIcon);
    private JLabel adminIcon = new JLabel(Icons.smallAdminIcon);
    private JLabel logoutIcon = new JLabel(Icons.smallLogOutIcon);
    private JLabel userIcon2 = new JLabel(Icons.smallUserIcon);
    private JLabel adminIcon2 = new JLabel(Icons.smallAdminIcon);
    private JLabel online2 = new JLabel(Icons.online);
    private JPanel naviHome = new JPanel();
    private JPanel naviAdmin = new JPanel();
    private JPanel naviReg = new JPanel();
    private JPanel naviUser = new JPanel();
    private JPanel naviOut = new JPanel();
    private JPanel[] navilabel = {naviHome,naviAdmin,naviReg,naviOut,naviUser};
    private ArrayList<User> user = new ArrayList<>();
    private boolean loggedIn = false;
    private JPanel leftDuck = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel sidePanel = new JPanel();
    private JPanel mainView = new JPanel();
    private JButton homeButton = new JButton("Home");
    private JButton userButton = new JButton("Registration");
    private JButton adminButton = new JButton("Admin");
    private JPanel homePanel = new JPanel();
    private JPanel adminPanel = new JPanel();
    private JButton logoutButton = new JButton("Log Out");
    private JPanel registerationPanel = new JPanel();
    private JPanel logoutPanel = new JPanel();
    private JButton logIn = new JButton("Log In");
    private JPanel loginPanel = new JPanel();
    private CardLayout cardLayout;
    private JPanel rightDuck = new JPanel();


    TollGate() {
        setUpUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(Dimen.MAIN_FRAME_SIZE);
        setBackground(new Color(0,0,0,0));
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setResizable(true);

        homeIcon.setVisible(true);
        regIcon.setVisible(false);
        userIcon.setVisible(false);
        adminIcon.setVisible(false);
        logoutIcon.setVisible(false);
        adminIcon2.setVisible(false);
        userIcon2.setVisible(false);

        online.setVisible(false);
        online2.setVisible(false);
        repaint();
    }
    private void getLeftDuck(){
        leftDuck.setBounds(0,0,364,30);
        leftDuck.setBackground(new Color(0,0,0));
        leftDuck.setLayout(new BorderLayout());
        getContentPane().add(leftDuck);
        getRootPane().setBorder(new LineBorder(new Color(0x000000)));
    }
    private void getRightDuck(){
        rightDuck.setBackground(new Color(0,0,0));
        JLabel cancleIcon = new JLabel("");
        JPanel canclePanel = new JPanel();
        homeIcon.setVisible(true);
        canclePanel.setBackground(lightTransparent);
        canclePanel.setBounds(960,0,48,30);
        canclePanel.setLayout(null);
        cancleIcon.setIcon(Icons.cancleIcon);
        cancleIcon.setBounds(9,3,23,23);
        canclePanel.add(cancleIcon);
        canclePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                canclePanel.setBackground(Color.red);
                int n = JOptionPane.showConfirmDialog(null,"Are you sure you want to Quit ?");
                if(n == 0 ) {
                    MyFrames.frame.dispose();
                    dispose();
                }
            }
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                repaint();
                canclePanel.setBackground(Color.red);
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                repaint();
                canclePanel.setBackground(Colors.lightTransparent);
            }
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                repaint();
                canclePanel.setBackground(Color.red);
            }
            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                repaint();
                canclePanel.setBackground(Colors.lightTransparent);
            }
        });


        JPanel maximizePanel = new JPanel();
        JLabel maximizeIcon = new JLabel("");
        maximizePanel.setBackground(Colors.lightTransparent);
        maximizePanel.setBounds(910, 0, 48, 30);
        maximizePanel.setLayout(null);
        maximizeIcon.setIcon(new ImageIcon("images//maximize.png"));
        maximizeIcon.setBounds(13, 3, 23, 23);
        maximizePanel.add(maximizeIcon);
        maximizePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(getExtendedState() == JFrame.MAXIMIZED_BOTH)
                    setExtendedState(JFrame.NORMAL);
                else
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                repaint();
                maximizePanel.setBackground(harshTransparent);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                repaint();
                maximizePanel.setBackground(Colors.lightTransparent);
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                repaint();
                maximizePanel.setBackground(harshTransparent);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                repaint();
                maximizePanel.setBackground(lightTransparent);
            }
        });
        JPanel minimizePanel = new JPanel();
        JLabel minimize = new JLabel("");
        minimize.setIcon(new ImageIcon("images//minnimize.png"));
        minimizePanel.setBackground(new Color(0, 0, 0, 10));
        minimizePanel.setBounds(860, 0, 48, 30);
        minimizePanel.setLayout(null);
        minimize.setBounds(13,3,23,23);
        minimizePanel.add(minimize);
        minimizePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                setState(Frame.ICONIFIED);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                repaint();
                minimizePanel.setBackground(harshTransparent);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                repaint();
                minimizePanel.setBackground(Colors.lightTransparent);
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                repaint();
                minimizePanel.setBackground(harshTransparent);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                repaint();
                minimizePanel.setBackground(Colors.lightTransparent);
            }
        });

        rightDuck.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                int i = mouseEvent.getXOnScreen();
                int j = mouseEvent.getYOnScreen();
                setLocation(i - mousePressedX, j - mousePressedY);
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });
        rightDuck.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount() == 2){
                    if (getExtendedState() == MAXIMIZED_BOTH){
                        setExtendedState(JFrame.NORMAL);
                    }
                    else
                        setExtendedState(MAXIMIZED_BOTH);
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                mousePressedX = mouseEvent.getX();
                mousePressedY = mouseEvent.getY();
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

        homeIcon.setIcon(new ImageIcon("images//home.png"));

        userIcon.setText("User");

        adminIcon.setText("Admin");

        logoutIcon.setText("Log Out");

        regIcon.setText("Registration");
        JLabel[] buttons = {homeIcon,userIcon,adminIcon,logoutIcon,regIcon};
        online.setBounds(820,3,12,12);
        userIcon2.setBounds(799,0,30,30);
        adminIcon2.setBounds(769,0,30,30);
        online2.setBounds(790,3,12,12);
        for(JLabel btn : buttons){
            btn.setForeground(Color.white);
            btn.setBounds(5,0,200,30);
            btn.setIconTextGap(10);
            btn.setFont(smallSegoeUIEmoji);
            btn.setHorizontalAlignment(SwingConstants.LEADING);
            btn.setHorizontalTextPosition(SwingConstants.TRAILING);
            rightDuck.add(btn);

        }
        rightDuck.add(adminIcon2);
        rightDuck.add(userIcon2);
        rightDuck.add(online);
        rightDuck.add(online2);
        rightDuck.add(minimizePanel);
        rightDuck.setBounds(364,0,1000,30);
        rightDuck.setLayout(null);
        rightDuck.add(maximizePanel);
        rightDuck.add(canclePanel);
        getContentPane().add(rightDuck);
    }
    private void setUpUI() {
        getLeftDuck();
        getRightDuck();
        setUpMainPanel();
    }
    private JPanel getLogginPanel(int i){
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setBounds(90,200,270,30);
        JButton validate = new JButton("Validate");
        validate.setBackground(new Color(0x44F90D));
        validate.setBounds(255,266,100,28);
        validate.setForeground(Color.black);
        JPanel innerLogginPanel = new RoundEdgePanel(30,new Color(0,0,0,200));
        innerLogginPanel.setLayout(null);
        innerLogginPanel.setBounds(300,150,400,350);
        JTextField textField;
        if(i == 1) {
            textField = new JTextField("Admin");
            textField.setEnabled(false);
            validate.addActionListener(actionPerformed ->{
                isAdminValid = authenticateAdmin(TextCoverter.capitalizer(textField.getText()),jPasswordField.getText());
                if(isAdminValid) {
                    rightDuck.setBackground(Color.black);
                    online2.setVisible(true);
                    adminIcon2.setVisible(true);
                    adminAvailable = true;
                    if(user.isEmpty()){
                      showEmptyView();
                    }else {
                        refreshed= false;
                      reFreshPayments();
                      refreshed = true;

                    }
                }
                else MyFrames.showSuccessfullFrame( "Access denield!!!",bigCancleIcon,getWidth(),getHeight());


            });

        }
        else {
            textField = new JTextField("");
            JLabel reset = new JLabel("Forgotten password? | reset");
            reset.setForeground(Color.WHITE);
            reset.setBounds(80,271,170,25);
            reset.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    MyFrames.showSuccessfullFrame("Password has been reset to \n\"123456789\"",null,getWidth(),getHeight());
                    reset.setForeground(Color.black);
                    repaint();
                }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {
                    reset.setForeground(Color.black);
                    repaint();
                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {
                    reset.setForeground(Color.white);
                    repaint();
                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
                    reset.setForeground(Color.black);
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    reset.setForeground(Color.white);
                    repaint();
                }
            });
            validate.addActionListener(actionPerformed -> {

                boolean isValid = authenticateUser(textField.getText(), jPasswordField.getText());
                if (isValid) {
                    loggedIn = true;
                    userIcon2.setVisible(true);
                    online.setVisible(true);
                    MyFrames.showSuccessfullFrame( "You are welcome",bigWelcomeIcon,getWidth(),getHeight());
                    loginPanel.removeAll();
                    repaint();
                    loginPanel.add(loggedIn());
                } else MyFrames.showSuccessfullFrame( "Access denield!!!",bigCancleIcon,getWidth(),getHeight());

            });

            innerLogginPanel.add(reset);

        }
        JLabel profileIcon = new JLabel(Icons.profileIcon);
        textField.setBounds(90,115,270,30);
        profileIcon.setBounds(55,105,50,50);

        JLabel passwordIcon = new JLabel(Icons.passwordIcon);
        passwordIcon.setBounds(55,200,30,30);

        Component[] components = {validate,passwordIcon,jPasswordField,profileIcon,textField};
        for(Component c: components)
            innerLogginPanel.add(c);
        innerLogginPanel.setLayout(null);

        return innerLogginPanel;
    }

    private JScrollPane getAdminLoggedIn() {
        JPanel admin = new JPanel();
        admin.setBackground(Color.black);
        JScrollPane scroller = new JScrollPane();
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Box b = new Box(BoxLayout.Y_AXIS);

        b.add(Box.createVerticalStrut(20));
        b.setLocation(10,10);
        admin.setLayout(null);
        adminPanel.setBorder(null);


        int k = 10;
        int sum =0;
        int j = 0;
        for(int i = 0; i< user.size() ; i++) {
            if (k == 10) {
                admin.add(getAllPayments(i, k));
                k = 0;
            } else {
                if (j == 0) {

                    sum = sum + 270;
                    admin.add(getAllPayments(i, sum));
                    j = 1;
                } else {
                    sum = sum + 260;
                    admin.add(getAllPayments(i, sum));
                    admin.setPreferredSize(new Dimension( 1000,290+sum));
                }
            }
        }
        scroller.setBackground(Color.black);
        scroller.setViewportView(admin);
        scroller.repaint();
        scroller.setFocusable(true);
        scroller.setRequestFocusEnabled(true);
        return scroller;
    }


    private JPanel getAllPayments(final int i, int space){
        User eachUser = user.get(i);

        JPanel paymentpanel = new RoundEdgePanel(25,new Color(0x3B3B34));
        paymentpanel.setLayout(null);
        paymentpanel.setSize(970,250);
        paymentpanel.setLocation(10,space);
        JLabel dusbinIcon = new JLabel(dustbinIcon);
        dusbinIcon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int num = JOptionPane.showConfirmDialog(null, "Remove \""+eachUser.getName()+"\" ?","Tollgate system",2);
                if(num == 0 )
                    user.remove(i);

                if(!(user.isEmpty())) {
                    cardLayout.show(mainView, "adminPanel");
                    reFreshPayments();
                    refreshed = true;
                    repaint();
                }
                else{
                    showEmptyView();
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        dusbinIcon.setBounds(850,20,25,25);
        JLabel copyToClipIcon = new JLabel(copyToClipBoardIcon);
        copyToClipIcon.setBounds(895,20,25,25);
        JLabel num = new JLabel(""+ (i+1) +".  " + eachUser.getIdNumber());
        num.setFont(smallSegoeUIEmoji);
        num.setForeground(Color.black);
        num.setBounds(20,10,300,40);

        JLabel label = new JLabel(eachUser.getName());
        label.setIcon(smallUserIcon);
        label.setIconTextGap(15);
        label.setHorizontalTextPosition(SwingConstants.TRAILING);
        label.setHorizontalAlignment(SwingConstants.LEADING);
        label.setFont(segoeUIEmoji);
        label.setForeground(Color.WHITE);
        label.setBounds(20,50,400,40);

        JLabel lastAmountPaid = new JLabel("Recent Payment:. ");
        JLabel lastA = new JLabel(""+eachUser.getLastAmountPayed());
        lastAmountPaid.setIcon(moneyIcon);
        lastAmountPaid.setBounds(10,100,300,40);
        lastA.setBounds(175,100,200,40);

        JLabel time = new JLabel(eachUser.getDateOfLastPayment());
        time.setFont(new Font("Segoe UI Emoji",Font.PLAIN,10));
        time.setForeground(new Color(0x000000));
        time.setBounds(50,120,400,50);
        time.setIcon(clockIcon);
        time.setIconTextGap(10);

        JLabel totalAmoutPaid = new JLabel("Total Payment:. ");
        JLabel totalA = new JLabel(""+eachUser.getTotalMoneyPayed());
        totalAmoutPaid.setBounds(310,100,300,40);
        totalA.setBounds(465,100,200,40);
        totalAmoutPaid.setIcon(moneyIcon);

        JLabel mobileNumber = new JLabel("Mobile Number:. ");
        JLabel mobileN = new JLabel(""+eachUser.getMobileNumber());
        mobileNumber.setBounds(640,100,300,40);
        mobileN.setBounds(810,100,200,40);
        mobileNumber.setIcon(phoneIcon);

        JLabel emailAdress = new JLabel("Email:. ");
        JLabel emailA = new JLabel(""+eachUser.getEmail());
        emailAdress.setBounds(150,200,400,40);
        emailA.setBounds(230,200,400,40);
        emailAdress.setIcon(email2);

        JLabel[] bigLabel = {totalA,mobileN,emailA,lastA};

        for(JLabel l: bigLabel){
            l.setFont(bigSegoeUIEmoji);
            if(l.getText().trim().equals("0.0")|| l.getText().trim().equals("No number"))
                l.setForeground(Color.red);
            else
                l.setForeground(lightGreen2);
        }
        emailA.setForeground(orangeColor);

        JLabel[] smallLabel = {emailAdress,lastAmountPaid,totalAmoutPaid,mobileNumber};

        for(JLabel l: smallLabel){
            l.setFont(mediumSegoeUIEmojij);
            l.setForeground(Color.gray);
        }

        paymentpanel.add(num);
        paymentpanel.add(time);
        paymentpanel.add(lastA);
        paymentpanel.add(lastAmountPaid);
        paymentpanel.add(mobileN);
        paymentpanel.add(mobileNumber);
        paymentpanel.add(emailA);
        paymentpanel.add(emailAdress);
        paymentpanel.add(totalAmoutPaid);
        paymentpanel.add(totalA);
        paymentpanel.add(copyToClipIcon);
        paymentpanel.add(dusbinIcon);
        paymentpanel.add(label);
        return paymentpanel;
    }

    private void showEmptyView() {
        adminPanel.removeAll();
        refreshed= false;
        adminPanel.setBackground(new Color(0xFFFFFF));
        adminPanel.setLayout(null);

        JLabel emptyIcon = new JLabel(Icons.emptyIcon);
        emptyIcon.setText("Empty, No user registered!");
        emptyIcon.setFont(segoeUIEmoji);
        emptyIcon.setForeground(Color.black);
        emptyIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
        emptyIcon.setHorizontalTextPosition(SwingConstants.CENTER);
        emptyIcon.setBounds(220,70,512,512);
        emptyIcon.setIconTextGap(0);
        adminPanel.add(emptyIcon);
        rightDuck.setBackground(Color.white);
        repaint();
    }

    private boolean authenticateAdmin(String text,  String text1) {
        boolean adminIsValid = false;

        if(text1.equals("12345"))
            adminIsValid = true;
        else
            adminIsValid = false;

        return adminIsValid;
    }

    private JPanel getRegisterationPanel(){
        JPanel innerRegistrationPanel = new JPanel();
        innerRegistrationPanel.setLayout(null);
        innerRegistrationPanel.setBackground(Colors.transparentColor);
        innerRegistrationPanel.setBounds(300,85,400,700);
        JLabel ownersNameLabel = new JLabel("Name.");
        ownersNameLabel.setIcon(profileIcon);
        ownersNameLabel.setForeground(Color.WHITE);
        JTextField ownersTextField = new JTextField("");
        ownersTextField.selectAll();
        ownersNameLabel.setBounds(22,75,100,25);
        ownersTextField.setBounds(100,70,280,30);
        ownersTextField.selectAll();
        ownersTextField.setSelectedTextColor(new Color(0x495249));
        JLabel emailIcon = new JLabel("Email");
        emailIcon.setForeground(Color.WHITE);
        ImageIcon email = new ImageIcon("images//email.png");
        emailIcon.setIcon(email);
        emailIcon.setBounds(22,135,130,25);
        JTextField emailTextField = new JTextField("");
        emailTextField.setBounds(100,130,280,30);

        emailTextField.addKeyListener(new DigitListener(emailTextField));

        JLabel heightIcon = new JLabel("Height.");
        heightIcon.setForeground(Color.WHITE);
        ImageIcon height = new ImageIcon("images//height.png");
        heightIcon.setIcon(height);
        heightIcon.setBounds(22,195,100,25);
        JTextField heihtTextField = new JTextField("");
        heihtTextField.setBounds(100,190,280,30);

        JLabel idIcon = new JLabel("Id no.");
        idIcon.setForeground(Color.WHITE);
        ImageIcon id = new ImageIcon("images//idNumber.png");
        idIcon.setIcon(id);
        idIcon.setBounds(22,255,150,25);
        JTextField idTextField = new JTextField("");
        idTextField.setBounds(100,250,280,30);


        JLabel phoneIcon = new JLabel("Mobile.");
        phoneIcon.setForeground(Color.WHITE);
        ImageIcon phone = new ImageIcon("images//mobile.png");
        phoneIcon.setIcon(phone);
        phoneIcon.setBounds(22,315,100,25);
        JTextField phoneTextField = new JTextField("");

        phoneTextField.setBounds(100,310,280,30);


        JLabel stateIcon = new JLabel("State.");
        stateIcon.setForeground(Color.WHITE);
        ImageIcon state = new ImageIcon("images//state.png");
        stateIcon.setIcon(state);
        stateIcon.setBounds(22,375,100,25);
        JTextField stateTextField = new JTextField("");
        stateTextField.setBounds(100,370,280,30);

        JLabel passwordIcon = new JLabel("Pass.");
        passwordIcon.setForeground(Color.WHITE);
        ImageIcon passes = new ImageIcon("images//passes.png");
        passwordIcon.setIcon(passes);
        passwordIcon.setBounds(22,435,100,25);
        JPasswordField passwordField = new JPasswordField("padsfsdvsv");
        passwordField.setBounds(100,430,280,25);

        JLabel confirmPassIcon = new JLabel("Confirm.");
        confirmPassIcon.setForeground(Color.WHITE);
        confirmPassIcon.setIcon(passes);
        confirmPassIcon.setBounds(22,495,100,25);
        JPasswordField confirmPassTextField = new JPasswordField("ieueueueue");
        confirmPassTextField.setBounds(100,490,280,25);

        JLabel  alreadyLabel= new JLabel("Already registerd? | Log In...");
        alreadyLabel.setForeground(Color.WHITE);
        alreadyLabel.setBounds(50,585,160,15);
        alreadyLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                alreadyLabel.setBackground(Color.pink);
                cardLayout.show(mainView,"loginPanel");
                rightDuck.setBackground(Colors.pink);
                for (JPanel p: navilabel)
                    p.setVisible(false);
                naviUser.setVisible(true);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                alreadyLabel.setForeground(Color.black);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                alreadyLabel.setForeground(Color.WHITE);
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                alreadyLabel.setForeground(Color.black);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                alreadyLabel.setForeground(Color.white);
                repaint();

            }
        });

        JButton register = new JButton("Register");
        register.setBounds(260,580,100,30);
        register.setBackground(lightGreen);
        Component[] c = {alreadyLabel,passwordIcon,passwordField,confirmPassIcon,confirmPassTextField,stateIcon,
                stateTextField,phoneIcon,phoneTextField,idIcon,idTextField,heightIcon,heihtTextField,register,emailIcon,emailTextField,ownersTextField,ownersNameLabel};
        for(Component component: c){
            innerRegistrationPanel.add(component);

        }
        phoneTextField.addKeyListener(new DigitListener(this));
        heihtTextField.addKeyListener(new DigitListener(this));
        idTextField.addKeyListener(new DigitListener(this));

        register.addActionListener(action -> {
            if(emailTextField.getText().trim().equals(""))
                MyFrames.showSuccessfullFrame("Email address is required! ",bigCancleIcon,getWidth(),getHeight());
            else if (ownersTextField.getText().trim().isEmpty())
                MyFrames.showSuccessfullFrame("Name is required! ",bigCancleIcon,getWidth(),getHeight());
            else{
                if(passwordField.getText().trim().equals("")||confirmPassTextField.getText().trim().equals(""))
                    MyFrames.showSuccessfullFrame("password is compulsory",bigCancleIcon,getWidth(),getHeight());
                else {
                    if (passwordField.getText().equals(confirmPassTextField.getText())) {
                        User u = new User();
                        boolean isReg = false;
                        for (User us : user) {
                            if (us.getEmail().equals(emailTextField.getText().trim().toLowerCase()))
                                isReg = true;
                        }

                        if(!isReg){
                            u.setEmail(TextCoverter.capitalizer(emailTextField.getText().trim()));
                            u.setPass(passwordField.getText().trim());
                            u.setName(TextCoverter.capitalizer(ownersTextField.getText().trim()));
                            if (heihtTextField.getText().trim().isEmpty())
                                u.setHeight(0);
                            else u.setHeight(Integer.parseInt(heihtTextField.getText().trim()));
                            u.setMobileNumber(phoneTextField.getText().trim().isEmpty() ? "No number" : phoneTextField.getText().trim());
                            u.setState(stateTextField.getText().trim());
                            u.setIdNumber((idTextField.getText().trim().isEmpty() ? "No id." : idTextField.getText().trim()));
                            u.setLastAmountPayed(10000);
                            u.setDateOfLastPayment(String.format("%tc", new Date()));
                            user.add(0,u);
                            MyFrames.showSuccessfullFrame("Registered Successfully",bigSuccessfulIcon,
                                    getWidth(),getHeight());
                            repaint();
                            totalAmountRemit += u.getTotalMoneyPayed();

                        }
                        else MyFrames.showSuccessfullFrame( "Email already exist!",bigCancleIcon,getWidth(),getHeight());

                    } else {
                        MyFrames.showSuccessfullFrame("Password does not match",bigCancleIcon,getWidth(),getHeight());
                    }
                }
            }

        });
        return  innerRegistrationPanel;
    }
    public static void main(String mubby[]){
        invokeLater(() -> new TollGate().setVisible(true));
    }




    private void setUpMainPanel(){
        panel1.setLayout(new BorderLayout());
        panel1.setBounds(0,30,1370,740);
        panel1.add(BorderLayout.CENTER,getSplitpane());
        add(panel1);

    }
    private JSplitPane getSplitpane(){
        JSplitPane splitPane1 = new JSplitPane();
        splitPane1.setRightComponent(getRightComponent());
        splitPane1.setDividerLocation(364);
        splitPane1.setDividerSize(1);
        splitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane1.setMaximumSize(getMaximumSize());
        splitPane1.setMaximumSize(Dimen.SPLIT_MENU_SIZE);
        splitPane1.setLeftComponent(getLeftComponent());
        splitPane1.setBorder(null);
        return splitPane1;
    }

    private JPanel getLeftComponent() {
        //set the bounds of buttons

        for (JPanel p : navilabel){
            p.setVisible(false);
        }
        naviHome.setVisible(true);
        homeButton.setBounds(10,130,354,80);
        naviHome.setBounds(0,130,5,80);

        homeButton.setIcon(new ImageIcon("images//home2.png"));

        adminButton.setBounds(10,240,354,80);
        naviAdmin.setBounds(0,240,5,80);
        adminButton.setIcon(new ImageIcon("images//admin.png"));

        userButton.setBounds(10,340,354,80);
        naviReg.setBounds(0,340,5,80);
        userButton.setIcon(new ImageIcon("images//register.png"));

        logIn.setBounds(10,440,354,80);
        naviUser.setBounds(0,440,5,80);
        logIn.setIcon(new ImageIcon("images//user.png"));

        logoutButton.setBounds(10,540,354,80);
        naviOut.setBounds(0,540,5,80);
        logoutButton.setIcon(new ImageIcon("images//logout.png"));

        //button properties
        JButton[] buttons = {homeButton,adminButton,logoutButton,userButton,logIn};
        for(JButton btn : buttons){

                btn.setBackground(Color.black);
                btn.setForeground(Color.WHITE);
                btn.setContentAreaFilled(true);
                btn.setBorderPainted(false);
                btn.setFocusPainted(false);
                btn.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
                btn.setHorizontalTextPosition(SwingConstants.TRAILING);
                btn.setHorizontalAlignment(SwingConstants.LEADING);
                btn.setIconTextGap(34);


        }

        //sidePanel and menu button listener panel


        homeButton.addActionListener(action -> {
            repaint();
            for (JPanel p : navilabel){
                p.setVisible(false);
            }
            naviHome.setVisible(true);
            refreshed = false;
            cardLayout.show(mainView, "homePanel");
            rightDuck.setBackground(new Color(0,0,0));
            homeIcon.setVisible(true);
            adminIcon.setVisible(false);
            userIcon.setVisible(false);
            logoutIcon.setVisible(false);
            regIcon.setVisible(false);
            repaint();
        });
        adminButton.addActionListener(actionEvent -> {cardLayout.show(mainView, "adminPanel");
            for (JPanel p : navilabel){
                p.setVisible(false);
            }
            naviAdmin.setVisible(true);
            if(!adminAvailable)
                rightDuck.setBackground(Colors.sky);
            else
                rightDuck.setBackground(Color.black);
            homeIcon.setVisible(false);
            adminIcon.setVisible(true);
            userIcon.setVisible(false);
            logoutIcon.setVisible(false);
            regIcon.setVisible(false);
            if(isAdminValid){
                if(!(user.isEmpty())) {
                        reFreshPayments();
                        repaint();
                    refreshed = true;

                }
                else {
                    showEmptyView();
                }
            }
            repaint();
        });
        userButton.addActionListener(actionEvent -> {cardLayout.show(mainView, "registerationPanel");
            rightDuck.setBackground(Colors.pink);
            homeIcon.setVisible(false);
            adminIcon.setVisible(false);
            userIcon.setVisible(false);
            logoutIcon.setVisible(false);
            for (JPanel p : navilabel){
                p.setVisible(false);
            }
            naviReg.setVisible(true);
            refreshed = false;

            regIcon.setVisible(true);
            repaint();
        });
        logoutButton.addActionListener(actionEvent ->{ cardLayout.show(mainView, "logoutPanel");
            rightDuck.setBackground(Colors.brown);
            refreshed = false;
            for (JPanel p : navilabel){
                p.setVisible(false);
            }
            naviOut.setVisible(true);
            int b = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?","TollGate System",2);
            if(b == 0){
                userIcon2.setVisible(false);
                online.setVisible(false);
                if(loggedIn) {
                    loggedIn = false;
                    loginPanel.removeAll();
                    loginPanel.add(getLogginPanel(2));
                    cardLayout.show(mainView,"loginPanel");
                    rightDuck.setBackground(new Colors().pink);
                    homeIcon.setVisible(false);
                    adminIcon.setVisible(false);
                    userIcon.setVisible(true);
                    //naviUser.setVisible(true);
                    logoutIcon.setVisible(false);
                    regIcon.setVisible(false);
                    repaint();
                }else{
                    int r = JOptionPane.showConfirmDialog(null,"You are not yet Logged in\nLog in ?","Log out -Toll Gate",1,2);
                    if (r == 0){
                        for (JPanel p: navilabel)
                            p.setVisible(false);
                        naviUser.setVisible(true);
                        cardLayout.show(mainView,"loginPanel");
                        rightDuck.setBackground(new Colors().pink);
                        homeIcon.setVisible(false);
                        adminIcon.setVisible(false);
                       // naviUser.setVisible(true);
                        userIcon.setVisible(true);
                        logoutIcon.setVisible(false);
                        regIcon.setVisible(false);
                        repaint();
                    }
                    else {
                        cardLayout.show(mainView,"homePanel");
                        rightDuck.setBackground(Color.white);
                    }
                }

            }
            else
            {
                cardLayout.show(mainView,"homePanel");
                homeIcon.setVisible(true);
                adminIcon.setVisible(false);
                userIcon.setVisible(false);
                regIcon.setVisible(false);
                logoutIcon.setVisible(false);
                rightDuck.setBackground(new Color(0,0,0));
                repaint();
            }
            for (JPanel p : navilabel){
                p.setVisible(false);
            }
            naviHome.setVisible(true);

            repaint();
        });
        logIn.addActionListener(actionPerformed -> {
            refreshed = false;
            for (JPanel p : navilabel){
                p.setVisible(false);
            }
            naviUser.setVisible(true);
            cardLayout.show(mainView, "loginPanel");
            rightDuck.setBackground(Colors.pink);
            homeIcon.setVisible(false);
            adminIcon.setVisible(false);
            userIcon.setVisible(true);
            logoutIcon.setVisible(false);
            regIcon.setVisible(false);
            repaint();
        });

        sidePanel.setLayout(null);
        sidePanel.add(naviOut);
        sidePanel.add(naviUser);
        sidePanel.add(naviReg);
        sidePanel.add(naviAdmin);
        sidePanel.add(naviHome);
        sidePanel.add(homeButton);
        sidePanel.add(userButton);
        sidePanel.add(logoutButton);
        sidePanel.add(adminButton);
        sidePanel.add(logIn);
        sidePanel.setBackground(Color.black);
        return sidePanel;
    }

    private JPanel getRightComponent(){
        mainView.setLayout(null);
        cardLayout = new CardLayout();
        cardLayout.addLayoutComponent(homePanel,"homePanel");
        cardLayout.addLayoutComponent(registerationPanel,"registerationPanel");
        cardLayout.addLayoutComponent(loginPanel,"loginPanel");
        cardLayout.addLayoutComponent(logoutPanel,"logoutPanel");
        cardLayout.addLayoutComponent(adminPanel,"adminPanel");
        mainView.setLayout(cardLayout);
        //Admin panel UI

        adminPanel.setLayout(null);
        JLabel label = new JLabel();
        label.setText("");
        label.setIcon(Icons.tollGateJPG);
        label.setBounds(-100, -100, 1300, 957);
        adminPanel.add(getLogginPanel(1));
        adminPanel.add(label);


        //RegistrationPanel UI

        registerationPanel.setBackground(Colors.pink);
        registerationPanel.setLayout(null);
        registerationPanel.add(getRegisterationPanel());

        //Home, logout  panel UI

        logoutPanel.setBackground(Colors.brown);

        //HomePanel UI

        homePanel.setBackground(Color.white);
        homePanel.setLayout(null);
        JLabel car = new JLabel("");
        car.setIcon(Icons.vehicleJPG);
        car.setBounds(0,-227,2000,1000);
        JPanel p = new JPanel();
        p.setBackground(Colors.transparentColor);
        p.setBounds(400,0,622,537);
        p.setLayout(null);
        JLabel text = new JLabel("You are welcome");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("MV Boli",Font.PLAIN,50));
        text.setBounds(80,70,400,100);
        p.add(text);
        JLabel text2 = new JLabel("to the");
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("MV Boli",Font.PLAIN,50));
        text2.setBounds(160,150,250,100);
        p.add(text2);

        JLabel bwRoad = new JLabel(blackWhiteCar);
        JLabel cRoad = new JLabel(coloredCar);
        JLabel dayNigth = new JLabel(dayandnight);
        JLabel cloud1 = new JLabel(Icons.cloud1);

        bwRoad.setBounds(100,70,512,512);
        cRoad.setBounds(510,70,512,512);
        dayNigth.setBounds(690,5,240,240);
        cloud1.setBounds(800,45,127,127);
        homePanel.add(bwRoad);
        homePanel.add(cloud1);
        homePanel.add(cRoad);
        homePanel.add(dayNigth);
        homePanel.add(getHomePanel());

        //login panel UI

        loginPanel.setBackground(new Colors().pink);
        loginPanel.setLayout(null);
        loginPanel.add(getLogginPanel(0));

        // adding panel to mainView
        JPanel[] panels  = {homePanel,adminPanel,registerationPanel,loginPanel,logoutPanel};
        for(JPanel ps : panels)
            mainView.add(ps);

        return mainView;
    }

    private JPanel getHomePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0,0,0));
        panel.setBounds(0,537,1022,200);
        panel.setLayout(null);
        JLabel about = new JLabel("About");
        about.setForeground(Color.white);
        about.setBounds(40,30,100,20);

        JLabel faq = new JLabel("FAQs");
        faq.setForeground(Color.white);
        faq.setBounds(40,60,100,20);

        JLabel logOut = new JLabel("Log Out");
        logOut.setForeground(Color.white);
        logOut.setBounds(40,90,100,20);

        JLabel help = new JLabel("Help");
        help.setForeground(Color.white);
        help.setBounds(40,120,100,20);
        panel.add(help);

        JLabel facebookIcon = new JLabel();
        ImageIcon facebook = new ImageIcon("images//facebook.png");
        facebookIcon.setIcon(facebook);
        facebookIcon.setBounds(370,150,25,25);

        JLabel instagramIcon = new JLabel();
        ImageIcon instagram = new ImageIcon("images//insta.png");
        instagramIcon.setIcon(instagram);
        instagramIcon.setBounds(400,150,25,25);

        JLabel twitterIcon = new JLabel();
        ImageIcon twitter = new ImageIcon("images//twitter.png");
        twitterIcon.setIcon(twitter);
        twitterIcon.setBounds(425,150,25,25);

        JLabel linkedInIcon = new JLabel();
        ImageIcon linkedIn = new ImageIcon("images//linkedIn.png");
        linkedInIcon.setIcon(linkedIn);
        linkedInIcon.setBounds(454,150,25,25);

        JLabel copyRight = new JLabel("@Copyright 2019");
        copyRight.setForeground(Color.white);
        copyRight.setBounds(374,175,200,25);



        JLabel contact = new JLabel("Contact");
        contact.setForeground(Color.white);
        contact.setBounds(400,30,200,20);


        JLabel report = new JLabel("Report Issues");
        report.setForeground(Color.white);
        report.setBounds(400,60,200,20);


        JLabel makePayment = new JLabel("Make Payment");
        makePayment.setForeground(Color.white);
        makePayment.setBounds(400,90,200,20);

        JLabel signIn = new JLabel("Sign In");
        signIn.setForeground(Color.white);

        signIn.setBounds(400,120,200,20);

        JLabel[] labels ={signIn,about,makePayment,logOut,contact,report,faq,help,copyRight,facebookIcon,instagramIcon,twitterIcon };
        for(JLabel l : labels) {
            panel.add(l);
            l.setFont(smallSegoeUIEmoji);
            l.addMouseListener(new HomePanelBottomDuckListener(labels, this));
        }
        report.addMouseListener(new HomePanelBottomDuckListener(labels,this));

        return panel;
    }
    private boolean authenticateUser(String emailAddress, String pass){
        boolean confirm = false ;
        for(User u : user){
            if(emailAddress.trim().toLowerCase().equals(u.getEmail()) && pass.trim().equals(u.getPass())|| emailAddress.trim().toLowerCase().equals(u.getEmail()) && pass.equals("0000"))
                confirm = true;
        }

        return confirm;
    }
    private JPanel loggedIn() {

        JLabel carName = new JLabel("Car Brand.");
        carName.setBounds(30, 105, 200, 20);
        carName.setIcon(new ImageIcon("images//pop.png"));
        carName.setForeground(Color.white);
        JComboBox<String> combo = new JComboBox<>();
        combo.addItem("none");
        combo.addItem("Toyota");
        combo.addItem("Honda");
        combo.addItem("Benz");
        combo.addItem("Audi");
        combo.addItem("Ford");
        combo.addItem("Acura");
        combo.addItem("Rolls Royce");
        combo.addItem("Hyunda");
        combo.addItem("Jeep");
        combo.addItem("Mack");
        combo.addItem("Cat");
        combo.addItem("Lamboghini");
        combo.addItem("Jaguar");
        combo.addItem("Tesla");
        combo.addItem("Ferrari");
        combo.addItem("Hummer");
        combo.setBounds(130, 100, 400, 30);

        JLabel carType = new JLabel("Car Type");
        carType.setIcon(new ImageIcon("images//car.png"));
        carType.setBounds(30,205,100,30);
        carType.setForeground(Color.white);
        JComboBox<String> carSizes = new JComboBox<>();
        carSizes.setBounds(130,200,400,30);
        carSizes.addItem("none");
        carSizes.addItem("Truck/trailer");
        carSizes.addItem("Bus/picnic");
        carSizes.addItem("Sport Car");

        JLabel carColor = new JLabel("Car Color");
        carColor.setIcon(new ImageIcon("images//carcolor.png"));
        carColor.setBounds(30,285,100,30);
        carColor.setForeground(Color.white);

        JTextField textField = new JTextField("input the color");
        textField.setBounds(130,285,400,30);

        JLabel plateNumber = new JLabel("Plate Number");
        plateNumber.setIcon(new ImageIcon("images//plateNumber.png"));
        plateNumber.setBounds(30,365,100,30);
        plateNumber.setForeground(Color.white);
        JTextField plateText = new JTextField("Input your plate number");
        plateText.setBounds(130,365,400,30);


        JLabel payment = new JLabel("Select Payment Method:");
        payment.setForeground(Color.white);
        payment.setBounds(80,445,200,30);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton paypalLabel = new JRadioButton("");
        JLabel paypal = new JLabel();
        paypal.setIcon(new ImageIcon("images//paypal.png"));

        paypal.setBounds(100, 485, 24, 24);
        paypalLabel.setBackground(new Color(0, 0, 0, 10));
        paypalLabel.setContentAreaFilled(false);
        paypalLabel.setBounds(80, 485, 19, 15);

        JRadioButton masterCardRadio = new JRadioButton();
        masterCardRadio.setBounds(150,485,19,15);

        JLabel mastercard = new JLabel();
        mastercard.setIcon(new ImageIcon("images//master.png"));
        mastercard.setBounds(170,485,22,15);
        mastercard.setBackground(Color.WHITE);
        masterCardRadio.setBackground(Color.black);
        JRadioButton visaRadio = new JRadioButton();
        visaRadio.setBackground(Color.black);
        visaRadio.setBounds(220,485,26,15);

        JLabel visa = new JLabel();
        visa.setIcon(new ImageIcon("images//visa.png"));
        visa.setBounds(240,485,22,15);
        buttonGroup.add(paypalLabel);
        buttonGroup.add(masterCardRadio);
        buttonGroup.add(visaRadio);

        paypal.setBackground(Color.white);
        paypal.setForeground(Color.white);
        JPanel middlePanel = new JPanel();
        JButton btn = new JButton("Proceed to payment");
        btn.setFont(new Font("MV Boli", Font.PLAIN, 24));
        btn.setForeground(Color.black);
        btn.setBackground(new Color(0x44F90D));
        btn.setBounds(110, 610, 420, 40);
        btn.addActionListener(actionPerformed -> {
            MyFrames myFrames = new MyFrames();
            myFrames.showProcessDialog();
        });
        middlePanel.add(btn);
        middlePanel.add(payment);
        middlePanel.setBackground(new Color(0,0,0,253));
        middlePanel.setBounds(220, 50, 600, 1000);
        middlePanel.setLayout(null);
        middlePanel.add(carName);
        middlePanel.add(plateNumber);
        middlePanel.add(plateText);
        middlePanel.add(combo);
        middlePanel.add(carType);
        middlePanel.add(paypalLabel);
        middlePanel.add(paypal);
        middlePanel.add(carSizes);
        middlePanel.add(visa);
        middlePanel.add(visaRadio);
        middlePanel.add(carColor);
        middlePanel.add(textField);
        middlePanel.add(mastercard);
        middlePanel.add(masterCardRadio);
        return middlePanel;
    }

    private JPanel getProcessPayment(){
        JPanel paymentPanel = new JPanel();

        //TODO: implement the payment method later in the code

        return paymentPanel;
    }
    private void reFreshPayments(){
        if(refreshed)
            adminPanel.repaint();

        else {
            loggedIn = true;
            adminPanel.removeAll();
            adminPanel.setLayout(null);
            adminPanel.setBackground(Color.black);
            rightDuck.setBackground(Color.black);
            JLabel totalNumberOfUsers = new JLabel("Total users:. ");
            JLabel totalU = new JLabel(""+user.size());
            totalU.setFont(segoeUIEmoji);
            JLabel totalAmountRemit = new JLabel("Money In Bank:. N");
            totalAmountRemit.setForeground(Color.white);
            JLabel totalR = new JLabel();
            totalR.setForeground(totalR.getText().equals("0.0") ? new Color(0xFF0000): new Color(0x00F211));
            totalAmountRemit.setFont(segoeUIEmoji);
            totalR.setFont(segoeUIEmoji);
            totalAmountRemit.setIcon(moneyInBankIcon);
            totalAmountRemit.setBounds(450,5,300,50);
            totalR.setBounds(710,5,300,50);
            totalU.setBounds(200,5,400,50);
            totalU.setForeground(lightGreen);
            totalNumberOfUsers.setBounds(20,5,200,50);
            totalNumberOfUsers.setForeground(Color.white);
            totalNumberOfUsers.setIconTextGap(10);
            totalNumberOfUsers.setIcon(peopleIcon);
            totalNumberOfUsers.setFont(segoeUIEmoji);
            totalR.setText(""+TollGate.totalAmountRemit);

            JScrollPane scrollPane = getAdminLoggedIn();
            scrollPane.setBorder(null);

            scrollPane.setBounds(0,70,1000,700);
            adminPanel.add(totalAmountRemit);
            adminPanel.add(totalNumberOfUsers);
            adminPanel.add(totalR);
            adminPanel.add(totalU);
            adminPanel.add(scrollPane, BorderLayout.CENTER);


            setExtendedState(Frame.MAXIMIZED_BOTH);
            repaint();
        }
    }

    class HomePanelBottomDuckListener implements MouseListener {
        private JLabel[] labels;
        private JFrame frame;

        private HomePanelBottomDuckListener(){}

        public HomePanelBottomDuckListener(JLabel[] labels, JFrame frame) {
            this.labels = labels;
            this.frame = frame;
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (mouseEvent.getSource() == labels[0]) {
                labels[0].setForeground(new Color(0xEDD38C));
                cardLayout.show(mainView,"loginPanel");
                rightDuck.setBackground(new Colors().pink);
                for (JPanel p: navilabel)
                    p.setVisible(false);
                naviUser.setVisible(true);
                repaint();
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            setForegroundToYellow(mouseEvent);
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            setForegroundToWhite(mouseEvent);
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
           setForegroundToYellow(mouseEvent);
        }


        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            for(int i = 0; i<labels.length;i++)
                if(mouseEvent.getSource() == labels[i])
                    labels[i].setForeground(Color.WHITE);
            frame.repaint();

        }
        public void setForegroundToWhite(MouseEvent mouseEvent){
            for(int i = 0; i<labels.length;i++)
                if(mouseEvent.getSource() == labels[i])
                    labels[i].setForeground(Color.WHITE);
            frame.repaint();
        }
        public void setForegroundToYellow(MouseEvent mouseEvent){
            for(int i = 0; i<=7 ; i++)
                if (mouseEvent.getSource() == labels[i])
                    labels[i].setForeground(new Color(0xEDD38C));
            frame.repaint();
        }
    }
}
