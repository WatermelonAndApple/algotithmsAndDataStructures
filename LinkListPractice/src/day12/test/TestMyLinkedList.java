package day12.test;

import day12.MyLinkedList;
import org.junit.jupiter.api.Test;

//测试设计的链表
public class TestMyLinkedList {
    @Test
    public void testMyLinkedList(){
        MyLinkedList obj = new MyLinkedList();
        obj.addAtTail(1);
        System.out.println(obj.get(0));
    }
}
