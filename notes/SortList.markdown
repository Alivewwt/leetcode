题目描述

给定一个链表，对链表进行排序，要求时间复杂度在$O(nlogn)$。

### 思路

这道题跟Insertion sort list 类似，要求我们用$O(nlogn)$算法对链表进行排序，但是并没有要求用哪一种排序算法，我么可以使用归并排序，快速排序，堆排序等满足要求的方法来实现。对这道题比较容易想到的是归并排序，因为之前有merge Two Sorted Lists，这是一个归并排序。剩下我们需要做的就是每次找到中点，然后对于左右进行递归，最后用Merge Two Sorted Lists 把它们合并起来。

### 代码

```java
 public ListNode getMiddle(ListNode node){
        ListNode slow=node;
        ListNode fast=node;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head==null|| head.next==null)
            return head;
        ListNode middle=getMiddle(head);
        ListNode next=middle.next;
        middle.next=null;
        return mergeList(sortList(head),sortList(next));
    }
    public ListNode mergeList(ListNode l1,ListNode l2){
        ListNode l3=new ListNode(-1);
        ListNode head=l3;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                head.next=l1;
                l1=l1.next;  
            }else{
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        if(l1!=null)
            head.next=l1;
       if(l2!=null)
           head.next=l2;
        return l3.next;
    }
```

