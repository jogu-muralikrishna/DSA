import java.util.Scanner;

public class Stack {

    static int[] stack;
    static int top = -1;
    static int MAX_SIZE;

    // Push operation
    static void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push.");
            return;
        }
        stack[++top] = value;
        System.out.println(value + " pushed into stack");
    }

    // Pop operation
    static void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return;
        }
        System.out.println(stack[top--] + " popped from stack");
    }

    // Peek operation
    static void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top element is: " + stack[top]);
    }

    // Display operation
    static void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    // isEmpty check
    static boolean isEmpty() {
        return top == -1;
    }

    // isFull check
    static boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        MAX_SIZE = sc.nextInt();
        stack = new int[MAX_SIZE];

        int choice;

        do {
            System.out.println("\n--- STACK MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Is Empty");
            System.out.println("6. Is Full");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    push(sc.nextInt());
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    peek();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println(isEmpty() ? "Stack is Empty" : "Stack is NOT Empty");
                    break;

                case 6:
                    System.out.println(isFull() ? "Stack is Full" : "Stack is NOT Full");
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}