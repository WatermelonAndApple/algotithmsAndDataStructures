package day11;

import main.ListNode;

import java.util.HashSet;
import java.util.Set;

//相交链表
public class GetIntersectionNode {
    /*
    给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     */
    //使用哈希表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB !=null ){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    //使用双指针
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode pa=headA,pb=headB;
        while (pa != pb){
            pa = pa==null ? headB : pa.next;
            pb = pb==null ? headA : pb.next;
        }
        return pa;
    }
}
