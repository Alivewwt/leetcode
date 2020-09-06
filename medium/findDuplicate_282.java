package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/5/26 10:09 下午
 * 寻找重复数 抽屉原理
 **/
public class findDuplicate_282 {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left<right){
            //无符号右移
            int mid = (left+right)>>>1;
            int cnt =0 ;
            for(int n: nums){
                if(n<=mid){
                    cnt+=1;
                }
            }
            if(cnt>mid){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2};
        System.out.println(new findDuplicate_282().findDuplicate(nums));
    }
}
