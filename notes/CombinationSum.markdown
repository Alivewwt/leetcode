### 题目描述

题目给了一个数组candidate array 和一个target，让我们从Array里找到所有的组合，任何组合只要是它的和等于target的话，都需要找到，但是不需要重复。这道题是可以重复利用一个数字的。

```java
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

### 思路

我们需要每次都代入同一个数字，直到它之和达到target或者它超过了target，然后在倒退回去一个数字，这种情况肯定要用递归了。这里是backtracking，每次倒退回一个数字，需要继续递归下去，在倒退，一直重复直到搜索了所有的可能性。

### 代码

```java
class Solution {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
		if(candidates==null||candidates.length==0)
            return res;
        Arrays.sort(candidates);
        List<Integer> temp=new ArrayList<Integer>();
        helper(candidates,0,target,temp);
        return res;
    }
    
    public void helper(int[] nums,int index,int target,List<Integer> temp){
        if(target<0)
            return ;
        if(target==0){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            helper(nums,i,target-nums[i],temp);
            temp.remove(temp.size()-1);
        }
    }
}
```

