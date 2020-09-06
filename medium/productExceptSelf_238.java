package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/6/4 10:18 下午
 * 除了自身以外的乘积
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 **/
public class productExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res1 = new int[len];
        int[] res2 = new int[len];
        res1[0] = 1;
        res2[len-1] = 1;
        for(int i=1;i<nums.length;i++){
            res1[i] = nums[i-1]*res1[i-1];
        }
        for(int i=len-2;i>=0;i--){
            res2[i] = nums[i+1]*res2[i+1];
        }
        for(int i=0;i<len;i++){
            nums[i] = res1[i]*res2[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = new productExceptSelf_238().productExceptSelf(nums);
        for(int i:res)
            System.out.println(i);
    }
}
