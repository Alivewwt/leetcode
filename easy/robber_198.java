package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/3/24 9:03 下午
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 **/
public class robber_198 {

    public static int robber(int []nums){
        if (nums==null)
            return 0;
        if (nums.length==1)
            return nums[0];

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        //当前元素选择与否？ 转移方程 dp[i] = max(dp[i-1],dp[i-2]+nums[i])
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,5,3,1,1,3};
        System.out.println(robber(nums));
    }

}
