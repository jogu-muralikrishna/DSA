import java.util.Scanner;

public class Queue {

    static int[] queue;
    static int front = 0;
    static int rear = -1;
    static int MAX_SIZE;

    // Enqueue operation
    static void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue.");
            return;
        }
        queue[++rear] = value;
        System.out.println(value + " enqueued into queue");
    }

    // Dequeue operation
    static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue.");
            return;
        }
        System.out.println(queue[front++] + " dequeued from queue");
    }

    // Peek operation
    static void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front element is: " + queue[front]);
    }

    // Display operation
    static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    // isEmpty
    static boolean isEmpty() {
        return front > rear;
    }

    // isFull
    static boolean isFull() {
        return rear == MAX_SIZE - 1;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        MAX_SIZE = sc.nextInt();
        queue = new int[MAX_SIZE];

        int choice;

        do {
            System.out.println("\n--- QUEUE MENU ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Is Empty");
            System.out.println("6. Is Full");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    enqueue(sc.nextInt());
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    peek();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println(isEmpty() ? "Queue is Empty" : "Queue is NOT Empty");
                    break;

                case 6:
                    System.out.println(isFull() ? "Queue is Full" : "Queue is NOT Full");
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