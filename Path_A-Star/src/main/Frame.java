package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	Node[][] nodeList;

	public Frame(int width, int hight) {
		Container pane = getContentPane();
		
		pane.setLayout(new BorderLayout());
		pane.add(getNodes(width, hight), BorderLayout.CENTER);
		pane.add(getButtons(), BorderLayout.EAST);
		

		this.setTitle("test");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	
	protected JComponent getNodes(int width, int hight){
		JPanel inner = new JPanel();
		inner.setLayout(new GridLayout(hight, width));
		nodeList = new Node[width][hight];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < hight; j++) {
				Node n = new Node(i, j, 15);
				nodeList[i][j] = n;
				inner.add(n);
			}
		}
		return inner;
	}
	
	protected JComponent getButtons(){
		JPanel inner = new JPanel();
		inner.setLayout(new BoxLayout(inner, BoxLayout.Y_AXIS));
		inner.add(new JButton("Clear Grid"));
		inner.add(new JButton("Update Grid"));
		
		return inner;
	}
	
}
