public class Binarysearch {
    public static int binarysearch(int[]arr, int key){
        int low = 0; 
        int high = arr.length - 1;

        while(low <= high){
            int mid =( low + high )/2;

            if(arr[mid]==key){
                return mid;
            }else if(key < arr[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int [] arr = { 10, 20, 30, 40, 50, 60};
        int key = 40;

        int result = binarysearch(arr, key);
        if( result != -1){
            System.out.println("the element is found at:"+ result );
        }else{
            System.out.println("the key element is not in array." + result);
        }
    }
}
