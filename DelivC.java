/*
 * @author Tom Waterman
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DelivC{

	private File inputFile;
	private File outputFile;
	private PrintWriter output;
	private Graph graph;
	private Node startingNode;

	//Constructor - DO NOT MODIFY
	public DelivC(File in, Graph gr) {
		inputFile = in;
		graph = gr;

		// Set up for writing to a file
		try {
			// Use input file name to create output file in the same location
			String inputFileName = inputFile.toString();
			String outputFileName = inputFileName.substring(0, inputFileName.length() - 4).concat("_out.txt");
			outputFile = new File(outputFileName);

			// A Printwriter is an object that can write to a file
			output = new PrintWriter(outputFile);
		} catch (Exception x) {
			System.err.format("Exception: %s%n", x);
			System.exit(0);
		}
		
		// Calls the method that will do the work of deliverable C
		runDelivC();

		output.flush();
	}

	//*********************************************************************************
	//               This is where your work starts
	
	private void runDelivC() {
		MSTPrims(graph);
	}
	
	/*
	 * Uses Prim's algorithm on a graph to produce a minimum spanning tree.
	 * Prints to both console and file the edges in the MST and the total 
	 * weight of the graph.
	 */
	public void MSTPrims(Graph graph) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>(1, new NodeKeyComparer());
		for (Node n : graph.getNodeList()) {
			n.setKey(1.0/0.0);                    
			n.setPredecessor(null);
		}
		
		Node root = findStartingNode(graph.getNodeList());
		root.setKey(0);
		
		for (Node n : graph.getNodeList()) {
			queue.add(n);
		}
		
		while (!queue.isEmpty()) {
			Node u = queue.poll();  
			for (Edge e : graph.getEdgeList()) {
				if (e.getHead().equals(u) && e.getTail().equals(u.getPredecessor()) && u.getPredecessor() != null){
					e.setIsMSTEdge(true);
					graph.setWeight(e.getDistance() + graph.getWeight());
				}
			}
			
			for (Edge e : u.getOutgoingEdges()) {  
				Node v = e.getHead();
				if (queue.contains(v) && e.getDistance() < v.getKey()){ 
					queue.remove(v);
					v.setPredecessor(u);
					v.setKey(e.getDistance());
					queue.add(v);
				}
			}
		}
		printResults();
	}
	
	/*
	 * Prints results in desired format to console and file
	 */
	public void printResults() {
		System.out.println("The minimum spanning tree has a total cost of " + graph.getWeight() +
							" and includes the following edges:");
		output.println("The minimum spanning tree has a total cost of " + graph.getWeight() + 
							" and includes the following edges:");
		for (Edge e : graph.getEdgeList()) {
			if (e.getIsMSTEdge() == true) {
				System.out.println(e.getHead().getAbbrev() + "-" + e.getTail().getAbbrev());
				output.println(e.getHead().getAbbrev() + "-" + e.getTail().getAbbrev());
			}
		}
	}
	
	/*
	 * Finds the starting node of a graph
	 */
	public Node findStartingNode(ArrayList<Node> nodeList) {  
		for (Node node : nodeList) {
			if (node.getValue().equalsIgnoreCase("S")){
				startingNode = node;
			}
		}
		return startingNode;
	}
	
	/*
	 * Compares nodes by key, then alphabetically by name if keys are the same
	 */
	private class NodeKeyComparer implements Comparator<Node>{

		@Override
		public int compare(Node node1, Node node2) {
			int result = (int) (node1.getKey() - node2.getKey()); 
			if (result == 0) { 
				return node1.getName().compareToIgnoreCase(node2.getName()); 
			}
			return result;
		} 
	}
}

