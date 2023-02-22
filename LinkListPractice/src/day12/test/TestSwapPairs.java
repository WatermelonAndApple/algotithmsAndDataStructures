package day12.test;


import day12.SwapPairs;
import main.ListNode;
import org.junit.jupiter.api.Test;
import utils.CreateListNode;

public class TestSwapPairs {
    @Test
    public void testSwapPairs(){
        SwapPairs  sp = new SwapPairs();
        //测试用例1
//        输入：head = [1,2,3,4]
//        输出：[2,1,4,3]
        int nums1[] = {1,2,3,4};
        ListNode t1 = CreateListNode.create(nums1);
        CreateListNode.printListNode(t1);
        CreateListNode.printListNode(sp.swapPairs(t1));

    }

}
