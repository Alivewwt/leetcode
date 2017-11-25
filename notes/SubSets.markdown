### 题目描述

给定一个不重复的数组，找出其中所有可能的子数组。

举例:

给定数组$nums=[1,2,3]$，结果是

```tex
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

### 思路

本题采用回溯算法实现，回溯算法的基本形式是“递归+循环”，正因为循环中嵌套着递归，递归中包含循环，这才使得回溯比一般的递归和单纯的循环更难理解。原数组中的每个元素有两种状态:存在和不存在。

1. 外层循环逐一往中间集合temp中加入元素nums[i]，使这个元素处于存在状态
2. 开始递归，递归中携带加入新元素的temp，并且下一次循环的起始是$i$元素的下一个，因而递归中更新$i$值为$i+1$
3. 将这个从中间集合temp中移除，使该元素处于不存在状态

### 代码

```java
  public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> res=new ArrayList<Integer>();
        bp(list,res,nums,0);
        return list;
    }
    public void bp(List<List<Integer>> list,List<Integer> temp,int[] nums,int start){
        list.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            bp(list,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
```

