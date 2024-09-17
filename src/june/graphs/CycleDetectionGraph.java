package june.graphs;

import java.util.ArrayList;

public class CycleDetectionGraph {
	static class Edge{
		int src;
		int dest;
		public Edge(int s,int d) {
			this.dest=d;
			this.src=s;
		}
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i] =new ArrayList<CycleDetectionGraph.Edge>();
		}
		
		graph[0].add(new Edge(0, 2));
		graph[1].add(new Edge(1, 0));
		graph[2].add(new Edge(2, 3));
		graph[3].add(new Edge(3, 0));
		
	}
	// TC O(V+E)
	public static boolean isCycleDirected(ArrayList<Edge> graph[],boolean vis[],int curr,boolean rec[]) {
		vis[curr]=true;
		rec[curr]=true;
		
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e=graph[curr].get(i);
			if(rec[e.dest]) {//cycle
				return true;
			}else if(!vis[e.dest]) {
				if(isCycleDirected(graph, vis, e.dest, rec)) {
					return true;
				}
			}
		}
		rec[curr]=false;
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int V=4;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		//System.out.println(isCycleDirected(graph, new boolean[V], 0, new boolean[V]));
		
		boolean vis[] = new boolean[V];
		boolean rec[] = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			if(!vis[i]) {
				boolean isCycle= isCycleDirected(graph, vis, 0, rec);
				if(isCycle) {
					System.out.println(isCycle);
					break;
				}
			}
		}
	}

}
