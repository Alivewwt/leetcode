package algorithm.easy;

/**
 * @author wuwt
 * @date 2020-01-12
 * input [2,2,1] output [1]
 **/
public class singleNum_136 {
    public static int singleNumber(int[] nums) {
          int res =0;
          for(int i=0;i<nums.length;i++){
              res^= nums[i];
          }
          return res;
    }

    public static void main(String[] args) {
       int nums[] = new int[]{2,2,1};
       System.out.println(singleNumber(nums));
    }

}
