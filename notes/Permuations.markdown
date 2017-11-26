### 题目描述

给定一个数组，返回其所有可能的排列。

举例:

数组[1,2,3]

返回全排列数组`[1,2,3]`, `[1,3,2]`, `[2,1,3]`, `[2,3,1]`, `[3,1,2]`, 和`[3,2,1]`.

### 思路

这道是求全排列问题，给定的输入数组没有重复项。跟Combinations一样，是个NP难题。方法还是原来的套路，用一个循环递归处理子问题。区别是这里并不是一直往后推进的，前面的数有可能放到后面，我们需要维护一个visited数组来表示该元素是否已经在当前结果中，因为我们每次取一个元素放入结果，然后递归剩下的元素，所有不会出现重复。

### 代码

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs=new ArrayList<List<Integer>>();
        List<Integer> item =new ArrayList<Integer>();
        boolean[] visited=new boolean[nums.length];
        bp(nums,rs,item,visited);
    return rs;
    }
    
    public void bp(int[] nums,List<List<Integer>> rs,List<Integer> item,boolean[] visited){
        if(item.size()==nums.length){
            rs.add(new ArrayList(item));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                item.add(nums[i]);
                visited[i]=true;
                bp(nums,rs,item,visited);
                item.remove(item.size()-1);
                visited[i]=false;
            }
        }
    }
}
```

