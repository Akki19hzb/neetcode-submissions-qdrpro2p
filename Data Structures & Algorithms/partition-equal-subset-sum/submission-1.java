class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        int n = nums.length;
        for(int num : nums)
            sum += num;
        
        if(sum%2 !=0) return false;
        int target = sum/2;

        boolean[][] dp = new boolean[n][target+1];

        //base case

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        
        for(int j=0; j<=target; j++){
            if(nums[0]==j){
                dp[0][j] = true;
            }
        }

        for(int i= 1; i<n; i++){
            for(int j=0; j<=target;j++){
                //not pick
                boolean notPick = dp[i-1][j];

                //pick
                boolean pick = false;
                
                if(nums[i]<=j){
                    pick = dp[i-1][j-nums[i]];
                }
                dp[i][j] = pick || notPick;
            }
        }
        return dp[n-1][target];
    }
}


