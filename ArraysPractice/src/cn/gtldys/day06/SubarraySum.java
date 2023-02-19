package cn.gtldys.day06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarraySum {
    //和为K的连续子数组的和
    //给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数
    public static void main(String[] args) {
        int [] t1={1,1,1};//k=2     2
        int []t2={1,2,3};//k=3      2
        int [] t3={0,0,1,2};//k=3   3
        int []t4={1,3,1,1};//k=2    1
        int []t5={1,2,1,3,2,5,1,4};//k=4    3
        int []t6={1,-1,0};//k=0    3
        System.out.println(subarraySum(t1,2));
        System.out.println(subarraySum(t2,3));
        System.out.println(subarraySum(t3,3));
        System.out.println(subarraySum(t4,2));
        System.out.println(subarraySum(t5,4));
        System.out.println(subarraySum(t6,0));
    }
    public static int subarraySum(int[] nums, int k) {
       int count=0,pre=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for (int i=0;i<nums.length;++i){
            pre+=nums[i];
            if(mp.containsKey(pre-k)){
                count+=mp.get(pre-k);
            }
            mp.put(pre,mp.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
