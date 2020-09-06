package alogrithm.easy;

import java.util.HashMap;

/**
 * @author created by wuwt
 * @date 2020/7/20 9:24 下午
 * 两数之和 已排过序+双指针
 **/
public class twoSum_167 {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j= numbers.length-1;
        while(i<j){
            int res = numbers[i]+numbers[j];
            if (res==target){
                return new int[]{i+1,j+1};
            }else if(res<target){
                i++;

            }else{
                j--;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        twoSum_167 t = new twoSum_167();
        int[] numbers= new int[]{2, 7, 11, 15};
        int[] res = t.twoSum(numbers,9);
        System.out.println(res[0]+" "+res[1]);
    }
}
