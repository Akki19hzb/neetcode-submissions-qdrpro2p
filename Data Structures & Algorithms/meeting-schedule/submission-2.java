/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparing(a -> a.end));
        if(intervals.isEmpty()) return true;
        int lastEnd = intervals.get(0).end;
        for(int i =1; i< intervals.size(); i++){
            
            if(intervals.get(i).start < lastEnd){
                return false;
            } else{
                lastEnd = Math.max(lastEnd, intervals.get(i).end);
            }
        }
        return true;
    }
}
