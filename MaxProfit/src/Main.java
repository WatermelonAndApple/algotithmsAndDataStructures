public class Main {
    //买卖股票的最佳时机
    /*
    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     */
    public static void main(String[] args) {
        //测试项
        int[] prices1={7,1,5,3,6,4};
        int [] prices2={7,6,4,3,1};
        int [] prices3={2,1};
        int [] prices4={1,2};
        int [] prices5={2,1,2,0,1};
        int [] prices6={3,2,6,5,0,3};
        int [] prices7={2,7,1,4};
        Solution s=new Solution();
        System.out.println("最大值为"+s.buyProfit2(prices1));
        System.out.println("最大值为"+s.buyProfit2(prices2));
        System.out.println("最大值为"+s.buyProfit2(prices3));
        System.out.println("最大值为"+s.buyProfit2(prices4));
        System.out.println("最大值为"+s.buyProfit2(prices5));
        System.out.println("最大值为"+s.buyProfit2(prices6));
        System.out.println("最大值为"+s.buyProfit2(prices7));
    }
}
class Solution {
    //时间太长了
    public int buyProfit(int[] prices) {
        int sale;//第i天买入的后卖出的价格。
        int max=0;//最大的利润值
        for(int i=0;i<prices.length-1;i++){
            sale=prices[i];
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]>sale){//找到最高的高于买入价格的卖出价格
                    sale=prices[j];
                }
            }
            max=Math.max(sale-prices[i],max);
        }
        return max;
    }
    public int buyProfit1(int[] prices) {
        if(prices.length==1)//数组只有一个数据的时候
            return 0;
        int buy=0;//买入的时间
        int sale=1;//卖出的时间
        int i=1;
        int max=prices[sale]-prices[buy];
        //买入的时间时钟要小于卖出的时间
        while (i< prices.length-1){
            if(prices[i] < prices[buy]){
                buy=i;
                sale=i+1;
                max=Math.max(max,prices[sale]-prices[buy]);
            }
            if(prices[i+1] > prices[sale]){
                sale=i+1;
                max=Math.max(max,prices[sale]-prices[buy]);
            }
            i++;
        }
        return  Math.max(0,max);
    }
    public int  buyProfit2(int [] prices){
        //假设在历史最低点买入股票
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;//最大利润
        for(int i=0;i<prices.length;i++){
            if(minPrice>prices[i]){
                minPrice=prices[i];
            }
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);
        }
        return maxProfit;
    }
}