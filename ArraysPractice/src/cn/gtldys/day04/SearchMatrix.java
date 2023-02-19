package cn.gtldys.day04;

public class SearchMatrix {
//    搜索二维矩阵
    /*
    编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
    每行的元素从左到右升序排列。
    每列的元素从上到下升序排列。
     */
    public static void main(String[] args) {
        //测试用例1：target=5 , 预期结果 true
        int [][] t1={{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        //测试用例2：target=20 , 预期结果 false
//        int [][] t2={{1,4,7,11,15},
//                {2,5,8,12,19},
//                {3,6,9,16,22},
//                {10,13,14,17,24},
//                {18,21,23,26,30}
//        };
        SolutionOfSearchMatrix s =new SolutionOfSearchMatrix();
        for (int i =0 ;i<= 31;i++){
            System.out.println(i+";"+s.searchMatrix2(t1, i));
        }
//        System.out.println(s.searchMatrix2(t1, 30));
    }
}
class SolutionOfSearchMatrix {
    //方法2 逐渐缩小矩阵的范围
    public boolean searchMatrix2(int[][] matrix, int target) {
        //如果target的值大于matrix[m-1][n-1](该矩阵的最大值)以及小于matrix[0][0](该矩阵的最小值)
        //则说明该矩阵没有要找的目标
        int m = matrix.length,n=matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m-1][n-1]){
            return false;//找不到target
        }
        return isExistTarget(matrix,target,m,n);
    }
    private boolean isExistTarget(int [][] matrix , int target,int m , int n){
        int row=0,col=0,newM=0,newN=n-1;//newM是缩小后的矩阵的起始行，newN是缩小后的矩阵的n-1
        byte direction = 0;//方向 , 0表示向右，1表示向下
        //逐渐缩小矩阵的范围
        while ( row < m && newN > -1){
            row=newM;
            col=0;
            direction = 0;
            while (row < m) {     //缩小矩阵范围
                if(matrix[row][col] == target){
                    return true;
                } else if (matrix[row][col] > target) { //缩小矩阵范围
                    if (direction == 0)
                        newM = row + 1;
                    else
                        newM = row;
                    newN = col -1 ;
                    break;
                }
                if(col == newN){//转变方向为向下
                    direction = 1;
                }
                switch (direction){
                    case 0 : col++;break;
                    case 1 : row++;break;
                }
            }
        }
        return false;
    }

    //方法1 查找当前元素的右边以及下边是否满足条件 :   超出时间限制
    public boolean searchMatrix(int[][] matrix, int target) {
        //如果target的值大于matrix[m-1][n-1](该矩阵的最大值)以及小于matrix[0][0](该矩阵的最小值)
        //则说明该矩阵没有要找的目标
        int m = matrix.length,n=matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m-1][n-1]){
            return false;//找不到target
        }
//        target的值在[matrix[0][0,matrix[m-1][n-1]区间内
        return isEqualTarget(matrix,target,0,0,m,n);//查找目标是否在矩阵中
    }
    //查找矩阵中是否有target,给方法1使用
    private boolean isEqualTarget(int [][] matrix,int target,int row,int col,int m,int n){
        boolean isTargetExist = false;//目标是否存在
        if ( row < m && col < n && matrix[row][col] == target) {//找到目标了
            System.out.println("目标的行列"+row+","+col);
            return true;
        }
        if( row < m && col < n && matrix[row][col] < target ){//继续向下以及向右查找
            //先向右查找
            isTargetExist = isEqualTarget(matrix,target,row,col+1,m,n);
            //在向下查找
            isTargetExist = isTargetExist == true ? true : isEqualTarget(matrix,target,row+1,col,m,n);
        }
        return isTargetExist ;
    }
}

