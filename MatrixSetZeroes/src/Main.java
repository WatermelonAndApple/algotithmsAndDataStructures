import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    //矩阵置零
//    给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0
    public static void main(String[] args) {
        //测试数据
        int [][]matrix1={{1,1,1},{1,0,1},{1,1,1}};
        int [][]matrix2={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        Solution s = new Solution();
        s.setZeroes1(matrix1);
        s.printMatrix(matrix1);
        System.out.println("分隔=====");
        s.setZeroes1(matrix2);
        s.printMatrix(matrix2);
    }
}
class Solution {
    /**
     * 矩阵置零
     * @param matrix  要重置的矩阵
     */
    public void setZeroes(int[][] matrix) {
        //记录行和列的数据
        HashSet<Integer> row=new HashSet<Integer>();
        HashSet<Integer> col=new HashSet<Integer>();
        //遍历矩阵找到零所在的位置并记录下来
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){//记录位置到hashset中
                    row.add(i);
                    col.add(j);
                }
            }
        }
        //将0元素其所在行和列的所有元素都设为 0
        for(int n : row){
           setRowZero(matrix,n);
        }
        for(int n : col){
            setColZero(matrix,n);
        }
    }
    public void setZeroes1(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        HashMap<Integer,Integer> isReadySetZeroes=new HashMap<>();//该行和列是否已经置零
        for(int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(!isReadySetZeroes.containsValue(j)) {//如果该列没有置零
                    if (matrix[i][j] == 0) {//如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0
                        isReadySetZeroes.put(i, j);//将置零的行和列添加到hashmap中
                        //进行置零操作
//                            setMatrixValueZero(matrix,i,j);
//                            break;
                    }
                }
            }
        }
        System.out.println(isReadySetZeroes);
    }
    //将行置为零
    public void setRowZero(int [][] matrix,int row){
        for(int i=0;i<matrix[0].length;i++){
                matrix[row][i]=0;
        }
    }
    //将列置为零
    public void setColZero(int[][] matrix,int col){
        for(int i=0;i<matrix.length;i++){
                matrix[i][col]=0;
        }
    }
    //打印矩阵
    public void printMatrix(int[][] matrix){
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

}