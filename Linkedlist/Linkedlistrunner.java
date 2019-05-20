import java.util.ArrayList;

public class Linkedlistrunner {
    public static void main(String args[]){
        Ganeshlinkedlist gan=new Ganeshlinkedlist();
        gan.add(5);
        gan.add(70);
        gan.add(94);
        gan.add(45);
        gan.add(3,43);
        gan.print();
        System.out.println("The size of the linkedlist is "+gan.size());
        ArrayList<Integer> arrList = new ArrayList<>(2);
        arrList.add(5);
        System.out.println("printing elements of arraylist");
        for(int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i));
        }
        System.out.println();
        System.out.println("Is it contain all collection elements:"+gan.containsAll(arrList));
        System.out.println();
        System.out.println("Is it that all elements are added to collection elements:"+gan.addAll(arrList));
        System.out.println();
        System.out.println("Is it  that all elements of array list are added to list at index 2:"+gan.addAll(2,arrList));
        gan.print();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Is it that collection elements are removed:"+gan.removeAll(arrList));
        gan.print();
        System.out.println();
        System.out.println();
        System.out.println("the last index is: "+gan.lastIndexOf(gan.toArray()));
        System.out.println();
        System.out.println("printing the Array");
        gan.printArray(gan.toArray());
        gan.print();
        System.out.println();
        System.out.println("Setting the 1st index to 9");
        gan.set(1,9);
        System.out.println("adding the element 1 to first index");
        gan.add(1,1);
        gan.print();
        System.out.println();
        System.out.println("removing element of index 2");
        gan.remove(2);
        gan.print();
    }
}
