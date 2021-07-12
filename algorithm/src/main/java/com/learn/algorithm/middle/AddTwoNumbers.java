package com.learn.algorithm.middle;



/**
 * @author lianshun
 * @date 2021/7/12 3:13 下午
 * @description
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.next == null && l1.val == 0){
            return l2;
        }
        if(l2.next == null && l2.val == 0){
            return l1;
        }
        ListNode result = new ListNode();
        ListNode head = result;
        int flag = 0;
        while (l1 != null && l2 != null){
            int val = l1.val + l2.val + flag;
            if(val < 10){
                result.next = new ListNode(val,null);
                result = result.next;
                flag = 0;
            }else{
                result.next = new ListNode(val%10,null);
                result = result.next;
                flag = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if(flag == 1){
            if(l1 != null){
                while (flag != 0 && l1 != null){
                    int val = l1.val + flag;
                    if(val >= 10){
                        result.next = new ListNode(val%10,null);
                        result = result.next;
                        l1 = l1.next;
                    }else{
                        result.next = new ListNode(val,null);
                        result = result.next;
                        l1 = l1.next;
                        flag = 0;
                    }
                }
            }


            if(l2 != null){
                while (flag != 0 && l2 != null){
                    int val = l2.val + flag;
                    if(val >= 10){
                        result.next = new ListNode(val%10,null);
                        result = result.next;
                        l2 = l2.next;
                    }else{
                        result.next = new ListNode(val,null);
                        result = result.next;
                        l2 = l2.next;
                        flag = 0;
                    }
                }
            }
        }

        if(flag == 1){
            result.next = new ListNode(1,null);
            flag = 0;
        }

        if(l1 != null) result.next = l1;
        if(l2 != null) result.next = l2;

        return head.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
