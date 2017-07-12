package project.leetcode;

import java.util.Arrays;

public class missingNumber {
	 public int missingNumber(int[] nums) {
	        Arrays.sort(nums);
	       int i=0;
	       //0,1,3
	       // 1
	       for(;i<nums.length;i++){
	    	   if(i!=nums[i])
	    		   return i;
	       }
	       //0,1,2
	       if(i==nums.length)
	    	   return i;
	       
	        return 0;
	    }
}
