package alogrithm.easy;

import alogrithm.medium.ListNode;

/**
 * @author created by wuwt
 * @date 2020/5/1 10:29 下午
 * 合并两个有序链表
 **/
public class mergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode head = l3;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                l3.next = l1;
                l3 =l1;
                l1 =l1.next;
            }else{
                l3.next = l2;
                l3 =l2;
                l1 =l2.next;
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
}
