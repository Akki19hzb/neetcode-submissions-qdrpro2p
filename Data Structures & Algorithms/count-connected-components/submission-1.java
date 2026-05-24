class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] =i;
        }

        int components = n; //initially all nodes seperate so n compermits

        for(int[] e : edges){
            int x = e[0];
            int y = e[1];

            if(find(parent, x) != find(parent, y)){
                union(parent, rank, x, y);
                components--;
            }
        }
        return components;
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
