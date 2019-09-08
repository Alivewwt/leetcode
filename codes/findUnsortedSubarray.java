/*
  题目:https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
* 最短连续没排序数组
*/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int nums1[]=new int[nums.length];
        //复制数组
        nums1=Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int start=-1,end=-2;
        for(int i=0;i<nums.length;i++){
           if(nums[i]!=nums1[i]){
               if(start==-1)
                   start=i;
               end=i;
           }
        }
        return end-start+1;
    }
}