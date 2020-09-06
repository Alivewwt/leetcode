package alogrithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author created by wuwt
 * @date 2020/4/16 9:05 下午
 * 合并区间，两个重叠区间，合并成一个
 **/
public class merge_56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<2||intervals[0].length==0)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //起始位置排序 o1[0]-o2[0]>0 就交换顺序
                return o1[0]-o2[0];
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        for(int i=0;i<intervals.length-1;i++){
            //寻找重叠区间
            if(intervals[i][1]>=intervals[i+1][0]){
                intervals[i+1][0] =intervals[i][0];
                intervals[i+1][1]= intervals[i][1]>intervals[i+1][1] ? intervals[i][1]:intervals[i+1][1];
            }else{
                res.add(intervals[i]);
            }
        }
        res.add(intervals[intervals.length-1]);
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new merge_56().merge(a);
        for(int i=0;i<res.length;i++){
//            for(int j=0;j<2;j++)
            System.out.println(res[i][0]);
            System.out.println(res[i][1]);
        }
    }
}
