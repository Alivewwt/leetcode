package alogrithm.medium;

import java.util.HashMap;

/**
 * @author created by wuwt
 * @date 2020/5/15 10:04 下午
 * 和为k的数组
 **/
public class subarraySum_560 {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> preSum = new HashMap<>();
        int res = 0;
        int sum = 0;
        preSum.put(0,1);//和为0的个数为1
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            //判断是否存在和为sum - k的连续式数组，如果存在，那么一定存在和为k的连续数组
            // 每次都是从数组起始位置累加的
            if(preSum.containsKey(sum-k)){
                res += preSum.get(sum-k);
            }
            // 如果不存在sum-k的连续子数组，则将sum的连续子数组存进preSum里
            preSum.put(sum,preSum.getOrDefault(sum,0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(new subarraySum_560().subarraySum(nums,2));
    }
}
