package day12;

import main.ListNode;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;

//两两交换链表中的节点
public class SwapPairs {
    /*
    给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = head, next = pre.next , oldPre = null , result = next;
        //pre节点表示前一个结点，next表示下一个结点,oldPre表示上一个交换前的pre
        while (pre != null){
            if(oldPre != null){
                oldPre.next = next;//将上一个交换前的pre连接到到下一个交换完后的next
            }
            oldPre = pre;//保存交前的pre
            //交换相邻的结点
            ListNode tmp = next.next;
            next.next = pre;
            //下一个pre 和 next
            pre = tmp;
            if (pre != null) {
                next = pre.next;
            }
            if(next == null){
                oldPre.next = pre;
                return result;
            }
        }
        oldPre.next = null;
        return result;
    }

}
