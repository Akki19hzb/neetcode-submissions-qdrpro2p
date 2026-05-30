class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();

        int m = grid.length;
        int n = grid[0].length;
        int fresh=0;

        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int time =0;

        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!q.isEmpty()){
            int size = q.size();
            boolean visited = false;

            for(int i=0; i<size; i++){
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                for(int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        fresh--;
                        visited = true;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            if(visited) time++; 
        }

        return fresh==0 ? time : -1;
    }
}
