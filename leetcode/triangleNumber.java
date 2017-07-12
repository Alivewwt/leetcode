package project.leetcode;

import java.util.Arrays;

/*
 * 给定一数组，返回组成三角形的个数，
 * 例{2,2,3,4} 返回3
 * [2,2,3]-->1
 * [2,3,4]-->2
 * [2,3,4]-->3
 * 思路：首先容易想到排序，默认复杂度O(nlogn),对数组下标循环，内部转化成一个two sum问题
 * 在首尾设两个指针，若left和right对应位置上的数字相加大于nums[i],那么left++位置上的数与nums[right]也定大于nums[i]
 */
public class triangleNumber {
	 public int triangleNumber(int[] nums) {
		 Arrays.sort(nums);
		 int res=0;
		 int length=nums.length;
		 for(int i=length-1;i>=2;i--){
			 int left=0,right=i-1;
			 while(left<right){
				 if(nums[left]+nums[right]>nums[i]){
					 res+=right-left;
					 right--;
				 }else{
					 left++;
				 }
			 }
		 }
		 return res;
	 }
}
