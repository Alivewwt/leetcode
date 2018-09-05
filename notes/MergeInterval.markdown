### 题目描述

题目给定若干个数组，让我们将有交集的数组合并，例如【1,3】，【2,6】则合并成[1,6]。而且给定的数组是无序的。所以我们需要先将数组区间集排序。由于我们要排序的是个结构体，所以我们要定义自己的comparator,才能用sort排序，我们以start的值从小到大来排序，排完序我们就可以开始合并了，首先要将第一个区间存入结果中，然后从第二个开始遍历区间集，如果有重叠，将结果中最后一个区间的end值更新为结果中最后一个区间的end和当前end 值之中的较大值，然后继续遍历区间集，一次类推可以得到最终结果。

### 思路

先排序，然后检查相邻两个区间，看前一个区间 的结尾是否大于后一个区间的开始，注意前一个区间包含后一个区间的情况。

### 代码

```java
public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
  	if(intervals==null||intervals.size()==0)
        return intervals;
      Collections.sort(intervals,new Comparator<Interval>(){
          @Override
          public int compare(Interval o1,Interval o2){
          return o1.start-o2.start;//升序排列    
          }
})；
          int size=intervals.size();
      int i=0,index=0;
      while(i<size){
		index=i+1;
          if(inedx<size){
    							if(intervals.get(i).end>=intervals.get(index).end){
			intervals.remove(index);
                  size=size-1;
              }
else if(intervals.get(i).end>=intervals.get(index).start){
                  intervals.get(i).end=intervals.get(index).end;
    intervals.remove(index);
    size=size-1;
  }
     else{
                  i++;
              }
          }
          else 
              break;
      }
      return intervals;
  }
    }
```

