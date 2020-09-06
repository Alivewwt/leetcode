package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/4/30 10:27 下午
 * 数组中只出现一次的两个数 利用 xor & (-xor) 得到最右边的 1
 **/
public class singleNumbers_56 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum^=nums[i];

        }
        int flag = sum&(-sum);
        int result =0 ;
        for(int i=0;i<nums.length;i++)
            if((flag&nums[i])!=0)
                result^=nums[i];
        return new int[]{result,result^sum};
    }

    public static void main(String[] args) {
        int[]  nums = {1,2,3,3,2,4};
        int res[] = new singleNumbers_56().singleNumbers(nums);
        System.out.println(res[0]+","+res[1]);
    }
}
