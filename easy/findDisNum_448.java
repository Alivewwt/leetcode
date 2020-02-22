package algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuwt
 * @date 2020-01-27
 * Input:[4,3,2,7,8,2,3,1]
 * Output:[5,6]
 **/
public class findDisNum_448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            //当前位置上的元素
            if (nums[nums[i]-1]!= nums[i]) {
//                int cur = nums[i];
//                nums[i] = nums[nums[i] - 1];
//                nums[nums[i] - 1] = cur;
                swap(i,nums[i]-1,nums); //交换两个位置上的数

                i--;
            }

        }
        for(int i =0;i<len;i++){
            if(i+1!=nums[i])
                res.add(i+1);
        }
        return  res;
    }

    public static void swap(int i,int j ,int []nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int nums[] ={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
