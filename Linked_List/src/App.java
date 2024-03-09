public class App {
    public static void main(String[] args) throws Exception {
        LinkedList myLinkedList = new LinkedList();

        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);        

        myLinkedList.printList();

        System.out.println("--------> ------> ");

        System.out.println("Rmove: " + myLinkedList.removeFinal());
        System.out.println("Rmove: " + myLinkedList.removeFinal());
        System.out.println("Rmove: " + myLinkedList.removeFinal());
        System.out.println("Rmove: " + myLinkedList.removeFinal());
        myLinkedList.printList();
    }
}
