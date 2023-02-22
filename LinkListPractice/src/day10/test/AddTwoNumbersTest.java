package day10.test;

import day10.AddTwoNumbers;
import main.ListNode;
import org.junit.jupiter.api.Test;
import utils.CreateListNode;

public class AddTwoNumbersTest {
    //两数之和的测试
    @Test
    public void testAddTwoNumbers() {
        //测试用例
//        输入：l1 = [2,4,3], l2 = [5,6,4]
//        输出：[7,0,8]
//        解释：342 + 465 = 807.
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode t1 = CreateListNode.create(nums1);
        ListNode t2 = CreateListNode.create(nums2);
        AddTwoNumbers s = new AddTwoNumbers();
        printListNode(s.addTwoNumbers(t1, t2));
    }

    @Test
    public void testAddTwoNumbers1() {
        //测试用例
//        输入：l1 = [9,9,9], l2 = [9,9,9,9]
//        输出：[8,9,9,0,1]
//        解释：9999 + 999 = 10998.
        int[] nums1 = {9, 9, 9};
        int[] nums2 = {9, 9, 9, 9};
        ListNode t1 = CreateListNode.create(nums1);
        ListNode t2 = CreateListNode.create(nums2);
        AddTwoNumbers s = new AddTwoNumbers();
        printListNode(s.addTwoNumbers(t1, t2));
    }

    public void printListNode(ListNode tmp) {
        while (tmp != null) {
            System.out.print(tmp.val);
            tmp = tmp.next;
        }
    }


}
