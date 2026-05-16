class Solution {
    public int jump(int[] nums) {
        int maxFar =0, jumps =0;
        int curEnd =0;

        for(int i =0; i< nums.length-1; i++){// till second last

            int far = nums[i]+i;
            maxFar = Math.max(far, maxFar);

            if(i == curEnd){
                curEnd = maxFar;
                jumps++;
            }
        }
        return jumps;
    }
}
