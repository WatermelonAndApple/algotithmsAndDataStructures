package cn.gtldys.day06;

public class ProductExceptSelf {
    //除自身以外数组的乘积
    /*
    给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
    题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
    请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     */
    public static void main(String[] args) {
        int [] t1={1,2,3,4};
        int [] t2={-1,1,0,-3,3};
       print(productExceptSelf(t1));
       print(productExceptSelf(t2));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int []answer = new int[n];
        answer[0]=1;
         int r=1;//存放后缀乘积
        for(int i=1;i<n;++i){
            answer[i]=nums[i-1]*answer[i-1];
        }
        for(int i=n-1;i>=0;--i){
            answer[i]=r * answer[i];//最终结果等于前缀乘积与后缀乘积的乘积
            r=nums[i]* r;
        }
        return answer;
    }
    public static void print(int[] nums){
        for (int n : nums){
            System.out.print(n+"\t");
        }
        System.out.println();
    }
}
