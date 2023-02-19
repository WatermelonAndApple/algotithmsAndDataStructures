package com.gtldys.linklist;

import java.util.ArrayList;

public class ReverseList {
    //反转链表
    //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    public static void main(String[] args) {
        //head=[1,2,3,4,5]   ,    预期结果[5,4,3,2,1]
        ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        //head=[1,2]   ,    预期结果[2,1]
        ListNode t1=new ListNode(2);
        ListNode t2=new ListNode(1,t1);
        //head=[] , 预期结果 []
        SolutionReverseList s=new SolutionReverseList();
        s.printList(s.reverseList1(n1));
        s.printList(s.reverseList1(t2));
        s.printList(s.reverseList1(null));
    }
}
class SolutionReverseList {
    //暴力破解法，直接通过两次遍历进进反转链表,第一次按照顺序记录链表中的数据，
    // 第二次记录的数据按照相反的顺序给链表进行赋值
    public ListNode reverseList(ListNode head) {
        ListNode curNode=head;
         int linkListLength=0;
        ArrayList<Integer> list=new ArrayList<>();
         while (curNode!=null){
             list.add(curNode.val);
             curNode=curNode.next;
             linkListLength++;
         }
         curNode=head;
         while (curNode!=null){
             curNode.val=list.get(--linkListLength);
             curNode=curNode.next;
         }
        return head;
    }
    //使用递归的方法，
    public ListNode reverseList1(ListNode head) {
        //链表没有结点或者只存在一个结点时
        if(head==null || head.next == null){
            return head;
        }
        ListNode result= reverseList1(head.next);
        head.next.next=head;
        head.next=null;
        return result;
    }
    public void printList(ListNode list){
        while (list!=null){
            System.out.print(list.val+"\t");
            list=list.next;
        }
        System.out.println("结束了！");
    }
}

