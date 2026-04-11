class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j, 0});
                }
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r= cell[0];
            int c = cell[1];
            int val = cell[2];

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < m  && nc >= 0 && nc <n && grid[nr][nc] == INF){
                    grid[nr][nc] = val +1;
                    q.offer(new int[]{nr, nc, val+1});
                }
            }
        }
    }

   
}
