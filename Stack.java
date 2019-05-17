public class Stack{
    Integer[] stack=new Integer[0];
    int rear=0;
    int front=0;
    public boolean push(Object o){


            Integer[]copy=new Integer[stack.length+1];
            for(int i=0;i<stack.length;i++){
                copy[i]=stack[i];
            }
            copy[rear]=(Integer)o;
            rear++;
            stack=new Integer[copy.length];
            for(int i=0;i<copy.length;i++){
                stack[i]=copy[i];
            }

        return false;
    }
    public boolean remove(){
       stack[stack.length-1]=0;
       Integer[]copy=new Integer[stack.length-1];
        for(int i=0;i<copy.length;i++){
            copy[i]=stack[i];
        }
        stack=new Integer[copy.length];
        for(int i=0;i<copy.length;i++){
            stack[i]=copy[i];
        }
        rear=rear-2;
        return true;
    }

    public int firstelement(){
        return (int)stack[front];
    }

    public int lastelement(){
        return (int)stack[rear];
    }


    public void print(){
        System.out.println("The Stack of element is....");
        for(int i=stack.length-1;i>=0;i--){
            System.out.println(""+stack[i]);
        }
    }

}