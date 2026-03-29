class Solution 
{
    public int search(int[] nums, int target) 
    {
        int s = 0;
        int e = nums.length - 1;


        while(s <= e)
        {
            int mid = s + (e - s) / 2;

            System.out.println(mid);
            if(nums[mid] == target) return mid;
            // if(target > nums[0])
            // {
            //     // in the first increasing part.
            //     if(nums[mid] > target)
            //     {
            //         // need to move left.
            //         e = mid - 1;
            //     }
            //     else
            //     {
            //         s = mid + 1;
            //     }
            // }
            // else
            // {
            //     if(target > nums[mid])
            //     {
            //         s = mid + 1;
            //     }
            //     else
            //     {
            //         e = mid - 1;
            //     }
            // }



            if(nums[mid] >= nums[s])
            {
                if(target > nums[mid] || target < nums[s]) s = mid + 1;
                else e = mid - 1;
            }
            else
            {
                if(target < nums[mid] || target > nums[e]) e = mid - 1;
                else s = mid + 1;
            }
        }

        return -1;
    }
}
