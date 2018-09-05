### 题目描述

>输入n个整数，找出其中最小的k个数。例如输入4,5,1,6,2,7,3,8这8个数，则最小的4个数字是1,2,3,4

### 思路

>1.
>
>- 利用快速排序划分的思想，每一次划分就会有一个数字位于以数组从小到大排列的最终位置index。
>
>- 位于index左边的数字都小于index对应的值，右边都大于index指向的值
>- 所以，当Index>k-1时，表示k个最小数字一定在Index的左边，此时，只需要对index的左边进行划分即可；
>- 当Index<k-1时，说明index及index左边数字还没满足k个数字，需要继续对k右边进行划分。
>
>2.
>
>- 可以先创建有一个大小为k的数据容器来存储最小的k个数字，从输入的n个整数中一个一个读入放入该容器中，如果容器中的数字少于k个，按题目要求直接返回空。
>- 如果容器中已有k个数字，而数组中还有值未加入，此时就不能直接插入了，而需要替换容器中的值。按以下步骤进行插入：
>  - 先找到容器中最大的值
>  - 将待插入值和最大值比较，如果待插入值大于容器中的最大值，则直接舍弃这个待插入值即可；如果待插入值小于容器中的最小值，则用这个待插入值替换掉容器中的最大值
>  - 重复上述步骤，容器中最后就是整个数组的最小k个数字。
>
>



### 代码

```java
import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(input==null||input.length==0||input.length<k||k<=0){
             return res;
        }
            
         int start  = 0;
        int end = input.length-1;
        int index = partition(input, start, end);
        //一直循环知道找到第k个位置正确的数。
        while (index != k - 1) {
            if (index > k - 1) {
                end = index-1;
                //index = partition(input, start, end);
            } else {
                start = index+1;
               
            }
              index = partition(input, start, end);
 
        }
 
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
 
        return res;
    }
      
    public static int partition(int input[],int start,int end){
        int tmp = input[start];
        while (start < end) {
            while (start < end && input[end] >= tmp) {
                end--;
            }
            input[start] = input[end];
            while (start < end && tmp >= input[start]) {
                start++;
            }
            input[end] = input[start];
        }
        input[start] = tmp;
        return start;
    }
}

```

```java
public static ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {
        if(input == null)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>(k);
        if(k > input.length)
            return list;
        TreeSet<Integer> tree = new TreeSet<Integer>();
        for(int i = 0 ; i < input.length; i++){
            tree.add(input[i]);
        }
        int i = 0;
        for(Integer elem : tree){
            if(i >= k)
                break;
            list.add(elem);
            i++;
        }
        return list;
    }
```

