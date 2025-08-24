//Approach-3 (Using Better Sliding Window) - O(n))
class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0;
        int lastZeroIdx = -1;
        int result = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                i = lastZeroIdx + 1;
                lastZeroIdx = j;
            }
            result = Math.max(result, j - i);
            j++;
        }
        return result;
    }
}

// //Approach-1 (Simple Brute Force) - T.C : O(n^2)
// class Solution {
//     private int n;

//     private int findMax(int[] nums, int skipIdx) {
//         int currLength = 0;
//         int maxLength = 0;

//         for (int i = 0; i < n; i++) {
//             if (i == skipIdx) 
//                 continue;

//             if (nums[i] == 1) {
//                 currLength++;
//                 maxLength = Math.max(maxLength, currLength);
//             } else {
//                 currLength = 0;
//             }
//         }
//         return maxLength;
//     }

//     public int longestSubarray(int[] nums) {
//         n = nums.length;
//         int result = 0;

//         int countZero = 0;
//         for (int i = 0; i < n; i++) {
//             if (nums[i] == 0) {
//                 countZero++;
//                 result = Math.max(result, findMax(nums, i));
//             }
//         }

//         if (countZero == 0) 
//             return n - 1;

//         return result;
//     }
// }

// //Approach-2 (Using Traditional Sliding Window) - O(n)
// class Solution {
//     public int longestSubarray(int[] nums) {
//         int zeroCount = 0;
//         int longestWindow = 0;

//         int i = 0;

//         for (int j = 0; j < nums.length; j++) {
//             if (nums[j] == 0) {
//                 zeroCount++;
//             }

//             // Shrink the window until the zero count comes under the limit
//             while (zeroCount > 1) {
//                 if (nums[i] == 0) {
//                     zeroCount--;
//                 }
//                 i++;
//             }

//             longestWindow = Math.max(longestWindow, j - i);
//         }

//         return longestWindow;
//     }
// }


