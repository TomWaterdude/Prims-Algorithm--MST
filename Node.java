import java.util.ArrayList;

// A node of a graph for the Spring 2018 ICS 340 program

public class Node {

	private String name;
	private String value; // The value of the Node which was stored in the value column
	private String abbrev; // The abbreviation for the Node
	private ArrayList<Edge> outgoingEdges;
	private ArrayList<Edge> incomingEdges;
	private int discoveryTime;
	private int finishTime;
	private String color;
	private double key;
	private Node predecessor;
	
	public Node(String abbreviation) {
		abbrev = abbreviation;
		value = null;
		name = null;
		outgoingEdges = new ArrayList<Edge>();
		incomingEdges = new ArrayList<Edge>();
	}

	public String getAbbrev() {
		return abbrev;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public ArrayList<Edge> getOutgoingEdges() {
		return outgoingEdges;
	}

	public ArrayList<Edge> getIncomingEdges() {
		return incomingEdges;
	}

	public void setAbbrev(String abbreviation) {
		abbrev = abbreviation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void addOutgoingEdge(Edge e) {
		outgoingEdges.add(e);
	}

	public void addIncomingEdge(Edge e) {
		incomingEdges.add(e);
	}

	public void setDiscoveryTime(int time) {
		this.discoveryTime = time;
	}

	public int getDiscoveryTime() {
		return discoveryTime;
	}

	public void setFinishTime(int time) {
		this.finishTime = time;
	}

	public int getFinishTime() {
		return finishTime;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getKey() {
		return key;
	}
	
	public void setKey(double key) {
		this.key = key;
	}
	
	public Node getPredecessor() {
		return predecessor;
	}
	
	public void setPredecessor(Node predecessor) {
		this.predecessor = predecessor;
	}
}
