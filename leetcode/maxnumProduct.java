package project.leetcode;

import java.util.Arrays;

public class maxnumProduct {
	public int maximumProduct(int[] nums) {
		int res=Integer.MIN_VALUE;
		if(nums.length==3)
			return res=nums[0]*nums[1]*nums[2];
		Arrays.sort(nums);
		int length=nums.length;
		int a=nums[length-1]*nums[length-2]*nums[length-3];
		int b=nums[0]*nums[1]*nums[length-1];
        return res=a>b?a:b;
	}
}
