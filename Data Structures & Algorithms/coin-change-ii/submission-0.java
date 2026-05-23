class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;

        int[][] dp = new int[m][amount+1];

        //base case;
        
        //when i is 0 i.e; only one coin 

        for(int j=0; j<= amount; j++){
            if(j%coins[0] == 0){
                dp[0][j] =1;
            }else{
                dp[0][j] =0;
            }
        }

        //when j is 0 i.e amount =0
        for(int i=0; i<m; i++){
            dp[i][0] =1;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<=amount; j++){
                int notPick = dp[i-1][j];

                int pick =0;
                if(coins[i]<= j){
                    pick = dp[i][j-coins[i]];
                }
                dp[i][j] = notPick + pick;
            }
        }
        return dp[m-1][amount];
    }
}
