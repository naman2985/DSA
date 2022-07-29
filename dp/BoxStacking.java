package dp;

import java.util.*;
/*
 * You are given a set of N types of rectangular 3-D boxes, where the ith box has height h, width w and length l.
 * You task is to create a stack of boxes which is as tall as possible, but you can only stack a box on top of 
 * another box if the dimensions of the 2-D base of the lower box are each strictly larger than those of the 2-D 
 * base of the higher box. Of course, you can rotate a box so that any side functions as its base. 
 * It is also allowable to use multiple instances of the same type of box.
 */

public class BoxStacking {
	public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        // Code here
        int rotations[][]=new int[3*n][3];
        int maxHeight[]=new int[3*n];
        int overallMax=0;
        for(int i=0;i<3*n;i++){
            int j=i/3;
            if(i%3==0){
                rotations[i][0]=width[j];
                rotations[i][1]=length[j];
                rotations[i][2]=height[j];
            }
            else if(i%3==1){
                rotations[i][0]=width[j];
                rotations[i][1]=height[j];
                rotations[i][2]=length[j];
            }
            else{
                rotations[i][0]=height[j];
                rotations[i][1]=length[j];
                rotations[i][2]=width[j];
            }
        }
        
        Arrays.sort(rotations, new Comparator<int[]>(){
            @Override
            public int compare(int[] first,int[] second){
                if(first[0]*first[1]<second[0]*second[1])
                    return -1;
                return 1;
            }
        });
        
        for(int i=0;i<3*n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if((rotations[i][0]>rotations[j][0] && rotations[i][1]>rotations[j][1]) || 
                (rotations[i][0]>rotations[j][1] && rotations[i][1]>rotations[j][0])){
                    max = Math.max(max,maxHeight[j]);
                }
            }
            maxHeight[i]=rotations[i][2]+max;
            overallMax=Math.max(overallMax,maxHeight[i]);
        }
        return overallMax;
    }
}
