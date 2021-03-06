package main;

import java.awt.Color;
import java.util.ArrayList;

public class AStar {

	public Node getPath(Node[][] nodeGrid, Node start, Node destination) {
		Node[][] nodeList = nodeGrid;
		ArrayList<Node> openList = new ArrayList<Node>();
		ArrayList<Node> closedList = new ArrayList<Node>();

		start.f = 0;
		openList.add(start);

		while (!openList.isEmpty()) {
			ArrayList<Node> successor = new ArrayList<Node>();
			//System.out.println("While");
			Node q = null;
			for (int i = 0; i < openList.size(); i++) {
				if (q == null)
					q = openList.get(i);
				if (q != null && openList.get(i).f < q.f)
					q = openList.get(i);
			}

			for (int i = 0; i < openList.size(); i++) {
				if (openList.get(i) == q)
					openList.remove(i);
			}

			if ((q.x - 1) >= 0 && (q.y - 1) >= 0) {
				if (nodeList[q.x - 1][q.y - 1] != q.parent) {
					nodeList[q.x - 1][q.y - 1].parent = q;
					successor.add(nodeList[q.x - 1][q.y - 1]);
				}
			}
			if ((q.y - 1) >= 0 && !(q.isWall)) {
				if (nodeList[q.x][q.y - 1] != q.parent) {
					nodeList[q.x][q.y - 1].parent = q;
					successor.add(nodeList[q.x][q.y - 1]);
				}
			}
			if ((q.x + 1) < nodeList.length && (q.y - 1) >= 0) {
				if (nodeList[q.x + 1][q.y - 1] != q.parent) {
					nodeList[q.x + 1][q.y - 1].parent = q;
					successor.add(nodeList[q.x + 1][q.y - 1]);
				}
			}
			if ((q.x - 1) >= 0 && !(q.isWall)) {
				if (nodeList[q.x - 1][q.y] != q.parent) {
					nodeList[q.x - 1][q.y].parent = q;
					successor.add(nodeList[q.x - 1][q.y]);
				}
			}
			if ((q.x + 1) < nodeList.length) {
				if (nodeList[q.x + 1][q.y] != q.parent) {
					nodeList[q.x + 1][q.y].parent = q;
					successor.add(nodeList[q.x + 1][q.y]);
				}
			}
			if ((q.x - 1) >= 0 && (q.y + 1) < nodeList[0].length) {
				if (nodeList[q.x - 1][q.y + 1] != q.parent) {
					nodeList[q.x - 1][q.y + 1].parent = q;
					successor.add(nodeList[q.x - 1][q.y + 1]);
				}
			}
			if ((q.y + 1) < nodeList[0].length) {
				if (nodeList[q.x][q.y + 1] != q.parent) {
					nodeList[q.x][q.y + 1].parent = q;
					successor.add(nodeList[q.x][q.y + 1]);
				}
			}
			if ((q.x + 1) < nodeList.length && (q.y + 1) < nodeList[0].length) {
				if (nodeList[q.x + 1][q.y + 1] != q.parent) {
					nodeList[q.x + 1][q.y + 1].parent = q;
					successor.add(nodeList[q.x + 1][q.y + 1]);
				}
			}

			for (Node node : successor) {
				//System.out.println("foreach");
				if (node == destination)
					
					
					return destination;
				
				
				node.g = q.g + node.resistance;
				float dx = Math.abs(destination.x - node.x);
				float dy = Math.abs(destination.y - node.y);
				node.h = (float) Math.sqrt((dx * dx) + (dy * dy));
				node.f = node.g + node.h;

				boolean tmp = false;
				for (int i = 0; i < openList.size(); i++) {
					if (openList.get(i).f < node.f && openList.get(i) == node)
						tmp = true;
				}

				for (int i = 0; i < closedList.size(); i++) {
					if (closedList.get(i).f < node.f && closedList.get(i) == node)
						tmp = true;
				}

				if (!tmp) {
					openList.add(node);
				}
			}
			System.out.println(q.x + " : " + q.y);
			//q.setBackground(Color.RED);
			closedList.add(q);
			/*try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		System.out.println("A-Star ende");
		// TODO: Falls das Ziel nicht erreicht wurded
		return new Node(-1, -1, 1);
	}
}
