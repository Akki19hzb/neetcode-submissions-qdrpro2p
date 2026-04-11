class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int count =0;
        for(int i =0; i <n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        for(int i=0; i< n; i++){
            if(!visited[i]){
                count++;
                bfs(visited, adj, i);
            }
        }
        return count;
    }

    private void bfs(boolean[] visited, List<List<Integer>> adj, int node){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);

        while(!q.isEmpty()){
            int u = q.poll();
            visited[u] = true;

            for(int v : adj.get(u)){
                if(!visited[v]){
                    q.offer(v);
                }
            }
        }
    }
}
