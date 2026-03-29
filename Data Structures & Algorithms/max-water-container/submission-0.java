class Solution 
{
    public int maxArea(int[] heights) 
    {
        int start = 0;
        int end = heights.length - 1;

        int res = Integer.MIN_VALUE;
        while(start < end)
        {
            res = Math.max(res, Math.min(heights[start], heights[end]) * (end - start));
            if(heights[start] < heights[end]) start++;
            else end--;
        }

        return res;
    }
}