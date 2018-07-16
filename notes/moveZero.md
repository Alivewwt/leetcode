### 题目描述

给定一个数组，将'0'元素放置到数组的后面，且不改变数组的相对顺序。不能开辟空间。

举例:

数组[0,1,0,3,12]

返回[1,3,12,0,0].

### 思路

这是道简单题，主要是在原数组上进行移动操作，设置两个变量i，j，遍历一遍数组，遇到不为零的元素，放在数组的前面，i++，遇到'0'，j++，继续遍历。

### 代码

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int a[]=new int[nums.length];
        int k=0,n=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                a[k++]=nums[i];
            }else{
                n++;
                a[nums.length-n]=0;
            }
        }
        for(int i=0;i<a.length;i++)
            nums[i]=a[i];
    }
}
```
