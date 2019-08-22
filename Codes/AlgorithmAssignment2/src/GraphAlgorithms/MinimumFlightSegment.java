/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Kelly
 */
public class MinimumFlightSegment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfNodes = scanner.nextInt();
        int numOfEdges = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[numOfNodes];// array list of adgacents
        for (int i = 0; i < numOfNodes; i++) {
            adj[i] = new ArrayList<>();//arry list for each adjacent of node i
        }
        for (int i = 0; i < numOfEdges; i++) {
            int node1, node2;
            node1 = scanner.nextInt();
            node2 = scanner.nextInt();
            adj[node1 - 1].add(node2 - 1);
            adj[node2 - 1].add(node1 - 1);
        }
        int startingNode = scanner.nextInt() - 1;// accept the starting node from the user
        int destinaitonNode = scanner.nextInt() - 1;// accept the destinaiton node from user 
        System.out.println(distance(adj, startingNode, destinaitonNode));// compute the minimu distance and display it
    }
    
    private static int distance(ArrayList<Integer>[] adj, int start, int termination) {
		//write your code here
		if (start == termination) {
			return 0;//if the termiantion(destinaton) is the same as the starting node return 0
		}
		int[] dist = new int[adj.length];
		for(int i=0; i<dist.length;i++){
			dist[i]=Integer.MAX_VALUE;// initilize the distance to all all the nodes with nodes with maximum number
		}

		dist[start] = 0;// the distance to the starting point is 0
		
		// Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

		// Enqueue the current node
        queue.add(start);
		
		while (!queue.isEmpty()) {
			// Dequeue a vertex from queue
			int u = queue.poll();
			// Get all adjacent vertices of the dequeued vertex u
            // If a adjacent has not been discovered, then enqueue it
			for (int v: adj[u]) {
				if (dist[v] == Integer.MAX_VALUE) {
					queue.add(v);// que the node the v 
                    dist[v] = dist[u] + 1;
                        if(v==termination){
                            break;// if riched the destinaiton stop traversing
                            
                        }
				}
			}
		}
		// ifthe distance to the destination is not MAX_VALUE then return the distance 
		if(dist[termination] != Integer.MAX_VALUE) {
			return dist[termination];
		}	
        return -1;// other wise return -1 marking that it is unreachable
    }
}
