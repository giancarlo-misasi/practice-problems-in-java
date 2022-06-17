package dev.gmisasi.practice.binary_search;

/**
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * 
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * 
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int idx = start;

        while (idx < end) {
            if (nums[idx] == target) {
                return idx;
            } else if (nums[idx] < target) {
                start = idx + 1;
                idx = ((end - start) / 2) + start; // skip forward
            } else {
                end = idx;
                idx = ((end - start) / 2) + start; // skip back
            }
        }

        // idx should always be < nums.length - 1
        if (nums[idx] >= target) {
            return idx;
        } else {
            return idx + 1;
        }
    }

    public static void main(String[] args) {

    }
}
