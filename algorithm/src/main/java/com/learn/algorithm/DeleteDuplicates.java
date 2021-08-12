package com.learn.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class DeleteDuplicates {
    public static void main(String[] args) {
        /*ListNode listNode1 = new ListNode(5,null);
        ListNode listNode2 = new ListNode(4,listNode1);
        ListNode listNode3 = new ListNode(4,listNode2);

        ListNode listNode4 = new ListNode(3,listNode3);*/
        ListNode listNode5 = new ListNode(2, null);
        ListNode listNode6 = new ListNode(2, listNode5);
        ListNode listNode7 = new ListNode(1, listNode6);
        deleteDuplicates(listNode7);
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        ListNode reNode = null;
        ListNode first = null;
        for (ListNode node = head; node != null; node = node.next) {
            if (!map.containsKey(node.val)) {
                map.put(node.val, 1);
            } else {
                map.put(node.val, map.get(node.val) + 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                if (reNode == null) {
                    reNode = new ListNode(key, null);
                    first = reNode;
                } else {
                    reNode.next = new ListNode(key, null);
                    reNode = reNode.next;
                }

            }
        }
        return first;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode reNode = new ListNode();
        ListNode startNode = reNode;
        ListNode first = head;
        if (head == null) {
            return head;
        }
        if (first == head && (first.next == null || (first.val != first.next.val))) {
            reNode.next = new ListNode(first.val, null);
            reNode = reNode.next;
        }
        for (; first.next != null; first = first.next) {

            if ((first.next.next == null && first.next.val != first.val)
                    || (first.next.val != first.val && first.next.val != first.next.next.val)) {
                reNode.next = new ListNode(first.next.val, null);
                reNode = reNode.next;

            }
        }
        return startNode.next;
    }
}

