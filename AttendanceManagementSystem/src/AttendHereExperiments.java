import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class AttendHereExperiments extends JPanel implements ActionListener{
	
	static JLayeredPane buttonPane;
	static JLabel updateNameLabel;
	JLabel removeNameLabel;
	JScrollPane dPanelSPane;
	JButton closePanelButton;
	String[] attend = {
			"P", "A", "NA", "NA"
	};
	ImageIcon bgIcon, submitbuttonIcon, addButtonIcon, updateButtonIcon, removeButtonIcon, roundImageIcon, sqToRoundIcon;
	Image addButtonImage;
	JLabel bgImageLabel, buttonImageLabel, updateImageLabel, removeImageLabel;
	JButton backButton, addButton, updateNamesButton, removeNamesButton, presentAllButton, absentAllButton;
	JRadioButton[] rb;
	JScrollPane scPane;
	JButton closeButton;
	ButtonGroup bg[];

	boolean updateFlag = true;
	static int increase;
	int removeLabels = 0;
	static JScrollBar verticalScrollBar;
	static JButton submitButton;
	int width = 400; 
	int height = 100;
	static JLayeredPane pane;
	
	static JLabel updateLabel[];
	ArrayList<String> names2 = new ArrayList<>(Arrays.asList( 
			"Abks Smith", "legend Johnson","John Doe", "Mary Williams", "David Jones",
			"Sarah Brown", "Michael Davis","Jennifer Miller", "Robert Wilson", "Laura Moore",
		    "Emily Martinez", "William Anderson", "Olivia Taylor", "James Brown", "Emma Wilson",
		    "Benjamin Garcia", "Ava Hernandez", "Liam Davis", "Mia Martinez", "Henry Gonzalez",
		    "Sophia Smith", "Alexander Harris", "Chloe Lewis", "Ethan Martin", "Grace Johnson",
		    "Samuel Harris", "Ella Gonzalez", "Daniel Brown", "Lily Davis", "Matthew Garcia"));
	
	String state;
	
	Object[][] data2 = {
		    {"Abks Smith", 25, state},
		    {"legend Johnson", 30, state},
		    {"John Doe", 28, state},
		    {"Mary Williams", 22, state},
		    {"David Jones", 35, state},
		    {"Sarah Brown", 29, state},
		    {"Michael Davis", 32, state},
		    {"Jennifer Miller", 27, state},
		    {"Robert Wilson", 31, state},
		    {"Laura Moore", 24, state},
		    {"Emily Martinez", 26, state},
		    {"William Anderson", 33, state},
		    {"Olivia Taylor", 29, state},
		    {"James Brown", 36, state},
		    {"Emma Wilson", 25, state},
		    {"Benjamin Garcia", 28, state},
		    {"Ava Hernandez", 23, state},
		    {"Liam Davis", 29, state},
		    {"Mia Martinez", 31, state},
		    {"Henry Gonzalez", 27, state},
		    {"Sophia Smith", 24, state},
		    {"Alexander Harris", 28, state},
		    {"Chloe Lewis", 30, state},
		    {"Ethan Martin", 32, state},
		    {"Grace Johnson", 29, state},
		    {"Samuel Harris", 34, state},
		    {"Ella Gonzalez", 26, state},
		    {"Daniel Brown", 28, state},
		    {"Lily Davis", 25, state},
		    {"Matthew Garcia", 30, state}
		};
	
	static JLabel[] nameLabel;
	JLabel attendLabel;
	int nameLabelHeight = 20;	
	int nameLabelWidth = 100;
	
	//Constructor.
	public AttendHereExperiments() {
	
	setLayout(null);
	setPreferredSize(new Dimension(1200, 1200));
	
	pane = new JLayeredPane();
	pane.setBounds(80, 10, 800, 1200);
		
	updateNameLabel = new JLabel("Update");
	updateNameLabel.setBackground(Color.gray);
	updateNameLabel.setBounds(750, 600, 90, 32);
	updateNameLabel.setFont(new Font(null, Font.BOLD, 24));
	updateNameLabel.setForeground(Color.white);
	updateNameLabel.setOpaque(true);
	
	removeNameLabel = new JLabel("Remove");
	removeNameLabel.setBackground(Color.orange);
	removeNameLabel.setBounds(850, 600, 100, 32);
	removeNameLabel.setFont(new Font(null, Font.BOLD, 24));
	removeNameLabel.setForeground(Color.white);
	removeNameLabel.setOpaque(true);
	removeNameLabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent m) {
			removeLabels();
	        revalidate(); // Refresh the panel
	        nameLabelHeight = 20; // Reset nameLabelHeight
	        disableLabel(removeNameLabel);
	        updateNameLabel.setBackground(Color.black);
	        updateNameLabel.addMouseListener(new MouseAdapter() {
	        	
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		updateNameLabels();
	    	        disableLabel(updateNameLabel);
	        	}
	        
	        });
		}
	});
	
	closePanelButton = new JButton("X");
	closePanelButton.setFocusable(false);
	int preffW = closePanelButton.getPreferredSize().width;
	int preffH = closePanelButton.getPreferredSize().height;
	closePanelButton.setBounds(1125, 0, preffW, preffH);
	closePanelButton.addActionListener(this);
	
    int panelWidth = (int)this.getPreferredSize().getWidth();
    int panelHeight = (int)this.getPreferredSize().getHeight();
	
    increase = names2.size();
	bgImageLabel = new JLabel();
	buttonImageLabel = new JLabel();
	
	//Button Icon.
	submitbuttonIcon = new ImageIcon("submitButtonBG2.jpg");
	Image image2 = submitbuttonIcon.getImage().getScaledInstance(110, 40, Image.SCALE_SMOOTH);
	submitbuttonIcon = new ImageIcon(image2);
	
	scPane = new JScrollPane();
	
	submitButton = new JButton("Submit");
	submitButton.addActionListener(this);
	submitButton.setFocusable(false);
	submitButton.setBounds(350, 1100, 100, 40);
