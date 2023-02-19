import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    //两个数组的交集
    /*
    给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
    回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，
    则考虑取较小值）。可以不考虑输出结果的顺序。
     */
    public static void main(String[] args) {
        //测试数据
        int[] nums1={1,2,2,1};
        int [] nums2={2,2};
        int [] nums3={4,9,5};
        int [] nums4={9,4,9,8,4};
        Solution s=new Solution();
        s.printResult(s.intersect1(nums1,nums2));
        System.out.println();
        s.printResult(s.intersect1(nums3,nums4));
    }
}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //先对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1=0,p2=0;
        //取交集
        ArrayList<Integer> list=new ArrayList<Integer>();
        while (p1!=nums1.length&&p2!=nums2.length){
            //当两个数组都还没有遍历完时
           if(nums1[p1]>nums2[p2]){
               p2++;
           }else if(nums1[p1]<nums2[p2]){
               p1++;
           }else {//相等，找到其中的一个交集值
               list.add(nums1[p1]);
               p1++;
               p2++;
           }
        }
        int [] num=new int[list.size()];
        for(int i=0;i<list.size();i++){
            num[i]=list.get(i);
        }
        return num;
    }
    public int[] intersect1(int[] nums1, int[] nums2) {
        //先对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1=0,p2=0;
        //取交集
        int []num;
        if(nums1.length>=nums2.length)
            num=new int[nums2.length];
        else
            num=new int[nums1.length];
        int index=0;
        while (p1!=nums1.length&&p2!=nums2.length){
            //当两个数组都还没有遍历完时
            if(nums1[p1]>nums2[p2]){
                p2++;
            }else if(nums1[p1]<nums2[p2]){
                p1++;
            }else {//相等，找到其中的一个交集值
                num[index++]=nums1[p1];
                p1++;
                p2++;
            }
        }
        return Arrays.copyOf(num,index);
    }
    //打印结果
    public void printResult(int [] num){
        System.out.println("公共结果为");
        for (int n:num){
            System.out.print(n+"\t");
        }
    }

}