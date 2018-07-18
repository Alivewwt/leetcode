### 题目

将两个有序链表合并成一个有序链表。

### 思路1

创建一个新的链表$C$，分别遍历两个链表，若链表$A$的节点值小于链表$B$的节点值，则将链表A的节点断开，链接到链表$C$上，否则将链表$B$的节点链接到C上，一直遍历到两个链表都为空。至此，两个链表合并结束。

### 代码1

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
	

```

### 思路2

可以考虑递归，递归简单，代码简洁。

```java
	public ListNode mergeTwoList(ListNode l1,ListNode l2 ){
		if(l1==null)
          return l2;
      	if(l2=null)
          return l1;
      ListNode l0=l1.vla<=l2.val?l1:l2;
      l0.next=l1.val<=l2.val?mergeTwoList(l1.next,l2):mergeTwoList(l1,l2.next);
      return l0;
	}
```

