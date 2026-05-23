class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        //base case 
        //when s2 is over so not take then also t is formed 
        for(int i=0; i<=m; i++){
            dp[i][0] = 1;
        }

        //for 1st col by default its zero, no need to set 

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    //if match 2 options take this one or other
                    dp[i][j] =
                    dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    return dp[m][n];

    }
}
