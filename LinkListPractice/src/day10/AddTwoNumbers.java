package day10;

import main.ListNode;

//两数之和
public class AddTwoNumbers {
    //    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//    请你将两个数相加，并以相同形式返回一个表示和的链表。
//    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(), l = result;
        int add = 0, sum = 0, tmp = 0;//add是进位，sum是每一位数的相加之和
        while (l1 != null || l2 != null) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += add;
            tmp = sum % 10;
            add = sum / 10;//进位
            //新的结点
            ListNode node = new ListNode(tmp);
            l.next = node;
            l = node;
        }
        if (add == 1) {
            //新的结点
            ListNode node = new ListNode(1);
            l.next = node;
            l = node;
        }
        return result.next;
    }
}

