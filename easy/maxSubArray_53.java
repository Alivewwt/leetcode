package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/5/5 2:14 下午
 * 和最大的连续子数组
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 **/
public class maxSubArray_53 {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int res = nums[0],maxSum= nums[0];
        for(int i=1;i<nums.length;i++){
            res = Math.max(res+nums[i],nums[i]);
            maxSum = Math.max(res,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println(new maxSubArray_53().maxSubArray(nums));
    }
}
