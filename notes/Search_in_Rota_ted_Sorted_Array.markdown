### 题目描述

假设按照升序排列的数组在事先未知的某个节点上旋转。

如(0,1,2,4,5,6,7可能变成 4,5,6,7,0,1,2)。

给你一个目标值来搜索。如果在数组中发现它则返回索引，否则返回-1。

假定数组中没有重复。

### 思路

这道题是二分查找的变体，看似麻烦，其实清理一下还是比较简单的。因为反转的缘故，当我们切取一半的时候可能会出现误区，所以我们要做进一步的判断。具体来说，假设数组是$A$，每次左边缘$l$，右边缘$r$，还有中间位置是$m$。在每次迭代中，分三种情况:

1. 如果$target==A[m]$，那么$m$就是我们要的结果，直接返回；
2. 如果$A[m]<A[r]$，那么说明从$m$到$r$一定是有序的(没有受到反转的影响)，那么我们只需判断target是不是在$m$到$r$之间，如果是则把左边缘移到$m+1$,否则就$target$在另一半，即右边缘移到$m-1$；
3. 如果$A[m]>=A[r]$，那么说明从$l$到$m$一定是有序的，同样只需要判断$target$是否在这个范围内，相应的移动边缘即可。根据以上方法，每次我们都可以切掉一半的数据，所有算法的时间复杂度是$O(log(n))$，空间复杂度是$O(1)$。

### 代码

```java
 public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target)
                return mid;
           else if(nums[mid]<nums[r])
           {
                if(nums[mid]<target&&nums[r]>=target)
                    l=mid+1;
               else
                   r=mid-1;
           }
            else{
                if(nums[mid]>target&&nums[l]<=target)
                   r=mid-1;
                else
                   l=mid+1;
            }
        }
        return -1;
    }
```

