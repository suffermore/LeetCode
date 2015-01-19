package highfre;

public class BestTimeToBuyAndSellStock {
	
	/**
	 * cur_min save the mini value of array prices
	 * */
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int cur_min = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            cur_min = Math.min(cur_min, prices[i]);
            max_profit = Math.max(prices[i] - cur_min, max_profit);
        }
        return max_profit;
    }
	
	public int maxProfitII(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int cur_profit = 0;
        int max_profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            cur_profit = Math.max(cur_profit + prices[i + 1] - prices[i], 0);
            max_profit = Math.max(max_profit, cur_profit);
        }
        return max_profit;
    }
}