//	submitButton.setIcon(submitbuttonIcon);
	submitButton.setBackground(Color.black);
	submitButton.setForeground(Color.orange);
	submitButton.setOpaque(true);
	submitButton.setVisible(true);
	
	presentAllButton = new JButton("Present All");
	presentAllButton.setBounds(890, 20, 100, 40);
	presentAllButton.setFocusable(false);
	presentAllButton.addActionListener(this);
	presentAllButton.setBackground(Color.black);
	presentAllButton.setForeground(Color.orange);
	
	absentAllButton = new JButton("Absent All");
	absentAllButton.setBounds(770, 20, 100, 40);
	absentAllButton.setFocusable(false);
	absentAllButton.addActionListener(this);
	absentAllButton.setBackground(Color.black);
	absentAllButton.setForeground(Color.orange);
	
	updateNamesButton = new JButton("Update Names");
	updateNamesButton.setBounds(640, 20, 120, 40);
	updateNamesButton.setFocusable(false);
	updateNamesButton.addActionListener(this);
	updateNamesButton.setBackground(Color.black);
	updateNamesButton.setForeground(Color.orange);
	updateNamesButton.setEnabled(false);

	removeNamesButton = new JButton("Remove Names");
	removeNamesButton.setBounds(500, 20, 130, 40);
	removeNamesButton.setFocusable(false);
	removeNamesButton.addActionListener(this);
	removeNamesButton.setBackground(Color.black);
	removeNamesButton.setForeground(Color.orange);
	
	addButton = new JButton("Add");
	int buttonWidth = (int)addButton.getPreferredSize().getWidth();
	int buttonHeight = (int)addButton.getPreferredSize().getHeight();
	addButton.setBounds(10, 20, buttonWidth, buttonHeight);
	addButton.setFocusable(false);
	addButton.addActionListener(this);
	addButton.setBackground(Color.black);
	addButton.setForeground(Color.orange);
	
	attendLabel = new JLabel("Attendance here");
	attendLabel.setBounds(280, 50, 500, 50);
	attendLabel.setForeground(Color.magenta);
	attendLabel.setFont(new Font(null, Font.BOLD, 32));
	
	sqToRoundIcon = new ImageIcon("bing_generate.jfif");
	
	try {
		bgIcon = new ImageIcon("Metal textures.jpg");
    	Image image = bgIcon.getImage().getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
    	bgIcon = new ImageIcon(image);
    	bgImageLabel.setIcon(bgIcon);
    	bgImageLabel.setBounds(0, 0, panelWidth, panelHeight);
    	bgImageLabel.setOpaque(true);    	
	}catch(Exception e) {
		System.out.println(e);
	}
	
	bg = new ButtonGroup[names2.size()];
	rb = new JRadioButton[4 * names2.size()];
	nameLabel = new JLabel[increase];
	updateLabel = new JLabel[names2.size()];
	
		for(int i = 0; i < increase; i++) {
		bg[i] = new ButtonGroup();

		int size = attend.length;
		
		for(int j = 0; j < size; j++) {
			int index = i * size + j;
			
			rb[index] = new JRadioButton(attend[j]);
			rb[index].setBounds(width, height, 60, 40);
			rb[index].setForeground(Color.green);
			rb[index].setPreferredSize(new Dimension(60, 40));
			rb[index].setOpaque(false);
			rb[index].setContentAreaFilled(true);
			rb[index].setBorderPainted(false);
			rb[index].addActionListener(this);
			rb[index].setFocusable(false);
			width += 70;
			
			bg[i].add(rb[index]);
			add(rb[index]);
			}
		if(i % 1 == 0) {
			width = 400;
			height += 30;
			}
		}
		
	//Displaying names.
	for(int i = 0; i < increase; i++) {
		nameLabel[i] = new JLabel(names2.get(i));
		nameLabel[i].setBounds(100, 100, nameLabelWidth, nameLabelHeight);
		if(i%1 == 0) {
		nameLabel[i].setForeground(Color.white);
			nameLabelHeight += 60;
		}
		pane.add(nameLabel[i]);
	}
		
	
	addKeyListener(new KeyAdapter() {
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}
	});
	
	setFocusable(true);
	
	// U can also use this to as escape key.
	
	 // Set up KeyBindings to listen for global key events
