class Solution {
    //PRISM Algo with a twist as nodes or edges not given 
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        pq.offer(new int[]{0, 0}); //weight,node

        int sum =0;
        boolean[] visited = new boolean[n];

        while(!pq.isEmpty()){
            int[] cell = pq.poll();

            int d = cell[0];
            int node = cell[1];

            if(visited[node]) continue; //IMP for not form cycle
            visited[node] = true;
            sum += d; // to collect the total cost 


            // usually here we look for nbrs but as edges not given 
            for(int v=0; v<n; v++){
                if(!visited[v]){
                    int dist = Math.abs(points[node][0] - points[v][0]) +
                    Math.abs(points[node][1] - points[v][1]); 

                    pq.offer(new int[]{dist, v});
                }
            }
        }
        return sum;
    }
}
