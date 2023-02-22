package day10.test;

import day10.DetectCycle;
import main.ListNode;
import org.junit.jupiter.api.Test;
import utils.CreateListNode;

public class DetectCycleTest {
    @Test
    public void testDetectCycle() {
        //测试用例1
//        输入：head = [3,2,0,-4], pos = 1
//        输出：返回索引为 1 的链表节点
//        解释：链表中有一个环，其尾部连接到第二个节点。
        int[] nums1 = {3, 2, 0, -4};
        ListNode t1 = CreateListNode.create(nums1, 1);
        DetectCycle dc = new DetectCycle();
        dc.detectCycle1(t1);
        //测试用例2
        /*
        输入：head = [1,2], pos = 0
        输出：返回索引为 0 的链表节点
        解释：链表中有一个环，其尾部连接到第一个节点。
         */
        int[] nums2 = {1, 2};
        ListNode t2 = CreateListNode.create(nums2, 0);
        dc.detectCycle1(t2);
        /*测试用例3
        输入：head = [1], pos = -1
        输出：返回 null
        解释：链表中没有环。
         */
        int[] nums3 = {1, 2, 3};
        ListNode t3 = CreateListNode.create(nums3, -1);
        dc.detectCycle1(t3);
    }

}
