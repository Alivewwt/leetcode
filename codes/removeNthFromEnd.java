package project.leetcode;

/*
 * 题目:https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * 删除链表中倒数第n个位置上节点
 * 我们可以设两个指针，一个快指针，一个慢指针，快指针先向后遍历n个节点，慢指针从头结点开始遍历，当快指针遍历到链表末尾时，
 * 慢指针刚好遍历到(len-n)的位置，即倒数第n个节点的前一个节点；最后删除倒数第n个节点。
 */
public class removeNthFromEnd {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(n<=0)
			return null;
		ListNode node=head;
        ListNode first=new ListNode(-1);
        first.next=head;
        ListNode preDelte=first;
 
        int i=0;
        /*
        while(i<n){
        	if(head==null)
        		return null;
        	head=head.next;
        	i++;
        }      
        while(head!=null){
        	head=head.next;
        	preDelte=preDelte.next;
        }
        preDelte.next=preDelte.next.next;
 */
        while(head!=null){
        	if(i<n)
        		i++;
        	else{
        		preDelte=preDelte.next;
        	}
        	head=head.next;
        }
        preDelte.next=preDelte.next.next;
        return first.next;
    }
	
	
}
