class Solution {
    public boolean validTree(int n, int[][] edges) {
        int edgesCount = edges.length;
        //For a graph to be valid tree it must have n-1 nodes 
        if(edgesCount != n-1) return false;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] =i;
        }

        for(int[] e : edges){
            int x = e[0];
            int y = e[1];
            if(find(parent, x) == find(parent, y)){
                //cycle detected
                //as all nodes are sepreate initially,
                // if already have common leader this means now cycle
                return false;
            }
            union(parent, rank, x, y);
        }
    return true;

    }

    int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    void union(int[] parent, int[] rank, int x , int y){
        int px = find(parent, x);
        int py = find(parent, y);

        if(px == py) return;

        if(rank[px] > rank[py]){
            parent[py] = px;
        }else if(rank[py] > rank[px]){
            parent[px] = py;
        }else{
            parent[px] = py;
            rank[py]++;
        }
    }
}
