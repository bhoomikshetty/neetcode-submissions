class Solution 
{
    public int search(int[] nums, int target) 
    {
        int start = 0;
        int end = nums.length - 1;


        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            System.out.println(mid);
            if(nums[mid] == target) return mid;
            // if(target > nums[0])
            // {
            //     // in the first increasing part.
            //     if(nums[mid] > target)
            //     {
            //         // need to move left.
            //         end = mid - 1;
            //     }
            //     else
            //     {
            //         start = mid + 1;
            //     }
            // }
            // else
            // {
            //     if(target > nums[mid])
            //     {
            //         start = mid + 1;
            //     }
            //     else
            //     {
            //         end = mid - 1;
            //     }
            // }

            if(nums[mid] >= nums[start] && target < nums[mid] && target >= nums[start]) end = mid - 1;
            else if(nums[mid] >= nums[start] && target > nums[mid]) start = mid + 1;
            else if(nums[mid] >= nums[start] && target < nums[mid] && target < nums[start]) start = mid + 1;

            else if(nums[mid] < nums[start] && target > nums[mid] && target <= nums[end]) start = mid + 1;
            else if(nums[mid] < nums[start] && target < nums[mid]) end = mid - 1;
            else if(nums[mid] < nums[start] && target > nums[mid] && target > nums[end]) end = mid - 1;
        }
        return -1;
    }
}
