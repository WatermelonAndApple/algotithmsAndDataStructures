package day11.test;

import day11.DeleteDuplicates;
import main.ListNode;
import org.junit.jupiter.api.Test;
import utils.CreateListNode;

public class DeleteDuplicatesTest {
    //删除排序链表中的重复元素测试
    @Test
    public void testDeleteDuplicates(){
        DeleteDuplicates dd =new DeleteDuplicates();
        //测试用例1：
        /*
        输入：head = [1,2,3,3,4,4,5]
        输出：[1,2,5]
         */
        int [] nums1 = {1,2,3,3,4,4,5};
        ListNode t1 = CreateListNode.create(nums1);
        dd.deleteDuplicates(t1);
        //测试用例2：
        /*
         输入：head = [1,1,1,2,3]
         输出：[2,3]
         */
        int [] nums2 = {1,1,1,2,3};
        ListNode t2 = CreateListNode.create(nums2);
        dd.deleteDuplicates(t2);
        int [] nums3 ={-3,-1,0,0,0,3,3};
        ListNode t3 =CreateListNode.create(nums3);
        dd.deleteDuplicates(t3);
    }

}
