package phone.gui;

import phone.method.ListOfElements;
import phone.method.PropertiesLoader;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JudicialFeesPanel implements ActionListener {

    public static Integer DISTANCE_FROM_THE_TEXT_TOP = 30;
    public static Integer DISTANCE_FROM_THE_TEXT_RIGHT = 60;
    public static Integer WIDTH_JFRAME = 1250;
    public static Integer HEIGHT_JFRAME = 800;
    public JFrame mainFrame;
    private JPanel panelClaims = new JPanel();
    private JPanel panelRecipient = new JPanel();
    private JPanel panelTransferDescription = new JPanel();
    JLabel textDamageList;
    JLabel textRecipientList;
    JComboBox comboDamageList = new JComboBox();
    JComboBox comboRecipient = new JComboBox();
    JLabel textNumberClaims;
    JLabel textRecipientName;
    ImageIcon imageIcon;
    JLabel image;
    JLabel textCity;
    JLabel textAccount;
    JTextField fieldNumberClaims = new JTextField();
    JTextField accountNumber=new JTextField();
    JComboBox listOfCities;
    JTextArea areaNameOfRecipient;
    SizerAndColorSwing sizerAndColorSwing = new SizerAndColorSwing();
    ListOfElements listOfElements = new ListOfElements();
    JButton buttonChooseRecipient;
    PropertiesLoader propertiesLoader = new PropertiesLoader();
    JLabel textSygnatur;
    JTextField fieldSygnature;
    JLabel textDiscrabe;
    JTextArea areaDiscrabe;
    JLabel txtAmount;
    JTextField fieldAmount;
    JButton buttonSave;


    public JudicialFeesPanel() {
        String path = propertiesLoader.loadImages("sourceImagePath").toString();
        imageIcon = new ImageIcon(path);
        image = new JLabel(imageIcon);
        buttonSave=new JButton("<html><strong>Zapisz</html></strong>");
        buttonSave.addActionListener(this);
        mainFrame = new JFrame("OPŁATY SĄDOWE - DODAJ NOWY PRZELEW");
        sizerAndColorSwing.assignJFrame(mainFrame, WIDTH_JFRAME, HEIGHT_JFRAME);
        image.setBounds(700, 180, 500, 200);
        sizerAndColorSwing.assignSizeJButton(buttonSave,430,630, 150);
        mainFrame.add(buttonSave);
        mainFrame.add(image);
        mainFrame.add(panelClaims);
        mainFrame.add(panelRecipient);
        mainFrame.add(panelTransferDescription);
        createPanelClaims();
        createPanelRecipient();
        createTransferDescription();
        sizerAndColorSwing.setLookAndFell(mainFrame);
    }

    public void createPanelClaims() {
        textNumberClaims = new JLabel("Numer szkody");
        textDamageList = new JLabel("Rodzaj szkody");
        sizerAndColorSwing.assignSizeJPanel(panelClaims, 0, 5, WIDTH_JFRAME - 600, 150, "Dane dotyczące szkody do przelewu");
        sizerAndColorSwing.assignSizeJComboBox(comboDamageList, 90, 30 + DISTANCE_FROM_THE_TEXT_TOP, 120, listOfElements.getTypeOfDamageList());
        sizerAndColorSwing.assignSizeColorJLabel(textDamageList, 90, 30);
        sizerAndColorSwing.assignSizeJTextField(fieldNumberClaims, 210 + DISTANCE_FROM_THE_TEXT_RIGHT, 30 + DISTANCE_FROM_THE_TEXT_TOP, 210);
        sizerAndColorSwing.assignSizeColorJLabel(textNumberClaims, 240 + DISTANCE_FROM_THE_TEXT_RIGHT, 30);
        panelClaims.add(comboDamageList);
        panelClaims.add(textDamageList);
        panelClaims.add(textNumberClaims);
        panelClaims.add(fieldNumberClaims);
    }

    public void createPanelRecipient() {
        buttonChooseRecipient = new JButton("<html><strong>Wybierz odbiorcę</strong></html>");
        areaNameOfRecipient = new JTextArea(5, 20);
        textRecipientList = new JLabel("*Rodzaj odbiorcy");
        textRecipientName = new JLabel("*Nazwa odbiorcy");
        textCity = new JLabel("*Miasto odbiorcy");
        textAccount = new JLabel("*Numer konta");
        listOfCities = new JComboBox();
        sizerAndColorSwing.assignSizeJPanel(panelRecipient, 0, 155, WIDTH_JFRAME - 600, 250, "Dane dotyczące odbiorcy przelewu");
        sizerAndColorSwing.assignSizeJComboBox(comboRecipient, 90, 30 + DISTANCE_FROM_THE_TEXT_TOP, 120, listOfElements.getTypeOfRecipientList());
        sizerAndColorSwing.assignSizeColorJLabel(textRecipientList, 90, 30);
        sizerAndColorSwing.assignSizeColorJLabel(textRecipientName, 240 + DISTANCE_FROM_THE_TEXT_RIGHT, 30);
        sizerAndColorSwing.assignJTextArea(areaNameOfRecipient, 210 + DISTANCE_FROM_THE_TEXT_RIGHT, 30 + DISTANCE_FROM_THE_TEXT_TOP);
        areaNameOfRecipient.setEnabled(false);
        sizerAndColorSwing.assignSizeJButton(buttonChooseRecipient, 400, 30,150);
        buttonChooseRecipient.addActionListener(this);
        sizerAndColorSwing.assignSizeColorJLabel(textCity, 90, 100);
        sizerAndColorSwing.assignSizeJComboBox(listOfCities, 90, 100 + DISTANCE_FROM_THE_TEXT_TOP, 160, listOfElements.getListOfCity());
        sizerAndColorSwing.assignSizeColorJLabel(textAccount, 90, 170);
        sizerAndColorSwing.assignSizeJTextField(accountNumber,90,210, 360);
        panelRecipient.add(comboRecipient);
        panelRecipient.add(textRecipientList);
        panelRecipient.add(areaNameOfRecipient);
        panelRecipient.add(textRecipientName);
        panelRecipient.add(buttonChooseRecipient);
        panelRecipient.add(textCity);
        panelRecipient.add(listOfCities);
        panelRecipient.add(textAccount);
        panelRecipient.add(accountNumber);
    }

    public void createTransferDescription() {
        textSygnatur=new JLabel("Sygnatura");
        fieldSygnature=new JTextField();
        textDiscrabe=new JLabel("*Opis");
        areaDiscrabe=new JTextArea(5,20);
        txtAmount=new JLabel("*Kwota");
        fieldAmount=new JTextField();
        sizerAndColorSwing.assignSizeJPanel(panelTransferDescription, 0, 420, WIDTH_JFRAME - 600, 260, "Dane dotyczące opisu i kwoty przelewu");
        sizerAndColorSwing.assignSizeJTextField(fieldSygnature, 90, 30 + DISTANCE_FROM_THE_TEXT_TOP, 120);
        sizerAndColorSwing.assignSizeColorJLabel(textSygnatur, 90, 30);
        sizerAndColorSwing.assignSizeColorJLabel(textDiscrabe, 240 + DISTANCE_FROM_THE_TEXT_RIGHT, 30);
        sizerAndColorSwing.assignJTextArea(areaDiscrabe, 210 + DISTANCE_FROM_THE_TEXT_RIGHT, 30 + DISTANCE_FROM_THE_TEXT_TOP);
        sizerAndColorSwing.assignSizeColorJLabel(txtAmount, 90, 100);
        sizerAndColorSwing.assignSizeJTextField(fieldAmount, 90, 100 + DISTANCE_FROM_THE_TEXT_TOP, 120);
        panelTransferDescription.add(textSygnatur);
        panelTransferDescription.add(fieldSygnature);
        panelTransferDescription.add(textDiscrabe);
        panelTransferDescription.add(areaDiscrabe);
        panelTransferDescription.add(txtAmount);
        panelTransferDescription.add(fieldAmount);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}