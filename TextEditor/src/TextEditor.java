import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEditor extends JFrame implements ActionListener{

	JTextArea textarea;
	JScrollPane scrollpane;
	JSpinner fontSizeSpinner;
	JLabel fontLabel;
	JButton fontColorButton;
	JComboBox fontBox;
	
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem saveItem;
	JMenuItem openItem;
	JMenuItem exitItem;
	
	TextEditor(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Code Via yt");
		setSize(500, 500);
		setLayout(new FlowLayout());
		
		textarea = new JTextArea();
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setFont(new Font("Arial", Font.PLAIN, 20));
		
		scrollpane = new JScrollPane(textarea);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setPreferredSize(new Dimension(450, 450));
		
		fontLabel = new JLabel("Font: ");
		
		fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50, 25));
		fontSizeSpinner.setValue(20);
		fontSizeSpinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				textarea.setFont(new Font(textarea.getFont().getFamily(), Font.PLAIN, (int)fontSizeSpinner.getValue()));
				
			}
		});
		
		fontColorButton = new JButton("Color");
		fontColorButton.addActionListener(this);
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		fontBox = new JComboBox(fonts);
		fontBox.addActionListener(this);
		fontBox.setSelectedItem("Arial");
		
		//--------MenuBar----------\\
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		saveItem = new JMenuItem("Save");
		openItem = new JMenuItem("Open");
		exitItem = new JMenuItem("Exit");
		
		saveItem.addActionListener(this);
		openItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		//--------/MenuBar----------\\
		
		this.setJMenuBar(menuBar);
		add(fontLabel);
		add(fontSizeSpinner);
		add(fontColorButton);
		add(fontBox);
		add(scrollpane);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == fontColorButton) {
			JColorChooser colorChooser = new JColorChooser();
			
			Color color = colorChooser.showDialog(null, "Choose a color", Color.black);
			textarea.setForeground(color);	
		}
		if(e.getSource() == fontBox) {
			textarea.setFont(new Font((String)fontBox.getSelectedItem(), Font.PLAIN, textarea.getFont().getSize()));
		}
		
		if(e.getSource() == openItem) {
		JFileChooser fileChooser = new JFileChooser()	;
		fileChooser.setCurrentDirectory(new File("."));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		fileChooser.setFileFilter(filter);
		
		int response = fileChooser.showOpenDialog(null);
		
		if(response == JFileChooser.APPROVE_OPTION) {
			File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			Scanner fileIn = null;
			
			try {
				fileIn = new Scanner(file);
				while(fileIn.hasNextLine()) {
					String line = fileIn.nextLine() + "\n";
					textarea.append(line);
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			finally {
				fileIn.close();
			}
			
		}
		
		}
		if(e.getSource() == saveItem) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));// '.' will set the file location to the project folder.
			
			int response = fileChooser.showSaveDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file;
				PrintWriter fileout = null;

				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					fileout = new PrintWriter(file);
					fileout.println(textarea.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				finally {
					fileout.close();
				}
			}
		}
		if(e.getSource() == exitItem) {
			System.exit(0);
}
	}
}
