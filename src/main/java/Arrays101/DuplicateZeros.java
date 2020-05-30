package Arrays101;

/*
Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.



Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]


Note:

1 <= arr.length <= 10000
0 <= arr[i] <= 9
 */

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int i = 0, sh = 0;
        for (i = 0; sh + i < arr.length; ++i) sh += arr[i] == 0 ? 1 : 0;
        for (i = i - 1; sh > 0; --i) {
            if (i + sh < arr.length) arr[i + sh] = arr[i];
            if (arr[i] == 0) arr[i + --sh] = arr[i];
        }
    }

    public void duplicateZerosII (int[] arr){
        int countZero = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0) countZero++;
        }
        int len = arr.length + countZero;
        //We just need O(1) space if we scan from back
        //i point to the original array, j point to the new location
        for(int i = arr.length - 1, j = len - 1;i>=0 && j>=0;i--,j--){
            if(arr[i] != 0){
                if(j<arr.length) arr[j] = arr[i];
            }else{
                if(j<arr.length) arr[j] = arr[i];
                j--;
                if(j<arr.length) arr[j] = arr[i];//copy twice when hit '0'
            }
        }
    }
}
