//import java.util.*;

// Edge between two nodes
public class Edge {

	private int distance;
	private Node tail;
	private Node head;
	// implement an edge type (tree / forward , back, cross)
	private String edgeType;
	private boolean isMSTEdge;

	public Edge(Node tailNode, Node headNode, int dist) {
		tail = tailNode;
		head = headNode;
		distance = dist;
	}

	public Node getTail() {
		return tail;
	}

	public Node getHead() {
		return head;
	}

	public int getDistance() {
		return distance;
	}

	public void setTail(Node newTail) {
		tail = newTail;
	}

	public void setHead(Node newHead) {
		head = newHead;
	}

	public void setDistance(int dist) {
		distance = dist;
	}

	public String getEdgeType() {
		return edgeType;
	}

	public void setEdgeType(String edgeType) {
		this.edgeType = edgeType;
	}
	
	public void setIsMSTEdge(boolean b) {
		isMSTEdge = b;
	}
	
	public boolean getIsMSTEdge() {
		return isMSTEdge;
	}
}
