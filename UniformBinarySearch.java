
import java.util.Scanner;
public class Linearsearch{
    
    public static int linearsearch(int [] arr, int key){

        for(int i =0; i < arr.length; i++){

            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);

        System.out.println("enter array size:");
            int n = sc.nextInt();

            int [] arr = new int[n];

        System.out.print("enter the array numbers:");
                for(int i=0; i<n; i++ ){
                     arr[i] = sc.nextInt();
            }
        System.out.println("enter the element which is meant to be found:");
        int key = sc.nextInt();

        int result = linearsearch(arr, key);

        if(result != -1){
            System.out.println("the element is found at:"+ result);
        } else { 
            System.out.println("the element is not found"+result);
        }
        sc.close();
    }
}
