package Arrays101;

/*
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
 */

import java.util.Arrays;

public class SquaresOfSortedArray {
    //better option in case if we have less space, in place operation
    public int[] sortedSquares(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[p] = nums[i] * nums[i];
                i++;
            } else {
                result[p] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }

    //uses extra space
    public int[] sortedSquaresII(int[] nums) {
        int[] res=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            res[i]=nums[i]*nums[i];
        }
        Arrays.sort(res);
        return res;
    }
}
