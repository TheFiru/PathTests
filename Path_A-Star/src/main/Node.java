package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Node extends JPanel {

	public int x, y;
	public float g, h, f;

	public Node(int x, int y, int size) {
		this.setPreferredSize(new Dimension(size, size));
		this.x = x;
		this.y = y;
		this.setBorder(new LineBorder(Color.BLACK));

	}

	
}
