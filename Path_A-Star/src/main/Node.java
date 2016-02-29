package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Node extends JPanel {

	public Node parent = null;
	public int x, y;
	public float g, h, f;
	public int resistance = 1;
	public boolean isWall = false;
	
	public void printCoor(){
		System.out.println(x + " : " + y);
		if(parent != null) parent.printCoor();
	}
	
	public void drawPath(){
		setBackground(Color.RED);
		if(parent != null) parent.drawPath();
	}

	public Node(int x, int y, int size) {
		this.setPreferredSize(new Dimension(size, size));
		this.x = x;
		this.y = y;
		this.setBorder(new LineBorder(Color.BLACK));
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(Color.GRAY);
				resistance = 99;
				System.out.println(x + " ; " + y);
				isWall = true;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	
}
