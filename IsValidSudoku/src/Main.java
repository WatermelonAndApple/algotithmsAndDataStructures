import java.util.Calendar;
import java.util.HashSet;

public class Main {
    //是否有效数独
    /*
    请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     */
    public static void main(String[] args) {
        char [][] board={
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','6','.','.'},
                {'1','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Solution s= new Solution();
        System.out.println(s.isValidSudoku1(board));
    }
}
class Solution {
    /**分两次遍历，第一次先看行和列是否有重复的，第二次才看小九宫格是否存在重复的
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        //行，列
        HashSet <Character> row=new HashSet<Character>();
        HashSet <Character> col=new HashSet<Character>();
        //九宫格
        HashSet <Character> nineGrid=new HashSet<Character>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                //验证行是否存在重复的
                if(board[i][j]>=49&&board[i][j]<=57){//填入的数字
                    if(!row.add(board[i][j])){//如果里面存在该数据就返回false
                       System.out.println("第"+i+"行");
                        return false;
                    }
//                    System.out.println(row);
                }
                //验证列是否存在重复的
                if(board[j][i]>=49&&board[j][i]<=57){//填入的数字
                    if(!col.add(board[j][i])){
                        System.out.println("第"+i+"列");
                        return false;
                    }
                }
            }
            row.clear();
            col.clear();
        }
        //验证小九宫格内是否存在重复的
        for(int i=1;i<=7;i+=3){
            for(int j=1;j<=7;j+=3){
                for (int x=-1;x<2;x++){
                    for(int y=-1;y<2;y++){
                        if(board[i+x][j+y]>=49&&board[i+x][j+y]<=57){//填入的数字
                            if(!nineGrid.add(board[i+x][j+y])){
                                System.out.println((i+x)+";"+(j+y));
                                return false;
                            }
                        }
                    }
                }
                nineGrid.clear();
            }
        }
        //有效的数独
        return  true;
    }

    /**
     * 一次遍历完成，一次遍历时同时判断行和列和小九宫是否存在重复的数据
     * @param board
     * @return
     */
    public boolean isValidSudoku1(char[][] board) {
        //行，列
        HashSet <Character> row=new HashSet<Character>();
        HashSet <Character> col=new HashSet<Character>();
        //九宫格
        HashSet <Character> nineGrid=new HashSet<Character>();
        //小九宫格的下标
        int x,y;
        int []tmp={0,3,6};
        for(int i=0;i<9;i++){
            x=tmp[i/3];
            y=tmp[i%3];
            for(int j=0;j<9;j++){
                //验证行是否存在重复的
                if(board[i][j] != '.'){//填入的数字
                    if(!row.add(board[i][j])){//如果里面存在该数据就返回false
                        return false;
                    }
                }
                //验证列是否存在重复的
                if(board[j][i] != '.'){//填入的数字
                    if(!col.add(board[j][i])){
                        return false;
                    }
                }
                //验证小九宫格内是否存在重复的
                if(board[x+j/3][y+j%3]!='.'){
                    if(!nineGrid.add(board[x+j/3][y+j%3])){
                        return false;
                    }
                }
            }
            row.clear();//清空
            col.clear();
            nineGrid.clear();
        }
        //有效的数独
        return  true;
    }
}