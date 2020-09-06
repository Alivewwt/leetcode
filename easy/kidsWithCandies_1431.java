package alogrithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author created by wuwt
 * @date 2020/6/15 8:42 下午
 * 拥有最多糖果的孩子
 * candies = [2,3,5,1,3], extraCandies = 3
 **/
public class kidsWithCandies_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int len = candies.length;
        int[] copyArray = Arrays.copyOf(candies,len);
        Arrays.sort(candies);
        int max = candies[len-1];
        for(int i=0;i<len;i++){
            int tmp = copyArray[i]+extraCandies;
            if (tmp >= max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        kidsWithCandies_1431 k = new kidsWithCandies_1431();
        int[]  candies = {2,3,5,1,3};
        List<Boolean> res = k.kidsWithCandies(candies,3);
        for(Boolean b: res){
            System.out.println(b);
        }
    }
}
