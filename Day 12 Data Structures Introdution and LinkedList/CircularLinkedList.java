class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{

    Node head, tail;

    public void addBeg(int data){
        Node node = new Node(data);
        if(head == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        head = node;
    }

    public void addEnd(int data) {
        Node node = new Node(data);
        if(head == null){
            head = tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void addPos(int data, int pos){
        Node node = new Node(data);

        if(head == null) {
            head = tail = node;
            return;
        }

        if(pos == 1) {
            addBeg(data);
            return;
        }

        Node temp = head;
        for(int i = 0; i < pos-1; i++) {
            temp = temp.next;
            if(temp == head) {
                System.out.println("Index out of range");
            }
        }
        node.next = temp.next;
        temp.next = node;
        if(temp == tail) {
            tail = node;
        }
    }

    public void deleteBeg() {
        if(head == null) {
            System.out.println("List is empty");
        }

        if(head == tail) {
            head = null;
        }
        else {
            tail.next = head.next;
            head = head.next;
        }
    }

    public void deleteEnd(){
        if(head == null) {
            System.out.println("List is empty");
        }

        if(head == tail) {
            head = null;
        }

        Node temp = head;
        while (temp.next != tail){
            temp = temp.next;
        }
        temp.next = head;
        temp = tail;
    }

    public void deletePos(int pos) {
        if(head == null) {
            System.out.println("List is empty");
        }

        if(head == tail) {
            head = null;
        }

        Node temp = head;
        for(int i = 0; i < pos-1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    public void updateValue(int data, int pos) {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        for(int i = 1; i < pos; i++) {
            temp = temp.next;
            if(temp == head) {
                System.out.println("Out of range!");
                return;
            }
        }
        temp.data = data;
    }

    public void display(){
        Node temp = head;
        do{
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        while (temp != head);
        System.out.println("Head");
    }
}

public class CircularLinkedList {
    public static void main(String[] args) {
        LinkedList ll =  new LinkedList();
        ll.addBeg(5);
        ll.addBeg(4);
        ll.addBeg(2);
        ll.addBeg(1);
        ll.addEnd(6);
        ll.addEnd(7);
        ll.addPos(3, 2);
        ll.addPos(8, 7);
        ll.display();
        System.out.println();
        ll.deleteBeg();
        ll.display();
        System.out.println();
        ll.deleteEnd();
        ll.display();
        System.out.println();
        ll.deletePos(3);
        ll.display();
        System.out.println();
        ll.updateValue(17,3);
        ll.display();
    }
}
