package leetcode;

/**
 * Created by shelvin on 2/10/16 at 00:27.
 */

public class BestTimetoBuyandSellStock_121
{
    public int maxProfit(int[] prices)
    {
        int len = prices.length;

        if (len == 0)
        {
            return 0;
        }

        int min = Integer.MIN_VALUE;
        int profit = 0;

        for (int price : prices)
        {
            min = price < min ? price : min;
            profit = (price - min) > profit ? (price - min) : profit;
        }

        return profit;
    }
}
