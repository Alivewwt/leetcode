package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/5/21 9:14 下午
 * 乘积最大的子数组
 **/
public class maxProduct_152 {
    public int maxProduct(int[] nums) {
        if(nums.length==0||nums==null)
            return 0;
        int max = Integer.MIN_VALUE,imax =1,imin=1;
        for(int i=0;i<nums.length;i++){
            //若当前值为负，交换两者
            if(nums[i]<0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax*nums[i],nums[i]);
            imin = Math.min(imin*nums[i],nums[i]);
            max = Math.max(imax,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[]  nums = {2,3,-2,4};
        System.out.println(new maxProduct_152().maxProduct(nums));
    }
}
