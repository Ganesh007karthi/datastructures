 public class Queue {

     int[] array=new int[0];
     int front;
     int rear;


     public boolean add(Object o) {
         int[] newarray=new int[array.length+1];
         for(int i=0;i<array.length;i++){
             newarray[i]=array[i];
         }
         newarray[rear]=(int)o;
         rear++;
         array=new int[newarray.length];
         for(int i=0;i<newarray.length;i++){
             array[i]=newarray[i];
         }

         return false;
     }


     public boolean offer(Object o) {
        return false;
     }


     public Object remove() {
         for(int i=0;i<array.length-1;i++){
             array[i]=array[i+1];
         }

         array[array.length-1]=0;
         return null;
     }


     public Object poll() {
         if(array.length<0){
             remove();
         }
         return null;
     }


     public Object peek() {
         if (array.length < 0) {
             return (Object) array[front];
         }
         return null;
     }

     public void print(){
         for(int i=0;i< array.length;i++){
             System.out.println(array[i]);
         }
     }
     public int size(){
         int size=array.length;
         return size;
     }

 }
