### 题目描述

给定一个数组，返回数组中连续和最大的值。如[-2,1,-3,4,-1,2,1,-5,4]，返回值为6。连续数组[4,-1,2,1]。

### 思路

这道题利用动态规划思想，设一个局部变量和全局变量，局部最大可能是全局最大，每次相加，如果局部最大值大于全局最大值，则将局部最大值更新为全局最大值、

### 代码

```java
	public int maxSubArray(int[] nums) {
      int res=Integer.MIN_VALUE,temp=0;
      for(int i=0;i<nums.length;i++){
        temp=Math.max(temp+nums[i],nums[i]);
        res=Math.max(temp,res);
      }
      return res;
    }
```

