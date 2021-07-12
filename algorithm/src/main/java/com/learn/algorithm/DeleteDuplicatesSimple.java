package com.learn.algorithm;

/**
 * @author lianshun
 * @date 2021/7/6 4:14 下午
 * @description
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 */
public class DeleteDuplicatesSimple {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4,null);
        ListNode listNode2 = new ListNode(4,listNode1);
        ListNode listNode3 = new ListNode(4,listNode2);
        ListNode listNode4 = new ListNode(3,listNode3);
        ListNode listNode5 = new ListNode(2,listNode4);
        ListNode listNode6 = new ListNode(2,listNode5);
        ListNode listNode7 = new ListNode(1,listNode6);

        ListNode head = deleteDuplicates(listNode7);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        while (second != null){
            if(first.val == second.val){
                first.next = second.next;
            }else {
                first = second;
            }
            second = second.next;
        }
       return head;
    }
}
