package phone.gui;

import phone.method.ListOfElements;
import phone.method.PropertiesLoader;
import phone.model.CallsRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class PhonePanel implements ActionListener, ItemListener {

    private static Integer DISTANCE_FROM_THE_TEXT_TOP = 30;
    private static Integer DISTANCE_FROM_THE_TEXT_RIGHT = 60;
    private static Integer WIDTH_JFRAME = 900;
    private static Integer HEIGHT_JFRAME = 400;
    public JFrame mainFrame;
    private JComboBox comboTopicList = new JComboBox();
    private JLabel txtTopicList;
    private JComboBox comboSubcategory = new JComboBox();
    private JLabel txtSubcategory;
    private JLabel textNumberClaims;
    private ImageIcon imageIcon;
    private JLabel image;
    private JTextField fieldNumberClaims = new JTextField();
    private SizerAndColorSwing sizerAndColorSwing = new SizerAndColorSwing();
    private ListOfElements listOfElements = new ListOfElements();
    private PropertiesLoader propertiesLoader = new PropertiesLoader();
    private JButton buttonSave;
    private JLabel txtWhoCalls;
    private JComboBox comboWhoCalls;
    private JLabel txtInfo;
    private CallsRepository callsRepository=new CallsRepository();

    public PhonePanel() {
        addFrame();
        addImage();
        addClaims();
        addCategory();
        addSubcategory();
        addWhoCalls();
        addFieldInfo();
        buttonSave=new JButton("<html><strong>Zapisz</html></strong>");
        buttonSave.addActionListener(this);

        sizerAndColorSwing.assignSizeJButton(buttonSave,220+ DISTANCE_FROM_THE_TEXT_RIGHT,200, 150);
        addComponents(buttonSave);
        addComponents(image);
        addComponents(fieldNumberClaims);
        addComponents(textNumberClaims);
        addComponents(txtTopicList);
        addComponents(comboTopicList);
        addComponents(comboSubcategory);
        addComponents(txtSubcategory);
        addComponents(txtWhoCalls);
        addComponents(comboWhoCalls);
        addComponents(txtInfo);
        sizerAndColorSwing.setLookAndFell(mainFrame);
        mainFrame.setVisible(true);
    }

    public void addComponents(Component component){
        mainFrame.add(component);
    }

    public void addImage(){
        String path = propertiesLoader.loadImages("sourcePhonePath").toString();
        imageIcon = new ImageIcon(path);
        image = new JLabel(imageIcon);
        image.setBounds(430, 40, 510, 210);
    }

    public void addFrame(){
        mainFrame = new JFrame("POŁĄCZENIA PRZYCHODZĄCE");
        sizerAndColorSwing.assignJFrame(mainFrame, WIDTH_JFRAME, HEIGHT_JFRAME);
    }

    public void addClaims() {
        textNumberClaims = new JLabel("Numer szkody");
        sizerAndColorSwing.assignSizeJTextField(fieldNumberClaims, 20, 30 + DISTANCE_FROM_THE_TEXT_TOP, 210);
        sizerAndColorSwing.assignSizeColorJLabel(textNumberClaims, 40, 30);

    }
    public void addCategory(){
        txtTopicList = new JLabel("Temat rozmowy");
        comboTopicList=new JComboBox();
        sizerAndColorSwing.assignSizeJComboBox(comboTopicList, 20, 100 + DISTANCE_FROM_THE_TEXT_TOP, 210,callsRepository.getTypeOfTopic());
        sizerAndColorSwing.assignSizeColorJLabel(txtTopicList, 40, 100);
        comboTopicList.setActionCommand("comboTopicList");
        comboTopicList.addItemListener(this);
    }

    public void addSubcategory(){
        txtSubcategory = new JLabel("Podkategoria");
        comboSubcategory=new JComboBox();
        sizerAndColorSwing.assignSizeJComboBox(comboSubcategory, 220+ DISTANCE_FROM_THE_TEXT_RIGHT, 100 + DISTANCE_FROM_THE_TEXT_TOP, 210,callsRepository.getTypeOfSubcategoryList(comboTopicList.getSelectedItem().toString()));
        sizerAndColorSwing.assignSizeColorJLabel(txtSubcategory, 240+DISTANCE_FROM_THE_TEXT_RIGHT, 100);
    }

    public void addWhoCalls(){
        txtWhoCalls = new JLabel("Kto dzwonił");
        comboWhoCalls=new JComboBox();
        sizerAndColorSwing.assignSizeJComboBox(comboWhoCalls, 20, 170 + DISTANCE_FROM_THE_TEXT_TOP, 210,listOfElements.getListWhoCalls());
        sizerAndColorSwing.assignSizeColorJLabel(txtWhoCalls, 40, 170);
    }
    public void addFieldInfo() {
        txtInfo = new JLabel("*Wszystkie pola muszą zostać uzupełnione");
        sizerAndColorSwing.assignSizeColorJLabel(txtInfo, 10, 5);
        txtInfo.setForeground(new Color(207, 0, 15));
        txtInfo.setFont(new Font("Helvetica", Font.BOLD, 12));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            comboSubcategory.removeAllItems();
            callsRepository.getTypeOfSubcategoryList(comboTopicList.getSelectedItem().toString());
            ArrayList newList=new ArrayList();
            newList=callsRepository.getTypeOfSubcategoryList(comboTopicList.getSelectedItem().toString());
            comboSubcategory.setModel(new DefaultComboBoxModel(newList.toArray()));
            comboSubcategory.repaint();
        }
    }
}