public class App {
    public static void main(String[] args) throws Exception {
        LinkedList myLinkedList = new LinkedList();

        
        myLinkedList.append(3);   
        myLinkedList.append(2);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(5);                
        
        
        myLinkedList.printList();

        System.out.println("-----------------");

        System.out.println(myLinkedList.binaryToDecimal());


        // myLinkedList.partitionList(3);

        // System.out.println(myLinkedList.findKthFromEnd(1).value);   
        // myLinkedList.set(1, 100);
        // myLinkedList.insert(1, 10000);
        // myLinkedList.insert(1, 10000);

        // myLinkedList.printList();

        // System.out.println("-------->");

        // System.out.println("Rmove: " + myLinkedList.removeFinal());
        // System.out.println("Rmove: " + myLinkedList.removeFinal());
        
        // myLinkedList.printList();

        // System.out.println("-------->");

        // myLinkedList.prepend(200);

        // myLinkedList.printList();

        // System.out.println("-------->");

        // myLinkedList.removeFirst();
        // myLinkedList.removeFirst();

        // myLinkedList.printList();
        

    }
}
