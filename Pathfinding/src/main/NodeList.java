package main;

public class NodeList {
	private static Node[][] nodeList = null;

	public NodeList(int x, int y) {
		nodeList = new Node[x][y];
	}

	public Node[][] getNodeList() {
		return nodeList;
	}

	public Node getNode(int x, int y) {
		if (nodeList != null)
			return nodeList[x][y];
		else {
			System.out.println("NodeList not initiated");
			return null;
		}
	}
	
	public void insertNode(Node n, int x, int y){
		if(nodeList != null){
			nodeList[x][y] = n;
		}
	}
	
	
}
