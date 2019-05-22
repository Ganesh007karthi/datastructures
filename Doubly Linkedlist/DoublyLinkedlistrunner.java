public class DoublyLinkedlistrunner {
    public static void main(String args[]){
        DoublyLinkedList gan=new DoublyLinkedList();
        gan.Addatfront(5);
        gan.Addatfront(4);
        gan.Addatend(6);
        gan.Addatend(8);
        gan.Addatnode(gan.head.next.next,7);
        gan.print();
        System.out.println();
        System.out.println("Deleting the element at front");
        gan.removeatfront();
        gan.print();
        System.out.println();
        System.out.println("Deleting the element at end;");
        gan.removeatend();
        gan.print();
           }
}
