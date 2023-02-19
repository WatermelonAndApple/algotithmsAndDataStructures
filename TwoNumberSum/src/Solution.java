import java.util.HashMap;
import java.util.Map;

public class Solution {
    //穷举法
    public  int[] twoSum(int [] nums,int target){
        System.out.println("twoSum");
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){//如果找到目标则记录下标并退出
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    //利用哈希表，查询表中是否存在target-x，然后将x插入哈希表中，即可以保证不会让x和自己匹配。
    public int[] hashTwoSum(int [] nums,int target){
        System.out.println("hashtwoSum");
        Map<Integer,Integer> hashtable=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hashtable.containsKey(target-nums[i])){
                return new int[] {hashtable.get(target-nums[i]),i};
            }
            hashtable.put(nums[i],i);
        }
        return null;
    }

}
