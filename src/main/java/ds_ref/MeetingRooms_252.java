package ds_ref;

import java.util.Arrays;

/*
//https://leetcode.com/problems/meeting-rooms/

//sort the meetings
//make sure end time is less that the start time of next then not overlap .if its greater then just return

 */
public class MeetingRooms_252 {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i][1] > intervals[i+1][0]) return false;
        }
        return true;
    }
}
