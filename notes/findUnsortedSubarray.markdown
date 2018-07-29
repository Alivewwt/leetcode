### 题目描述

给定一个数组，在数组找到没有排序的最短子数组。

```
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
```

### 思路

先将数组升序排序，将排序后的数组和原数组一一比较，比较哪些元素变了，左右两边发生变化的元素的位置就是要求的子数组的长度范围。

### 代码

```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
     	int nums1=new int[nums.length];
        //复制数组
        nums1=Array.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int start=-1,end=-1;
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
```

