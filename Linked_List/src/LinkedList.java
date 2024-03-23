import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    class Node {
        int value;
        Node next;

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

    public Node removeFinal(){
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

            return temp;
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

    public Node removeFirst(){
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

        return temp;
    }

    public Node get(int index){
        if(length == 0 || index >= length || index < 0){
            return null;
        }

        Node temp = head;

        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index,int value){
        if(index < 0 || index > length){
            return false;
        }
        if(index == 0){
            prepend(value);
            return true;
        }else if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp    = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= length){
            return null;
        }
        if(index == 0){
            return removeFirst();
        }else if(index == length - 1){
            return removeFinal();
        }
        Node pre  = get(index - 1);
        Node temp = get(index);

        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for(int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode(){
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if(size == 0) return null;

        if(size%2 == 0){
            int tempSize = size -1;
            tempSize = tempSize/2 + 1;
            return get(tempSize);
        }

        int tempSize = size -1;
        tempSize = tempSize/2;
        return get(tempSize);
    }

    //Using Fast and Slow technique
    public Node findMiddleNodeV2(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean hasLoop(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) return true;
        }
        return false;
    }

    public Node findKthFromEnd(int k){
        Node slow = head;
        Node fast = head;
        for(int i = 0; i < k; i++){
            if(fast == null)return null;
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;             
        }
        return slow;
    }

    public void partitionList(int x){
        if(head == null) return;

        Node newNode1 = new Node(0);
        Node newNode2 = new Node(0);

        Node temp1 = newNode1;
        Node temp2 = newNode2;

        Node current = head;

        while (current != null) {                    
            
            if(current.value < x){
                temp1.next = current;
                temp1 = current;
            }else {
                temp2.next = current;
                temp2 = current;
            }
            current = current.next;
        }

        temp2.next = null;
        temp1.next = newNode2.next;

        head = newNode1.next;

        printList();
    }

    public void removeDuplicatesV1() {
        if (head == null) return;
    
        Node current = head;
    
        while (current != null) {
            Node runner = current;
            
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            
            current = current.next;
        }
        
        printList();
    }
    
    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (values.contains(current.value)) {
                previous.next = current.next;
                length -= 1;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }

        printList();
    }

    public int binaryToDecimal(){        
        int num = 0;
        Node current = head;
        while(current != null){
            num *= 2;
            num += current.value;

            current = current.next;
        }

        return num;
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
