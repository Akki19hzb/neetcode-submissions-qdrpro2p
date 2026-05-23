class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum =0;
        for(int num : nums){
            sum += num;
        }

        int s2 = (sum-target)/2;

        if(sum - target <0 || (sum-target)%2 !=0) return 0;

        int[][] dp = new int[n][s2+1];

        //Base case
        if(nums[0]==0){
            dp[0][0] =2; //2 ways either pick or not pick
        }else{
            dp[0][0] =1; //not pick then target =0

            if(nums[0]<=s2){
                dp[0][nums[0]] =1;
            }
        }

        // for(int i=1; i<n; i++){
        //     dp[i][0] =1;
        // }

        //NOW PICK NOT PICK

        for(int i=1; i<n; i++){
            for(int j =0; j<=s2; j++){
                int notPick = dp[i-1][j];

                int pick = 0;

                if(nums[i]<=j){
                    pick = dp[i-1][j-nums[i]];
                }
                dp[i][j] = pick +notPick;
            }
        }

        return dp[n-1][s2];

    }
}
