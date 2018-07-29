### 题目描述

这道题给我们一个数组，让我们统计前k个高频的数字，对于统计数字的问题，我们应该考虑用HashMap来做，建立数字和其出现次数的映射，然后按照出现次数进行排序。我们可以用堆排序来做，也可以用桶排序来做，在建立好数字和其出现次数的映射后，我们按照其出现次数将数字放到对应的位置中去，这样我们从桶的后面向前遍历，最先得到的就是出现次数最多的数字，我们找到k个后返回即可。

### 思路

1. #### 桶排序

### 代码

```java
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k){
    	List<Integer> rs=new ArrayList<Integer>();
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int count=map.get(nums[i])+1;
                map.put(nums[i],count);
            }else{
                map.put(nums[i],1)
                    
            }
        }
        //一个数出现的最多次数为nums.length,所有桶的大小为nums.length+1
        List<Integer>[] bucket=new List[nums.length+1];
        for(int key:map.keySet()){
			int count=map.get(key);
            if(bucket[count]==null)
                bucket[count]=new ArrayList<Integer>();
            bucket[count].add(key);
        }
        for(int i=nums.length;i>0;i--){
			if(bucket[i]!=null &&res.size()<k)
                res.addAll(bucket[i]);
        }
        return res;
    }
}
```

