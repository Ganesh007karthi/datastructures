 public class Queuerunner extends Queue{
    public static void main(String args[]){
        Queue q=new Queue();
        q.add(5);
        q.add(34);
        q.add(5);
        q.add(36);
        q.add(8);
        q.add(3);
        q.add(8);
        q.add(9);
        q.add(1);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(45);
        System.out.println(""+q.size());
        q.print();
        System.out.println("");
        System.out.println("The first element of the queue:"+ q.peek());
        System.out.println("");
        System.out.println("dequeueing.....");
        q.remove();
        System.out.println("");
        System.out.println("The first element of the queue:"+ q.peek());
        System.out.println("");
        q.print();
    }
}
