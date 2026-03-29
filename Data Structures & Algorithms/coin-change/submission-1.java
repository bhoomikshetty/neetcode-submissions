class Solution 
{
    int[] dp;
    public int numberOfCoins(int[] coins, int amount)
    {
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;

        if(dp[amount] != -1) return dp[amount];
        int res = Integer.MAX_VALUE;
        for(int i=coins.length - 1; i>=0; i--)
        {
            int r = numberOfCoins(coins, amount - coins[i]);
            if(r != Integer.MAX_VALUE)
            {
                res = Math.min(res, 1+r);
            }
        }

        return dp[amount] = res;
    }
    public int coinChange(int[] coins, int amount) 
    {
        dp = new int[amount+1];
        Arrays.fill(dp, -1);

        int answer = numberOfCoins(coins, amount);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
