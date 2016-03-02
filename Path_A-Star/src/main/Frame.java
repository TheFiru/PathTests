package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements ActionListener {

	NodeList nodeList;
	Node n;
	AStar astar = new AStar();
	
	JButton b1 = new JButton("Draw Path");
	JButton b2 = new JButton("Clear");

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
		nodeList = new NodeList(width, hight);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < hight; j++) {
				Node n = new Node(i, j, 15);
				n.x = i;
				n.y = j;
				nodeList.insertNode(n, i, j);
				inner.add(n);
			}
		}
		return inner;
	}
	
	protected JComponent getButtons(){
		JPanel inner = new JPanel();
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		inner.setLayout(new BoxLayout(inner, BoxLayout.Y_AXIS));
		inner.add(b1);
		inner.add(b2);
		
		return inner;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.b1){
			n = astar.getPath(nodeList.getNodeList(), nodeList.getNode(10, 1), nodeList.getNode(10, 18));
			//n.printCoor();
			//n.drawPath();
		}
	}
	
	
	
}
