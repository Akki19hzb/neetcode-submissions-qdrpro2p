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
    //     intervals.sort(Comparator.comparing(a -> a.start));
        
    //     for(int i =1; i < intervals.size(); i++){
    //         Interval prev = intervals.get(i-1);
    //         Interval curr = intervals.get(i);

    //         if(prev.end > curr.start){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    if(intervals.size() == 0 ){
        return true;
    }
    intervals.sort(Comparator.comparing(a -> a.end));

    int lastEnd = intervals.get(0).end;


    for(int i=1; i< intervals.size(); i++){
        if(intervals.get(i).start < lastEnd){
            return false;
        }
        lastEnd = intervals.get(i).end;
    }
    return true;
    }
}
