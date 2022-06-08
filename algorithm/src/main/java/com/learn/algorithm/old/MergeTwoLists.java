package com.learn.algorithm.old;

/**
 * @author lianshun
 * @date 2021/6/11 10:45 上午
 * @description
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(4, null);
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode1 = new ListNode(2, listNode2);

        ListNode listNode6 = new ListNode(5, null);
        ListNode listNode5 = new ListNode(4, listNode6);
        ListNode listNode4 = new ListNode(3, listNode5);

        ListNode a = mergeTwoLists(listNode1, listNode4);
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode();
        ListNode first = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        if (l1 == null && l2 != null) {
            result.next = l2;
        } else if (l1 != null && l2 == null) {
            result.next = l1;
        }
        return first.next;
    }
}
