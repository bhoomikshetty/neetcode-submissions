class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int len = nums.length;

        for(int i=0; i<=len-3; i++)
        {
            
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];

            int j = i + 1;
            int k = len - 1;

            int num_i = nums[i];
            while(j < k)
            {
                if(nums[j] + nums[k] == target)
                {
                    int num_j = nums[j];
                    int num_k = nums[k];

                    res.add(new ArrayList<Integer>(Arrays.asList(num_i, num_j, num_k)));
                    j++; k--;

                    while(j < k && nums[k] == num_k && nums[j] == num_j) {j++; k--;} 
                } 
                else if(nums[j] + nums[k] < target) j++;
                else k--;
            }
        }

        return res;
    }
}

// -4 => 
// we need 4


//           l      r      
// -4 -1 -1 -1 0 1 2 


//    l   r
// -4 2 2 2