import java.util.*;

public class Graph {

	private ArrayList<Node> nodeList;
	private ArrayList<Edge> edgeList;
	private Node startingNode;
	private int weight;
	
	public Graph() {
		nodeList = new ArrayList<Node>();
		edgeList = new ArrayList<Edge>();
	}
	
	public ArrayList<Node> getNodeList() {
		return nodeList;
	}
	
	public ArrayList<Edge> getEdgeList() {
		return edgeList;
	}
	
	public void addNode(Node n) {
		nodeList.add(n);
	}
	
	public void addEdge(Edge e) {
		edgeList.add(e);
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int i) {
		weight = i;
	}

	public Node selectStartingNode(ArrayList<Node> nodeList) {  
		for (Node node : nodeList) {
			if (node.getValue().equalsIgnoreCase("S")){
				startingNode = node;
			}
		}
		return startingNode;
	}
}

