        // Convert the ArrayList to a 2D ArrayList
//        List<List<Object>> data = new ArrayList<>();
//        for (String name : presentNames) {
//            List<Object> row = new ArrayList<>();
//            row.add(name);
//            row.add(""); // Add an empty string for the second column
//            data.add(row);
//        }
//
//        // Create a DefaultTableModel with the column names and data
//        DefaultTableModel model = new DefaultTableModel(
//                data.stream().map(row -> row.toArray()).toArray(Object[][]::new),				
//                columnNames
//        );
//
//        // Create the JTable with the model
//        table = new JTable(model);


//        nameColumn.setHeaderValue("Full Name"); // Set custom header text
//        nameColumn.setHeaderRenderer(new MyHeaderRenderer()); // Use a custom header renderer
//        customColumnModel.addColumn(nameColumn);
//        
//        // Add the rest of the columns
//        for (int i = 1; i < columnNames1.length; i++) {
//            TableColumn column = new TableColumn(i);
//            column.setHeaderValue(columnNames1[i]); // Use default header text
//            customColumnModel.addColumn(column);
//        }
//
//        table.setColumnModel(customColumnModel);

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class ExperimentsFrameTable extends JFrame implements ActionListener{

    JTable table1, table2, table3;
    AttendHereExperiments attendHere;
    JScrollPane scrollPane1, scrollPane2, scrollPane3;
    JPanel panel;
    JButton saveButton, signButtton;
    JTextField textField1;
    String text;
    
    ImageIcon imageIcon;
    JLabel imageLabel;
    
//    public ExperimentsFrameTable(ArrayList<String> presentNames, ArrayList<String> age, ArrayList<String> absentNames, ArrayList<String>absentAges, ArrayList<String>naNames, Object[][] names) {
	public ExperimentsFrameTable(Object[][] names) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        panel = new JPanel(new BorderLayout());
        
        textField1 = new JTextField(10);
        
        saveButton = new JButton("Save");
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        
        signButtton = new JButton("Sign submit");
        signButtton.setFocusable(false);
        signButtton.addActionListener(this);
        
        String[] columnNames1 = {"Names", "Age", "Status"};
  
        
        table1 = new JTable(names, columnNames1);
        table1.setFont(new Font(null, Font.BOLD, 16));
        table1.setRowHeight(40);
        table1.setForeground(Color.red);
        table1.setGridColor(Color.black);
        table1.setShowGrid(true);
        
//        DefaultTableColumnModel customColumnModel = new DefaultTableColumnModel();
        
        TableColumn nameColumn = new TableColumn(0);
        
        DefaultTableCellRenderer customRenderer = new DefaultTableCellRenderer() {
        	@Override
        	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hadFocus, int row, int column) {
				
        		Component component = super.getTableCellRendererComponent(table, value, isSelected, hadFocus, row, column);
        		
        		
        		if(column == 0 || column == 2 ||column == 1) {
        			component.setBackground(Color.green);
        		}else {
                    // Use the default background color for other columns
                    component.setBackground(table.getBackground());
                }
        		return component;
        	}
        };
     
        table1.getColumnModel().getColumn(0).setCellRenderer(customRenderer);
        table1.getColumnModel().getColumn(2).setCellRenderer(customRenderer);
        table1.getColumnModel().getColumn(1).setCellRenderer(customRenderer);
        
        scrollPane1 = new JScrollPane(table1);

        panel.add(scrollPane1, BorderLayout.CENTER);
        
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.add(textField1);
        textFieldPanel.add(saveButton);
        panel.add(textFieldPanel, BorderLayout.SOUTH);
        
//        add(textFieldPanel);
        add(panel);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource() == saveButton) {
    		
//    		JTable tabelToSave = new JTable(table1.getModel());
    		text = textField1.getText();
    		if(text.isEmpty()) {
    			JOptionPane.showMessageDialog(panel, "Signature is needed!");
    		}else {    			
    			//Choose a file.
    			
    			JFileChooser fileChooser = new JFileChooser();
    			int option  = fileChooser.showSaveDialog(this);
    			
    			if(option == JFileChooser.APPROVE_OPTION) {
    				File file = fileChooser.getSelectedFile();
    				String fileName  = file.getAbsolutePath();
    				saveTable(table1, fileName);
    			}
    		}
    	}
    } 
     
    private void saveTable(JTable table1, String fileName) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
    		int rowCount = table1.getRowCount();
    		int columnCount = table1.getColumnCount();

    		//Write column headers.
    		for(int i = 0; i < columnCount; i++) {
    			String columnNames = table1.getColumnName(i);
    			writer.write(columnNames != null ? columnNames : "");
    			writer.write(table1.getColumnName(i));
    			if(i < columnCount - 1) {
    				writer.write(",");
    			}
    		}
    		writer.newLine();
    		
    		//Write table data.
    		for(int row = 0; row < rowCount; row++) {
    			for(int column = 0; column < columnCount; column++) {
    			Object cellValue = table1.getValueAt(row, column);
    			writer.write(cellValue != null ? cellValue.toString() : "");
//    				writer.write(table.getValueAt(row, column).toString());
    				if(column < columnCount - 1) {
    					writer.write(",");
    				}
    			}
    			writer.newLine();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
		}
	}
    }