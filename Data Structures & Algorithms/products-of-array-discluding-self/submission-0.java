class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int parr[] = new int[nums.length];
        int sarr[] = new int[nums.length];
        for (int i = 0; i < nums.length;i++) {
            sarr[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0;i--) {
            parr[i] = prod;
            prod *= nums[i];
        }

        for (int i = 0; i < nums.length;i++) {
            nums[i] = parr[i] * sarr[i];
        }

        return nums;
    }
}  
