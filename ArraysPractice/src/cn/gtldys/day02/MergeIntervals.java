package cn.gtldys.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    //合并数组区间
//    以数组 intervals 表示若干个区间的集合，
//    其中单个区间为 intervals[i] = [starti, endi] 。
//    请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
    public static void main(String[] args) {
        int t1[][]={{1,3},{2,6},{8,10},{15,18}};//预期结果[[1,6],[8,10],[15,18]]
        int t2[][]={{1,4},{4,5}};//预期结果[[1,5]]
        int t3[][]={{1,3},{0,5}};//预期结果[[0,5]]
        int t4[][]={{1,2},{3,4}};//预期结果[[1,2],[3,4]]
        int t5[][]={{1,4},{0,1}};//预期结果[[0,4]]
        int t6[][]={{1,4},{0,2},{3,5}};//预期结果[[0,5]]
        SolutionOfMI smi=new SolutionOfMI();
        smi.printMergeIntervals(smi.merge(t1));
        smi.printMergeIntervals(smi.merge(t2));
        smi.printMergeIntervals(smi.merge(t3));
        smi.printMergeIntervals(smi.merge(t4));
        smi.printMergeIntervals(smi.merge(t5));
        smi.printMergeIntervals(smi.merge(t6));
    }
}
class SolutionOfMI {

    public int[][] merge(int[][] intervals) {
        //对二维数组进行排序（按照二维数组的第1列元素升序排序）
       Arrays.sort(intervals, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return o1[0]-o2[0];
           }
       });
        int[][] result=new int[intervals.length][2];
        System.out.println("排好序后");
        printMergeIntervals(intervals);
        int resultLength=0;
        boolean flag=false;
        int [] cur = new int[2];//当前的区间
        cur[0]=intervals[0][0];
        cur[1]=intervals[0][1];
        //遍历二维数组
        for(int i=0;i<intervals.length;i++){
            if(flag){
                cur[0]=intervals[i][0];
                cur[1]=intervals[i][1];
            }
            if(i<intervals.length-1 && cur[1]>=intervals[i+1][1]){//当前区间包含其后的的区间
                flag=false;
                continue;
            }
            if (i<intervals.length-1 && cur[1]>=intervals[i+1][0]&&cur[1]<intervals[i+1][1]) {//当前的区间同其后的区间存在重叠部分
//                cur[0]=intervals[i][0];
                cur[1]=intervals[i+1][1];//合并区间
                flag=false;
                continue;
            }
////            当前的区间同其后的区间不存在重叠
            result[resultLength][0]=cur[0];
            result[resultLength][1]=cur[1];
            resultLength++;
            flag=true;
        }
        return Arrays.copyOf(result,resultLength);
//        return result;
    }
    public void printMergeIntervals(int [][] intervals){
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