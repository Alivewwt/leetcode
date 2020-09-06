package alogrithm.medium;

import java.util.Stack;

/**
 * @author created by wuwt
 * @date 2020/4/14 9:28 下午
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 不准反转，借助栈保存链表
 **/
public class addTwoNumbers_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode pre = l1;
        while(pre!=null){
            s1.push(pre);
            pre = pre.next;
        }
        pre = l2;
        while (pre!=null){
            s2.push(pre);
            pre = pre.next;
        }
        int add =0;
        while(!s1.isEmpty()&&!s2.isEmpty()){
            int sum = add+ s1.pop().val+s2.pop().val;
            add = sum/10;
            int v = sum%10;
            ListNode node = new ListNode(v);
            node.next = dummy.next;
            dummy.next = node;
        }

        while(!s1.isEmpty()){
            int sum = add+ s1.pop().val;
            int v = sum%10;
            add = sum/10;

            ListNode node = new ListNode(v);
            node.next = dummy.next;
            dummy.next = node;
        }

        while(!s2.isEmpty()){
            int sum = add+ s2.pop().val;
            int v = sum%10;
            add = sum/10;

            ListNode node = new ListNode(v);
            node.next = dummy.next;
            dummy.next = node;
        }
        if(add!=0){
            ListNode node = new ListNode(add);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;

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
