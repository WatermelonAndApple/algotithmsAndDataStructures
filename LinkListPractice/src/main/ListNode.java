package main;

public class ListNode {//链表
    public int val;//值
    public ListNode next;//下一个结点

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}