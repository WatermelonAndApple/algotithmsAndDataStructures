public class RemoveElement {
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * 你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，
     * 而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     *
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3]
     * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * 注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     * @param args
     */
    public static void main(String[] args) {
        int [] t1={3,2,2,3};
        int [] t2 = {0,1,2,2,3,0,4,2};
        int [] t3 ={0,1,2,3};
        int [] t4 = {2,2,1,3,2,2,3,3,4,5,6,2,1,0};
        int [] t5 ={1,0,1,1};
        System.out.println(removeElement(t1, 3));
        System.out.println(removeElement(t2, 2));
        System.out.println(removeElement(t3, 5));
        System.out.println(removeElement(t4, 0));
        System.out.println(removeElement(t5, 1));
        System.out.println();
    }
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;//n表示数组的长度
//        if(n == 1 && nums[0] == val){
//            return 0;
//        }
        int tail = n-1;//数组尾部下标
        //遍历数组
        for(int i = 0; i < n; i++) {
            if(nums[i] == val) {//找到要抛弃的目标数值时
//                将该目标放到数组的后面(抛弃它)
                while ( nums[tail] == val){
                    tail--;
                    if(tail < 0){
                        return 0;
                    }
                }
                if( i >= tail)
                    break;
                //交换
                nums[i] = nums[tail];
                nums[tail] = val;
            }
        }
        return   tail+1;
    }
}
