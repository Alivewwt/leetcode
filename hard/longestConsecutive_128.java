package alogrithm.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author created by wuwt
 * @date 2020/6/7 11:40 上午
 * 最长连续序列
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 **/
public class longestConsecutive_128 {
    public int longestConsecutive(int[] nums) {
        //利用set去重
        Set<Integer> num_set = new HashSet<>();
        for(int num:nums){
            num_set.add(num);
        }

        int longestStreak = 0;
        for(int num:num_set){
            //枚举的数x一定是在数组中不存在前驱 x-1
            if(!num_set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                while(num_set.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                }

                longestStreak = Math.max(currentStreak,longestStreak);
            }

        }
        return longestStreak;
    }


}
