### 题目描述

给定一个数组，在一列数组中取出一个或多个不相邻数，使其和最大。

### 思路

对于这类求极值的问题首先考虑动态规划，我们维护一个一维数组dp,其中dp[i]表示到i位置时不相邻数能形成最大和。我们先拿一个简单的例子来分析一下，比如说nums[3,2,1,5]，那么我们来看我们的dp数组应该是什么样的，首先dp[0]=3没啥疑问，再看dp[1]是多少呢？由于3比2大，所以我们选择第一个数，当前房子的2不抢，所以dp[1]=3，那么再来dp[2]，由于不能选择相邻的，所以我们可以在前面的一个的dp值加上当前的房间值，和当前房间的前面一个dp值比较，取较大值做当前的dp的值，所以我们可以得到递推式dp[i]=max(nums[i]+dp[i-2],dp[i-1]),由此看出我们需要初始化dp[0]和dp[1]，其中dp[0]即为nums[0],dp[1]此时应该为max(nums[0],nums[1])。

### 代码

```java
class Solution {
    public int rob(int[] nums) {
      if(nums==null||nums.length<=1)
        return nums.length==0?0:nums[0];
      int dp[]=new int[nums.length];
      dp[0]=nums[0];
      dp[1]=nums[0]>nums[1]?nums[0]:nums[1];
      if(nums.length==2)
        return money[1];
      for(int i=2;i<nums.length;i++){
        dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
      }
      return dp[nums.length-1];
    }
}
```

