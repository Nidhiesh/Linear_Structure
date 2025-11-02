package linkedlist;

public class DoublyLinkedList {
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
            prev = next = null;
        }
    }

    Node head, tail = null;

    // Code to insert Node at begin
    public void insert_at_begin(int data) {
        Node nn = new Node(data);
        if (head == null) {
            head = tail = nn;
        } else {
            nn.next = head;
            head.prev = nn;
            head = nn;
        }
    }

    // Code to insert Node at particular position
    public void insert_at_position(int data, int pos) {
        Node nn = new Node(data);
        Node temp = head;
        if (pos == 0) {
            nn.next = head;
            head.prev = nn;
            head = nn;
        } else {
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
                if (temp == null) {
                    break;
                }
            }
            if (temp == null) {
                System.out.println("Position out of range");
                return;
            } else if (temp.next == null) {
                tail.next = nn;
                nn.prev = tail;
                tail = nn;
            } else {
                nn.next = temp.next;
                nn.prev = temp;
                nn.next.prev = nn;
                temp.next = nn;
            }
        }
    }

    // Code to insert Node at end
    public void insert_at_end(int data) {
        Node nn = new Node(data);
        if (head == null) {
            head = tail = nn;
        } else {
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }
    }

    // Code to delete Node at begin
    public void delete_at_begin() {
        if (head == null) {
            System.out.println("No Node to delete");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Code to delete Node at particular position
    public void delete_at_position(int pos) {
        Node temp = head;
        if (pos == 0) {
            if (head == null) {
                System.out.println("No Node to delete");
                return;
            }
            head = head.next;
            if (head != null)
                head.prev = null;
        } else {
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
                if (temp == null) {
                    break;
                }
            }
            if (temp == null || temp.next == null) {
                System.out.println("No Node to delete");
            } else if (temp.next.next == null) {
                temp.next = null;
                tail = temp;
            } else {
                temp.next = temp.next.next;
                temp.next.prev = temp;
            }
        }
    }

    // Code to delete Node at end
    public void delete_at_end() {
        if (tail == null) {
            System.out.println("No Node to delete");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Code to display all Node data
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main block of code
    public static void main(String[] args) {
        DoublyLinkedList n = new DoublyLinkedList();
        n.insert_at_begin(5);
        n.display();
        n.insert_at_begin(10);
        n.display();
        n.insert_at_end(12);
        n.display();
        n.insert_at_end(20);
        n.display();
        n.delete_at_begin();
        n.display();
        n.delete_at_end();
        n.display();
        n.insert_at_position(3, 2);
        n.display();
        n.delete_at_position(0);
        n.display();
    }
}
