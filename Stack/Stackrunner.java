public class Stackrunner {
    public static void main(String args[]){
        Stack gan=new Stack();
        gan.push(4);
        gan.push(6);
        gan.push(9);
        gan.push(3);
        gan.print();
        System.out.println();
        System.out.println("removing the stack in LIFO manner...");
        gan.remove();
        gan.print();
        System.out.println();
        System.out.println("The top most element of stack is......"+gan.lastelement());
        System.out.println();
        System.out.println("The bottom most element of stack is......"+gan.firstelement());
    }
}
