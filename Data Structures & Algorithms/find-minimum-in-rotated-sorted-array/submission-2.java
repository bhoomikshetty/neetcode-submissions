class Solution 
{
    public int findMin(int[] nums) 
    {

        int s = 0;
        int e = nums.length - 1;

        while(s < e)
        {
            int mid = s + (e - s) / 2;

            if(nums[s] < nums[e]) return nums[s];
            if(nums[mid] >= nums[s])
            {
                s = mid + 1; 
            }
            else e = mid;
        }

        return nums[s];
    }
}