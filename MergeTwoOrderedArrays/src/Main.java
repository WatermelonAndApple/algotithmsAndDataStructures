import java.util.Arrays;

public class Main {
    //合并两个有序数组
//    给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//    请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//    注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
//    nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
    public static void main(String[] args) {
//        int [] nums1=new int[]{4,5,6,0,0,0};
//        int [] nums2=new int[]{1,2,3};
        int [] nums1=new int[]{1,2,3,0,0,0};
        int [] nums2=new int[]{2,5,6};
//        int [] nums1=new int[]{4,0,0,0,0,0};
//        int [] nums2=new int[]{1,2,3,5,6};

//        int [] nums1=new int[]{0};
//        int [] nums2=new int[]{1};
          Solution s=new Solution();
          //解法2
//          s.merge1(nums1,3,nums2,3);
//        解法1
        s.merge(nums1,3,nums2,3);
        System.out.println("合并后的结果为");
        for(int n:nums1){
            System.out.print(n+"\t");
        }
    }
}
class Solution {
    //解法1:双指针尾插法
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur=m+n-1;//合并后的的nums1数组的尾部下标
        int p1=m-1;//nums1的数组的尾部下标
        int p2=n-1;//nums2数组的尾部下标
        while (p1>=0||p2>=0){
            if(p1==-1){
                nums1[cur--]=nums2[p2--];
            }  else if (p2==-1) {
                nums1[cur--]=nums1[p1--];
            }else if (nums1[p1]>nums2[p2]) {
                nums1[cur--]=nums1[p1--];
            }else {
                nums1[cur--]=nums2[p2--];
            }
        }

    }
//解法2
     public void merge1(int[] nums1, int m, int[] nums2, int n) {
// 将nums2放到nums1后面然后对nums1进行排序。
        for (int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
        //对nums1进行排序
        Arrays.sort(nums1);
    }



}