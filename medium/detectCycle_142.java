package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/8/30 7:52 下午
 * 环形链表
 **/
public class detectCycle_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(true){
            if(fast==null ||fast.next==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;

            if (fast==slow)
                break;
        }
        //第二次相遇
        fast = head;
        while(fast!=slow){
            fast= fast.next;
            slow= slow.next;
        }
        return fast;
    }
}
