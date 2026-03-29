class Solution 
{
    public int search(int[] nums, int target) 
    {

        int s = 0;
        int e = nums.length - 1;

        while(s <= e)
        {
            int mid = s + (e - s) / 2;
            if(nums[mid] == target) return mid;

            if(target <= nums[e] && nums[mid] <= nums[e] && target >= nums[mid]) s = mid + 1;
            else if(target <= nums[e] && nums[mid] <= nums[e] && target < nums[mid]) e = mid - 1;
            else if(target <= nums[e] && nums[mid] >= nums[s]) s = mid + 1;
            // else if(target <= nums[e] && nums[mid]  nums[s]) s = mid + 1;
            
            else if(target > nums[e] && nums[mid] >= nums[s] && target >= nums[mid]) s = mid + 1;
            else if(target > nums[e] && nums[mid] >= nums[s] && target < nums[mid]) e = mid - 1;
            else if(target > nums[e] && nums[mid] <= nums[e]) e = mid - 1;
        }        

        return -1;
    }
}
