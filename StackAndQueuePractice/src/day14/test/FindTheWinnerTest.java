package day14.test;

import day14.FindTheWinner;
import org.junit.jupiter.api.Test;

//找出游戏的获胜者测试
public class FindTheWinnerTest {
    @Test
    public void test(){
        FindTheWinner ftw = new FindTheWinner();
        //测试用例1：
//        输入：n = 5, k = 2
//        输出：3
//        解释：游戏运行步骤如下：
//        1) 从小伙伴 1 开始。
//        2) 顺时针数 2 名小伙伴，也就是小伙伴 1 和 2 。
//        3) 小伙伴 2 离开圈子。下一次从小伙伴 3 开始。
//        4) 顺时针数 2 名小伙伴，也就是小伙伴 3 和 4 。
//        5) 小伙伴 4 离开圈子。下一次从小伙伴 5 开始。
//        6) 顺时针数 2 名小伙伴，也就是小伙伴 5 和 1 。
//        7) 小伙伴 1 离开圈子。下一次从小伙伴 3 开始。
//        8) 顺时针数 2 名小伙伴，也就是小伙伴 3 和 5 。
//        9) 小伙伴 5 离开圈子。只剩下小伙伴 3 。所以小伙伴 3 是游戏的获胜者。
        System.out.println(ftw.findTheWinner(5, 2));
        //测试用例2：
//        输入：n = 6, k = 5 ,输出 1
        System.out.println(ftw.findTheWinner(6, 5));
        //测试用例2：
//        输入：n = 4， k = 1 ，输出 4
        System.out.println(ftw.findTheWinner(4, 1));
    }
}
