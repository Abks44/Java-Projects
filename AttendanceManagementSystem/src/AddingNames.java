import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AddingNames extends JFrame implements ActionListener {

    AttendHereExperiments attendHere;
    DefaultListModel<String> studentListModel;
    JList<String> studentList;
    JPanel panel;
    JButton addButton;
    JTextField nameField;
    ImageIcon icon;
    JLabel imageLabel;
    JScrollPane scpane;
//    JLayeredPane layeredPane;

    public AddingNames(AttendHereExperiments attendHere) {
        this.attendHere = attendHere;
        
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        int width = getWidth();
        int height = getHeight();
//        System.out.println("Width: " + width + "\nHeight:" + height);
//        System.out.println(getWidth());
        
        imageLabel = new JLabel();
        
        icon = new ImageIcon("InsertName.png");
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon.setImage(image);
        imageLabel.setIcon(icon);
        
        studentListModel = new DefaultListModel<>();
        studentList = new JList<>(studentListModel);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        scpane = new JScrollPane(studentList);
        
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        addButton.setFocusable(false);

        nameField = new JTextField(20);
        
        // Add a key listener to the nameField to handle the Enter key
        nameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_ENTER) {
                    handleKey();
                }
            }
        });
 
        panel.add(new JLabel("Name: "));
        panel.add(nameField);
        panel.add(addButton);
        panel.add(imageLabel);
        
        add(panel, BorderLayout.NORTH);
//        setComponentZOrder(scpane, 0);
        add(new JScrollPane(studentList), BorderLayout.SOUTH);
//        add(scpane, BorderLayout.SOUTH);

        setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
//            attendHere.dPanel.setVisible(true);
            if(nameField != null) {
            handleKey();
            }
        }
    }

    public void handleKey() {
        String name = nameField.getText();
        studentListModel.addElement(name);

//        attendHere.defaultListModel.addElement(name);
        nameField.setText("");
    }
}
