 public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] DP = new int[target+1];
       
        Arrays.fill(DP, -1);
        
        return combinationSum4DP(nums, target, DP);
    }
    
    public int combinationSum4DP(int[] nums, int target, int[] DP){
        if (target < 0) return 0;
        
        if (target == 0) return 1;
    
        
        if (DP[target] != -1) return DP[target];
        
        int total = 0;
        for (int i = 0; i < nums.length; i++){
            total += combinationSum4DP(nums, target-nums[i], DP);
        }
        
        DP[target] = total;
        
        return DP[target];
    }