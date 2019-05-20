import java.util.*;

public class Ganeshlinkedlist implements List<Integer> {
    private Linkedlist root=null;
    @Override
    public int size() {
        Linkedlist node=root;
        int size=0;
        while (node!=null){
            size++;
            node=node.next;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        Linkedlist node=root;
        return node==null;
    }

    @Override
    public boolean contains(Object o) {
        int size=size();
        Object[]obj=toArray();
        for(int i=0;i<size;i++){
           if (obj[i]==o){
               return true;
           }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        int size=size();
        Linkedlist node=root;
        Object[]obj=new Object[size];
        int itr=0;
        while(node!=null){
            obj[itr]=node.val;
            node=node.next;
            itr++;
        }
        return obj;
    }

    @Override
    public <Integer> Integer[] toArray(Integer[] a) {
        Linkedlist  node=root;
        int itr=0;
        if (node!=null){
            while (node != null) {
                a[itr] = (Integer) node.val;
            }
            return a;
        }
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        Linkedlist node=root;
        if (node==null){
            root=new Linkedlist(integer);
            node=root;
            return true;
        }
        else {
            while(node.next!=null){
                node=node.next;
                }
            node.next=new Linkedlist(integer);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Linkedlist node=root;
        if (node==null){
            return false;
        }
        if(node.val==(int)o){
            root=root.next;
        }
        else{
            while(node.next!=null){
                if(node.next.val==(int)o){
                    node.next=node.next.next;
                    return true;
                }
                node=node.next;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object []obj=c.toArray();
        int len=obj.length;
        int mark=0;
        for(int i=0;i<len;i++){
            if(contains((int)obj[i])){
                mark++;//use to mark the checked value
            }
        }
        if(mark==len){
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        Object[]obj=c.toArray();
        int len=obj.length;
        int mark=0;
        for(int i=0;i<len;i++){
            add((int)obj[i]);
            mark++;
        }
        if(mark==len){
            return true;
        }

        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        Object[]obj=c.toArray();
        int len=obj.length;
        int mark=0;
        for(int i=0;i<len;i++){
            add(index,(int)obj[i]);
            mark++;
        }
        if(len==mark){
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[]obj=c.toArray();
        int len=obj.length;
        int mark=0;
        for(int i=0;i<len;i++){
            remove((int)obj[i]);
            mark++;
        }
        if(len==mark){
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Linkedlist node=root;
        Object[] tempArray =c.toArray();
        int itr=0;
        if(size()>0) {
            while (node != null) {
                for (int j = 0; j < tempArray.length; j++) {
                    if (node.val == tempArray[j]) {
                        itr++;
                    }
                }
                if (itr == 0) {
                    remove(node);
                }
                node = node.next;
            }
            return true;
        }

        return false;
    }

    @Override
    public void clear() {
        root=null;
    }

    @Override
    public Integer get(int index) {
        int a=1;
        Linkedlist node=root;
        while (node.next!=null){
            if(a==index){
                return node.val;
            }
            node=node.next;
            a++;
        }
        return null;
    }

    @Override
    public Integer set(int index, Integer element) {
        int itr=1;
        Linkedlist node=root;
        while (node!=null){
            if(itr==index){
                node.val=element;
                return node.val ;
            }
            node=node.next;
            itr++;
        }
        return null;
    }

    @Override
    public void add(int index, Integer element) {
            Linkedlist node=root;
            if (index>size()){
                return;
            }
            if (index==1){
                root=new Linkedlist(element);
                root.next=node;
                return;
            }
            else{
                    for(int i=2;i<=index;i++){
                    if(i==index){
                        Linkedlist temp=node.next;
                        node.next=new Linkedlist(element);
                        node.next.next=temp;
                        return;
                    }else{
                        node=node.next;
                    }
                    }
            }

    }

    @Override
    public Integer remove(int index) {
        Linkedlist node=root;
        int i=2;
        if(index==1){
            root=node.next;
            return null;
        }
            while(node.next!=null){
                if(i==index){
                    node.next=node.next.next;
                    return null;
                }
                i++;
                node=node.next;
            }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        Linkedlist node=root;
        int index=1;
        int itr=0;
        while(node!=null){
            if(toArray()[itr]==o){
                return index;
            }
            index++;
            itr++;
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        Linkedlist node=root;
        int index=1;
        while(node!=null){
            if(node.next==null){
                return index;
            }
            node=node.next;
            index++;
        }
        return 0;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        if (size()>0){
            MyIterator myIterator=new MyIterator(size(),intArray(),0);
        }
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        Linkedlist node=root;
        if (index<size()){
            int[] listArray=new int[size()-index-1];
            for (int i=1,itr=0;i<=size();i++){
                if(i>=size()-index) {
                    listArray[itr] =node.val;
                    itr++;
                }
                node=node.next;
            }
            MyIterator myIterator=new MyIterator(size()-index,listArray,index-1);
            return myIterator;
        }
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        LinkedList sublist = new LinkedList();
        Linkedlist node = root;
        int itr = 1;
        if (size() >= toIndex) {
            while (node != null) {
                if (itr >= fromIndex && itr <= toIndex) {
                    sublist.add(node.val);
                }
                itr++;
                node = node.next;
            }return sublist;
        } else {
            System.out.println("Enter the correct Limit");
            return null;
        }
    }

    public void print() {
        Linkedlist node=root;
            if (node == null) {
                System.out.println("there is no values to print");
            }
            else {
                while (node!= null) {
                    System.out.println(node.val);
                    node = node.next;
                }
            }
        }
    public void printArray(Object[] object){
        int i=0,size=size();
        System.out.println("the array is");
        while (i<size){
            System.out.println(object[i]);
            i++;
        }
        System.out.println();
    }
    public int[] intArray(){
        Linkedlist node=root;
        int[] intArray=new int[size()];
        int itr=0;
        while (node!=null){
            intArray[itr]=node.val;
            itr++;
            node=node.next;
        }
        return intArray;
    }

    }


