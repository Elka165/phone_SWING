package phone.gui;

import phone.method.PropertiesLoader;
import phone.sql.SqlQuery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {

    private static Integer WIDTH_JFRAME = 420;
    private static Integer HEIGHT_JFRAME = 240;
    public JFrame loginFrame;
    private PropertiesLoader propertiesLoader = new PropertiesLoader();
    private ImageIcon imageLoginIcon;
    private JLabel loginLabelImage;
    private SizerAndColorSwing sizerAndColorSwing = new SizerAndColorSwing();
    private JLabel txtLogin;
    private JLabel userLogin;
    private JButton loginButton;
    private JButton cancelButton;
    private JLabel txtRegister;

    public Login() {

        loginFrame = new JFrame("LOGOWANIE");
        sizerAndColorSwing.assignJFrame(loginFrame, WIDTH_JFRAME, HEIGHT_JFRAME);
        addImageIcon();
        addLogin();
        addLoginButton();
        addCancelLogin();
        addRegistration();

        loginFrame.add(loginLabelImage);
        loginFrame.add(txtLogin);
        loginFrame.add(userLogin);
        loginFrame.add(cancelButton);
        loginFrame.add(loginButton);
        loginFrame.add(txtRegister);
        sizerAndColorSwing.setLookAndFell(loginFrame);
        loginFrame.setVisible(true);
    }


    private void addImageIcon() {
        String path = propertiesLoader.loadImages("sourceLoginImagePath").toString();
        imageLoginIcon = new ImageIcon(path);
        loginLabelImage = new JLabel(imageLoginIcon);
        loginLabelImage.setBounds(25, 30, 130, 130);
    }

    private void addLogin() {
        txtLogin = new JLabel("Login");
        sizerAndColorSwing.assignSizeColorJLabel(txtLogin, 220, 70);
        userLogin = new JLabel(System.getProperty("user.name"));
        sizerAndColorSwing.assignSizeColorJLabel(userLogin, 270, 70);
        userLogin.setForeground(new Color(0, 0, 0));
        userLogin.setFont(new Font("Helvetica", Font.BOLD, 12));
    }

    private void addLoginButton() {
        loginButton = new JButton("Zaloguj");
        loginButton.addActionListener(this);
        sizerAndColorSwing.assignSizeJButton(loginButton, 290, 120, 70);
    }

    private void addCancelLogin() {
        cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(this);
        sizerAndColorSwing.assignSizeJButton(cancelButton, 220, 120, 70);
    }

    private void addRegistration() {
        txtRegister = new JLabel("Zarejestruj się");
        sizerAndColorSwing.assignSizeColorJLabel(txtRegister, 270, 160);
        sizerAndColorSwing.changeFontWhenMoveMouseAndActivateNemFrame(txtRegister, loginFrame, "phone.gui.RegistrationPanel");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == cancelButton) {
            System.exit(0);
        }

        if(source==loginButton){
            SqlQuery sqlQuery=new SqlQuery();
            sqlQuery.isLoginInDatabase(userLogin.getText(), loginFrame);
        }
    }
}