class Solution 
{
    public boolean canJump(int[] nums) 
    {
        if(nums[0] == 0 && nums.length == 1) return true;
        if(nums[0] == 0) return false;

        int len = nums.length;
        boolean[] jump = new boolean[len];

        jump[len - 1] = true;

        for(int i=len-2; i>=0; i--)
        {
            if(nums[i] == 0) jump[i] = false;
            for(int j=i; j<=i+nums[i]; j++) if(j < len && jump[j]) jump[i] = jump[j];
        }

        return jump[0];
    }
}

// 4 1 2 0 1