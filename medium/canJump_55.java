package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/18 10:47 上午
 * 给定一个数组，假设你在数组的第一位，每个数组元素代表你能跳跃的步数，判断你能否到数组的最后一个位置
 **/
public class canJump_55 {
    public boolean canJump(int[] nums) {
        if (nums==null||nums.length==0)
            return true;
        int right= 0;
        //可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离不断更新。
        for(int i=0;i<nums.length;i++){
            if(i>right)return false;
            right = Math.max(right,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums ={3,2,1,0,4};
        System.out.println(new canJump_55().canJump(nums));
    }
}
