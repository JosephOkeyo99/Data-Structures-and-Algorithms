import java.util.Arrays;

public class ArrayOperations {

    public static void main(String[] args) {
        // 1. Declaration and Initialization
        int[] numbers = {25, 10, 45, 30, 15};

        // Alternative: Fixed-size declaration
        // int[] numbers = new int[5];

        System.out.println("Initial Array: " + Arrays.toString(numbers));

        // 2. Accessing Elements (0-based indexing)
        System.out.println("First element (index 0): " + numbers[0]);
        System.out.println("Third element (index 2): " + numbers[2]);

        // 3. Modifying Elements
        numbers[1] = 99; // Changing 10 to 99
        System.out.println("After modifying index 1: " + Arrays.toString(numbers));

        // 4. Traversing an Array (Standard for-loop)
        System.out.print("Traversing elements: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // 5. Finding Sum and Maximum Value
        int sum = 0;
        int max = numbers[0];

        for (int num : numbers) {
            sum += num;
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Sum of elements: " + sum);
        System.out.println("Maximum element: " + max);

        // 6. Simple Linear Search
        int target = 45;
        int foundIndex = linearSearch(numbers, target);
        if (foundIndex != -1) {
            System.out.println("Element " + target + " found at index: " + foundIndex);
        } else {
            System.out.println("Element " + target + " not found.");
        }
    }

    // Helper method for Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}