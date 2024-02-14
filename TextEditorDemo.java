import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditorDemo implements ActionListener{

	JFrame frame;
	JLabel label;
	JMenu filemenu, editmenu;
	JMenuBar menubar;
	JMenuItem newitem, saveitem, saveAllitem, changeFontitem;
	JTextArea textarea;
	
	JPanel panel;
	
	public TextEditorDemo(){
		frame = new JFrame("Text Editor demo program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(700, 700);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.black);
		
		textarea = new JTextArea();
		textarea.setBounds(100, 100, 500, 600);
		textarea.setLineWrap(true);
		textarea.setBackground(Color.black);
		textarea.setForeground(Color.cyan);
		textarea.setFont(new Font("Mandana", Font.PLAIN, 40));
		
		label = new JLabel();
		
		menubar = new JMenuBar();
		menubar.setBackground(Color.black);
		menubar.setForeground(Color.orange);
		
		filemenu = new JMenu("File");
		editmenu = new JMenu("Edit");
		
		filemenu.setForeground(Color.orange);
		editmenu.setForeground(Color.orange);

		menubar.setBounds(20, 20, 60, 30);
		
		newitem = new JMenuItem("New");
		saveitem = new JMenuItem("Save");
		saveAllitem = new JMenuItem("Save All");
		changeFontitem = new JMenuItem("Font");
		
		filemenu.add(newitem);
		filemenu.add(saveitem);
		filemenu.add(saveAllitem);
		
		editmenu.add(changeFontitem);
		
		filemenu.addActionListener(this);
		editmenu.addActionListener(this);
		
		menubar.add(filemenu);
		menubar.add(editmenu);
		
		panel.add(menubar);
//		panel.add(editmenu);
		panel.add(textarea);
	
		frame.add(panel);
		frame.setVisible(true);
		
	}
	
	public static void main(String[]args) {
	new TextEditorDemo();
}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
