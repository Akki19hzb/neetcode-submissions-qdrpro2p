class Solution {
    public boolean canJump(int[] nums) {
        int maxFar = 0;

        for(int i=0 ; i< nums.length; i++){
            if(i > maxFar) return false;

            int far = nums[i]+ i;
            maxFar = Math.max(maxFar, far);
        }
        return true;
    }
}
