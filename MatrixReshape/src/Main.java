public class Main {
    //重塑矩阵
    /*
    给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
    重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
    如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵
     */
    public static void main(String[] args) {
        int [][] mat={{1,2},{3,4}};
        Solution s=new Solution();
        s.printMatrix(s.matrixReshape(mat, 1, 4));
        System.out.println("分隔符");
        s.printMatrix(s.matrixReshape(mat, 2, 4));
    }
}
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        int [][]reshapeMat;//重塑的矩阵
        if(m*n!=r*c) {//不可以重塑
            return mat;
        }else{//可以重塑
            reshapeMat=new int[r][c];
        }
        //重塑矩阵
        for (int i=0;i<m*n;i++){
            reshapeMat[i/c][i%c]=mat[i/n][i%n];
        }
        return reshapeMat;
    }
    //打印矩阵
    public void printMatrix(int[][] mat){
        for(int i=0;i< mat.length;i++){
            for (int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+"\t");
            }
            System.out.println();
        }
    }
}