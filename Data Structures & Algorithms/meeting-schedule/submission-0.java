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

class Solution 
{
    public boolean canAttendMeetings(List<Interval> intervals) 
    {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        });

        int lastEnd = 0;
        for(Interval interval: intervals)
        {
            if(lastEnd > interval.start) return false;
            lastEnd = interval.end;
        }
        
        return true;
    }
}
