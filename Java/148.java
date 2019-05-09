__________________________________________________________________________________________________
3ms
class Solution {
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }

        ListNode f = head, s = head, pre = null;
        while(f != null && f.next != null){
            pre = s;
            s = s.next;
            f = f.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(s);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(l != null && r != null){
            if(l.val <= r.val){
                cur.next = l;
                l = l.next;
                cur = cur.next;
            } else {
                cur.next = r;
                r = r.next;
                cur = cur.next;
            }
        }
        if(l != null){
            cur.next = l;
        }
        if(r != null){
            cur.next = r;
        }
        return dummyHead.next;
    }
}
__________________________________________________________________________________________________

__________________________________________________________________________________________________
