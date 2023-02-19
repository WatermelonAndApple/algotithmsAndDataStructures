
import java.util.Arrays;

public class Main {
    //求给定数组中的最大的子数组和
//    给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//    子数组 是数组中的一个连续部分。
    public static void main(String[] args) {
        int [] nums1=new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int [] nums2=new int[]{1};
        int [] nums3=new int[]{5,4,-1,7,8};
        int [] nums4=new int[]{-1};
        int [] nums5=new int[]{-1,-2};
        Solution s=new Solution();
        System.out.println("最大的子数组和为"+s.maxSubArray(nums1));
        System.out.println("最大的子数组和为"+s.maxSubArray(nums2));
        System.out.println("最大的子数组和为"+s.maxSubArray(nums3));
        System.out.println("最大的子数组和为"+s.maxSubArray(nums4));
        System.out.println("最大的子数组和为"+s.maxSubArray(nums5));
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int [] dp=new int[nums.length];//nums[i]对应的最大子数组和的dp[i]
        for(int i=0;i<nums.length;i++){
            //如果nums[i-1]的最大子数组和大于等于0则nums[i]的最大子数组和等于dp[i]=dp[i-1]+nums[i]
            if(i-1>=0&&dp[i-1]>=0){
                dp[i]=dp[i-1]+nums[i];
            }else {
                //如果nums[i-1]的最大子数组和小于0则nums[i]的最大子数组和等于dp[i]=nums[i]
                dp[i]=nums[i];
            }
            max=Math.max(max,dp[i]);
            System.out.print(dp[i]+"\t");
        }
        return max;
    }
}