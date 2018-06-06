 public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        if (n < 1) return 0;
        int sum = 0;
        
        for (int i = 0; i < n; i++){
            sum+=nums[i];
        }
        
        int[][] DP = new int[n][2*sum+1];
        for (int[] row : DP){
            Arrays.fill(row, -1);
        }
        
        
        return findTargetSumWaysDP(nums, 0, 0, S, DP);
    }
    
    public int findTargetSumWaysDP(int[] nums, int i, int sum,  int target, int[][] DP){
        if (i == nums.length){
            return sum == target? 1:0;
        }
        int y = sum + DP[0].length/2;
        if (DP[i][y] != -1) return DP[i][y];
        
        DP[i][y] = findTargetSumWaysDP(nums, i+1, sum-nums[i], target, DP) + findTargetSumWaysDP(nums, i+1, sum+nums[i], target, DP);
        
        return DP[i][y];
    }