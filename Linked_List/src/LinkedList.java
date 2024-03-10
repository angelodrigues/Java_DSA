public class LinkedList {

    class Node {
        private int value;
        private Node next;
    
        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(){}

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;            
        }
        length ++;
    }

    public Integer removeFinal(){
        if(length == 0){            
            return null;      
        }else{
            Node temp = head;
            Node pre  = head; 
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;                
            }   

            tail = pre;
            tail.next = null;

            length--;

            if(length == 0){
                head = null;
                tail = null;
            }

            return temp.value;
        }
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Integer removeFirst(){
        if(length == 0){
            return null;
        }
        Node temp = head;
        head      = head.next;
        temp.next = null;        
        
        length--;
        if(length == 0){            
            tail = null;
        }           

        return temp.value;
    }

    public Integer get(int index){
        if(length == 0 || index >= length || index < 0){
            return null;
        }

        Node temp = head;
        if(head.next != null){
            for(int i = 0; i < index; i++){                
                temp = temp.next;                
            }
        }

        return temp.value;
    }

    public void printList(){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length " + length);
    }
}