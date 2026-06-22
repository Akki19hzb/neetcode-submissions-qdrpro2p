class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bt(0, new ArrayList<>(), res, nums);
        return res;
        
    }


    private void bt(int idx, List<Integer> ds, List<List<Integer>> res, int[] nums){
        res.add(new ArrayList<>(ds));

        for(int start= idx; start< nums.length; start++){
            ds.add(nums[start]);

            bt(start+1, ds, res, nums);

            ds.remove(ds.size()-1);
        }
    }
}
