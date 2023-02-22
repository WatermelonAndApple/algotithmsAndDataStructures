package day14;

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
实现 MinStack 类:
MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。
 */
public class MinStack {
    private  int MIN_STACK_MAX = 5 ;//栈的最大的容量
    private  int min;//最小元素
    private int length;//张的长度
    private int [] nums ;//存放栈的数据
    public MinStack() {
        nums = new int[MIN_STACK_MAX];
        min = Integer.MAX_VALUE;
        length = 0;
    }
    //入栈
    public void push(int val) {
        if(length == MIN_STACK_MAX - 2){
            extend();//栈的容量不足扩展栈
        }
        if(min > val){
            min = val;//获取最小值
        }
        nums[length++] = val;
    }
    //出栈
    public void pop() {
        if(nums[length -1] == min){//如果栈顶是最小值，且出栈了
            //从新获取新的最小值
            min = Integer.MAX_VALUE;
            for (int i=0;i<length-1;i++){
                if (min > nums[i]){
                    min = nums[i];
                }
            }
        }
       length--;
    }
    //获取栈顶元素
    public int top() {
        if(length > 0){
            return nums[length - 1];
        }
        return -1;
    }
    //获取该栈中的最小元素
    public int getMin() {
        return min;
    }
    //扩充栈的容量
    public void extend(){
        MIN_STACK_MAX *= 2;
        int [] tmp = new int[MIN_STACK_MAX];
        for (int i = 0;i<length;i++){
            tmp[i] = nums[i];//将栈中元素赋值到新的位置
        }
        nums = tmp;
    }
}
