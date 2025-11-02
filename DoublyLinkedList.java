package linkedlist;

import java.util.Scanner;

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
    public void insert_at_particular_position(int data, int pos) {
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
    public void delete_at_particular_position(int pos) {
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
    	try(Scanner c = new Scanner(System.in)){
    		
//	        Scanner c = new Scanner(System.in);
	        boolean flag = true;
	        int a,b;
	        while(flag) {
	        	System.out.println("********************************************************************************");
	        	System.out.println("1.Insert at begin\n2.Insert at particular position\n3.Insert at end\n4.Delete at begin\n5.Delete at particular position\n6.Delete at end\n7.Display all nodes\n7.Exit");
	        	System.out.print("Enter your choice : ");
	        	int choice = c.nextInt();
	        	switch(choice) {
	        	case 1:
	        		
	        		System.out.print("Enter value to insert : ");
	        		a = c.nextInt();
	        		n.insert_at_begin(a);
	        		System.out.println(a+" is inserted at the begin");
	        		break;
	        	
	        	case 2:
	        		
	        		System.out.print("Enter value to insert : ");
	        		a = c.nextInt();
	        		System.out.print("Enter the position to insert : ");
	        		b = c.nextInt();
	        		n.insert_at_particular_position(a,b);
	        		System.out.println(a+" is inserted at the position "+b+"/n /n");
	        		break;
	        		
	        	case 3:
	        		
	        		System.out.print("Enter value to insert : ");
	        		a = c.nextInt();
	        		n.insert_at_end(a);
	        		System.out.println(a+" is inserted at the the end/n/n");
	        		break;
	        		
	        	case 4:
	        		n.delete_at_begin();
	        		System.out.println("First node is deleted/n/n");
	        		break;
	        		
	        	case 5:
	        		System.out.print("Enter the position to delete : ");
	        		a = c.nextInt();
	        		n.delete_at_particular_position(a);
	        		System.out.println("Node is deleted at the position "+a+"\n\n");
	        		break;
	        		
	        	case 6:
	        		n.delete_at_end();
	        		System.out.println("Last node is deleted\n\n");
	        		break;
	        		
	        	case 7:
	        		n.display();
	        		System.out.println("All datas are displayed\n\n");
	        		break;
	        		
	        	case 8:
	        		System.out.println("Program is going to exit\n\n");
	        		flag = false;
	        		break;
	        		
	        	default:
	        		System.out.println("Invalid choice\n\n");
	        		break;
	        	}
	        }
	    }
    }
}
