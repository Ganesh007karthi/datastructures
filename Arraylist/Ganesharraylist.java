import java.util.*;

public class Ganesharraylist implements List {
    private int size=0;
    private Integer[]array=new Integer[size];
    @Override
    public int size() {
        int len;
        len=array.length;
        return len;
    }

    @Override
    public boolean isEmpty() {
        if(size()<=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0;i<size();i++){
            if(array[i]==o){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        if(size()>0){
            MyIterator myIterator=new MyIterator(size(),toIntArray(),0);
            return myIterator;
        }
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] newarray=new Object[size()];
        for(int i=0;i<size();i++){
            newarray[i]=array[i];
        }
        return newarray;
    }

    @Override
    public boolean add(Object o) {
        int len=size();
        Integer[] newarray=new Integer[len+1];
        if(len==0){
            array=new Integer[1];
            array[0]=(Integer)o;
            return true;
        }else{
            for(int i=0;i<len;i++){
                newarray[i]=array[i];
            }
            newarray[len]=(Integer)o;
            array=new Integer[len+1];
            for(int i=0;i<len+1;i++){
                array[i]=newarray[i];
            }
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        int len=size();
        Integer[] newarray=new Integer[len];
        for(int i=0;i<len;i++){
            newarray[i]=array[i];
        }
        for(int i=0;i<len;i++){
            if(newarray[i]==o){
                array=new Integer[len-1];
            }
        }
        int itr=0;
        for(int i=0;i<len;i++){
            if(newarray[i]==o){
                continue;
            }
            array[itr]=newarray[i];
            itr++;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Object [] obj=c.toArray();
            if(obj.length>0){
                for(int i=0;i<obj.length;i++){
                    add(obj[i]);
                }
                return true;
            }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if(c.size()>0) {
            Object[] obj = c.toArray();
            for(int i=obj.length-1;i>=0;i--){
                add(index,obj[i]);
            }
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
         array=new Integer[0];
    }

    @Override
    public Object get(int index) {
        if(index<size()){
            return array[index];
        }
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        for(int i=0;i<size();i++){
            if(i==index){
                array[i]=(Integer)element;
            }

        }
        return null;
    }

    @Override
    public void add(int index, Object element) {
            Integer[] newArray=new Integer[size()];
            for(int i=0;i<size();i++){
                newArray[i]=array[i];
            }
            array=new Integer[array.length+1];
            for(int i=0;i<size();i++){
                if (index > i) {
                    array[i]=newArray[i];
                }
                if(index==i){
                    array[i]=(Integer)element;
                }
                if(index<i){
                    array[i]=newArray[i-1];
                }
            }
    }

    @Override
    public Object remove(int index) {
        int length=size();
        Integer[] newArray=new Integer[length];
        for(int i=0;i<length;i++){
            newArray[i]=array[i];
        }for(int i=0;i<newArray.length;i++){
            if(i==index){
                array=new Integer[length-1];
            }
        }int itr=0;
        for(int i=0;i<length;i++){
            if(i==index){
                continue;
            }
            array[itr]=newArray[i];
            itr++;
        }

        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==o){
                break;
            }
            index++;
        }
         return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (size() > 0) {
            for(int i=size()-1;i>=0;i--){
                if(array[i]==0){
                    return i;
                }
            }
        }
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        if(size()>0){
            MyIterator myIterator=new MyIterator(size(),toIntArray(),0);
            return myIterator;
        }
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        if(size()>0){
            MyIterator myIterator=new MyIterator(size(),toIntArray(),index);
            return myIterator;
        }
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if(size()>0){
            ArrayList sublist=new ArrayList();
            for(int i=fromIndex;i<=toIndex;i++){
                sublist.add(array[i]);
            }return sublist;
        }
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] tempArray=c.toArray();
        if(c.size()>0) {
            for (int i = 0; i < size(); i++) {
                int itr = 0;
                for (int j = 0; j < tempArray.length; j++) {
                    if (array[i] == tempArray[j]) {
                        itr++;
                    }
                }
                if (itr == 0) {
                    remove(array[i]);
                }
            }
            return true;
        }
        return false;

        }

    @Override
    public boolean removeAll(Collection c) {
        Object[] tempArray=c.toArray();
        if(c.size()>0) {
            for (int i = 0; i < tempArray.length; i++) {
                for (int j = 0; j <size() ; j++) {
                    if (tempArray[i] == array[j]) {
                        remove(array[j]);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        Object[] tempArray=c.toArray();
        for (int i=0;i<tempArray.length;i++){
            int  check=0;
            for (int j=0;j<size();j++){
                if(tempArray[i]==array[j]){
                    check++;
                }
            }
            if(check==0){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if(a.length==size()){
            for (int i=0;i<a.length;i++){
                a[i]=array[i];
            }
            return a;
        }
        else if(a.length!=size()&&size()!=0) {
            Object[] objArray = new Object[size()];
            for (int i=0;i<size();i++){
                objArray[i]=array[i];
            }
            return objArray;
        }
        else {
            return new Object[0];
        }
    }

    public  int[] toIntArray(){
        if(size()>0){
            int [] intArray=new int[size()];
            for (int i=0;i<size();i++){
                intArray[i]=array[i];
            }
            return  intArray;
        }
        return new int[0];
    }


    public void print(){
        for(int i=0;i<size();i++){
            System.out.println(array[i]);
        }
    }





    public static void main(String args[]){
        Ganesharraylist gan=new Ganesharraylist();
        gan.add(3);
        gan.add(5);
        gan.print();
        System.out.println();
        System.out.println();
        Object a=5;
        gan.remove(a);
        gan.print();
        System.out.println();
        System.out.println();
        gan.add(5);
        gan.print();
        System.out.println();
        System.out.println();
        gan.remove(1);
        gan.print();
        System.out.println();
        System.out.println();
        LinkedList newlist=new LinkedList();
        newlist.add(6);
        newlist.add(8);
        newlist.add(9);
        System.out.println("Is that collections are added to the arraylist:"+gan.addAll(newlist)) ;
        gan.print();
        System.out.println();
        System.out.println(""+gan.size());
        System.out.println();
        System.out.println(""+gan.indexOf(6));
        System.out.println(""+gan.lastIndexOf(6));
        System.out.println();
        System.out.println(""+gan.subList(1,3));
        System.out.println();
        System.out.println();
        System.out.println("Is that collections are added to the arraylist:"+gan.addAll(2,newlist));
        gan.print();
    }
}
