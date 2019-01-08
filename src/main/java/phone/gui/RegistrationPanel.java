package phone.gui;

import phone.method.ListOfElements;
import phone.method.PropertiesLoader;

import javax.swing.*;
import java.awt.*;

public class RegistrationPanel {
    public static Integer WIDTH_JFRAME = 560;
    public static Integer HEIGHT_JFRAME = 430;
    public static Integer SIZE_X = 250;
    public static Integer WIDTH_FIELD = 240;
    public JFrame registrationFrame;
    PropertiesLoader propertiesLoader = new PropertiesLoader();
    ImageIcon imageRegistrationIcon;
    JLabel registrationLabelImage;
    SizerAndColorSwing sizerAndColorSwing = new SizerAndColorSwing();
    JLabel txtLogin;
    JLabel userLogin;
    JLabel txtInfo;
    JLabel txtName;
    JTextField nameField;
    JLabel txtSurname;
    JTextField surnameField;
    ListOfElements listOfElements = new ListOfElements();
    JButton saveButton;
    JLabel txtBackToLoginPanel;


    public RegistrationPanel() {

        addMainPanel();
        addImageRegistration();
        addLogin();
        addFieldInfo();
        addName();
        addSurname();
        addSaveButton();
        addBackToLoginPanel();
        addAllToRegistrationPanel();
        sizerAndColorSwing.setLookAndFell(registrationFrame);
        registrationFrame.setVisible(true);
    }

    public void addComponentToRegistrationPanel(Component component){
        registrationFrame.add(component);
    }

    public void addAllToRegistrationPanel(){
        addComponentToRegistrationPanel(registrationLabelImage);
        addComponentToRegistrationPanel(txtLogin);
        addComponentToRegistrationPanel(userLogin);
        addComponentToRegistrationPanel(txtInfo);
        addComponentToRegistrationPanel(txtName);
        addComponentToRegistrationPanel(nameField);
        addComponentToRegistrationPanel(surnameField);
        addComponentToRegistrationPanel(txtSurname);
        addComponentToRegistrationPanel(saveButton);
        addComponentToRegistrationPanel(txtBackToLoginPanel);
    }

    public void addLogin() {
        txtLogin = new JLabel("Login");
        sizerAndColorSwing.assignSizeColorJLabel(txtLogin, SIZE_X, 50);
        userLogin = new JLabel(System.getProperty("user.name"));
        sizerAndColorSwing.assignSizeColorJLabel(userLogin, SIZE_X, 70);
        userLogin.setForeground(new Color(0, 0, 0));
        userLogin.setFont(new Font("Helvetica", Font.BOLD, 12));
    }

    public void addMainPanel() {
        registrationFrame = new JFrame("REJESTRACJA");
        sizerAndColorSwing.assignJFrame(registrationFrame, WIDTH_JFRAME, HEIGHT_JFRAME);
        registrationFrame.setVisible(false);
    }

    public void addFieldInfo() {
        txtInfo = new JLabel("*Wszystkie pola muszą zostać uzupełnione");
        sizerAndColorSwing.assignSizeColorJLabel(txtInfo, SIZE_X, 25);
        txtInfo.setForeground(new Color(207, 0, 15));
        txtInfo.setFont(new Font("Helvetica", Font.BOLD, 12));
    }

    public void addImageRegistration() {
        String path = propertiesLoader.loadImages("sourceRegistrationImagePath").toString();
        imageRegistrationIcon = new ImageIcon(path);
        registrationLabelImage = new JLabel(imageRegistrationIcon);
        registrationLabelImage.setBounds(10, 70, SIZE_X, 200);
    }

    public void addName() {
        txtName = new JLabel("Imię");
        sizerAndColorSwing.assignSizeColorJLabel(txtName, SIZE_X, 100);

        nameField = new JTextField(15);
        sizerAndColorSwing.assignSizeJTextField(nameField, SIZE_X, 130, WIDTH_FIELD);
    }

    public void addSurname() {
        txtSurname = new JLabel("Nazwisko");
        sizerAndColorSwing.assignSizeColorJLabel(txtSurname, SIZE_X, 160);
        surnameField = new JTextField(15);
        sizerAndColorSwing.assignSizeJTextField(surnameField, SIZE_X, 190, WIDTH_FIELD);
    }

    public void addSaveButton() {
        saveButton = new JButton("Zapisz");
        sizerAndColorSwing.assignSizeJButton(saveButton, 390, 350, 100);
    }

    public void addBackToLoginPanel(){
        txtBackToLoginPanel = new JLabel("← Powrót do logowania");
        sizerAndColorSwing.assignSizeColorJLabel(txtBackToLoginPanel, 40, 350);
        sizerAndColorSwing.changeFontWhenMoveMouseAndActivateNemFrame(txtBackToLoginPanel, registrationFrame, "phone.gui.Login");
    }
}