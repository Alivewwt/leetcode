### 题目

将$K$个有序链表合并成一个有序链表。

### 思路

将$K$个链表合并，使用归并排序，就是分治法，是一个比较经典的$O(nlogn)$的排序算法。思路是先分成两个子任务，然后递归求子任务，最后回溯回来。这个题目也是这样，先把$K$个list分成两半，然后继续划分，直到剩下两个list合并起来。

### 代码

```java
	public ListNode mergeTwoList(ListNode l1,ListNode l2 ){
		ListNode l3=new ListNode(-1);
		ListNode head=l3;
		while(l1!=null&&l2!=null){
			if(l1.val<=l2.val){
				l3.next=l1;
				l3=l1;
				l1=l1.next;
			}
			else {
				l3.next=l2;
			    l3=l2;
			    l2=l2.next;
			}	
		}
		if(l1!=null){
			l3.next=l1;
		
		}
		if(l2!=null){
			l3.next=l2;
		}	
		return head.next;
	}
	
	 public ListNode mergeKLists(ListNode[] lists) {
		 if(lists==null||lists.length==0)
	    		return null;
	     int len=lists.length;
	     if(len==1)
	        return lists[0];
	   while(len>1){
	       int mid=(len+1)/2;
	       for(int i=0;i<len/2;i++){
	           lists[i]=mergeTwoList(lists[i],lists[i+mid]);
	       }
	       len=mid;
	   }
		 return lists[0];
	 }
```

