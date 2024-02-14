import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AttendHere extends JPanel implements ActionListener{

	JButton submitButton, backButton;
	JRadioButton rb1, rb2, rb3, rb4;
	JRadioButton rb5, rb6, rb7, rb8;
	JRadioButton rb9, rb10, rb11, rb12;
	JRadioButton rb13, rb14, rb15, rb16;
	JRadioButton rb17, rb18, rb19, rb20;
	JRadioButton rb21, rb22, rb23, rb24;
	JRadioButton rb25, rb26, rb27, rb28;
	JRadioButton rb29, rb30, rb31, rb32;
	JRadioButton rb33, rb34, rb35, rb36;
	JRadioButton rb37, rb38, rb39, rb40;
	JRadioButton rb41, rb42, rb43, rb44;
	JRadioButton rb45, rb46, rb47, rb48;
	Font labelFont;
	JLabel presentLabel, absentLabel, NALabel;
	ButtonGroup bg1, bg2, bg3, bg4, bg5, bg6, bg7, bg8, bg9, bg10, bg11, bg12;
	ImageIcon icon;
	int count = 0;
	int rbHeight = 50;
	int present = 0;
	int absent = 0;
	int NA = 0;
	String[] names = {
		"Abks", "Verma", "John", "Mary",  "David", "Sarah", "Michael", "Jennifer", "Robert", "Laura", "William", "Emily"
	};
	String[] sNo = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

	
	int nameLabelHeight = 50;
	int sNoHeight = 50;
	JLabel[] nameLabels, sNoLabel;
	
	boolean rb1Selected = false;
	boolean rb2Selected = false;
	boolean rb3Selected = false;
	boolean rb4Selected = false;
	boolean rb5Selected = false;
	boolean rb6Selected = false;
	boolean rb7Selected = false;
	boolean rb8Selected = false;
	boolean rb9Selected = false;
	boolean rb10Selected = false;
	boolean rb11Selected = false;
	boolean rb12Selected = false;
	boolean rb13Selected = false;
	boolean rb14Selected = false;
	boolean rb15Selected = false;
	boolean rb16Selected = false;
	boolean rb17Selected = false;
	boolean rb18Selected = false;
	boolean rb19Selected = false;
	boolean rb20Selected = false;
	boolean rb21Selected = false;
	boolean rb22Selected = false;
	boolean rb23Selected = false;
	boolean rb24Selected = false;
	boolean rb25Selected = false;
	boolean rb26Selected = false;
	boolean rb27Selected = false;
	boolean rb28Selected = false;
	boolean rb29Selected = false;
	boolean rb30Selected = false;
	boolean rb31Selected = false;
	boolean rb32Selected = false;
	boolean rb33Selected = false;
	boolean rb34Selected = false;
	boolean rb35Selected = false;
	boolean rb36Selected = false;
	boolean rb37Selected = false;
	boolean rb38Selected = false;
	boolean rb39Selected = false;
	boolean rb40Selected = false;
	boolean rb41Selected = false;
	boolean rb42Selected = false;
	boolean rb43Selected = false;
	boolean rb44Selected = false;
	boolean rb45Selected = false;
	boolean rb46Selected = false;
	boolean rb47Selected = false;
	boolean rb48Selected = false;
	
	public AttendHere() {
		setLayout(null);
		setBackground(Color.black);
				
		labelFont = new Font(null, Font.BOLD, 20);
		nameLabels = new JLabel[names.length];
		sNoLabel = new JLabel[sNo.length];

		for(int i = 0; i <names.length; i++) {
			nameLabels[i] = new JLabel(names[i]);
			nameLabels[i].setForeground(Color.green);
			nameLabels[i].setBounds(100, nameLabelHeight, 100, 20);
			add(nameLabels[i]);
//			nameLabels[i].setVisible(false);
			nameLabelHeight += 30;
		}
		
		for(int i = 0; i <sNo.length; i++) {
			sNoLabel[i] = new JLabel(sNo[i]);
			sNoLabel[i].setForeground(Color.green);
			sNoLabel[i].setBounds(50, sNoHeight, 100, 20);
			add(sNoLabel[i]);
//			nameLabels[i].setVisible(false);
			sNoHeight += 30;
		}
		
		presentLabel = new JLabel("Total student: " + count);
		presentLabel.setBounds(100, 100, 400, 20);
		presentLabel.setVisible(false);
		presentLabel.setForeground(Color.green);
//		presentLabel.setOpaque(true);
//		presentLabel.setBackground(Color.orange);
		presentLabel.setFont(labelFont);
		
		absentLabel = new JLabel("Total student: " + count);
		absentLabel.setBounds(100, 150, 400, 20);
		absentLabel.setVisible(false);
		absentLabel.setForeground(Color.green);
		absentLabel.setBackground(Color.WHITE);
		absentLabel.setFont(labelFont);
		
		NALabel = new JLabel("Total student: " + count);
		NALabel.setBounds(100, 200, 400, 20);
		NALabel.setVisible(false);
		NALabel.setForeground(Color.green);
		NALabel.setFont(labelFont);
		
		submitButton = new JButton("Submit");
		submitButton.setFocusable(false);
		submitButton.setBounds(300, 600, 80, 40);
		submitButton.addActionListener(this);
		
		backButton = new JButton("Back", icon);
		backButton.setFocusable(false);
		backButton.setBounds(0, 0, 80, 40);
		backButton.addActionListener(this);
		backButton.setVisible(false);
		
		icon = new ImageIcon("backButton.png");
		int width = 100;
		int height = 50;
		
		icon.setImage(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		
		backButton.setIcon(icon);
		
		bg1 = new ButtonGroup();
		bg2 = new ButtonGroup();
		bg3 = new ButtonGroup();
		bg4 = new ButtonGroup();
		bg5 = new ButtonGroup();
		bg6 = new ButtonGroup();
		bg7 = new ButtonGroup();
		bg8 = new ButtonGroup();
		bg9 = new ButtonGroup();
		bg10 = new ButtonGroup();
		bg11 = new ButtonGroup();
		bg12 = new ButtonGroup();
		
		rb1 = new JRadioButton("P");
		rb1.setBounds(300, rbHeight, 40, 30);
		rb1.setBackground(Color.black);
		rb1.setForeground(Color.yellow);
		rb1.setFocusable(false);
		rb1.addActionListener(this);
		
		rb2 = new JRadioButton("A");
		rb2.setBackground(Color.black);
		rb2.setForeground(Color.yellow);
		rb2.setFocusable(false);
		rb2.setBounds(350, rbHeight, 40, 30);
		rb2.addActionListener(this);
		
		rb3 = new JRadioButton("N/A");
		rb3.setBackground(Color.black);
		rb3.setForeground(Color.yellow);
		rb3.setFocusable(false);
		rb3.setBounds(400, rbHeight, 50, 30);
		rb3.addActionListener(this);
		
		rb4 = new JRadioButton("N/A");
		rb4.setBackground(Color.black);
		rb4.setForeground(Color.yellow);
		rb4.setFocusable(false);
		rb4.setBounds(450, rbHeight, 50, 30);
		rb4.addActionListener(this);
	
		rb5 = new JRadioButton("P");
		rb5.setBackground(Color.black);
		rb5.setForeground(Color.yellow);
		rb5.setFocusable(false);
		rb5.setBounds(300, rbHeight + 30, 40, 30);
		rb5.addActionListener(this);
		
		rb6 = new JRadioButton("A");
		rb6.setBackground(Color.black);
		rb6.setForeground(Color.yellow);
		rb6.setFocusable(false);
		rb6.setBounds(350, rbHeight + 30, 40, 30);
		rb6.addActionListener(this);
		
		rb7 = new JRadioButton("N/A");
		rb7.setBackground(Color.black);
		rb7.setForeground(Color.yellow);
		rb7.setFocusable(false);
		rb7.setBounds(400, rbHeight + 30, 50, 30);
		rb7.addActionListener(this);
		
		rb8 = new JRadioButton("N/A");
		rb8.setBackground(Color.black);
		rb8.setForeground(Color.yellow);
		rb8.setFocusable(false);
		rb8.setBounds(450, rbHeight + 30, 50, 30);
		rb8.addActionListener(this);

		rb9 = new JRadioButton("P");
		rb9.setBackground(Color.black);
		rb9.setForeground(Color.yellow);
		rb9.setFocusable(false);
		rb9.setBounds(300, rbHeight + 60, 40, 30);
		rb9.addActionListener(this);
		
		rb10 = new JRadioButton("A");
		rb10.setBackground(Color.black);
		rb10.setForeground(Color.yellow);
		rb10.setFocusable(false);
		rb10.setBounds(350, rbHeight + 60, 40, 30);
		rb10.addActionListener(this);
		
		rb11 = new JRadioButton("N/A");
		rb11.setBackground(Color.black);
		rb11.setForeground(Color.yellow);
		rb11.setFocusable(false);
		rb11.setBounds(400, rbHeight + 60, 50, 30);
		rb11.addActionListener(this);
		
		rb12 = new JRadioButton("N/A");
		rb12.setBackground(Color.black);
		rb12.setForeground(Color.yellow);
		rb12.setFocusable(false);
		rb12.setBounds(450, rbHeight + 60, 50, 30);
		rb12.addActionListener(this);
	
		rb13 = new JRadioButton("P");
		rb13.setBackground(Color.black);
		rb13.setForeground(Color.yellow);
		rb13.setFocusable(false);
		rb13.setBounds(300, rbHeight + 90, 40, 30);
		rb13.addActionListener(this);
		
		rb14 = new JRadioButton("A");
		rb14.setBackground(Color.black);
		rb14.setForeground(Color.yellow);
		rb14.setFocusable(false);
		rb14.setBounds(350, rbHeight + 90, 40, 30);
		rb14.addActionListener(this);
		
		rb15 = new JRadioButton("N/A");
		rb15.setBackground(Color.black);
		rb15.setForeground(Color.yellow);
		rb15.setFocusable(false);
		rb15.setBounds(400, rbHeight + 90, 50, 30);
		rb15.addActionListener(this);
		
		rb16 = new JRadioButton("N/A");
		rb16.setBackground(Color.black);
		rb16.setForeground(Color.yellow);
		rb16.setFocusable(false);
		rb16.setBounds(450, rbHeight + 90, 50, 30);
		rb16.addActionListener(this);
		
		rb17 = new JRadioButton("P");
		rb17.setBackground(Color.black);
		rb17.setForeground(Color.yellow);
		rb17.setFocusable(false);
		rb17.setBounds(300, rbHeight + 120, 40, 30);
		rb17.addActionListener(this);
		
		rb18 = new JRadioButton("A");
		rb18.setBackground(Color.black);
		rb18.setForeground(Color.yellow);
		rb18.setFocusable(false);
		rb18.setBounds(350, rbHeight + 120, 40, 30);
		rb18.addActionListener(this);
		
		rb19 = new JRadioButton("N/A");
		rb19.setBackground(Color.black);
		rb19.setForeground(Color.yellow);
		rb19.setFocusable(false);
		rb19.setBounds(400, rbHeight + 120, 50, 30);
		rb19.addActionListener(this);
		
		rb20 = new JRadioButton("N/A");
		rb20.setBackground(Color.black);
		rb20.setForeground(Color.yellow);
		rb20.setFocusable(false);
		rb20.setBounds(450, rbHeight + 120, 50, 30);
		rb20.addActionListener(this);
		
		rb21 = new JRadioButton("P");
		rb21.setBackground(Color.black);
		rb21.setForeground(Color.yellow);
		rb21.setFocusable(false);
		rb21.setBounds(300, rbHeight + 150, 40, 30);
		rb21.addActionListener(this);
		
		rb22 = new JRadioButton("A");
		rb22.setBackground(Color.black);
		rb22.setForeground(Color.yellow);
		rb22.setFocusable(false);
		rb22.setBounds(350, rbHeight + 150, 40, 30);
		rb22.addActionListener(this);
		
		rb23 = new JRadioButton("N/A");
		rb23.setBackground(Color.black);
		rb23.setForeground(Color.yellow);
		rb23.setFocusable(false);
		rb23.setBounds(400, rbHeight + 150, 50, 30);
		rb23.addActionListener(this);
		
		rb24 = new JRadioButton("N/A");
		rb24.setBackground(Color.black);
		rb24.setForeground(Color.yellow);
		rb24.setFocusable(false);
		rb24.setBounds(450, rbHeight + 150, 50, 30);
		rb24.addActionListener(this);
		
		rb25 = new JRadioButton("P");
		rb25.setBackground(Color.black);
		rb25.setForeground(Color.yellow);
		rb25.setFocusable(false);
		rb25.setBounds(300, rbHeight + 180, 40, 30);
		rb25.addActionListener(this);
		
		rb26 = new JRadioButton("A");
		rb26.setBackground(Color.black);
		rb26.setForeground(Color.yellow);
		rb26.setFocusable(false);
		rb26.setBounds(350, rbHeight + 180, 40, 30);
		rb26.addActionListener(this);
		
		rb27 = new JRadioButton("N/A");
		rb27.setBackground(Color.black);
		rb27.setForeground(Color.yellow);
		rb27.setFocusable(false);
		rb27.setBounds(400, rbHeight + 180, 50, 30);
		rb27.addActionListener(this);
		
		rb28 = new JRadioButton("N/A");
		rb28.setBackground(Color.black);
		rb28.setForeground(Color.yellow);
		rb28.setFocusable(false);
		rb28.setBounds(450, rbHeight + 180, 50, 30);
		rb28.addActionListener(this);
		
		rb29 = new JRadioButton("P");
		rb29.setBackground(Color.black);
		rb29.setForeground(Color.yellow);
		rb29.setFocusable(false);
		rb29.setBounds(300, rbHeight + 210, 40, 30);
		rb29.addActionListener(this);
		
		rb30 = new JRadioButton("A");
		rb30.setBackground(Color.black);
		rb30.setForeground(Color.yellow);
		rb30.setFocusable(false);
		rb30.setBounds(350, rbHeight + 210, 40, 30);
		rb30.addActionListener(this);
		
		rb31 = new JRadioButton("N/A");
		rb31.setBackground(Color.black);
		rb31.setForeground(Color.yellow);
		rb31.setFocusable(false);
		rb31.setBounds(400, rbHeight + 210, 50, 30);
		rb31.addActionListener(this);
		
		rb32 = new JRadioButton("N/A");
		rb32.setBackground(Color.black);
		rb32.setForeground(Color.yellow);
		rb32.setFocusable(false);
		rb32.setBounds(450, rbHeight + 210, 50, 30);
		rb32.addActionListener(this);
		
		rb33 = new JRadioButton("P");
		rb33.setBackground(Color.black);
		rb33.setForeground(Color.yellow);
		rb33.setFocusable(false);
		rb33.setBounds(300, rbHeight + 240, 40, 30);
		rb33.addActionListener(this);
		
		rb34 = new JRadioButton("A");
		rb34.setBackground(Color.black);
		rb34.setForeground(Color.yellow);
		rb34.setFocusable(false);
		rb34.setBounds(350, rbHeight + 240, 40, 30);
		rb34.addActionListener(this);
		
		rb35 = new JRadioButton("N/A");
		rb35.setBackground(Color.black);
		rb35.setForeground(Color.yellow);
		rb35.setFocusable(false);
		rb35.setBounds(400, rbHeight + 240, 50, 30);
		rb35.addActionListener(this);
		
		rb36 = new JRadioButton("N/A");
		rb36.setBackground(Color.black);
		rb36.setForeground(Color.yellow);
		rb36.setFocusable(false);
		rb36.setBounds(450, rbHeight + 240, 50, 30);
		rb36.addActionListener(this);
		
		rb37 = new JRadioButton("P");
		rb37.setBackground(Color.black);
		rb37.setForeground(Color.yellow);
		rb37.setFocusable(false);
		rb37.setBounds(300, rbHeight + 270, 40, 30);
		rb37.addActionListener(this);
		
		rb38 = new JRadioButton("A");
		rb38.setBackground(Color.black);
		rb38.setForeground(Color.yellow);
		rb38.setFocusable(false);
		rb38.setBounds(350, rbHeight + 270, 40, 30);
		rb38.addActionListener(this);
		
		rb39 = new JRadioButton("N/A");
		rb39.setBackground(Color.black);
		rb39.setForeground(Color.yellow);
		rb39.setFocusable(false);
		rb39.setBounds(400, rbHeight + 270, 50, 30);
		rb39.addActionListener(this);
		
		rb40 = new JRadioButton("N/A");
		rb40.setBackground(Color.black);
		rb40.setForeground(Color.yellow);
		rb40.setFocusable(false);
		rb40.setBounds(450, rbHeight + 270, 50, 30);
		rb40.addActionListener(this);
		
		rb41 = new JRadioButton("P");
		rb41.setBackground(Color.black);
		rb41.setForeground(Color.yellow);
		rb41.setFocusable(false);
		rb41.setBounds(300, rbHeight + 300, 40, 30);
		rb41.addActionListener(this);
		
		rb42 = new JRadioButton("A");
		rb42.setBackground(Color.black);
		rb42.setForeground(Color.yellow);
		rb42.setFocusable(false);
		rb42.setBounds(350, rbHeight + 300, 40, 30);
		rb42.addActionListener(this);
		
		rb43 = new JRadioButton("N/A");
		rb43.setBackground(Color.black);
		rb43.setForeground(Color.yellow);
		rb43.setFocusable(false);
		rb43.setBounds(400, rbHeight + 300, 50, 30);
		rb43.addActionListener(this);
		
		rb44 = new JRadioButton("N/A");
		rb44.setBackground(Color.black);
		rb44.setForeground(Color.yellow);
		rb44.setFocusable(false);
		rb44.setBounds(450, rbHeight + 300, 50, 30);
		rb44.addActionListener(this);
		
		rb45 = new JRadioButton("P");
		rb45.setBackground(Color.black);
		rb45.setForeground(Color.yellow);
		rb45.setFocusable(false);
		rb45.setBounds(300, rbHeight + 330, 40, 30);
		rb45.addActionListener(this);
		
		rb46 = new JRadioButton("A");
		rb46.setBackground(Color.black);
		rb46.setForeground(Color.yellow);
		rb46.setFocusable(false);
		rb46.setBounds(350, rbHeight + 330, 40, 30);
		rb46.addActionListener(this);
		
		rb47 = new JRadioButton("N/A");
		rb47.setBackground(Color.black);
		rb47.setForeground(Color.yellow);
		rb47.setFocusable(false);
		rb47.setBounds(400, rbHeight + 330, 50, 30);
		rb47.addActionListener(this);
		
		rb48 = new JRadioButton("N/A");
		rb48.setBackground(Color.black);
		rb48.setForeground(Color.yellow);
		rb48.setFocusable(false);
		rb48.setBounds(450, rbHeight + 330, 50, 30);
		rb48.addActionListener(this);
	
		bg1.add(rb1);
		bg1.add(rb2);
		bg1.add(rb3);
		bg1.add(rb4);
		
		bg2.add(rb5);
		bg2.add(rb6);
		bg2.add(rb7);
		bg2.add(rb8);
		
		bg3.add(rb9);
		bg3.add(rb10);
		bg3.add(rb11);
		bg3.add(rb12);
		
		bg4.add(rb13);
		bg4.add(rb14);
		bg4.add(rb15);
		bg4.add(rb16);
		
		bg5.add(rb17);
		bg5.add(rb18);
		bg5.add(rb19);
		bg5.add(rb20);
		
		bg6.add(rb21);
		bg6.add(rb22);
		bg6.add(rb23);
		bg6.add(rb24);
		
		bg7.add(rb25);
		bg7.add(rb26);
		bg7.add(rb27);
		bg7.add(rb28);
		
		bg8.add(rb29);
		bg8.add(rb30);
		bg8.add(rb31);
		bg8.add(rb32);
		
		bg9.add(rb33);
		bg9.add(rb34);
		bg9.add(rb35);
		bg9.add(rb36);
		
		bg10.add(rb37);
		bg10.add(rb38);
		bg10.add(rb39);
		bg10.add(rb40);
		
		bg11.add(rb41);
		bg11.add(rb42);
		bg11.add(rb43);
		bg11.add(rb44);
		
		bg12.add(rb45);
		bg12.add(rb46);
		bg12.add(rb47);
		bg12.add(rb48);
		
		
		 add(rb1);
		 add(rb2);
		 add(rb3);
		 add(rb4);
		 add(rb5);
		 add(rb6);
		 add(rb7);
		 add(rb8);
		 add(rb9);
		 add(rb10);
		 add(rb11);
		 add(rb12);
		 add(rb13);
		 add(rb14);
		 add(rb15);
		 add(rb16);
		 add(rb17);
		 add(rb18);
		 add(rb19);
		 add(rb20);
		 add(rb21);
		 add(rb22);
		 add(rb23);
		 add(rb24);
		 add(rb25);
		 add(rb26);
		 add(rb27);
		 add(rb28);
		 add(rb29);
		 add(rb30);
		 add(rb31);
		 add(rb32);
		 add(rb33);
		 add(rb34);
		 add(rb35);
		 add(rb36);
		 add(rb37);
		 add(rb38);
		 add(rb39);
		 add(rb40);
		 add(rb41);
		 add(rb42);
		 add(rb43);
		 add(rb44);
		 add(rb45);
		 add(rb46);
		 add(rb47);
		 add(rb48);
		 add(submitButton);
		 add(backButton);
		 add(presentLabel);
		 add(absentLabel);
		 add(NALabel);
//		 add(nameLabels);
		 
		setVisible(true);
	}
	
	public void studentCount() {
		submitButton.setVisible(false);
		rb1.setVisible(false);
		rb2.setVisible(false);
		rb3.setVisible(false);
		rb4.setVisible(false);
		rb5.setVisible(false);
		rb6.setVisible(false);
		rb7.setVisible(false);
		rb8.setVisible(false);
		
		for(int i = 0; i <names.length; i++) {
			nameLabels[i] = new JLabel(names[i]);
			nameLabels[i].setBounds(10, nameLabelHeight, 100, 20);
			add(nameLabels[i]);
			nameLabelHeight += 30;
			nameLabels[i].setVisible(false);
		}
		
//		JLabel label = new JLabel("Total student: " + count);
	    presentLabel.setText("Student present: " + present);
	    absentLabel.setText("Student absent : " + absent);
	    NALabel.setText("N/A: " + NA);
	    
		presentLabel.setVisible(true);
		absentLabel.setVisible(true);
		NALabel.setVisible(true);
	}

	public void storedData(int present, int absent, int NA) {
		System.out.println(present);
		System.out.println(absent);
		System.out.println(NA);
	}
	
	public void storeRadioButton(boolean rb1Selected, boolean rb2Selected, boolean rb3Selected, boolean rb4Selected, boolean rb5Selected,boolean rb6Selected, boolean rb7Selected, boolean rb8Selected) {
		if(rb1Selected) {
			rb1.setSelected(true);
		}
		if(rb2Selected) {
			rb2.setSelected(true);
		}
		if(rb3Selected) {
			rb3.setSelected(true);
		}
		if(rb4Selected) {
			rb4.setSelected(true);
		}
		if(rb5Selected) {
			rb5.setSelected(true);
		}
		if(rb6Selected) {
			rb6.setSelected(true);
		}
		if(rb7Selected) {
			rb7.setSelected(true);
		}
		if(rb8Selected) {
			rb8.setSelected(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Layer 1.
		if(e.getSource() == rb1) {
			if(present < 1) {
				rb1Selected = true;
				present++;
			}
		}
		if(e.getSource() == rb2) {
			if(absent < 1) {
			rb2Selected = true;
			absent++;
			}
		}
		if(e.getSource() == rb3) {
			rb3Selected = true;
			if(NA <1) {
			NA++;
			}
		}
		if(e.getSource() == rb4) {
			rb4Selected = true;
			if(NA < 1) {
			NA++;
			}
		}
		
		// Layer 2.
		if(e.getSource() == rb5) {
			if(present < 2) {
				rb5Selected = true;
				present++;
			}
		}
		if(e.getSource() == rb6) {
			if(absent < 2) {
				rb6Selected = true;
				absent++;
			}
		}
		if(e.getSource() == rb7) {
			if(NA < 2) {
				rb7Selected = true;
				NA++;
			}
		}
		if(e.getSource() == rb8) {
			if(NA < 2) {
				rb8Selected = true;
				NA++;
			}	
		}
		if(e.getSource() == rb9) {
			if(NA < 3) {
				rb9Selected = true;
				present++;
			}
		}
			if(e.getSource() == rb10) {
				if(NA < 3) {
					rb10Selected = true;
					absent++;
				}
			}
				if(e.getSource() == rb11) {
					if(NA < 3) {
						rb11Selected = true;
						NA++;
					}
				}
					if(e.getSource() == rb12) {
						if(NA < 3) {
							rb12Selected = true;
							NA++;
						}
					}
		
		if(e.getSource() == submitButton) {
			
			submitButton.setVisible(false);
			backButton.setVisible(true);
			
			System.out.println(present);
			System.out.println(absent);
			System.out.println(NA);
			studentCount();
		}
		
		if(e.getSource() == backButton) { 
			 Container parent = getParent();
		        parent.remove(this); // Remove the current panel

		        // Create a new instance of AttendHere and add it to the parent container
		        AttendHere newPanel = new AttendHere();		    
		        
		        parent.add(newPanel);

		      
		        // Repaint the parent container to reflect the changes
		        parent.revalidate();
		        
		        submitButton.setVisible(true);
//		        newPanel.rb2.setSelected(true);
		        
		        newPanel.storeRadioButton(rb1Selected, rb2Selected, rb3Selected, rb4Selected, rb5Selected, rb6Selected, rb7Selected, rb8Selected);
		        
//		        storedData(present, absent, NA);
		        }
		repaint();
	}
}
