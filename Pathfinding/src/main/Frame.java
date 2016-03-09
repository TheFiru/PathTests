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

public class Frame implements ActionListener {
	private JFrame frame;
	private NodeList nodeList;

	JButton b1 = new JButton("Draw Path");
	JButton b2 = new JButton("Clear");
	JButton b3 = new JButton("Test");

	public Frame() {
		frame = new JFrame("Pathfinding");
		Container pane = frame.getContentPane();
		pane.setLayout(new BorderLayout());

		pane.add(getGrid(20, 20), BorderLayout.CENTER);
		pane.add(getButtons(), BorderLayout.EAST);

		frame.pack();
		frame.setVisible(true);

	}

	private JComponent getButtons() {
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		panel.add(b1);
		panel.add(b2);
		panel.add(b3);

		return panel;
	}

	private JComponent getGrid(int x, int y) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(x, y));
		nodeList = new NodeList(x, y);
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				Node node = new Node();
				node.x = i;
				node.y = j;

				node.setSize(15);

				nodeList.insertNode(node, i, j);
				panel.add(node.getPanel());
			}
		}

		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.b1) {
			// Do Stuff
			AStar a = new AStar(nodeList, nodeList.getNode(1, 1), nodeList.getNode(10, 10));
			a.run();
			

		} else if (e.getSource() == this.b2) {
			// Do Stuff
			for (int i = 0; i < nodeList.getNodeList().length; i++) {
				for (int j = 0; j < nodeList.getNodeList().length; j++) {
					nodeList.getNode(i, j).resetNode();
				}
			}
		} else if (e.getSource() == this.b3) {
			printNeighbors(0, 0);
		}
	}

	// http://stackoverflow.com/questions/652106/finding-neighbours-in-a-two-dimensional-array
	public void printNeighbors(int x, int y) {
		int rowLimit = nodeList.getNodeList().length;
		int columnLimit = nodeList.getNodeList()[0].length;

		for (int i = Math.max(0, x - 1); i <= Math.min(x + 1, rowLimit); i++) {
			for (int j = Math.max(0, y - 1); j <= Math.min(y + 1, columnLimit); j++) {
				if (i != x || j != y) {
					System.out.println(nodeList.getNode(i, j).x + " : " + nodeList.getNode(i, j).y);
				}
			}
		}
	}

}
