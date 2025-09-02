import java.util.ArrayList;

class GraphDFS {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];

        ans.add(0);
        vis[0] = true;

        dfsOfGraphHelper(adj, 0, ans, vis);
        return ans;
    }

    public void dfsOfGraphHelper(ArrayList<ArrayList<Integer>> adj, int src, ArrayList<Integer> ans, boolean[] vis) {
        ArrayList<Integer> nbrs = adj.get(src);

        for(int v: nbrs) {
            if(vis[v] == false) {
                ans.add(v);
                vis[v] = true;
                dfsOfGraphHelper(adj, v, ans, vis);
            }
        }
    }

    // Utility method to create graph from edges
    public static ArrayList<ArrayList<Integer>> buildGraph(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Initialize adjacency lists for all vertices
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

    // Method to print the graph
    public static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Node " + i + ": " + graph.get(i));
        }
    }

    public static void main(String[] args) {
        GraphDFS graphDFS = new GraphDFS();

        // Test Case 1: Connected Graph (based on your diagram)
        int[][] edges1 = {
                {0, 3}, {3, 4}, {4, 6},
                {0, 1}, {1, 2}, {3, 2},
                {2, 5}, {5, 6}
        };
        ArrayList<ArrayList<Integer>> graph1 = buildGraph(7, edges1);
        System.out.println("Graph 1 Adjacency List:");
        printGraph(graph1);
        ArrayList<Integer> result1 = graphDFS.dfsOfGraph(7, graph1);
        System.out.println("DFS from node 0: " + result1);

        // Test Case 2: Simple Linear Graph
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}};
        ArrayList<ArrayList<Integer>> graph2 = buildGraph(4, edges2);
        System.out.println("\nGraph 2 - Linear:");
        printGraph(graph2);
        ArrayList<Integer> result2 = graphDFS.dfsOfGraph(4, graph2);
        System.out.println("DFS from node 0: " + result2);

        // Test Case 3: Star Graph
        int[][] edges3 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}};
        ArrayList<ArrayList<Integer>> graph3 = buildGraph(5, edges3);
        System.out.println("\nGraph 3 - Star:");
        printGraph(graph3);
        ArrayList<Integer> result3 = graphDFS.dfsOfGraph(5, graph3);
        System.out.println("DFS from node 0: " + result3);

        // Test Case 4: Tree Structure
        int[][] edges4 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}};
        ArrayList<ArrayList<Integer>> graph4 = buildGraph(6, edges4);
        System.out.println("\nGraph 4 - Tree Structure:");
        printGraph(graph4);
        ArrayList<Integer> result4 = graphDFS.dfsOfGraph(6, graph4);
        System.out.println("DFS from node 0: " + result4);

        // Test Case 5: Single Node Graph
        ArrayList<ArrayList<Integer>> graph5 = new ArrayList<>();
        graph5.add(new ArrayList<>());
        System.out.println("\nGraph 5 - Single Node:");
        printGraph(graph5);
        ArrayList<Integer> result5 = graphDFS.dfsOfGraph(1, graph5);
        System.out.println("DFS from node 0: " + result5);

        // Test Case 6: Two Connected Nodes
        int[][] edges6 = {{0, 1}};
        ArrayList<ArrayList<Integer>> graph6 = buildGraph(2, edges6);
        System.out.println("\nGraph 6 - Two Nodes:");
        printGraph(graph6);
        ArrayList<Integer> result6 = graphDFS.dfsOfGraph(2, graph6);
        System.out.println("DFS from node 0: " + result6);

        System.out.println("\n=== Testing Complete ===");
    }
}