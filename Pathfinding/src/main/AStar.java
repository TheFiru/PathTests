package main;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class AStar implements Runnable {

	private Node[][] grid;
	private Node startNode, destination;
	private ArrayList<Node> openList;
	private ArrayList<Node> closedList;
	
	public AStar(Node[][] nodeList, Node start, Node destination){
		grid = nodeList;
		startNode = start;
		this.destination = destination;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//http://stackoverflow.com/questions/652106/finding-neighbours-in-a-two-dimensional-array
		
		
	}
	
}
