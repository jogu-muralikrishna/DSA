public class interpolationsearch{
    public static int interpolationsearchm(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;
        while(low <= high && key >=arr[low] && key<= arr[high]){
            int pos = low + ((key - arr[low]) * (high - low))/ (arr[high] - arr[low]);

            if(arr[pos] == key){
                return pos;
            }

            if (arr[pos] < key){
                low = pos +1;
            }
            else {
                high = pos -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50 ,60, 70 , 80, 90, 100};
        int key = 70;
        int result = interpolationsearchm(arr, key);

        if ( result !=0){
            System.out.println("element found at "+ result);
        }else{
            System.out.println("the elemnt is not there");
        }
    }
}