
import java.util.Arrays;

public class FibonacciSearch {

    /**
     * Performs Fibonacci Search on a sorted array.
     * 
     * @param arr The sorted array to search.
     * @param x   The element to search for.
     * @return The index of the element if found, otherwise -1.
     */
    public static int fibonacciSearch(int[] arr, int x) {
        int n = arr.length;

        // Initialize Fibonacci numbers
        int fibMMm2 = 0; // (m-2)'th Fibonacci No.
        int fibMMm1 = 1; // (m-1)'th Fibonacci No.
        int fibM = fibMMm2 + fibMMm1; // m'th Fibonacci No.

        // fibM is going to store the smallest Fibonacci
        // Number greater than or equal to n
        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        // Marks the eliminated range from front
        int offset = -1;

        /*
         * while there are elements to be inspected.
         * Note that we compare arr[fibMm2] with x.
         * When fibM becomes 1, fibMm2 becomes 0
         */
        while (fibM > 1) {
            // Check if fibMm2 is a valid location
            int i = Math.min(offset + fibMMm2, n - 1);

            /*
             * If x is greater than the value at index fibMm2,
             * cut the subarray array from offset to i
             */
            if (arr[i] < x) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            }

            /*
             * If x is less than the value at index fibMm2,
             * cut the subarray after i+1
             */
            else if (arr[i] > x) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }

            /* element found. return index */
            else
                return i;
        }

        /*
         * comparing the last element with x
         */
        if (fibMMm1 == 1 && arr[Math.min(offset + 1, n - 1)] == x)
            return Math.min(offset + 1, n - 1);

        /* element not found. return -1 */
        return -1;
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = { 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100, 235 };
        int x = 85;

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Element to search: " + x);

        int index = fibonacciSearch(arr, x);

        if (index >= 0)
            System.out.println("Found at index: " + index);
        else
            System.out.println(x + " isn't present in the array");

        // Interactive testing part (optional, can be commented out)
        /*
         * Scanner sc = new Scanner(System.in);
         * System.out.print("Enter number to search in the array above: ");
         * if(sc.hasNextInt()) {
         * int val = sc.nextInt();
         * int idx = fibonacciSearch(arr, val);
         * if (idx >= 0)
         * System.out.println("Found at index: " + idx);
         * else
         * System.out.println(val + " isn't present in the array");
         * }
         * sc.close();
         */
    }
}