package cn.gtldys.day03;
//螺旋矩阵
public class SpiralMatrix {
    public static void main(String[] args) {
        SolutionOfSM s= new SolutionOfSM();
        s.printMatirx(s.generateMatrix(1));
        s.printMatirx(s.generateMatrix(2));
        s.printMatirx(s.generateMatrix(3));

        s.printMatirx(s.generateMatrix(20));
    }
}
class SolutionOfSM{
    public int[][] generateMatrix(int n) {
        int [][] resultMatrix=new int[n][n];
        short data=1;//数据
        byte loopCount=0;//当前在第几层，0表示最外层,数值越大表示越靠近内层
        byte row=0,col=0;//矩阵元素的所在的行列
        byte direction=0;//0表示右，1表示下，2表示左，3表示上
        while (n>0){
            row=loopCount;
            col=loopCount;
            if(n==1){//如果只剩下一个数据了
                resultMatrix[row][row]=data;
            }
            direction=0;
            for(int i=1;i<=4*(n-1);++i){//由外向内进行赋值
                resultMatrix[row][col]=data++;
//                System.out.println(row+";"+col);
                //移动的方向
                switch (direction){
                    case 0:col++;break;//向右
                    case 1:row++;break;//向下
                    case 2:col--;break;//向左
                    case 3:row--;break;//向上
                }
                if(i % (n-1) == 0){
                    direction++;//改变方向
                }
            }
            loopCount++;//外层遍历完了，向内层继续
            n-=2;
        }
        return resultMatrix;
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

