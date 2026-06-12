class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> hm = new HashMap<>();

        for(char c : tasks){
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }
        /*
            pq holds the count of the tasks which can be processed in current time,
            so when we process once, it becomes unavailable for next n times,
            so meanwhile(till time current time +n +1) we keep in the queue and 
            when time is over we pull it back in pq
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : hm.values()){
            pq.offer(val);
        }

        //count left (freq), time 
        Deque<int[]> q = new ArrayDeque<>(); 

        int time =0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(!q.isEmpty() && time == q.peek()[1]){
                pq.offer(q.poll()[0]);
            }

            if(!pq.isEmpty()){
                int count = pq.poll();
                count--;

                if(count !=0){
                    q.offer(new int[]{count, time+n+1});
                }
            }
        }
        return time;
    }
}
