package utils;

import main.ListNode;

//生成链表的工具
public final class CreateListNode {
    //根据数组自动生成单链表
    public static ListNode create(int[] nums) {
        ListNode head = new ListNode(), node = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode newNode = new ListNode();
            newNode.val = nums[i];
            node.next = newNode;
            node = newNode;
        }
        return head.next;
    }

    /**
     * description: 根据数组自动生成存在环形链表
     * date: 14:21 2023/2/20
     *
     * @param nums ,每个结点的数据
     * @param pos  ， 环形链表的起始位置,环形链表是从链表尾部连接到链表的pos位置,
     *             pos=-1表示不存在环形链表,pos从0开始表示第一个结点
     *             return 该链表的地址
     **/
    public static ListNode create(int[] nums, int pos) {
        ListNode head = new ListNode(), node = head, nodeInPos = null;//nodeInPos表示环形链表的起始位置
        for (int i = 0; i < nums.length; i++) {
            ListNode newNode = new ListNode();
            newNode.val = nums[i];
            if (i == pos) {
                nodeInPos = newNode;//记录下环形链表的开始位置
            }
            node.next = newNode;
            node = newNode;
        }
        //将链表尾部连接到pos位置的结点处
        node.next = nodeInPos;
        System.out.println(nodeInPos);
        return head.next;
    }
    //打印链表
    public  static void printListNode(ListNode head){
        while (head != null){
            System.out.print(head.val + "\t");
            head = head.next;
        }
    }



}
