import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Notepad extends KeyAdapter implements KeyListener, ActionListener{
	int fsize = 17;
	
	private JTextArea area;
	private JScrollPane scpane;
	String text = "";
	
	JFrame f = new JFrame("NotePad Example");
	
	JTextField title;
	Font newFont;
	JPanel bottomPanel;
	JLabel detailsOfFile;
	JList fontStyleList, fontFamilyList, fontSizeList;
	JScrollPane sb;
	JMenuBar menuBar;
	JMenu file, edit, format;
	JMenuItem newdoc, open, save, exit, print, copy, paste, cut, selectall, fontfamily, fontstyle, fontsize;
	
	String fontFamilyValues[] = {"Agency FB", "Antiqua", "Architect", "Arial", "Calibri", "comic sans", "courier", "cursive", "impact", "serif"};
	String fontSizeValues[] = {"5", "10", "15", "20", "25", "30", "35", "40", "45", "50","55", "60", "65", "70"};
	
	int []stylevalue = {Font.PLAIN, Font.BOLD, Font.ITALIC};
	String[] fontStyleValues = {"Plain", "bold", "Italic"};
	String fontFamily, fontSize, fontStyle;
	int fstyle;
	int cl;
	int linecount;
	JScrollPane sp;
	
	public Notepad() {
		initUI();
		//calling addActionEvent() method to add events.
		addActionEvent();
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("New")) {
			area.setText("");
		}else if(ae.getActionCommand().equals("Open"));
		JFileChooser chooser = new JFileChooser("c:/");
		chooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files",".txt");
		chooser.addChoosableFileFilter(restrict);
		
		int result = chooser.showOpenDialog(f);
		if(result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			try {
				FileReader reader = new FileReader(file);
				BufferedReader br = new BufferedReader(reader);
				area.read(br, null);
				
				br.close();
				area.requestFocus();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		//if save option is choosen.

		else if(ae.getActionCommand().equals("Save")) {
			final JFileChooser SaveAs = new JFileChooser();
			SaveAs.setApproveButtonText("Save");
			//asking from user where to save file.
			int actionDialog = SaveAs.showOpenDialog(f);
			if(actionDialog != JFileChooser.APPROVE_OPTION) {
				return;
			}
			File fileName = new File(SaveAs.getSelectedFile() + ".txt");
			BufferedWriter outfile = null;
			try {
				outfile = new BufferedWriter(new FileWriter(fileName));
				area.write(outfile);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	// if print option is choosen.
		else if(ae.getActionCommand().equals("Prine")) {
			try {
				//printer dialog will open.
				area.print();
			}catch(Exception e) {
				
			}
		}
		// if exit option is choosen.
		else if(ae.getActionCommand().equals("Exit")) {
			//Destroying / Closing the frame/window.
			f.dispose();
		}
		//if copy option is choosen
		else if(ae.getActionCommand().equals("Copy")) {
			//Getting selected selecting text.
			text = area.getSelectedText();
		}
		// if paste option is choosen.
		else if(ae.getActionCommand().equals("Paste")) {
			area.insert(text, area.getCaretPosition());
		}
		// if cut option is chooosen.
		else if(ae.getActionCommand().equals("Cut")) {
			text = area.getSelectedText();
			area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
		}//if select all option is choosen.
		else if(ae.getActionCommand().equals("Select All")) {
			area.selectAll();
		}//if font family change option is choosen.
		else if(ae.getActionCommand().equals("Font Family")) {
			JOptionPane.showConfirmDialog(null, fontFamilyList, "Choose Font Family",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			fontFamily = String.valueOf(fontFamilyList.getSelectedValue());
			newFont = new Font(fontFamily,fstyle , fsize);
			area.setFont(newFont);
		}//if style change option is choosen.
		else if(ae.getActionCommand().equals("Font Style")) {
			JOptionPane.showConfirmDialog(null, fontStyleList, "Choose Font Style", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			fstyle = stylevalue[fontStyleList.getSelectedIndex()];
			newFont = new Font(fontFamily, fstyle, fsize);
			area.setFont(newFont);
		}//if Font size change option is choosen.
		else if(ae.getActionCommand().equals("Font Size")) {
			JOptionPane.showConfirmDialog(null, fontSizeList, "Choose Font Size", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			fontSize = String.valueOf(fontSizeList.getSelectedValue());
			fsize = Integer.parseInt(fontSize);
			newFont = new Font(fontFamily, fstyle, fsize );
			area.setFont(newFont);
		}
	}
	@Override
	public void keyTyped(KeyEvent ke) {
		//calculating length and count of words.
		cl = area.getText().length();
		linecount = area.getLineCount();
		detailsOfFile.setText("Length: " + cl + "Line: " + linecount);
	}
	
	public void initUI() {
		detailsOfFile = new JLabel();
		
		bottomPanel = new JPanel();
		
		//Creating Menubar.
		menuBar = new JMenuBar();
		//creatin Menu File.
		file = new JMenu("File");
		
		//creating MenuItem New.
		newdoc = new JMenuItem("New");
		
		
		
		//Assigning shortCut "ctrl + N" for "NEW" MenuItem.
		newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		//Creating MenuItem "Open".
		open = new JMenuItem("Open");
		
		//Assigning shortCut "ctrl + O" for Open menu item.
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		//Creating MenuItem "Save".
		save = new JMenuItem("Save");
		
		//Assigning shortcut for "ctrl + N" for "Save" MenuItem.
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		//Creating MenuItem "Print" .
		print = new JMenuItem("Print");
		
		//Assigning shortCut "CTRL + P" for "Print" MenuItem.
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		
		//Creating menuItem "Exit".
		exit = new JMenuItem("Exit");
		
		//Assigning shortCut "ESC" for "Exit" Menu Item.
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
		
//		Creating menu"Edit"
		edit = new JMenu("Edit");
		
		//Creating MenuItem Copy
		copy = new JMenuItem("Copy");
		
		//Assigning shortCut "CTRL + C" for "Copy" menu item.
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		//Creating menuItem Paste
		paste = new JMenuItem("Paste");
		
		//Assigning shortCut "CTRL + V for "Paste" menu Item.
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		
		//Creating MenuItem cut.
		cut = new JMenuItem("Cut");
		
		//Assigning shortCut "CTRL + X" for Cut menuItem.
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		//Creating MenuItem "SelectAll".
		selectall = new JMenuItem("Select All");
		
		//Assigning shortCut "CTRL + A" for select ALL menuItem.
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		//Creating Menu "Format".
		format = new JMenu("Format");
		
		//Creating menuItem Font Family.
		fontfamily = new JMenuItem("Font-Family");
		
		//Creating MenuItem "Font-Style".
		fontstyle = new JMenuItem("Font-Style");
		
		//Creating MenuItem "Font-Size".
		fontsize = new JMenuItem("Font-Size");
		
		//Creating List of fonts and assigning the list values.
		fontFamilyList = new JList(fontFamilyValues);
		
		//Creating List of Fonts and Assigning the list values.
		fontStyleList = new JList(fontStyleValues);
		
		//Creating List of fonts and Assigning the List values.
		fontSizeList = new JList(fontStyleValues);
		
		//Allowing user to select one option.
		fontFamilyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fontStyleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fontSizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//TextArea/Editor of Notepad.
		area = new JTextArea();
		
//		Default font will be san_serif and default font Style will be plain and default style//Size will 20.
		area.setFont(new Font("San_Serif", Font.PLAIN, 20));
		
//		set the line Wrapping policy of the TextArea.
		area.setLineWrap(true);
		
		//Set the word wrapping policy of the text Area.
		area.setWrapStyleWord(true);
		
		//Creating Scrollables around textArea.
		scpane = new JScrollPane(area);
		
		//Creating borders for ScrollPane.
		scpane.setBorder(BorderFactory.createEmptyBorder());
		
		//Adding MenuBar in Frame.
		f.setJMenuBar(menuBar);
		
//		Adding All Menus is MenuBar.
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(format);
		
		file.add(newdoc);
		file.add(open);
		file.add(save);
		file.add(print);
		file.add(exit);
		
		edit.add(copy);
		edit.add(paste);
		edit.add(cut);
		edit.add(selectall);
		
		format.add(fontfamily);
		format.add(fontstyle);
		format.add(fontsize);
		
		bottomPanel.add(detailsOfFile);
		
		//setting up the size of frame.
			f.setSize(980, 480);
			
			//setting up layout of a frame.
			f.setLayout(new BorderLayout());
			
			//adding panels in frame.
			f.add(scpane,BorderLayout.CENTER);
			f.add(bottomPanel,BorderLayout.SOUTH);
			
			//setting frame visible to user.
			f.setVisible(true);
	}
	public void addActionEvent() {
		//Registering action listeners to buttons.
		newdoc.addActionListener(this);
		save.addActionListener(this);
		print.addActionListener(this);
		exit.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		cut.addActionListener(this);
		selectall.addActionListener(this);
		open.addActionListener(this);
		fontfamily.addActionListener(this);
		fontsize.addActionListener(this);
		fontstyle.addActionListener(this);
	}
	 
	public static void main(String[]args) {
	
	new Notepad();
	}
	}


