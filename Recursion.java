// Direct recursion 

/*public class Krishna {
    public static void DirectRecursion (int n) {
        if(n==-1) return;
        System.out.println(n);
        DirectRecursion(n-1);
    }
    public static void main(String[] args) {
        DirectRecursion(10);
    }
}*/

//Indirect Recursion

/*public class Krishna {
    public static void functionA(int n) {
        if(n <= 0) return;
        System.out.println("A" + n);;
        functionB(n-1);
    }
    public static void functionB(int n) {
        if(n <= 0) return;
        System.out.println("B" + n);
        functionA(n/2);
    }
    public static void main(String[] args) {
      functionA(10);
    }
    }*/

//Tail Recursion

/*public class Krishna {
    public static void number(int n,int k) {
        if(n == 0) return;
        System.out.println(k);
        number(n-1,k-1);
    }
    public static void main(String[] args) {
        number(5,1);
    }
}
*/