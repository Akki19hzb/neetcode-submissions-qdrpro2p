class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]- b[0]));
        //sort by start time 

        List<int[]> ans = new ArrayList<>();

        ans.add(intervals[0]);

        for(int i=1; i<intervals.length; i++){
            int[] slot = intervals[i];
            int[] lastSlot = ans.get(ans.size()-1);

            if(slot[0] <= lastSlot[1]){
                lastSlot[1] = Math.max(lastSlot[1] , slot[1]);
            }else{
                ans.add(slot);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
