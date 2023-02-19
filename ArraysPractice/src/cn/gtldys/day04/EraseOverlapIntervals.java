package cn.gtldys.day04;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    //无重叠区间
//    给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
    public static void main(String[] args) {
//        int [][]t1={{1,2},{2,3},{3,4},{1,3}};
//        int [][]t2={{1,2},{1,2},{1,2}};
//        int [][]t3={{1,2},{2,3}};
//        int [][]t4={{1,2},{1,3},{1,5},{2,3},{3,5}};
//        int [][]t5={{1,4},{2,5}};
//        int [][]t6={{1,2},{3,4},{1,5},{4,5},{5,6},{2,6}};
//        int [][]t7={{1,100},{11,22},{1,11},{2,12}};
//        SolutionOFEraseOverlapIntervals s = new SolutionOFEraseOverlapIntervals();
//        System.out.println(s.eraseOverlapIntervals(t1));
//        System.out.println(s.eraseOverlapIntervals(t2));
//        System.out.println(s.eraseOverlapIntervals(t3));
//        System.out.println(s.eraseOverlapIntervals(t4));
//        System.out.println(s.eraseOverlapIntervals(t5));
//        System.out.println(s.eraseOverlapIntervals(t6));
//        System.out.println(s.eraseOverlapIntervals(t7));
        int []a1={1,4,2}; //4
        int []a2={5,4,4}; //7
        int []a3={5,0,0};  //5
        int [] a4={4,1,0};  //4
        int [] a5={5,1,2};  //5
        int [] a6={3,4,5};  //6
        System.out.println(fillCups(a1));
        System.out.println(fillCups(a2));
        System.out.println(fillCups(a3));
        System.out.println(fillCups(a4));
        System.out.println(fillCups(a5));
        System.out.println(fillCups(a6));
    }
    public static int fillCups(int [] amount){
        //先排序
        Arrays.sort(amount);
        int preDataSum = amount[0] + amount[1];
        int sum = preDataSum + amount[2];
        int minTime=0;//最少的时间
       if(preDataSum <= amount[2]){
           return amount[2];
       }else {
           if(sum % 2 == 0){//最小的两个数据之和如果是偶数
               minTime = sum / 2;
           }else {
               minTime =  sum / 2 + 1;
           }
       }
        return minTime;
    }
}

class SolutionOFEraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        //对二维数组进行排序（按照二维数组的第1列元素升序排序）
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        print(intervals);
        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
    private void print(int[][] intervals){
        for(int[] tmp : intervals){
            System.out.print("[");
            for(int x:tmp){
                System.out.print(x+",");
            }
            System.out.print("]");
        }
        System.out.println("===");
    }

}

