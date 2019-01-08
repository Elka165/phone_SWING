package phone.gui;

import phone.method.ClassCreator;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SizerAndColorSwing {

    private Color fontColor = new Color(108, 122, 137);
    private Font fontElement = new Font("Helvetica", Font.BOLD, 12);
    private Color lineColor = new Color(189, 195, 199);
    private static final Integer WIDTH_JLABEL = 250;
    private static final Integer HEIGHT_BOUNDS = 30;
    private static final Integer WIDTH_SCROLL_PANE = 300;
    private static final Integer HEIGHT_SCROLL_PANE = 120;


    public void assignSizeColorJLabel(JLabel jLabel, Integer sizeX, Integer sizeY) {
        jLabel.setBounds(sizeX, sizeY, WIDTH_JLABEL, HEIGHT_BOUNDS);
        jLabel.setFont(fontElement);
        jLabel.setForeground(fontColor);
    }

    public void assignSizeJComboBox(JComboBox jComboBox, Integer sizeX, Integer sizeY, Integer width, ArrayList list) {
        jComboBox.setModel(new DefaultComboBoxModel(list.toArray()));
        jComboBox.setBounds(sizeX, sizeY, width, HEIGHT_BOUNDS);
    }

    public void assignSizeJTextField(JTextField jTextField, Integer sizeX, Integer sizeY, Integer width) {
        jTextField.setBounds(sizeX, sizeY, width, HEIGHT_BOUNDS);
    }

    public void assignSizeJButton(JButton jButton, Integer sizeX, Integer sizeY, Integer width) {
        jButton.setBounds(sizeX, sizeY, width, HEIGHT_BOUNDS);
    }

    public void assignSizeJPanel(JPanel jPanel, Integer sizeX, Integer sizeY, Integer width, Integer height, String title) {
        jPanel.setBackground(Color.white);
        jPanel.setBorder(BorderFactory.createLineBorder(lineColor));
        jPanel.setBorder(BorderFactory.createTitledBorder("title"));
        jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, lineColor), title, TitledBorder.CENTER, TitledBorder.CENTER));
        jPanel.setLayout(null);
        jPanel.setBounds(sizeX, sizeY, width, height);
    }

    public JFrame assignJFrame(JFrame jFrame, Integer width, Integer height) {
        jFrame.setSize(width, height);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setBackground(Color.WHITE);
        jFrame.setLayout(null);
        return jFrame;
    }

    public void assignJTextArea(JTextArea jTextArea, Integer sizeX, Integer sizeY) {
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setBounds(sizeX, sizeY, WIDTH_SCROLL_PANE, HEIGHT_SCROLL_PANE);
    }

    public void assignJSrollPane(JScrollPane scrollPane, Integer sizeX, Integer sizeY) {
        scrollPane.setBounds(sizeX, sizeY, WIDTH_SCROLL_PANE, HEIGHT_SCROLL_PANE);
    }

    public void setLookAndFell(JFrame jFrame) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(jFrame);

        } catch (Exception exc) {
            System.err.println("Nie potrafię wczytać systemowego wyglądu: " + exc);
        }
    }

    public void changeFontWhenMoveMouseAndActivateNemFrame(Component component, JFrame frameInvisible, String className) {

        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                frameInvisible.setVisible(false);
               ClassCreator classCreator=new ClassCreator(className);
            }
            public void mouseEntered(MouseEvent e) {
                component.setFont(new Font("Helvetica", Font.ITALIC, 12));
            }
            public void mouseExited(MouseEvent e) {
                component.setFont(new Font("Helvetica", Font.BOLD, 12));
            }
        });
    }



}