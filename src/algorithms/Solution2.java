package algorithms;

import java.lang.Math;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        BigInteger val1 = this.decodeValue(l1);
//        BigInteger val2 = this.decodeValue(l2);
//        BigInteger sum = val1.add(val2);
//        System.out.println("sum = " + sum);
//        return encodeValue(sum);

        /*
        使用链表的操作方式
        2017-2-20
         */
        int pre = 0;
        ListNode head = null;
        ListNode point = null;
        while (null != l1 || null != l2) {
            ListNode newL = new ListNode(0);
            if (l1 == null && null != l2) {
                newL.val = (l2.val + pre) % 10;
                pre = (l2.val + pre) / 10;
                l2 = l2.next;

            } else if (null != l1 && l2 == null) {
                newL.val = (l1.val + pre) % 10;
                pre = (l1.val + pre) / 10;
                l1 = l1.next;

            } else if (null != l1 && null != l2) {
                newL.val = (l1.val + l2.val + pre) % 10;
                pre = (l1.val + l2.val + pre) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }

            //建立指向
            if (head == null) {
                head = newL;
                point = head;
            } else {
                point.next = newL;
                point = newL;
            }

        }
        if (0 != pre)
            point.next = new ListNode(pre);
        return head;


        /*
        思想正确，代码还可以简略！
         */
    }

    //自定义的内部数据结构
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    private void printListNode(ListNode listNode) {
        int i = 0;
        while (null != listNode) {
            System.out.println("No." + i);
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
            i++;
        }
    }

    /*
    官方解答
     */
    private ListNode bestSolution(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        Solution2 s2 = new Solution2();
        s2.printListNode(s2.addTwoNumbers(l1, l2));

    }
}