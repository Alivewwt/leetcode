package project.leetcode;

/*
*题目:https://leetcode.com/problems/merge-two-sorted-lists/description/
*合并两个有序的链表
*解题思路：新建一个链表作为合并后的新链表，依次比较两个链表，如果l1的val小于等于l2的val,则将l1的节点链接到l3上去
*否则将l2的节点链接到l3上，循环到结束，将未遍历结束的链表直接链接到l3上去，至此算法过程结束
*
*/
public class MergeTwoList {

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
		while(l1!=null){
			l3.next=l1;
			l3=l1;
			l1=l1.next;
		}
		while(l2!=null){
			l3.next=l2;
			l3=l2;
			l2=l2.next;
		}	
		    
		return head.next;
	}
}
