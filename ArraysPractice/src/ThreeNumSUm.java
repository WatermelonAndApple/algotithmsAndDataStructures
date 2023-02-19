import java.util.*;

public class ThreeNumSUm {
    //三数之和
    /*
     *给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j],
     * nums[k]] 满足 i != j、i != k 且 j != k ，
     * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
        你返回所有和为 0 且不重复的三元组。
        注意：答案中不可以包含重复的三元组。
     *
     */
    public static void main(String[] args) {
        //测试用例
        int [] t1={-1,0,1,2,-1,-4};
        int [] t2={0,1,1};
        int [] t3={0,0,0};
        int [] t4={-2,0,0,2,2};
        int [] t5={-1,-1,-2};
        SolutionThreeNumSUm s= new SolutionThreeNumSUm();
        System.out.println(s.threeSum1(t1));
        System.out.println(s.threeSum1(t2));
        System.out.println(s.threeSum1(t3));
        System.out.println(s.threeSum1(t4));
        System.out.println(s.threeSum1(t5));
    }
}
class SolutionThreeNumSUm {
    public List<List<Integer>> threeSum(int[] nums) {
        //先对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        return result;
    }
    public List<List<Integer>> threeSum1(int[] nums) {
        //先对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(nums[nums.length-1]<0) {
            System.out.println("t5");
            return result;
        }
        int j=0,k=0;//在i位置后的j和k，且满足i<j<k
        int iVal=0,jVal=0,kVal=0;//i,j,k对应的值
        int preIVal=Integer.MIN_VALUE;//满足条件的i的值
        //遍历排好序并去除重复的数组
        for(int i=0;i<nums.length-2;i++){
            iVal=nums[i];
            if(preIVal==iVal)
                continue;
            if(iVal > 0) {//如果当前的i位置的值大于0，则其后的元素的三数之和必定不可能等于0
                System.out.println("t4");
                return result;
            }
            j=i+1;
            k=nums.length-1;
            while (j<k){
                jVal=nums[j];
                kVal=nums[k];
                if(-iVal == jVal + kVal){//找到了一组答案
                    List <Integer> l = new ArrayList<>();
                    l.add(iVal);l.add(jVal);l.add(kVal);
                    result.add(l);//j和k往内移动到同当前的值不同的位置
                    while(nums[++j]==jVal&&j<k);
                    while (nums[--k]==kVal&&j<k);
                    preIVal=iVal;
                }else if(-iVal < jVal + kVal){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}
