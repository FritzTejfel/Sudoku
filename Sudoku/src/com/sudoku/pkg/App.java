package com.sudoku.pkg;

import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {

		
		GUI gui = new GUI();
		
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(450,450);
		gui.setVisible(true);

	}

}
