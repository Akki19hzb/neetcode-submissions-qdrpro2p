class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n= hand.length;

        if(n%groupSize !=0) return false;

        TreeMap<Integer,Integer> tm = new TreeMap<>();

        for(int num : hand)
            tm.put(num , tm.getOrDefault(num, 0)+1);
        
        while(!tm.isEmpty()){
            int first = tm.firstKey();

            for(int i=0; i< groupSize; i++){
                int key = first+i;

                if(!tm.containsKey(key)) return false;

                tm.put(key, tm.get(key)-1);
                if(tm.get(key)==0) tm.remove(key);
            }
        }
        return true;
    }
}
