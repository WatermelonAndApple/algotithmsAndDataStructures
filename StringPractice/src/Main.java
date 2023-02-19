public class Main {
    //最大以1为边界的正方形
    public static void main(String[] args) {
       Main s =new Main();
       int [][] t1={{1,1,1},{1,1,0},{1,1,1}};
        int [][] t2={{1,1,0,0},{0,1,1,0}};
        int [][] t3={{0,0,1,1},{0,0,1,1}};
        int [][] t4={{1,1},{0,1},{1,1}};
        int [][] t5={{1,1,1,1},{1,1,1,1},{1,0,1,1},{1,1,1,1}};
        int [][] t6={{0,0},{0,0},{0,0}};
        System.out.println(s.largest1BorderedSquare(t1));
        System.out.println(s.largest1BorderedSquare(t2));
        System.out.println(s.largest1BorderedSquare(t3));
        System.out.println(s.largest1BorderedSquare(t4));
        System.out.println(s.largest1BorderedSquare(t5));
         System.out.println(s.largest1BorderedSquare(t6));

    }
    /*
    给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，
    并返回该子网格中的元素数量。如果不存在，则返回 0。
    输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
    输出：9
    输入：grid = [[1,1,0,0]]
    输出：1
     */
    public int largest1BorderedSquare(int[][] grid) {
        int m =grid.length,n=grid[0].length;
        int border = Math.min(m,n);//假设最大边长为矩阵所能满足条件的正方形最大边长
        int i=0,j=0;//i代表行，j代表列
        while (border>0){
            i=0;
            j=0;
            while (true){
                if(i+border-1 >=m){
                    break;
                }
                if(isResultSquare(grid,i,j,border)){
                    return border * border;
                }
                j++;
                if (j + border -1 >=n){
                    j=0;
                    i++;
                }
            }
            border--;
        }
        return border ;
    }
    //是否是我们要求的正方形
    public boolean isResultSquare(int[][] grid,int i,int j,int border){
        //遍历该正方形边长上的所有数据，如果存在0则说明不是我们要的正方形
        byte direction = 0;//0，1,2,3分别表示向右、下、左、上移动，
        for(int k=1;k<=4*(border-1);k++){
            if(grid[i][j] == 0){
                return false;
            }
            switch (direction){
                case 0: j++;break;
                case 1: i++;break;
                case 2: j--;break;
                case 3: i--;break;
            }
            if(k % (border-1) == 0){
                direction++;
            }
        }
        if(border == 1){
            if(grid[i][j] == 0){
                return false;
            }
        }
        return true;
    }
}