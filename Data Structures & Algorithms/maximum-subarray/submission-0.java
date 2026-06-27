class Solution {
    public int maxSubArray(int[] nums) {
        int ans=Integer.MIN_VALUE, sum=0;
        for(int n : nums){
            sum =Math.max(sum + n , n);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
