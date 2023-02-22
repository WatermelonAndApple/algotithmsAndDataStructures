package day14.test;


import day14.MinStack;
import org.junit.jupiter.api.Test;

//测试最小栈
public class MinStackTest {
    @Test
    public void testMinStack(){
        MinStack s =new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());
        s.push(4);
        s.push(5);
        s.push(6);
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());
    }

}
