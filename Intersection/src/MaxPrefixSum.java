import java.util.Arrays;

/**
 * 最大前缀和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class MaxPrefixSum {
    public static void main(String[] args) {
        int [] t1 = {-2,1,-3,4,-1,2,1,-5,4};
        int [] t2 = {5,4,-1,7,8};
        int [] t3 = {1,-4,4,9,-10,-1,20};
        int [] t4 = {1};
        int [] t5 = {-1,-2,-3};
        int [] t6 = {0,0,0};
        int [] t7 = {-2,1};
        System.out.println(maxSubArray(t1));
        System.out.println(maxSubArray(t2));
        System.out.println(maxSubArray(t3));
        System.out.println(maxSubArray(t4));
        System.out.println(maxSubArray(t5));
        System.out.println(maxSubArray(t6));
        System.out.println(maxSubArray(t7));
    }
    public  static int maxSubArray(int[] nums) {
        int n = nums.length , tmp,max;
        int [] dp  = new int[n];
        dp[0] = nums[0];
        max = dp[0];
        for(int i = 1; i < n; i++){
            tmp = dp[i-1] + nums[i];
            if(tmp > nums[i]){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
