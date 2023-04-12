public class JumpGame {
    /**
     * 跳跃游戏
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     */
    public static void main(String[] args) {
        int [] t1={2,3,1,1,4}; //true
        int [] t2 ={3,2,1,0,4};//false
        int [] t3 ={1,2,3,4};//true
        int [] t4 = {0,1,2,3};//flase
        int [] t5 = {2,1,1,3};//true
        int [] t6 = {0};//true
        int [] t7 = {2,0};//true
        int [] t8 = {0,1,2,0};//false
        int [] t9 = {2,3,1,0,5,2,4,0,10};//true
        int [] t10 = {1,2,0,0,0,4};//false
        System.out.println(canJump(t1));
        System.out.println(canJump(t2));
        System.out.println(canJump(t3));
        System.out.println(canJump(t4));
        System.out.println(canJump(t5));
        System.out.println(canJump(t6));
        System.out.println(canJump(t7));
        System.out.println(canJump(t8));
        System.out.println(canJump(t9));
        System.out.println(canJump(t10));
    }

    /**
     * 查找0，判断能否跳过0，如果能够所有的跳过0就表示可以到达终点,
     * 如果数组全为正整数则表示可以到最后
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        //数组长度
      int n = nums.length;
      for (int i=0;i<n;i++){
          if(nums[i] == 0 && i != n-1){
              boolean flag = false;//能否跳过0
              //如果在最后一个元素之前存在等于0的数，判断是否在该数的前面是否存在能够跳过该数的值
              for(int j = i-1; j >= 0; j--){
                  if(nums[j] + j > i){//如果能够跳过该0值
                      flag = true;
                      break;
                  }
              }
              if(!flag){//如果不能够跳过0,则无法到达终点
                  return false;
              }
          }
      }
      return true;
    }
//    public static boolean isCanJump(int [] nums,int curIndex){
//        //到达数组的最后一个下标位置
//        if(curIndex == nums.length-1){
//            return true;
//        }else if(curIndex >= nums.length) {//下标越界了
//            return  false;
//        }else if(nums[curIndex] == 0){//不是最后一个却无法进行移动了
//            return false;
//        }
//        //是否可以跳跃到终点
//        boolean isCan = false;
//        for(int i=1;i<=nums[curIndex];i++){
//            //从新的下标开始进行跳跃
//            isCan = isCan == true ? isCan : isCanJump(nums,curIndex + i);
//        }
//        return isCan;
//    }
}
