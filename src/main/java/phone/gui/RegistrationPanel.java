package phone.gui;

import phone.method.ListOfElements;
import phone.method.PropertiesLoader;
import phone.model.User;
import phone.sql.SqlQuery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPanel implements ActionListener {
    private static Integer WIDTH_JFRAME = 560;
    private static Integer HEIGHT_JFRAME = 430;
    private static Integer SIZE_X = 250;
    private static Integer WIDTH_FIELD = 240;
    public JFrame registrationFrame;
    private PropertiesLoader propertiesLoader = new PropertiesLoader();
    private ImageIcon imageRegistrationIcon;
    private JLabel registrationLabelImage;
    private SizerAndColorSwing sizerAndColorSwing = new SizerAndColorSwing();
    private JLabel txtLogin;
    private JLabel userLogin;
    private JLabel txtInfo;
    private JLabel txtName;
    private JTextField nameField;
    private JLabel txtSurname;
    private JTextField surnameField;
    private ListOfElements listOfElements = new ListOfElements();
    private JButton saveButton;
    private JLabel txtBackToLoginPanel;


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

    private void addComponentToRegistrationPanel(Component component){
        registrationFrame.add(component);
    }

    private void addAllToRegistrationPanel(){
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

    private void addLogin() {
        txtLogin = new JLabel("Login");
        sizerAndColorSwing.assignSizeColorJLabel(txtLogin, SIZE_X, 50);
        userLogin = new JLabel(System.getProperty("user.name"));
        sizerAndColorSwing.assignSizeColorJLabel(userLogin, SIZE_X, 70);
        userLogin.setForeground(new Color(0, 0, 0));
        userLogin.setFont(new Font("Helvetica", Font.BOLD, 12));
    }

    private void addMainPanel() {
        registrationFrame = new JFrame("REJESTRACJA");
        sizerAndColorSwing.assignJFrame(registrationFrame, WIDTH_JFRAME, HEIGHT_JFRAME);
        registrationFrame.setVisible(false);
    }

    private void addFieldInfo() {
        txtInfo = new JLabel("*Wszystkie pola muszą zostać uzupełnione");
        sizerAndColorSwing.assignSizeColorJLabel(txtInfo, SIZE_X, 25);
        txtInfo.setForeground(new Color(207, 0, 15));
        txtInfo.setFont(new Font("Helvetica", Font.BOLD, 12));
    }

    private void addImageRegistration() {
        String path = propertiesLoader.loadImages("sourceRegistrationImagePath").toString();
        imageRegistrationIcon = new ImageIcon(path);
        registrationLabelImage = new JLabel(imageRegistrationIcon);
        registrationLabelImage.setBounds(10, 70, SIZE_X, 200);
    }

    private void addName() {
        txtName = new JLabel("Imię");
        sizerAndColorSwing.assignSizeColorJLabel(txtName, SIZE_X, 100);

        nameField = new JTextField(15);
        sizerAndColorSwing.assignSizeJTextField(nameField, SIZE_X, 130, WIDTH_FIELD);
    }

    private void addSurname() {
        txtSurname = new JLabel("Nazwisko");
        sizerAndColorSwing.assignSizeColorJLabel(txtSurname, SIZE_X, 160);
        surnameField = new JTextField(15);
        sizerAndColorSwing.assignSizeJTextField(surnameField, SIZE_X, 190, WIDTH_FIELD);
    }

    private void addSaveButton() {
        saveButton = new JButton("Zapisz");
        sizerAndColorSwing.assignSizeJButton(saveButton, 390, 350, 100);
        saveButton.addActionListener(this);
    }

    private void addBackToLoginPanel(){
        txtBackToLoginPanel = new JLabel("← Powrót do logowania");
        sizerAndColorSwing.assignSizeColorJLabel(txtBackToLoginPanel, 40, 350);
        sizerAndColorSwing.changeFontWhenMoveMouseAndActivateNemFrame(txtBackToLoginPanel, registrationFrame, "phone.gui.Login");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == saveButton) {
            SqlQuery sqlQuery=new SqlQuery();
            User newUser=new User(userLogin.getText(), nameField.getText(), surnameField.getText());
            sqlQuery.addUser(newUser, registrationFrame);
        }
    }
}