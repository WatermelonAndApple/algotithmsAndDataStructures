import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    /**
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     *输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     * 解释：[4,9] 也是可通过的
     */
    public static void main(String[] args) {
        int [] t1 = {1,2,2,1};
        int [] t2 = {2,2};
        int [] t3 = {4,9,5};
        int [] t4 = {9,4,9,8,4};
        int [] result1 = intersection(t1,t2);
        int [] result2 = intersection(t3,t4);
        System.out.println();
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums1){
            //将nums1中不重复的数据放入到set中
            if(!set.contains(n)){
                set.add(n);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int n : nums2) {
            //如果存在nums1 与 nums2的交集
            if(set.contains(n)){
                list.add(n);
                set.remove(n);
            }
        }
        int [] result = new int[list.size()];
        for(int i=0;i< list.size();i++){
          result[i] = list.get(i);
        }
        return result;
    }
}