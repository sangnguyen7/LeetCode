public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;
        int[] countBit = new int[32];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < countBit.length; j++){
                countBit[j] += nums[i] >> j & 1;
            }
        }
        
        for (int i = 0; i < countBit.length; i++){
            total +=(n-countBit[i])*countBit[i];
        }
        return total;
    }