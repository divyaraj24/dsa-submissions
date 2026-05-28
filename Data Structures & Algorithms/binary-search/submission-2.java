public class Solution {
    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -1;
    }
}

// public class Solution {
//     public int search(int[] nums, int target) {
//         int l = 0, r = nums.length;

//         while (l < r) {
//             int m = l + (r - l) / 2;
//             if (nums[m] >= target) {
//                 r = m;
//             } else {
//                 l = m + 1;
//             }
//         }
//         return (l < nums.length && nums[l] == target) ? l : -1;
//     }
// }