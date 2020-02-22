package algorithm.easy;

/**
 * @author wuwt
 * @date 2020-02-01
 * 合并两个有序列表
 **/
public class mergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null)
            return l1;
        else if (l2==null)
            return l2;
        else if(l1==null && l2==null)
            return null;
        ListNode l3 = new ListNode(-1);
        ListNode head =  l3;
        while(l1.next!=null && l2!=null){
            if (l1.val<=l2.val){
                l3.next =l1;
                l3 = l1;
                l1 = l1.next;
            }else{
                l3.next = l2;
                l3 = l2;
                l2 = l2.next;
            }

        }
        while(l1!=null){
            l3.next = l1;
            l3 = l1;
            l1 =l1.next;
        }
        while(l2!=null){
            l3.next = l2;
            l3 = l2;
            l1 =l2.next;
        }
        return head.next;
    }
}
