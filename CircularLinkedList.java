package linkedlist;

import java.util.*;

public class CircularLinkedList {

	class Node{
        int data;
        Node next;
        
        Node(int d){
            data = d;
            next = null;
        }
    }
    Node head,tail = null;
    
    //Code to insert Node at the begin
    
    public void insert_at_begin(int data){
        Node nn = new Node(data);
        if(head == null){
            head = tail = nn;
        }
        else{
            nn.next = head;
            head = nn;
            tail.next = nn;
        }
    }
    
  //Code to insert Node at particular position
    
    public void insert_at_particular_position(int data,int pos){
        Node nn = new Node(data);
        Node temp = head;
        if(pos == 0){
            nn.next = head;
            head = nn;
            tail.next = nn;
        }
        else{
            for(int i=0;i<pos-1;i++){
                temp = temp.next;
                if(temp == null)   break;
            }
            if(temp == null){
                System.out.println("Position out of range!");
                return;
            }
            else if(temp.next == null){
                temp.next = nn;
                nn.next = null;
                tail = nn;
            }
            else{
            nn.next = temp.next;
            temp.next = nn;
            }
        }
    }
    
  //Code to insert Node at end
    
    public void insert_at_end(int data){
        Node nn = new Node(data);
        if(head == null){
            head = tail = nn;
        }
        else{
            tail.next = nn;
            tail = nn;
            nn.next = head;
        }
    }
    
    public void delete_at_begin(){
        if(head == null){
            System.out.println("No Node to delete");
            return;
        }
        else{
            head = head.next;
            tail.next = head;
        }
    }
    
  //Code to delete Node at particular position
    
    public void delete_at_particular_position(int pos){
        Node temp = head;
        if(head == null){
            System.out.println("No Node to delete!");
            return;
        }
        else if(pos == 0){
            head = head.next;
            tail.next = head;
        }
        else {
            for(int i=0;i<pos-1;i++){
                temp = temp.next;
                if(temp == null)  break;
            }
            if(temp.next == null || temp == null){
                System.out.println("Position out of range!");
            }
            else if(temp.next == tail){
                temp.next = head;
                tail = temp;
            }
            else{
                temp.next = temp.next.next;
            }
        }
    }
    
  //Code to delete Node at end
    
    public void delete_at_end(){
        Node temp = head;
        if(head == null){
            System.out.println("No Node to delete");
            return;
        }
        else{
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
            
        }
    }
    
  //Code to display all Node data

    public void display(){
        Node temp = head;
        while(temp != tail){
        	System.out.print(temp.data+" -> ");
        	temp = temp.next;
        };
        System.out.println(temp.data);
      System.out.println();
    
    }

    
    public static void main(String [] args){
    	try(Scanner c = new Scanner(System.in)){
    	CircularLinkedList n = new CircularLinkedList();
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
        		System.out.println(a+" is inserted at the position "+b);
        		break;
        		
        	case 3:
        		
        		System.out.print("Enter value to insert : ");
        		a = c.nextInt();
        		n.insert_at_end(a);
        		System.out.println(a+" is inserted at the the end");
        		break;
        		
        	case 4:
        		n.delete_at_begin();
        		System.out.println("First node is deleted");
        		break;
        		
        	case 5:
        		System.out.print("Enter the position to delete : ");
        		a = c.nextInt();
        		n.delete_at_particular_position(a);
        		System.out.println("Node is deleted at the position "+a);
        		break;
        		
        	case 6:
        		n.delete_at_end();
        		System.out.println("Last node is deleted");
        		break;
        		
        	case 7:
        		n.display();
        		System.out.println("All datas are displayed");
        		break;
        		
        	case 8:
        		System.out.println("Program is going to exit");
        		flag = false;
        		break;
        		
        	default:
        		System.out.println("Invalid choice");
        		break;
        	}
        }
    }
    }


}
