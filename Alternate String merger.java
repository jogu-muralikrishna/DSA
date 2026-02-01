import java.util.Scanner;
public class Aliternatestringbuilder{
    
    /*public static String combineAlternately(String a, String b) {
    StringBuilder res = new StringBuilder();
    
    int n = Math.max(a.length(), b.length());
    
    for (int i = 0; i < n; i++) {
        if (i < a.length()) {
            res.append(a.charAt(i));
        }
        if (i < b.length()) {
            res.append(b.charAt(i));
        }
    }
    
    return res.toString();
}*/

    public static String combineAlternately(String a, String b) {

        StringBuilder result = new StringBuilder();

        int minlength = Math.min(a.length(), b.length());

        for(int i=0; i <minlength; i++ ){
            result.append(a.charAt(i));
            result.append(b.charAt(i));
        }
        if(a.length() > minlength){
            result.append(a.substring(minlength));
        }else if(b.length() > minlength){
            result.append(b.substring(minlength));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
     
        System.out.print("Enter first string: ");
        String a = sc.nextLine();
        
        System.out.print("Enter second string: ");
        String b = sc.nextLine();
        
        
        String result = combineAlternately(a, b);
        
        System.out.println("Output: " + result);
        
        sc.close();
    }
}

