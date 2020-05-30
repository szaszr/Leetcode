package Arrays101;

/*
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.



Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]

Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
 */

public class ReplaceElementWithGreatestElementOnRightSide {

    public int[] replaceElements(int[] arr) {
        int size = arr.length;

        // Initialize the next greatest element
        int max_from_right =  arr[size-1];

        // The next greatest element for the rightmost
        // element is always -1
        arr[size-1] = -1;

        // Replace all other elements with the next greatest
        for (int i = size-2; i >= 0; i--)
        {
            // Store the current element (needed later for
            // updating the next greatest element)
            int temp = arr[i];

            // Replace current element with the next greatest
            arr[i] = max_from_right;

            // Update the greatest element, if needed
            if(max_from_right < temp)
                max_from_right = temp;
        }
        return arr;
    }

    public int[] replaceElementsII(int[] arr) {
        int rightMaxNum = arr[arr.length-1];
        arr[arr.length-1]= -1;
        for(int i=arr.length-2; i>=0;i--){
            int temp =rightMaxNum;
            rightMaxNum= Math.max(rightMaxNum, arr[i]);
            arr[i]= temp;
        }
        return arr;

    }
}
