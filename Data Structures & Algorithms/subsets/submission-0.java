class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(nums, 0, res, new ArrayList<>());
        return res;
        
    }

    void f(int[] nums, int idx, List<List<Integer>> res, List<Integer> list){

        if(idx== nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        //pick
        list.add(nums[idx]);
        f(nums, idx+1, res, list);

        //backtrack
        list.remove(list.size() -1);

        //not pick
        f(nums, idx+1, res, list);
    }
}
