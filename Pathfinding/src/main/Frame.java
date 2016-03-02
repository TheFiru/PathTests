package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Frame {
	private JFrame frame;
	
	public Frame(){
		frame = new JFrame("Pathfinding");
		Container pane = frame.getContentPane();
		pane.setLayout(new BorderLayout());
		
		
		
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private JComponent getButtons(){
		
	}
	
	private JComponent getGrid(){
		
	}
	
}
