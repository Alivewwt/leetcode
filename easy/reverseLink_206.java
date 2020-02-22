package algorithm.easy;

/**
 * @author wuwt
 * @date 2020-01-12
 * 反转链表 input[1->2->3->4->5->NULL] output [5->4->3->2->1->NULL]
 **/
public class reverseLink_206 {
    public ListNode reverseList(ListNode head) {
        if (head==null ||head.next==null)
            return head;
        ListNode pre = head.next;

        head.next = null;
        while(pre!=null){
            ListNode tail = pre.next;
            pre.next = head;
            head = pre;
            pre = tail;
        }
         return head ;
    }
}
