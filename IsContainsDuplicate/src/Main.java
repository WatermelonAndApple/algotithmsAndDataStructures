import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
//    给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//    是否存在重复的元素
    public static void main(String[] args) {
       int [] nums=new int[]{1,2,3,1};
       int [] nums1=new int [] {1,2,3,4};
       int [] nums2=new int [] {1,1,1,3,3,4,3,2,4,2};
        Solution s=new Solution();
        System.out.println(s.containsDuplicate(nums));
        System.out.println(s.containsDuplicate(nums1));
        System.out.println(s.containsDuplicate(nums2));
        HashSet<Integer> h=new HashSet<Integer>();
        System.out.println("第一次添加"+h.add(1));
        System.out.println("第二次添加"+h.add(1));
    }
}
class Solution {
    public boolean containsDuplicate(int[] nums) {
        //新建一个HashSet
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int n:nums){
            if(!hs.add(n))//如果存在重复元素
                return true;
        }
       return  false;
    }
}