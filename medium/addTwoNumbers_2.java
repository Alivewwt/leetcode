package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/13 9:47 下午
 **/
public class addTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null)
            return null;
        ListNode  head = new ListNode(0);
        ListNode pre = head;
        int add =0;
        while(l1 !=null && l2!=null){
            int sum = l1.val+l2.val+add;
            int val = sum%10;
            add = sum/10;
            pre.next = new ListNode(val);;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            int sum = add+l1.val;
            int val = sum%10;
            add = sum/10;

            pre.next = new ListNode(val);
            pre = pre.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int sum = add+l2.val;
            int val = sum%10;
            add = sum/10;

            pre.next = new ListNode(val);
            pre = pre.next;
            l2 = l2.next;
        }
        if(add!=0)
            pre.next = new ListNode(1);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        node1.next = null;
        node2.next = node3;
        node3.next = null;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node4.next = null;
        node5.next = null;

//        node6.next = null;

        ListNode res =new addTwoNumbers_2().addTwoNumbers(node1,node4);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
