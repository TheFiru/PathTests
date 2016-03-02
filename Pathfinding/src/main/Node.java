package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Node {

	private JPanel panel;
	int x, y;
	
	public Node(){
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK));
	}
	
	public void setSize(int size){
		if(panel != null){
			panel.setPreferredSize(new Dimension(size, size));
		}
		else{
			System.out.println("SetSize: panel == null");
		}
	}
	
	public void setColor(Color color){
		if(panel != null){
			panel.setBackground(color);
		}
		else{
			System.out.println("SetColor: panel == null");
		}
	}
	
	public JComponent getPanel(){
		if(panel != null){
			return panel;
		}
		else{
			System.out.println("GetPanel: panel == null");
			return null;
		}
	}
}
