package project.leetcode;

/*
 * 归并排序
 * 合并多个有序列表
 * 最容易想到的方法是“归并排序”:将两个或两个以上的有序表组合成一个新的有序表，无论是顺序存储还是链式存储结构，对于任何两个长度分别为m
 * 和n的有序表，其组合都可在O(m+n)的时间复杂度量级上完成。对于k个有序表，假设共有N个元素，且这些有序表初始状态都不为空，每个有序表平均
 * 拥有N/K个元素。最常用的的是采用“二分”的思想进行两两合并。第一轮循环，有序表list[0]与list[(k+1)/2],list[1]与list[(k+1)/2+1]
 * ...这样k个有序表就被组合成了k/2个有序表，第二轮循环后就将减少为k/4个有序表；直到组合成一个具有N个元素的有序表。总的时间复杂度：O(NKlogK)
 */
public class MergeKList {
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
}
