import java.util.HashMap;

public class Main {
    //一维数组的多数元素
//    给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
//    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    public static void main(String[] args) {
        int [] t1={3,2,3};
        int [] t2={2,2,1,1,1,2,2};
        int [] t3={1,2};
        int [] t4={1,1,2,2,3,1,2,3,4};
        int [] t5={1,1,2,3,4};
        Solution s = new Solution();
        System.out.println(s.majorityElement(t1));
        System.out.println(s.majorityElement(t2));
        System.out.println(s.majorityElement(t3));
        System.out.println(s.majorityElement(t4));
        System.out.println(s.majorityElement(t5));
    }
}
class Solution {
    /**
     * （1）遍历数组
     * （2）将对应的数值添加到哈希表中，如果哈希表中存在该数值则键数值对应的 value 加 1
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        //遍历数组
        for (int n : nums) {
            if (!hm.containsKey(n)) {//如果没有则将该数字添加到哈希表中
                hm.put(n, 1);
            }else{//如果哈希表中存在该数值则将该数值对应的value值加1；
                hm.put(n,hm.get(n)+1);
            }
        }
        System.out.println(hm);
        int maxCount=0,majortyEle=0;
        //遍历哈希表，找到最大的出现次数
        for(Integer n : hm.keySet()){
            Integer tmp = hm.get(n);
            if(tmp > maxCount){
                maxCount = tmp;
                majortyEle = n;//多数元素
            }
        }
        if(maxCount > nums.length/2){
            return majortyEle;
        }
        //取出该一维数组的多数元素
        return -1;
    }
}