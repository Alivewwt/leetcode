package alogrithm.hard;

/**
 * @author created by wuwt
 * @date 2020/4/18 7:21 下午
 * 贪心算法，计算到达每一步需要的step
 **/
public class jump_45 {
    public int jump(int[] nums) {
        int step =0;
        int maxPos =0;
        int end =0;
        //从起点开始循环起跳，到达最终位置以后不再起跳
        for(int i=0;i<nums.length-1;i++){
            maxPos = Math.max(maxPos,i+nums[i]);//[2,4]
            // 判断是否到达上一步能跳到的最远位置。
            if(i==end){
                end = maxPos;//[0,2,4]
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        System.out.println(new jump_45().jump(nums));
    }
}
