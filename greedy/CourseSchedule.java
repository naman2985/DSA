package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseSchedule {
	public static int scheduleCourse(int[][] courses) {
        int n=courses.length,currTime=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(courses,Comparator.comparingInt(a -> a[1]));
        for(int i=0;i<n;i++){
            pq.add(courses[i][0]);
            currTime+=courses[i][0];
            if(currTime>courses[i][1]) currTime-=pq.poll();
        }
        return pq.size();
    }
}
