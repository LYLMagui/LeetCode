import org.junit.Test;

/**
 * 121. 买卖股票的最佳时机
 **/
public class BestTimeToBuyAndSellStock {
    /**
     * 方法一： 动态规划
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            max = Math.max((prices[i] - dp[i]), max);
        }
        return max;
    }

    @Test
    public void test() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int i = bestTimeToBuyAndSellStock.maxProfit(prices);
        System.out.println(i);
    }

}
