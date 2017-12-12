### 题目描述

给定一个数组，返回数组中连续乘积最大的值。如[2,-5,-2,-4,3]，返回值为24。

### 思路

这道题类似之前的数组中连续相加的最大值，利用动态规划，全局最大一定是局部最大，局部最大可能是全局最大。但这道题要求是相乘，和相加又有些不同。因为连乘的话，遇到负数相乘时，乘积变小，再与一个负数相乘，乘积变为正，就会得到最大的乘积。所以这里我们需要维护一个局部最大时，还要维护一个局部最小，这样如果下一个元素遇到负数时，就有可能与这个最小相乘得到当前最大的乘积。

### 代码

```java
	public static int solution(int[] nums) {
		if(nums==null ||nums.length==0)
            return 0;
        int max=nums[0];
        int min_local=nums[0];
        int max_local=nums[0];
        for(int i=1;i<nums.length;i++){
        	int max_copy=max_local;
        	max_local=Math.max(Math.max(nums[i]*max_local, nums[i]), nums[i]*min_local);
        	min_local=Math.min(Math.min(nums[i]*max_copy,nums[i]),nums[i]*min_local);
        	max=Math.max(max,max_local);
        }
        return max;
    }
```

