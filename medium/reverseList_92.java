package alogrithm.medium;


/**
 * @author created by wuwt
 * @date 2020/3/25 9:26 下午
 * 1->2->3->4->5  => 1->4->3->2->5
 **/
public class reverseList_92 {
    public static ListNode reverseList(ListNode head,int m,int n){
        if(head==null ||head.next==null|| m>n)
            return head;
        ListNode dumpy1 = new ListNode(0);
        ListNode dumpy2 = new ListNode(0);
        dumpy1.next = head;
        ListNode pre = dumpy1;
        int i = 0;
        //找到前置节点
        while(++i<m){
            pre = pre.next;
        }
        //拆分链表
        int k = n-m+1;
        //pre ->1
        while(k-->0){
            //1->2,1->3,1->4,
            ListNode node = pre.next;
            pre.next = node.next;

            node.next = dumpy2.next;
            dumpy2.next = node;

        }
       // dumpy2 0->4->3->2
        // 插入节点
        while (dumpy2.next!=null){
            ListNode node = dumpy2.next;
            dumpy2.next = node.next;

            node.next = pre.next;
            pre.next = node;
            pre = pre.next;
        }

        return dumpy1.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        ListNode pre = reverseList(l1,2,4);
        while(pre!=null){
            System.out.println(pre.val);
            pre = pre.next;
        }

    }

}
