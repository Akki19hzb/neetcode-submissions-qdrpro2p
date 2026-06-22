class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        bt(0, new ArrayList<>(), res, nums);
        return res;
    }


    private void bt(int idx, List<Integer> ds, List<List<Integer>> res, int[] nums){
        res.add(new ArrayList<>(ds));

        for(int start= idx; start< nums.length; start++){
            //duplicate handling 

            if(start>idx && nums[start] == nums[start-1])
                continue;
            
            ds.add(nums[start]);

            bt(start+1, ds, res, nums);

            ds.remove(ds.size()-1);
        }
    }
}
