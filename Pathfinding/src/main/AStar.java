package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class AStar{

	private NodeList grid;
	private Node startNode, destination;
	private ArrayList<Node> openList, closedList, successor;
	
	
	public AStar(NodeList nodeList, Node start, Node destination){
		grid = nodeList;
		startNode = start;
		this.destination = destination;
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		
		openList = new ArrayList<Node>();
		closedList = new ArrayList<Node>();
		
		startNode.f = 0;
		openList.add(startNode);
		
		int count = 0;
		
		while(!openList.isEmpty()){
			successor = new ArrayList<Node>();
			Node q = null;
			
			System.out.println("Durchlauf: " + count);
			count++;
			for (int i = 0; i < openList.size(); i++) {
				if (q == null)
					q = openList.get(i);
				if (q != null && openList.get(i).f < q.f)
					q = openList.get(i);
				//System.out.println(openList.get(i).x + " : " + openList.get(i).y);
			}

			for (int i = 0; i < openList.size(); i++) {
				//System.out.println(openList.get(i).x + " : " + openList.get(i).y);
				if (openList.get(i).x == q.x && openList.get(i).y == q.y){
					//System.out.println("Removed: " + openList.get(i).x + " : " + openList.get(i).y);
					openList.remove(i);
				}
			}
			
			/*for (int i = 0; i < openList.size(); i++) {
				System.out.println(openList.get(i).x + " : " + openList.get(i).y);
			}*/
			//System.out.println("Currently investigating: " + q.x + " : " + q.y);
			
			getNeighbors(q.x, q.y);
			
			for (Node node : successor) {
				
				if(node == destination) {
					destination.setColor(Color.GREEN);
					return;
				}
				//System.out.println("Successor: " + node.x + " : " + node.y );
				node.g = q.g + 1;
				float dx = Math.abs(destination.x - node.x);
				float dy = Math.abs(destination.y - node.y);
				node.h = (float) Math.sqrt((dx * dx) + (dy * dy));
				
				node.f = node.g + node.h;
				
				boolean tmp = false;
				for (int i = 0; i < openList.size(); i++) {
					if (openList.get(i).x == node.x && openList.get(i).y == node.y && openList.get(i).f < node.f)
						tmp = true;
					//System.out.println(i);
				}

				for (int i = 0; i < closedList.size(); i++) {
					if (closedList.get(i).f < node.f && closedList.get(i) == node)
						tmp = true;
				}

				if (!tmp) {
					openList.add(node);
				}
			}
			q.setColor(Color.RED);
			closedList.add(q);
			
		}
		
		System.out.println("A-Star ende");
		
	}
	
	//http://stackoverflow.com/questions/652106/finding-neighbours-in-a-two-dimensional-array
	public void getNeighbors(int x, int y){
		int rowLimit = grid.getNodeList().length;
		int columnLimit = grid.getNodeList()[0].length;
		
		for (int i = Math.max(0, x-1); i <= Math.min(x+1, rowLimit); i++) {
			for (int j = Math.max(0, y-1); j <= Math.min(y+1, columnLimit); j++) {
				if((i != x || j != y) && !grid.getNode(i, j).isWall && grid.getNode(i, j) != grid.getNode(x, y).parent){
					//System.out.println(grid.getNode(i, j).x + " : " + grid.getNode(i, j).y);
					grid.getNode(i ,j).setParent(grid.getNode(x, y));
					successor.add(grid.getNode(i, j));
				}
			}
		}
	}
	
}
