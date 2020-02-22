package algorithm.easy;

import java.util.HashMap;

/**
 * @author wuwt
 * @date 2020-01-27
 * 寻找数组中出现频次超过n/2的数
 **/
public class majorityElement_169 {
    public static int majorityElement(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int c =1;
        int flag = nums[0];
        for (int i =1;i<nums.length;i++){
            if(nums[i]!=flag){
                c =c-1;
                if(c==0){
                    flag = nums[i];
                    c=1;
                }

            }else
                c+=1;
        }
        return flag;
    }

}
