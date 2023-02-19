package cn.gtldys.day02;

public class SortColors {
    /*
    给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    必须在不使用库内置的 sort 函数的情况下解决这个问题。
     */
    public static void main(String[] args) {
        int [] t1={2,0,2,1,1,0};
        int [] t2={2,0,1};
        int [] t3={0,0};
        int [] t4={2,1};
        int [] t5={1,0,2};
        SolutionofSC s= new SolutionofSC();
        s.sortColors(t1);
        s.printNum(t1);
        s.sortColors(t2);
        s.printNum(t2);
        s.sortColors(t3);
        s.printNum(t3);
        s.sortColors(t4);
        s.printNum(t4);
        s.sortColors(t5);
        s.printNum(t5);
    }
}
class SolutionofSC {
    public void sortColors(int[] nums) {
        int p1=0,p2=nums.length-1;
        for(int i=0;i<=p2;++i){
            while (i<=p2 && nums[i]==2){
                swap(nums,i,p2);
                p2--;
            }
            if(nums[i] == 0){
                swap(nums,i,p1);
                p1++;
            }
        }
    }

    /**交换数据
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int [] nums ,int i ,int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public void printNum(int [] nums){
        for(int n : nums){
            System.out.print(n+"\t");
        }
        System.out.println("===");
    }

}
