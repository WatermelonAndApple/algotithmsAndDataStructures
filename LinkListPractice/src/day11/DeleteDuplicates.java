package day11;

import main.ListNode;

import java.util.HashMap;
import java.util.Map;

//删除排序链表中的重复元素
public class DeleteDuplicates {
    /*
    给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){//当结点为0或1时
            return head;
        }
        int [] nums = new int[201];
        while (head != null){
            nums[head.val + 100] ++;
            head = head.next;
        }
        ListNode result = new ListNode();
        ListNode pre = result;
        for (int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                System.out.print(i - 100);
                ListNode node = new ListNode(i - 100);
                pre.next = node;
                pre = node;
            }
        }
       return result.next;
    }
}
