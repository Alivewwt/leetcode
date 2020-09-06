package alogrithm.hard;

import alogrithm.medium.ListNode;

import java.util.PriorityQueue;

/**
 * @author created by wuwt
 * @date 2020/4/27 10:14 下午
 * 合并k个有序链表
 **/

public class mergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;
        //链表长度
//        int len = lists.length;
//        if(len==1)
//            return lists[0];
//        while(len>1){
//            int mid = (len+1)/2;
//            for(int i=0;i<len/2;i++){
//                lists[i] = mergeList(lists[i],lists[i+mid]);
//            }
//            len = mid;
//        }
//        return lists[0] ;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(ListNode node : lists){
            while(node!=null){
                queue.add(node.val);
                node = node.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while(!queue.isEmpty()){
            ListNode temp = new ListNode(queue.poll());
            tmp.next = temp;
            tmp = temp;

        }
        return res.next;

    }
    //合并两个有序链表
    public ListNode mergeList(ListNode l1,ListNode l2){
        ListNode l3 = new ListNode(-1);
        ListNode head = l3;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                l3.next = l1;
                l3=l1;
                l1.next=l1;
            }else{
                l3.next = l2;
                l3 = l2;
                l2.next = l2;
            }
        }

        if(l1!=null){
            l3.next = l1;

        }

        if(l2!=null){
            l3.next = l2;
        }
        return head.next;
    }

}
