class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int start0 = f(nums, 0, n-2);
        int start1 = f(nums, 1, n-1);

        return Math.max(start0, start1);
    }

    int f(int[] nums, int start, int end){  

        int size = end-start+1;
        if(size==1) return nums[start];
        int[] dp = new int[size];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);

        for(int i= start+2; i<=end; i++){
            int idx = i- start; //imp to have local index
            dp[idx] = Math.max(nums[i] + dp[idx-2], dp[idx-1]);
        }
        return dp[size-1];
    }
}
