package dev.gmisasi.practice.two_pointers;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array
 * of the squares of each number sorted in non-decreasing order.
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * 
 * Example 1:
 * 
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * 
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        // positive numbers won't change order (amongst themselves)
        // same for negative
        // we can look for first positive number and work in both directions
        // take from either left or right, depending on which absolute value is larger
        
        // find pivot
        int pivot = 0;
        while (pivot < nums.length) {
            if (nums[pivot] < 0) {
                pivot++;
            } else {
                break;
            }
        }
        
        // square the values
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = nums[i] * nums[i];
        }
        
        int idx = 0;
        int[] result = new int[nums.length];
        
        // sort
        int pos = pivot;
        int neg = pos - 1;
        while (pos < nums.length && neg >= 0) {
            if (nums[pos] < nums[neg]) {
                result[idx++] = nums[pos++];
            } else {
                result[idx++] = nums[neg--];
            }
        }
        while (pos < nums.length) {
            result[idx++] = nums[pos++];
        }
        while (neg >= 0) {
            result[idx++] = nums[neg--];
        }
        
        // done
        return result;
    }

    public static void main(String[] args) {

    }
}
