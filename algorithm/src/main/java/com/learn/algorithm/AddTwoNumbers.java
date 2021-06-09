package com.learn.algorithm;

public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode listNode3 = new ListNode(3,null);
        ListNode listNode2 = new ListNode(4,listNode3);
        ListNode listNode1 = new ListNode(2,listNode2);

        ListNode listNode6 = new ListNode(4,null);
        ListNode listNode5 = new ListNode(6,listNode6);
        ListNode listNode4 = new ListNode(5,listNode5);

        addTwoNumbers(listNode1,listNode4);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        if(l1.next!=null && l2.next!=null){

        }
        return null;
    }
}


 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }