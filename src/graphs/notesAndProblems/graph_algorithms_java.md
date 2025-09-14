# Graph Algorithms - Java Implementations

## Dijkstra Algorithm

``` java
class Solution
{
    public static class Pair implements Comparable<Pair>{
        int vtx,wsf;
        Pair(int vtx,int wsf){
            this.vtx = vtx;
            this.wsf = wsf;
        }
        public int compareTo(Pair O){
            return this.wsf - O.wsf;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] ans = new int[V];
        Arrays.fill(ans,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S,0));
        while(pq.size()>0){
            Pair rem = pq.remove();
            if(ans[rem.vtx] != Integer.MAX_VALUE) continue;
            
            ans[rem.vtx] = rem.wsf;
            for(ArrayList<Integer> e : adj.get(rem.vtx)){
                int nbr = e.get(0);
                int wt = e.get(1);
                if(ans[nbr]!=Integer.MAX_VALUE) continue;
                pq.add(new Pair(nbr , rem.wsf+wt));
            }
            
        }
        return ans;
        
    }
}
```

## Bellman-Ford Algorithm

``` java
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] ans = new int[V];
        Arrays.fill(ans,100000000);
        ans[S]= 0;
        
        for(int i = 0; i<V-1; i++){
            for(ArrayList<Integer> e : edges){
                int u = e.get(0);
                int v = e.get(1);
                int wt = e.get(2);
                if(ans[u] != 100000000 && ans[u]+ wt < ans[v]){
                    ans[v] = ans[u]+wt;
                }
            }
        }
        for(ArrayList<Integer> e : edges){
                int u = e.get(0);
                int v = e.get(1);
                int wt = e.get(2);
                if(ans[u] != 100000000 && ans[u]+ wt < ans[v]){
                     int[] an = {-1};
                     return an;
                }
            }
        return ans;
        
    }
}
```

## Detect Negative Weight Cycle

``` java
class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int [] arr = new int[n];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[0] = 0;
        int itr = 1;
        while(itr<=n-1){
            
            for(int i = 0; i<edges.length; i++){
                int src = edges[i][0];
                int des = edges[i][1];
                int wt = edges[i][2];
                if(arr[src] != Integer.MAX_VALUE && arr[src]+wt<arr[des]){
                    arr[des]  = arr[src] +wt;
                }
            }
            itr++;
        }
        
        for(int i = 0; i<edges.length; i++){
                int src = edges[i][0];
                int des = edges[i][1];
                int wt = edges[i][2];
                if(arr[src] != Integer.MAX_VALUE && arr[src]+wt<arr[des]){
                     //-ve cycle
                     return 1;
                }
            }
        return 0;
        
    }
}
```
