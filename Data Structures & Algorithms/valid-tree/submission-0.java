class Solution {
    public boolean validTree(int n, int[][] edges) {
        /*Graph to be Tree 
        1. n nodes then it should have n-1 edges
        2. all the nodes should be connected
        */

        if(edges.length != n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0; i <n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        int count =0;

        while(!q.isEmpty()){
            int u = q.poll();
            visited[u] = true;
            count++;

            for(int v : adj.get(u)){
                if(!visited[v]){
                    q.offer(v);
                }
            }
        }

        //if all the nodes are visited so all nodes connected
        return count == n;
        
    }
}