//    getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "exit");
//    getActionMap().put("exit", new AbstractAction() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.exit(0);
//        }
//    });
	
	addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		handleImageButton(e.getX(), e.getY());
	}
	});
	
	add(attendLabel);
	add(closePanelButton);
	add(pane);
//	add(updateNameLabel);
//	add(removeNameLabel);
	add(presentAllButton);
	add(absentAllButton);
	add(updateNamesButton);
	add(removeNamesButton);
	add(addButton);
	
}	
	
	private void disableLabel(JLabel label) {
		for(MouseListener mouselistener : label.getMouseListeners()) {
			label.removeMouseListener(mouselistener);
		}
		
		label.setBackground(Color.gray);

	}
	
	public void handleImageButton(int x, int y) {
		int imageX = 10;
		int imageY = 20;
		int imageWidth = 50;
		int imageHeight = 50;
		
		if(x >= imageX && x <= imageX + imageWidth && y >= imageY && + y <= imageY + imageHeight) {
			
	    	AddingNames addingNames = new AddingNames(this);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Background image for panel.
		g.drawImage(bgIcon.getImage(), 0, 0, this);
				
//		rounding image background.
//		Graphics2D g2d = (Graphics2D)g;
//		Ellipse2D.Double circle = new Ellipse2D.Double(10, 20, 50, 50);
//		g2d.setClip(circle);
//		g.drawImage(sqToRoundIcon.getImage(), 10, 20, 50, 50, this);
//		g2d.setClip(null);
		
	}
	
	private void removeLabels() {
		  // Clear existing labels
		try {
	    for (int i = 0; i < nameLabel.length; i++) {
	        if (nameLabel[i] != null) {
	            pane.remove(nameLabel[i]); // Remove the existing label.
	        }
	    }
	    repaint();
	    revalidate();
	}catch(Exception e) {
		System.out.println("error in removeLabels() method");
		System.out.println(e);
	}
	}
	
	private void updateNameLabels() {		
		// Create and add new labels for all names in names2
		try {
	    for (int i = 0; i < increase; i++) {
	    	nameLabel[i] = new JLabel(names2.get(i));
	    	nameLabel[i].setBounds(100, nameLabelHeight, nameLabelWidth, nameLabelHeight + 170);
	    	if (i % 1 == 0) {
	        	nameLabel[i].setForeground(Color.red);
	            nameLabelHeight += 20;
	        }
	        pane.add(nameLabel[i]);
	    }
	    repaint();
	    revalidate();
	}catch(Exception e) {
		System.out.println("error in updateNameLabels() method");
		System.out.println(e);
	}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    
	    for(int i = 0; i < data2.length; i++) {
	    	if(rb[i * 4].isSelected()) {
	    		data2[i][2] = "Present";
	    	}else if(rb[i * 4 + 1].isSelected()) {
	    		data2[i][2] = "Absent";
	    	}else if(rb[i * 4 + 2].isSelected()) {
	    		data2[i][2] = "N/A 1";
	    	}else if(rb[i * 4 + 3].isSelected()){
	    		data2[i][2] = "N/A 2";
	    	}
	    	else {
	    		data2[i][2] = "N/A";
	    	}
	    }
	    
	    if(e.getSource() == submitButton) {
			ExperimentsFrameTable frameTable = new ExperimentsFrameTable(data2);
	        }
	    
		//Close dPanel
	    else if(e.getSource() == closePanelButton) {
			System.exit(0);
		}
		
	    else if(e.getSource() == presentAllButton){
			for(int i = 0; i < data2.length; i++) {
				rb[i * 4].setSelected(true);
			}
		}

		else if(e.getSource() == absentAllButton){
			for(int i = 0; i < data2.length; i++) {
				rb[i * 4 + 1].setSelected(true);
			}
		}
		
		
		else if(e.getSource() == updateNamesButton) {
			nameLabelHeight = 20; // Reset nameLabelHeight
			updateNameLabels();
			updateNamesButton.setEnabled(false);
			repaint();
			revalidate();
		}

		else if(e.getSource() == removeNamesButton) {
			removeLabels();
			updateNamesButton.setEnabled(true);
		    revalidate();
		}
		else if(e.getSource() == addButton) {
	    	AddingNames addingNames = new AddingNames(this);
		}
		
		repaint();
	    revalidate();
	}

public static void main(String[]args) {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 800);
	frame.setLocationRelativeTo(null);
	JLabel testLabel = new JLabel("Am i visible out of panel!");
	
	AttendHereExperiments panel = new AttendHereExperiments();
	panel.setComponentZOrder(submitButton, 0);
	panel.setComponentZOrder(pane, 0);
	
	   frame.setLayout(new BorderLayout());
	    
	  JScrollPane scrollPane = new JScrollPane(panel);
	  
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    
	    verticalScrollBar = scrollPane.getVerticalScrollBar();
	    verticalScrollBar.setUnitIncrement(16);

	    // Add the JScrollPane to the frame.
	    frame.add(testLabel, BorderLayout.NORTH);
	    frame.add(scrollPane);
	    frame.setVisible(true);
}
}
