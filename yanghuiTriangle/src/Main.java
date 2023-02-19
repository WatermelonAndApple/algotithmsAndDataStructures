import java.util.ArrayList;
import java.util.List;

public class Main {
    //杨辉三角
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generate(1));
        System.out.println(s.generate(2));
        System.out.println(s.generate(3));
        System.out.println(s.generate(4));
        System.out.println(s.generate(5));
        System.out.println(s.generate(6));
        System.out.println(s.generate(7));
        System.out.println(s.getRow(2));
        System.out.println(s.getRow(0));
        System.out.println(s.getRow(3));
    }
}
class Solution {
    //生成杨辉三角形
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> yanghuiList = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> l = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    l.add(1);//首尾均为1
                } else if (i > 1) {//当前数等于其右上方的数余其左上方的数之和
                    l.add(yanghuiList.get(i - 1).get(j - 1) +
                            yanghuiList.get(i - 1).get(j));
                }
            }
            yanghuiList.add(l);
        }
        return yanghuiList;
    }
    /*
     * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * //
     */
    public List<Integer> getRow(int rowIndex) {
        List <Integer> yanghuiListRow=new ArrayList<Integer>();
        yanghuiListRow.add(1);
        for(int i=1;i<=rowIndex;++i){
            yanghuiListRow.add((int)(long)yanghuiListRow.get(i-1)*(rowIndex-i+1)/i);
        }
        return yanghuiListRow;
    }
}
