package ds_ref;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/meeting-rooms-ii
 */

public class MeetingRoomsII_253 {

    /*
    in the below scenario
    [[9,10],[4,9],[4,17]]
    meeting room is 2
    becuase 4,9  [9,10 can use the same room as 4,9 is over]
     */
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals.length <=0) return 0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            int endTime=pq.peek();
            int startTime=intervals[i][0];
            if(startTime >= endTime){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }


    public static void main(String[] args) {
        //int [][] a ={{9,10},{4,9},{4,17}};
        int [][] a ={{9,10},{4,9},{4,17}};
        //int [][] a ={{0,30},{5,10},{15,20}};
        //int [][] a ={{2,7}};
        System.out.println(minMeetingRooms(a));
    }
}
