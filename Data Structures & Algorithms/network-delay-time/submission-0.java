class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        int INF = Integer.MAX_VALUE;

        for(int i=0; i<=n; i++)
            adj.add(new ArrayList<>());

    
        for(int[] time : times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); //dist, node
        int[] dist = new int[n+1];

        Arrays.fill(dist, INF);
        dist[k] =0;
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int u = cell[1];
            int d = cell[0]; 

            if(dist[u] < d) continue; //stale data

            for(int[] node :adj.get(u)){
                int v = node[0];
                int wt = node[1];
                if(d+wt < dist[v]){
                    dist[v] = d+wt;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        int ans =0;
        for(int i =1; i<=n; i++){
            if(dist[i]==INF) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
