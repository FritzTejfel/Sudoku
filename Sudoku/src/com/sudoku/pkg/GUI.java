package com.sudoku.pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField[][] Fields = new JTextField[9][9];
	private static Font font = new Font("Courier", Font.BOLD,16);
	private static Font empty = new Font("Courier", Font.BOLD,18);
	
	public GUI() {
		
		Core core = new Core();
		
		JPanel Panel = new JPanel();
		this.add(Panel);
		Panel.setLayout(new GridLayout(9,9));
		Panel.setBackground(Color.WHITE);
		Panel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		
		for( int i = 0; i< 9; i++){
			
			for(int j = 0; j < 9; j++) {
				
				Fields[i][j] = new JTextField();	
			    Fields[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			    Panel.add(Fields[i][j]);
			    
			    if(core.GameTable[i][j] == 0) {
			    	
			    	Fields[i][j].setText(Fields[i][j].getText());
			    	Fields[i][j].setForeground(Color.RED);
			    	Fields[i][j].setFont(empty);
			    	
			    } /* END if*/ else {
			    			    	 
			    	Fields[i][j].setText(Fields[i][j].getText() + core.GameTable[i][j]);
			    	Fields[i][j].setFont(font);
			    } // END else if
			    
			  
			    Fields[i][j].setHorizontalAlignment(JTextField.CENTER);
			    
			    			
			}// END for(j)
			System.out.println();
		} // END for(i)
		
		
	} // END GUI Constructor 
	
} // END GUI class extends JFrame
