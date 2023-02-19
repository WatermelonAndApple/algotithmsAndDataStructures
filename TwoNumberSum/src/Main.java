public class Main {
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    public static void main(String[] args) {
//        test1
//        int [] nums={2,7,11,15};
//        int target=9;
        //test2
//        int [] nums={3,3};
//        int target=6;
        //test3
        int [] nums={3,2,4};
        int target=6;
        int[] result;
        //使用穷举法
//        result=new Solution().twoSum(nums,target);
        //使用哈希表法
        result=new Solution().hashTwoSum(nums,target);

        if(result!=null){
            System.out.println("找到了，结果为");
            System.out.println("["+result[0]+","+result[1]+"]");
        }else{
            System.out.println("没有结果!");
        }
    }

}