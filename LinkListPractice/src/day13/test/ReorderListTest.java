package day13.test;

import day13.ReorderList;
import main.ListNode;
import org.junit.jupiter.api.Test;
import utils.CreateListNode;

//测试重排链表
public class ReorderListTest {
    @Test
    public void testReorderList(){
        ReorderList rl = new ReorderList();
        //测试用例1：输入：head = [1,2,3,4]
        //输出：[1,4,2,3]
        int [] nums1 = {1,2,3,4};
        ListNode t1 = CreateListNode.create(nums1);
        rl.reorderList(t1);
        CreateListNode.printListNode(t1);//打印重排后的链表
        System.out.println("===分隔===");
        //测试用例2：输入：head = [1,2,3,4,5]
        //输出：[1,5,2,4,3]
        int [] nums2 = {1,2,3,4,5};
        ListNode t2 = CreateListNode.create(nums2);
        rl.reorderList(t2);
        CreateListNode.printListNode(t2);//打印重排后的链表
        System.out.println("===分隔===");
        // 测试用例3：输入：head = [1,2,3,4,5,6]
        //输出：[1,6,2,5,3,4]
        int [] nums3 = {1,2,3,4,5,6};
        ListNode t3 = CreateListNode.create(nums3);
        rl.reorderList(t3);
        CreateListNode.printListNode(t3);//打印重排后的链表
        System.out.println("===分隔===");
        // 测试用例4：输入：head = [1,2,3]
        //输出：[1,3,2]
        int [] nums4 = {1,2,3};
        ListNode t4 = CreateListNode.create(nums4);
        rl.reorderList(t4);
        CreateListNode.printListNode(t4);//打印重排后的链表
        System.out.println("===分隔===");
        // 测试用例5：输入：head = [1]
        //输出：[1]
        int [] nums5 = {1};
        ListNode t5 = CreateListNode.create(nums5);
        rl.reorderList(t5);
        CreateListNode.printListNode(t5);//打印重排后的链表
        System.out.println("===分隔===");
        // 测试用例6：输入：head = [1,2]
        //输出：[1,2]
        int [] nums6 = {1,2};
        ListNode t6 = CreateListNode.create(nums6);
        rl.reorderList(t6);
        CreateListNode.printListNode(t6);//打印重排后的链表
        System.out.println("===分隔===");
    }
}
