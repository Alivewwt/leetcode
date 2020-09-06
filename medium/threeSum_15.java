package alogrithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author created by wuwt
 * @date 2020/6/14 1:53 下午
 * 三数之和等于0
 *
 **/
public class threeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(nums==null||len<3)
            return res;
        Arrays.sort(nums); //排序
        for(int i=0;i<len;i++){
            if(nums[i]>0) break;
            if(i>0&& nums[i]==nums[i-1])
                continue;
            int L =i+1;
            int R = len-1;
            while (L<R){
                int sum = nums[i]+nums[L]+nums[R];
                if(sum==0){
                    res.add(Arrays.asList(nums[L],nums[i],nums[R]));
                    while (L<R && nums[L]==nums[L+1]) L++;
                    while (L<R && nums[R]==nums[R-1]) R--;
                    L++;
                    R--;
                }
                else if(sum<0) L++;
                else if(sum>0) R--;
            }
        }
        return res;
    }
}
