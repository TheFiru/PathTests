package main;

import java.util.concurrent.Callable;

public interface PathAlgorythm extends Callable<Node[]>{
	
	public Node[] getPath(Node[][] grid, Node start, Node destination);

	
}
