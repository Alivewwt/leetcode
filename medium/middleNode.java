package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/3/23 8:30 下午
 * 返回链表中间以后的节点 长度为偶数 [1,2,3,4,5] return [3,4,5]; [1,2,3,4,5,6] return [4,5,6],
 * 快慢指针
 **/
public class middleNode {
    public  ListNode middleNode(ListNode head){
        if (head == null || head.next==null)
            return head;
//        int length = len(head);
//
//        int mid = length/2;
//        ListNode node = head;
//        int i = 0;
//        while(i<mid){
//            node = node.next;
//            i+=1;
//        }
        ListNode slow = head;
        ListNode fast = head;
        // 奇数，快节点指向末尾；
        //偶数，快节点指向NULL
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static int len(ListNode head){
        int i = 0;
        ListNode node = head;
        while(node!=null){
            i+=1;
            node = node.next;
        }
        return i;
    }

}
