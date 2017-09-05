package project.leetcode;

/*
* 题目；https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
* 移除数组中重复元素，在原始数组中进行操作，从第一位数字开始比较，比较数组两个相邻位置的数，
* 如果不相等，就把数字拿出来赋给数组中新的位置上，否则继续比较。
*
*/
public class rmDuplicate {
	 public int removeDuplicates(int[] nums) {
		 
		 if(nums.length==0)
			 return 0;
		 int index=0;
	        for(int i=1;i<nums.length;i++){
	            if(nums[index]!=nums[i])
	            	nums[++index]=nums[i];
	        }	        
	        return index+1;
	    }
}
