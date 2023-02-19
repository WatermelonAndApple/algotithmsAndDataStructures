package org.gtldys.stack;

import java.util.Stack;

//使用栈来实现队列
public class QueueByStack {
    /*
    请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
    实现 MyQueue 类：
    void push(int x) 将元素 x 推到队列的末尾
    int pop() 从队列的开头移除并返回元素
    int peek() 返回队列开头的元素
    boolean empty() 如果队列为空，返回 true ；否则，返回 false
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.pop());
        myQueue.push(3);
        System.out.println(myQueue.pop());
        myQueue.push(4);
        System.out.println(myQueue.pop());
        myQueue.push(5);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}
//用两个栈实现的队列
class MyQueue {
    //两个栈
    Stack<Integer> s1,s2;

    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        s1ValueToS2();
        return s2.pop();
    }

    public int peek() {
        s1ValueToS2();
        return s2.peek();
    }
    public void s1ValueToS2(){
        if(s2.empty()) {
            while (!s1.isEmpty()) {//当s2为空,s1不为空时,将s1中的元素出栈，将出栈的元素放入到s2中
                s2.push(s1.pop());
            }
        }
    }
    public boolean empty() {
        return s2.isEmpty()&&s1.isEmpty();
    }
}
