package main;

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
			System.out.println("While");
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

			if (nodeList[q.x - 1][q.y - 1] != q.parent) {
				nodeList[q.x - 1][q.y - 1].parent = q;
				successor.add(nodeList[q.x - 1][q.y - 1]);
			}
			if (nodeList[q.x][q.y - 1] != q.parent) {
				nodeList[q.x][q.y - 1].parent = q;
				successor.add(nodeList[q.x][q.y - 1]);
			}
			if (nodeList[q.x + 1][q.y - 1] != q.parent) {
				nodeList[q.x + 1][q.y - 1].parent = q;
				successor.add(nodeList[q.x + 1][q.y - 1]);
			}
			if (nodeList[q.x - 1][q.y] != q.parent) {
				nodeList[q.x - 1][q.y].parent = q;
				successor.add(nodeList[q.x - 1][q.y]);
			}
			if (nodeList[q.x + 1][q.y] != q.parent) {
				nodeList[q.x + 1][q.y].parent = q;
				successor.add(nodeList[q.x + 1][q.y]);
			}
			if (nodeList[q.x - 1][q.y + 1] != q.parent) {
				nodeList[q.x - 1][q.y + 1].parent = q;
				successor.add(nodeList[q.x - 1][q.y + 1]);
			}
			if (nodeList[q.x][q.y + 1] != q.parent) {
				nodeList[q.x][q.y + 1].parent = q;
				successor.add(nodeList[q.x][q.y + 1]);
			}
			if (nodeList[q.x + 1][q.y + 1] != q.parent) {
				nodeList[q.x + 1][q.y + 1].parent = q;
				successor.add(nodeList[q.x + 1][q.y + 1]);
			}

			for (Node node : successor) {
				System.out.println("foreach");
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

			closedList.add(q);
		}
		// TODO: Falls das Ziel nicht erreicht wurde
		return new Node(-1,-1, 1);
	}
}
