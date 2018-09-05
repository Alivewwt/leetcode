### 题目描述

给定一个数组，将数组分成两部分，使得数组两部分的和相等。

举例:

给定数组$nums=[1, 5, 11, 5]$，结果是

>可以分成$[1,5,5]$和$[11]$两个数组。

### 思路

>这个问题看起来还是有一些难度的，实际上是一个01背包问题，通过动态规划来解决。把数字看成是物品，数字的值看成是价值，重量不限，目标也不太一样，需要确定是否能够达到价值加起来是否能达到总和的一半。
>
>具体的来说，
>
>我们要先有一个Boolean数组dp[]，用来存储对应的数值能不能通过加这些数字得到，数组的大小就是总和的一半，记作target，然后从小到大来判断是否能达到，最终返回dp[target]的值即可，如果为true，则说明能够通过数字的加和得到总和的一半。
>
>接下来，我们通过两种循环依次来判断基于前i个数，能凑成总和是哪些，如果可以凑成，那么将dp对应的位置设置为true即可。具体的方法集合背包问题非常相似了。

### 代码

```java
public class Solution {
	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0) {
			return true;
		}
		int target = 0;
		Arrays.sort(nums);
		for (int num : nums) {
			target += num;
		}
		if (target % 2 != 0) {
			return false;
		}
		volumn /= 2;
		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		for (int i = 1; i <= nums.length; i++) {
			for (int j = target; j >= nums[i - 1]; j--) {
				dp[j] = dp[j] || dp[j - nums[i - 1]];
			}
		}
		return dp[target];
	}
}
```

