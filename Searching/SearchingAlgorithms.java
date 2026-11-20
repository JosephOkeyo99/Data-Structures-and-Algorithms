import java.util.Arrays;

public class SearchingAlgorithms {

    // 1. Linear Search: Checks elements sequentially one by one
    // Time Complexity: O(n) | Space Complexity: O(1)
    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Search comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Linear Search comparisons: " + comparisons);
        return -1;
    }

    // 2a. Binary Search (Iterative): Requires a SORTED array, halves search space each step
    // Time Complexity: O(log n) | Space Complexity: O(1)
    public static int binarySearchIterative(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length - 1;
        int comparisons = 0;

        while (left <= right) {
            comparisons++;
            // Prevents potential integer overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;

            if (sortedArr[mid] == target) {
                System.out.println("Binary Search (Iterative) comparisons: " + comparisons);
                return mid;
            } else if (sortedArr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Binary Search (Iterative) comparisons: " + comparisons);
        return -1;
    }

    // 2b. Binary Search (Recursive)
    // Time Complexity: O(log n) | Space Complexity: O(log n) due to call stack
    public static int binarySearchRecursive(int[] sortedArr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (sortedArr[mid] == target) {
            return mid;
        } else if (sortedArr[mid] < target) {
            return binarySearchRecursive(sortedArr, mid + 1, right, target);
        } else {
            return binarySearchRecursive(sortedArr, left, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        // Works on unsorted data
        int[] unsortedData = {42, 15, 88, 23, 7, 64, 51, 90, 12, 35};
        int target = 64;

        System.out.println("Unsorted Array: " + Arrays.toString(unsortedData));
        int linearIdx = linearSearch(unsortedData, target);
        System.out.println("Linear Search result for " + target + ": index " + linearIdx);

        System.out.println("--------------------------------------------------");

        // Binary search requires sorted data
        int[] sortedData = Arrays.copyOf(unsortedData, unsortedData.length);
        Arrays.sort(sortedData);
        System.out.println("Sorted Array:   " + Arrays.toString(sortedData));

        int binaryIdx = binarySearchIterative(sortedData, target);
        System.out.println("Binary Search (Iterative) result for " + target + ": index " + binaryIdx);

        int recursiveIdx = binarySearchRecursive(sortedData, 0, sortedData.length - 1, target);
        System.out.println("Binary Search (Recursive) result for " + target + ": index " + recursiveIdx);
    }
}