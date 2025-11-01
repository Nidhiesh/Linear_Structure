public class SingleLinkedList{
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
        }
    }
    
    //Code to insert Node at particular position
    
    public void insert_at_particular_position(int data,int pos){
        Node nn = new Node(data);
        Node temp = head;
        if(pos == 0){
            nn.next = head;
            head = nn;
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
        }
    }
    
    //Code to delete Node at begin
    
    public void delete_at_begin(){
        if(head == null){
            System.out.println("No Node to delete");
            return;
        }
        else{
            head = head.next;
        }
    }
    
    //Code to delete Node at particular position
    
    public void delete_at_particular_position(int pos){
        Node temp = head;
        if(head == null){
            System.out.println("No Node to delete!");
            return;
        }
        else if(pos ==0){
            head = head.next;
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
                temp.next = null;
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
            temp.next = null;
            tail = temp;
        }
    }
     //Code to display all Node data

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
      System.out.println();
    }

    
    public static void main(String [] args){
        SingleLinkedList n = new SingleLinkedList();
        n.insert_at_begin(1);
        n.insert_at_begin(2);
        n.insert_at_begin(3);
        n.insert_at_begin(4);
        n.display();
        n.insert_at_end(5);
        n.display();
        n.delete_at_begin();
        n.display();
        n.insert_at_particular_position(100,4);
        n.display();
        n.delete_at_particular_position(3);
        n.display();
    }
}