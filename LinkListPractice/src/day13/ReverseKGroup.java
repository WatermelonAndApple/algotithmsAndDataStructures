package day13;

import main.ListNode;
//K 个一组翻转链表
public class ReverseKGroup {
    /*
    给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
    k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
    你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;//nodes加入结点的个数
        boolean isNotFirstReverse = false;//是否不是第一次进行翻转
        ListNode node = head ,firstNodeBeforeReverse = null   , lastNodeAfterReverse = null;
        ListNode result = null;//结果
        //firstNodeBeforeReverse,上一组翻转前的的第一个结点,lastNodeAfterReverse上一组翻转后的最后一个结点
        while (node != null){
            n++;
            if( n % k == 1){
                if(isNotFirstReverse){
                    lastNodeAfterReverse = reverse(firstNodeBeforeReverse,k);//翻转前一组
                }
                firstNodeBeforeReverse = node;
            } else if (n % k == 0 ) {
                if (!isNotFirstReverse){
                    result = node;//记录第一组翻转后的第一个结点,整个链表翻转完成后的新的头结点
                    isNotFirstReverse = true;
                }else {//此时node是下一组翻转后的第一个结点,lastNodeAfterReverse则是
                   linkedListNode(lastNodeAfterReverse,node);
                }
                n = 0;
            }
            node = node.next;
        }
        if(n == 0){//说明此时链表的结点个数恰好是k的倍数
            if(isNotFirstReverse){
                lastNodeAfterReverse = reverse(firstNodeBeforeReverse,k);//翻转前一组
            }
//            System.out.println(firstNodeBeforeReverse.val);
            linkedListNode(lastNodeAfterReverse,null);
        }else {//说明此时链表的结点个数不是k的倍数，此时必然存在未进行翻转的结点
            linkedListNode(lastNodeAfterReverse,firstNodeBeforeReverse);
        }
        if(isNotFirstReverse){//进行了翻转，返回新的头结点
            return result;
        }
        //没有进行任何翻转
        return head;
    }
    //翻转链表
    public ListNode reverse(ListNode node , int k){
        if(k == 1){
            return node;
        }
        reverse(node.next,k-1).next = node;
        return node;
    }
    //连接结点
    public void linkedListNode(ListNode node1,ListNode node2){
        if(node1 != null){
            node1.next = node2;
        }
    }
}
