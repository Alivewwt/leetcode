package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/5/29 9:45 下午
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 **/
public class rob_198 {
    public int rob(int[] nums) {
        if(nums.length==0||nums==null)
            return 0;
        int dp[] = new int[nums.length];
        if(nums.length==1)
            return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            //当前是偷或者不偷
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new rob_198().rob(nums));
    }
}
