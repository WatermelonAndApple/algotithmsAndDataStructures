package com.gtldys.linklist;

public class RemoveLinkListElements {
    //移除链表元素
    /*
    * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    * */
    public static void main(String[] args) {
        Solution s =new Solution();
        //测试用例1: head=[1,2,6,3,4,5,6],val=6
        ListNode n6=new ListNode(6);
        ListNode n5=new ListNode(5,n6);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(6,n3);
        ListNode n1=new ListNode(2,n2);
        ListNode head=new ListNode(1,n1);
        //测试用例2：head=[],val=1
        //测试用例3：head=[7,7,7,7],val=7
        ListNode h1_n1=new ListNode(7);
        ListNode h1_n2=new ListNode(7,h1_n1);
        ListNode h1_n3=new ListNode(7,h1_n2);
        ListNode head1=new ListNode(7,h1_n3);
        s.printList(s.removeElements(head,6));
        s.printList(s.removeElements(null,1));
        s.printList(s.removeElements(head1,7));

        //测试用例4：head=[1] val=2
        ListNode head2=new ListNode(1);
        s.printList(s.removeElements(head2,2));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preNode=head,curNode=head;//preNode前一个结点,curNode当前结点
        ListNode resultList=null;
        boolean isDeleteNode =false;//是否删除了结点
        boolean isFirst=true;//给resultList赋值执行一次
        while (curNode!=null){
            if(curNode.val==val){//如果值相等就删除该结点
                if(curNode==head){//如果首个数据等于val
                    preNode=null;
                }else{
                    if(preNode!=null)
                        preNode.next = curNode.next;
                }
                isDeleteNode=true;
            }else{
                 preNode=curNode;
            }
            if(isFirst&&preNode!=null){
                isFirst=false;
                resultList=preNode;
            }
            curNode=curNode.next;
        }
        if (isDeleteNode){//删除了数据
            return resultList;
        }//没有删除
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
