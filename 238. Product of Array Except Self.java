public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        
        Arrays.fill(output, 1);
        
        int product = 1;
        
        for (int i = 1; i < nums.length; i++){
            product *= nums[i-1];
            output[i] = product;
        }
        
        product = 1;
        
        for (int i = nums.length-2; i >= 0; i--){
            product *= nums[i+1];
            output[i] *=product;
        }
        
        return output;
}

public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        
        Arrays.fill(output, 1);
        
        int productForward = 1;
        int productBackward = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++){
            productForward *= nums[i-1];
            productBackward *= nums[n-i];
            output[i] *= productForward;
            output[n-i-1] *= productBackward;
        }
        
        return output;
}