package dev.gmisasi.practice.binary_search;

/**
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which returns whether version
 * is bad. Implement a function to find the first bad version. You should
 * minimize the number of calls to the API.
 * 
 * Constraints:
 * 
 * 1 <= bad <= n <= 231 - 1
 * 
 * Example 1:
 * 
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * 
 * Example 2:
 * 
 * Input: n = 1, bad = 1
 * Output: 1
 */
public class FirstBadVersion {

    static int firstBadVersion = 1;

    public static boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int idx = start;

        while (idx <= end) {
            if (isBadVersion(idx)) {
                if (idx == start) {
                    return idx;
                } else {
                    end = idx;
                    idx = start + ((end - start) / 2);
                }
            } else {
                start = idx + 1;
                idx = start + ((end - start) / 2);
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
