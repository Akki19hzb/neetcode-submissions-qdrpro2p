class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res =0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    int area = dfs(grid, visited, i,j);
                    res = Math.max(area, res);

                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, boolean[][] visited, int row, int col){
        if(row<0 || row>=grid.length || col <0 || col >= grid[0].length 
        || grid[row][col] == 0){
            return 0;
        }

        if(visited[row][col]) return 0;

        visited[row][col] = true;
        int area =1;

        area += dfs(grid, visited,row+1, col);
        area += dfs(grid, visited,row-1, col);
        area += dfs(grid, visited,row, col-1);
        area += dfs(grid, visited,row, col+1);
        return area;
    }
}
