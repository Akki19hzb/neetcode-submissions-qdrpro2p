class Solution {
    //USING FIND UNION 
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int V = edges.length;
        parent = new int[V+1];
        rank = new int[V+1];

        for(int i=0; i<=V; i++)
            parent[i] = i;
        // int[] ans = new int[2];

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            if(find(u) == find(v)){ 
                //common leader means already connected so cycle will be formed
                //so need to remove this edge
                return e;
            }
            union(u, v);
        }
        return new int[]{};
    }

    private int find(int x){
        if(parent[x] != x){
            return find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px==py) return;

        int rx = rank[px];
        int ry = rank[py];

        if( rx < ry){
            parent[px] = py;
        }else if(rx > ry){
            parent[py] = px;
        }else{
            parent[py] = px;
            rank[px]++;
        }
    }
}
