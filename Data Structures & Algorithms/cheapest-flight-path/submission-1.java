class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        int INF = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++)  
            adj.add(new ArrayList<>());

        for(int[] f : flights){
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        int[] price = new int[n];
        Arrays.fill(price, INF);
        price[src] =0;

        Queue<int[]> pq =
            new ArrayDeque<>(); //stops, price, node

        pq.offer(new int[]{0, 0, src});

        while(!pq.isEmpty()){
            int[] cell = pq.poll();

            int stops = cell[0];
            int cost = cell[1];
            int u = cell[2];

            if(stops <=k){
                for(int[] node : adj.get(u)){
                    int v = node[0];
                    int costV = node[1];
                    if(cost + costV < price[v]){
                        price[v] = cost + costV;
                        pq.offer(new int[]{stops+1, price[v], v});
                    }
                }
            }
        }

        return price[dst] != INF ? price[dst] : -1;    
    }
}
