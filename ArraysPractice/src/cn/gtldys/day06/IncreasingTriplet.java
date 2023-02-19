package cn.gtldys.day06;

public class IncreasingTriplet {
    //递增的三元子序列
    //    给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
    //    如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
    public static void main(String[] args) {
        int [] t1={1,2,3,4,5};
        int[]t2={5,4,3,2,1};
        int [] t3={1,2};
        int []t4={2,1,5,0,4,6};
        int []t5={1,1,-2,6};
        Solution s = new Solution();
        System.out.println(s.increasingTriplet(t1));
        System.out.println(s.increasingTriplet(t2));
        System.out.println(s.increasingTriplet(t3));
        System.out.println(s.increasingTriplet(t4));
        System.out.println(s.increasingTriplet(t5));
    }
}
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n < 3)//数组元素小于3，则一定不存在
            return false;
        int first = nums[0],second=Integer.MAX_VALUE,third;//第一个数,第二个数,第三个数,满足first < second < third
        for(int i=1;i<n;i++){
            third = nums[i];
            if(second < third){//nums[i]表示第3个数，此时存在first < second < nums[i];
                System.out.println(first+";"+second+";"+third);
                return true;
            }else if(third > first){
                second = third;
            }else {
                first = third;
            }
        }
        return false;
    }
}
