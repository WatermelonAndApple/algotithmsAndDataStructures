package day13.test;

import day13.ReverseKGroup;
import main.ListNode;
import org.junit.jupiter.api.Test;
import utils.CreateListNode;

//. K 个一组翻转链表测试
public class TestReverseKGroup {
    @Test
    public void testReverseKGroup(){
        ReverseKGroup obj = new ReverseKGroup();
        //测试用例1：
//        输入：head = [1,2,3,4,5], k = 2
//        输出：[2,1,4,3,5]
        int [] nums1 = {1,2,3,4,5,6,7,8,9,10};
        ListNode t1 = CreateListNode.create(nums1);
//        obj.reverseKGroup(t1,3);
        CreateListNode.printListNode( obj.reverseKGroup(t1,3));
    }
}
