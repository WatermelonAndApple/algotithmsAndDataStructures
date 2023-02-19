package com.gtldys.linklist;

public class DeleteDuplicatesDataInLinkList {
    //删除重复的链表元素
    //给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
    public static void main(String[] args) {
        //head=[1,1,2],结果：[1,2]
        ListNode n1 =new ListNode(2);
        ListNode n2=new ListNode(1,n1);
        ListNode head=new ListNode(1,n2);

        //head=[1,1,2,3,3],结果,[1,2,3]
        ListNode n3 =new ListNode(3);
        ListNode n4=new ListNode(3,n3);
        ListNode n5=new ListNode(2,n4);
        ListNode n6=new ListNode(1,n5);
        ListNode head1=new ListNode(1,n6);

        ListNode head3=new ListNode(1);
        SolutionDeleteDuplicates s =new SolutionDeleteDuplicates();
        s.printList(s.deleteDuplicates(head));
        s.printList(s.deleteDuplicates(head1));
        s.printList(s.deleteDuplicates(null));
        s.printList(s.deleteDuplicates(head3));
    }
}
class SolutionDeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        //如果链表为空或者链表长度为1
        if(head==null||head.next==null){
            return head;
        }
        int curMin=head.val;
        ListNode curNode=head,preNode=head;
        while (curNode!=null){
            if(curNode.val>curMin){
                curMin=curNode.val;
                preNode.next=curNode;
                preNode=curNode;
            }
            //去除链与链表最后数据相同的重复数据
            if(curNode.next==null&&preNode!=curNode){
//                System.out.println(curNode.val+";"+preNode.val);
//                System.out.println(curNode==preNode);
                preNode.next=null;
            }
            curNode=curNode.next;
        }
//        System.out.println(curMin);
        return head;
    }
    public void printList(ListNode list){
        while (list!=null){
            System.out.print(list.val+"\t");
            list=list.next;
        }
        System.out.println("结束了！");
    }
}
