package utils;

//矩阵工具类
public  class MatrixUtils {
    //打印矩阵
    public static void printMatirx(int[][]matrix){
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("end==");
    }
}
