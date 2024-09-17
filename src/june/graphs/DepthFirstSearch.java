package june.graphs;

import java.util.ArrayList;

public class DepthFirstSearch {
	static class Edge {
		int src;
		int dest;

		public Edge(int s, int d) {
			this.dest = d;
			this.src = s;
		}
	}

	public static void CreateGraph(ArrayList<Edge> graph[]) {

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));

		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));

		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));

		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));

		graph[6].add(new Edge(6, 5));
	}

	public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
		System.out.print(curr + " ");
		vis[curr] = true;

		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if (vis[e.dest] == false)
				dfs(graph, e.dest, vis);
		}
	}
	// TC O(N^N)
	public static void modifedDFSAllPaths(ArrayList<Edge> graph[],boolean vis[],int curr,String path,int tar){
		
		if(curr==tar) {
			System.out.println(path);
			return;
		}
		
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e= graph[curr].get(i);
			if(!vis[e.dest]) {
				vis[curr]=true;
				modifedDFSAllPaths(graph,vis,e.dest,path+e.dest,tar);
				vis[curr]=false;
			}
		}
			
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int V = 7;
		ArrayList<Edge> graph[] = new ArrayList[V];
		CreateGraph(graph);
		int src=0,tar=5;
		modifedDFSAllPaths(graph,new boolean[V],src,"0",tar);
		/*
		 * boolean vis1[] = new boolean[V]; dfs(graph, 0, vis1);
		 * System.out.println(" ");
		 * 
		 * boolean vis[] = new boolean[V]; for (int i = 0; i < V; i++) { if (vis[i] ==
		 * false) { dfs(graph, i, vis); } }
		 */

	}

}
