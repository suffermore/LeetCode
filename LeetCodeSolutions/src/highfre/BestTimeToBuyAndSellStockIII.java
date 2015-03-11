package highfre;

public class BestTimeToBuyAndSellStockIII {
	
	//O(n) method
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        //In array left, left[i] save the max profit of the first i element in array prices
        int[] left = new int[prices.length];
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        
        //In array right, left[i] save the max profit of the last i element in array prices
        int[] right = new int[prices.length];
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i > 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        
        //enumerate division of two transactions
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            //can sell and buy in the same day
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }
	
	/**
	 * O(n^2) Method
	 * Divide array into two parts, and use solution in BestTimeToBuyAndSellI.
	 * Then add two profits of two parts together and get the max one
	 * */
	public int maxProfitII(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
        	//second divProfit starts from i because we can sell and buy in the same day
            profit = divProfit(prices, 0, i) + divProfit(prices, i, prices.length - 1);
        }
        return profit;
    }
    
    public int divProfit(int[] prices, int start, int end) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
    
    public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
		int[] prices = {1, 2};
		System.out.println(b.maxProfit(prices));
	}
}
