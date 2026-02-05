import java.util.Scanner;

class CircularLinkedList {

    // ===== Node structure =====
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ===== Tail pointer =====
    private Node tail = null;

    // ===== Insert at Front =====
    public void insertAtFront(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            tail = newNode;
            tail.next = tail; // circular
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        System.out.println(data + " inserted at front");
    }

    // ===== Insert at End =====
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println(data + " inserted at end");
    }

    // ===== Delete from Front =====
    public void deleteFromFront() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node head = tail.next;

        if (head == tail) { // only one node
            System.out.println(head.data + " deleted");
            tail = null;
        } else {
            System.out.println(head.data + " deleted");
            tail.next = head.next;
        }
    }

    // ===== Delete from End =====
    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node head = tail.next;

        if (head == tail) { // only one node
            System.out.println(tail.data + " deleted");
            tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        System.out.println(tail.data + " deleted");
        temp.next = tail.next;
        tail = temp;
    }

    // ===== Search =====
    public void search(int key) {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = tail.next;
        int position = 1;

        do {
            if (temp.data == key) {
                System.out.println(key + " found at position " + position);
                return;
            }
            temp = temp.next;
            position++;
        } while (temp != tail.next);

        System.out.println(key + " not found in list");
    }

    // ===== Display =====
    public void display() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = tail.next;
        System.out.print("Circular Linked List: ");

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != tail.next);

        System.out.println();
    }

    // ===== Main (Driver Code) =====
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularLinkedList cll = new CircularLinkedList();
        int choice;

        do {
            System.out.println("\n--- CIRCULAR LINKED LIST MENU ---");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Front");
            System.out.println("4. Delete from End");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    cll.insertAtFront(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    cll.insertAtEnd(sc.nextInt());
                    break;

                case 3:
                    cll.deleteFromFront();
                    break;

                case 4:
                    cll.deleteFromEnd();
                    break;

                case 5:
                    System.out.print("Enter key to search: ");
                    cll.search(sc.nextInt());
                    break;

                case 6:
                    cll.display();
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
