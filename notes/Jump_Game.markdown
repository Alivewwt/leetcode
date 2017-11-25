### 题目描述

题目说的是一个非负整数的数组，每个数字表示在当前位置的基础上最多可以走的步数，求判断能不能到达最后一个位置，ps(我以为是必须刚好到达最后一个位置，超过了不算，理解题意有误)。

举例:

A = `[2,3,1,1,4]`, return `true`.

A = `[3,2,1,0,4]`, return `false`.

### 思路

这题实际考察的是贪心策略，局部最优也是全局最优。顺序扫描数组，记录下能到达的最远的位置。局部最优local=A[i]+i,而全局最优则是global=Math.max(global,local)。只需一次遍历时间复杂度是$O(n)$，而空间上是$O(1)$。

### 代码

```java
public boolean canJump(int[] nums) {
        int length=nums.length;
        int reach=0;
        int i=0;
        for(;i<length&&i<=reach;i++){
            reach=Math.max(reach,i+nums[i]);
        }
   return reach>=length-1;
}
```

