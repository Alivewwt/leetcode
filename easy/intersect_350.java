package alogrithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author created by wuwt
 * @date 2020/7/13 8:26 下午
 * 求两个数组的交集
 **/
public class intersect_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i:nums1){
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else{
                map.put(i,1);
            }
        }
        for(int j:nums2){
            if(map.containsKey(j)&&map.get(j)>0){
                res.add(j);
                map.put(j,map.get(j)-1);
            }
        }
       int r[] = new int[res.size()];
        for(int i=0;i<res.size();i++){
            r[i] = res.get(i);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        intersect_350 in = new intersect_350();
        int[] r = in.intersect(nums1,nums2);
        for(int i:r){
            System.out.println(i);
        }
    }
}
