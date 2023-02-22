package day13;

import main.ListNode;

import java.util.ArrayList;
import java.util.List;

//重排链表
public class ReorderList {
    /*
    给定一个单链表 L 的头节点 head ，单链表 L 表示为：
    L0 → L1 → … → Ln - 1 → Ln
    请将其重新排列后变为：
    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     */
    public void reorderList(ListNode head) {
        List<ListNode> lists = new ArrayList<>();
        while (head != null){
            lists.add(head);
            head = head.next;
        }
        int n = lists.size(); //链表长度
        if(n == 1){
            return ;
        }
        ListNode pre = null, next = null;
        for(int i=0;i<n/2;i++){
            pre = lists.get(i);
            if(next != null) {
                next.next = pre;
            }
            next = lists.get(n-i-1);
            pre.next = next;
        }
        if(n % 2 ==0){//链表结点个数为偶数
            next.next = null;
        }else {//链表结点个数为奇数
           ListNode tail =  lists.get(n/2);
           tail.next= null;
           next.next= tail;
        }
    }
}
