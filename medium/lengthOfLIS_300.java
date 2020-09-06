package alogrithm.medium;

import java.util.Arrays;

/**
 * @author created by wuwt
 * @date 2020/8/27 9:28 下午
 * 最长上升子序列
 **/

public class lengthOfLIS_300 {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++ ){
                if(nums[i]> nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res=0;
        for(int i=0;i<dp.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2,9};
        System.out.println(new lengthOfLIS_300().lengthOfLIS(nums));
    }
}
