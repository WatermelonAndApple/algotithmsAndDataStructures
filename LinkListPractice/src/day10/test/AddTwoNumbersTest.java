package day10.test;

import day10.AddTwoNumbers;
import main.ListNode;
import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {
    //两数之和的测试
    @Test
    public void testAddTwoNumbers(){
        //测试用例
//        输入：l1 = [2,4,3], l2 = [5,6,4]
//        输出：[7,0,8]
//        解释：342 + 465 = 807.
        ListNode n1=new ListNode(3);
        ListNode n2=new ListNode(4,n1);
        ListNode t1=new ListNode(2,n2);
        ListNode n3=new ListNode(4);
        ListNode n4=new ListNode(6,n3);
        ListNode t2=new ListNode(5,n4);
        AddTwoNumbers s =new AddTwoNumbers();
        printListNode(s.addTwoNumbers(t1,t2));
    }
    @Test
    public void testAddTwoNumbers1(){
        //测试用例
//        输入：l1 = [9,9,9], l2 = [9,9,9,9]
//        输出：[8,9,9,0,1]
//        解释：9999 + 999 = 10998.
        ListNode n1=new ListNode(9);
        ListNode n2=new ListNode(9,n1);
        ListNode t1=new ListNode(9,n2);
        ListNode n8=new ListNode(9);
        ListNode n3=new ListNode(9,n8);
        ListNode n4=new ListNode(9,n3);
        ListNode t2=new ListNode(9,n4);
        AddTwoNumbers s =new AddTwoNumbers();
       printListNode(s.addTwoNumbers(t1,t2));
    }
    public void printListNode(ListNode tmp){
        while (tmp != null){
            System.out.print(tmp.val);
            tmp=tmp.next;
        }
    }


}
