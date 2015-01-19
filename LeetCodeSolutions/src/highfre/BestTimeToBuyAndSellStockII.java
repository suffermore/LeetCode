package highfre;

public class BestTimeToBuyAndSellStockII {
	
	public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit = profit + prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
	
	/**
	 * If prices[i + 1] > prices[i], there is an available profit, then we add the profit.
	 * Follow UP: how many transactions there are?
	 * */
	public int maxProfitAndTransactionTimes(int[] prices) {
        int profit = 0;
        int times = 1;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit = profit + prices[i + 1] - prices[i];
            } else {
            	times++;
            }
        }
        return times;
    }
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockII b = new BestTimeToBuyAndSellStockII();
		int[] p = {1,2,3,1,3};
		System.out.println(b.maxProfitAndTransactionTimes(p));
	}
}
