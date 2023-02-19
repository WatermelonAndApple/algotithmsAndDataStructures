package cn.gtldys.day03;

public class RotateMatrix {
//    //将矩阵旋转90度
//    给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//    你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
    public static void main(String[] args) {
        int [][] m1={{1,2,3},{4,5,6},{7,8,9}};
        int [][] m2={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int [][] m3={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        SolutionOfRM srm=new SolutionOfRM();
        srm.printMatirx(m1);
        srm.printMatirx(m2);

        System.out.println("顺时针旋转选择后");
        srm.rotate(m1);
        srm.printMatirx(m1);
        srm.rotate(m2);
        srm.printMatirx(m2);
        srm.printMatirx(m3);
        srm.rotate(m3);
        srm.printMatirx(m3);

    }
}
class SolutionOfRM {
    public void rotate(int[][] matrix) {
        int n=matrix.length;//矩阵的长度
        int tmp;
        int x=0,y=0;//当前要移动的数据的位置
        int loopCount=0;//第几次外层循环
        int data;//当前要移动的数据
        while (n>0){
            x=loopCount;
            y=loopCount;
            data=matrix[x][y];
            for(int i=0;i<4*(n-1);++i){
//                System.out.println(data);
                tmp=matrix[y][matrix.length-1-x];
                matrix[y][matrix.length-1-x]=data;
                data=tmp;//保存要移动的数据
//                新的x，y
                tmp=y;
                y=matrix.length-1-x;
                x=tmp;
                if((i+1)%4==0){
                    y++;
//                    if();
                    data=matrix[x][y];
                }
            }
            loopCount++;
            n-=2;
        }
    }
    //打印矩阵
    public void printMatirx(int[][]matrix){
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("end==");
    }

}
