package main;

public class NodeList {
	private static Node[][] nodeList;
	
	public NodeList(int width, int height){
		nodeList = new Node[width][height];
	}
	
	public Node[][] getNodeList(){
		return nodeList;
	}
	
	public Node getNode(int x, int y){
		return nodeList[x][y];
	}
	
	public void insertNode(Node n, int x, int y){
		nodeList[x][y] = n;
	}
}
