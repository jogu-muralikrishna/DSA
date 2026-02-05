import java.util.Scanner;

class DoublyLinkedList {

    // ===== Node structure =====
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // ===== Head pointer =====
    private Node head = null;

    // ===== Insert at Front =====
    public void insertAtFront(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        System.out.println(data + " inserted at front");
    }

    // ===== Insert at End =====
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        System.out.println(data + " inserted at end");
    }

    // ===== Delete from Front =====
    public void deleteFromFront() {
        if (head == null) {
            System.out.println("List is empty, cannot delete");
            return;
        }

        System.out.println(head.data + " deleted from front");

        head = head.next;

        if (head != null) {
            head.prev = null;
        }
    }

    // ===== Delete from End =====
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty, cannot delete");
            return;
        }

        if (head.next == null) {
            System.out.println(head.data + " deleted from end");
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.println(temp.data + " deleted from end");
        temp.prev.next = null;
    }

    // ===== Search =====
    public void search(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        int position = 1;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println(key + " found at position " + position);
                return;
            }
            temp = temp.next;
            position++;
        }

        System.out.println(key + " not found in list");
    }

    // ===== Display Forward =====
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Doubly Linked List (Forward): ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ===== Display Backward =====
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Doubly Linked List (Backward): ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // ===== Main (Driver Code) =====
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        int choice;

        do {
            System.out.println("\n--- DOUBLY LINKED LIST MENU ---");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Front");
            System.out.println("4. Delete from End");
            System.out.println("5. Search");
            System.out.println("6. Display Forward");
            System.out.println("7. Display Backward");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    dll.insertAtFront(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    dll.insertAtEnd(sc.nextInt());
                    break;

                case 3:
                    dll.deleteFromFront();
                    break;

                case 4:
                    dll.deleteFromEnd();
                    break;

                case 5:
                    System.out.print("Enter element to search: ");
                    dll.search(sc.nextInt());
                    break;

                case 6:
                    dll.displayForward();
                    break;

                case 7:
                    dll.displayBackward();
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