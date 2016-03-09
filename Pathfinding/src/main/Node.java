package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Node {

	private JPanel panel = null;
	int x = -1, y = -1;
	float g = 9999, h = 0, f = 0;
	boolean isWall = false;
	Node parent = null;
	
	
	public Node(){
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK));
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e){
				if(e.getModifiers() == MouseEvent.BUTTON1_MASK){
					if(panel != null){
						panel.setBackground(Color.GRAY);
						isWall = true;
					}
					
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e){
				if(panel != null){
					panel.setBackground(Color.GRAY);
					isWall = true;
				}
			}
		});
	}
	
	
	public void printPath(){
		this.setColor(Color.GREEN);
		if(this.parent != null)
		this.parent.printPath();
	}
	
	
	public void resetNode(){
		this.isWall = false;
		if(panel != null){
			panel.setBackground(null);
		}
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
	
	public void setParent(Node n){
		this.parent = n;
	}
}
