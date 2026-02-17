public class BinarySearch {
    static int BinarySearch(int[]arr, int key){
        int low = 0;
        int high = arr.length-1;

        while(low <=high) {
            int mid = (low + high)/2;

            if(arr[mid]== key) {
                return mid;
            }
            else if(arr[mid] < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7,8,9};
        int key = 5;

        int result = BinarySearch(arr ,key);

        if(result != -1) 
            System.out.println("Element is found at index:" + result);
        else
            System.out.println("element was not found");
    }
}
