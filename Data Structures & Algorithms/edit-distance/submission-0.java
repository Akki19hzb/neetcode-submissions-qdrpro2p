class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        //base case
        for(int i=0; i<=m; i++){
            dp[i][0]= i; //remove leftover of word1 as word 2 is already formed
        }

        for(int j=0; j<=n; j++){
            dp[0][j] = j; //as word1 over, and still word 2 left need to insert
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insert = dp[i][j-1];
                    int replace = dp[i-1][j-1];
                    int delete = dp[i-1][j];
                    dp[i][j] = 1+ Math.min(insert, Math.min(replace, delete));
                }
            }
        }
        return dp[m][n];
    }
}
