class Solution {
    public int coinChange(int[] coins, int amount) {
        int INF = (int)1e9;
        int m = coins.length;
        int[][] dp = new int[m][amount+1];
        for(int j= 0; j<=amount; j++){
            if(j%coins[0]==0){
                dp[0][j] = j/coins[0];
            }else{
                dp[0][j] = INF;
            }
        }

        for(int i=1; i< m; i++){
            for(int j=0; j<= amount; j++){
                int notPick = dp[i-1][j];

                int pick = INF;
                if(coins[i]<=j){
                    pick = 1 + dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(notPick, pick);
            }
        }
        return dp[m-1][amount]>= INF ? -1 : dp[m-1][amount];
    }
}
