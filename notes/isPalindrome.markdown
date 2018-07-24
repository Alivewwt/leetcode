### 题目描述

判断一个链表是否是回环链表

举例:

```
Input: 1->2
Output: false
```

```
Input: 1->2->2->1
Output: true
```

### 思路

将链表的后半部分入栈，链表先进后出。将栈里的元素一一出栈，然后与链表的前部分一一比较。若不相等，则该链表不是回环链表。

### 代码

```java
public boolean isPalindrome(ListNode head) {
 	if(head==null||head.next==null)
        return true;
    ListNode first=head.next;
    ListNode next=head;
    while(next.next!=null&&next.next.next!=null){
        first=first.next;
        next=next.next.next;
    }
    
    Stack<ListNode> stack=new StackNode<ListNode>();
    while(first!=null){
        stack.push(first.val);
        first=first.next;
    }
    
    while(!stack.isEmpty()){
        if(stack.pop()!=head.val)
            return false;
        head=head.next;
    }
    return true;
}
```

